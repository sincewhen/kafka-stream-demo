package fisher.kafka.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TestProducer {

	public static final List<String> TEST_STRING = 
			Arrays.asList("1 | Wang | Wu | 18601234567",
			              "2 | Li | Si | 13901234567", 
			              "3 | Zhang | San | 13921234567", 
			              "4 | Alice | Joe | 13901234568");

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
		props.put("acks", "all");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		try (final Producer<String, String> producer = new KafkaProducer<>(props)) {
			TEST_STRING.stream().map(s -> new ProducerRecord<String, String>("nonkeyed-records", s))
					.forEach(producer::send);
		}
	}
}
