package fisher.kafka.streams.tests;
 
import com.google.protobuf.Parser;
import fisher.kafka.streams.proto.ParsedMovie;
import fisher.kafka.streams.serdes.ProtobufDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.LongDeserializer;
 
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
 
public class TestConsumer {
 
    public static void main(String[] args) {
        // 为输出事件构造protobuf deserializer
        Deserializer<ParsedMovie.Movie> deserializer = new ProtobufDeserializer<>();
        Map<String, Parser<ParsedMovie.Movie>> config = new HashMap<>();
        config.put("parser", ParsedMovie.Movie.parser());
        deserializer.configure(config, false);
 
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put("group.id", "test-group");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        KafkaConsumer<Long, ParsedMovie.Movie> consumer = new KafkaConsumer<>(props, new LongDeserializer(), deserializer);
        consumer.subscribe(Arrays.asList("movies"));
        while (true) {
            ConsumerRecords<Long, ParsedMovie.Movie> records = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<Long, ParsedMovie.Movie> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }
}