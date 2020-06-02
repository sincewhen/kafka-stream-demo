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

import fisher.kafka.streams.proto.SongEventOuterClass;
import fisher.kafka.streams.serdes.ProtobufDeserializer;
 
public class TestConsumer {
 
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalStateException("Must specify an output topic name.");
        }
 
        Deserializer<SongEventOuterClass.SongEvent> deserializer = new ProtobufDeserializer<>();
        Map<String, Parser<SongEventOuterClass.SongEvent>> config = new HashMap<>();
        config.put("parser", SongEventOuterClass.SongEvent.parser());
        deserializer.configure(config, false);
 
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
 
        try (final Consumer<String, SongEventOuterClass.SongEvent> consumer = new KafkaConsumer<>(props, new StringDeserializer(), deserializer)) {
            consumer.subscribe(Arrays.asList(args[0]));
            while (true) {
                ConsumerRecords<String, SongEventOuterClass.SongEvent> records = consumer.poll(Duration.ofMillis(500));
                for (ConsumerRecord<String, SongEventOuterClass.SongEvent> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        }
    }
}