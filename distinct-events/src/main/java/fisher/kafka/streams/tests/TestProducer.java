package fisher.kafka.streams.tests;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import fisher.kafka.streams.proto.ClickOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerializer;
 
public class TestProducer {
    private static final List<ClickOuterClass.Click> TEST_CLICK_EVENTS = Arrays.asList(
            ClickOuterClass.Click.newBuilder().setIp("10.0.0.1")
                    .setUrl("https://docs.confluent.io/current/tutorials/examples/kubernetes/gke-base/docs/index.html")
                    .setTimestamp("2019-09-16T14:53:43+00:00").build(),
            ClickOuterClass.Click.newBuilder().setIp("10.0.0.2")
                    .setUrl("https://www.confluent.io/hub/confluentinc/kafka-connect-datagen")
                    .setTimestamp("2019-09-16T14:53:43+00:01").build(),
            ClickOuterClass.Click.newBuilder().setIp("10.0.0.3")
                    .setUrl("https://www.confluent.io/hub/confluentinc/kafka-connect-datagen")
                    .setTimestamp("2019-09-16T14:53:43+00:03").build(),
            ClickOuterClass.Click.newBuilder().setIp("10.0.0.1")
                    .setUrl("https://docs.confluent.io/current/tutorials/examples/kubernetes/gke-base/docs/index.html")
                    .setTimestamp("2019-09-16T14:53:43+00:00").build(),
            ClickOuterClass.Click.newBuilder().setIp("10.0.0.2")
                    .setUrl("https://www.confluent.io/hub/confluentinc/kafka-connect-datagen")
                    .setTimestamp("2019-09-16T14:53:43+00:01").build(),
            ClickOuterClass.Click.newBuilder().setIp("10.0.0.3")
                    .setUrl("https://www.confluent.io/hub/confluentinc/kafka-connect-datagen")
                    .setTimestamp("2019-09-16T14:53:43+00:03").build()
    );
 
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new ProtobufSerializer<ClickOuterClass.Click>().getClass());
 
        try (final Producer<String, ClickOuterClass.Click> producer = new KafkaProducer<>(props)) {
            TEST_CLICK_EVENTS.stream().map(click -> new ProducerRecord<String, ClickOuterClass.Click>("clicks", click)).forEach(producer::send);
        }
    }
}