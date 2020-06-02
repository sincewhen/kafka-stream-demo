package fisher.kafka.streams.tests;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.google.protobuf.Parser;

import fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass;
import fisher.kafka.streams.serdes.ProtobufDeserializer;

public class TestConsumer {
    public static void main(String[] args) {
        Deserializer<YearlyMovieFiguresOuterClass.YearlyMovieFigures> deserializer = new ProtobufDeserializer<>();
        Map<String, Parser<YearlyMovieFiguresOuterClass.YearlyMovieFigures>> config = new HashMap<>();
        config.put("parser", YearlyMovieFiguresOuterClass.YearlyMovieFigures.parser());
        deserializer.configure(config, false);

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group01");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        try (final Consumer<String, YearlyMovieFiguresOuterClass.YearlyMovieFigures> consumer =
                     new KafkaConsumer<>(props, new StringDeserializer(), deserializer)) {
            consumer.subscribe(Arrays.asList("movie-figures-by-year"));
            while (true) {
                ConsumerRecords<String, YearlyMovieFiguresOuterClass.YearlyMovieFigures> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, YearlyMovieFiguresOuterClass.YearlyMovieFigures> record : records) {
                    System.out.printf("value = %s%n", record.value());
                }
            }
        }
    }
}