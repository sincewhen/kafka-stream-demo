package fisher.kafka.streams.tests;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
 
public class TestConsumer {
 
    public static void main(String[] args) {
 
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group01");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
 
        try (final Consumer<String, Integer> consumer = new KafkaConsumer<>(props, new StringDeserializer(), new IntegerDeserializer())) {
            consumer.subscribe(Arrays.asList("movie-revenue"));
            while (true) {
                ConsumerRecords<String, Integer> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, Integer> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        }
    }
}