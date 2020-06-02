package fisher.kafka.streams.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import fisher.kafka.streams.proto.PublicationOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerializer;
 
public class TestProducer {
 
    // ≤‚ ‘ ‰»Î ¬º˛
    private static final List<PublicationOuterClass.Publication> TEST_PUBLICATIONS = Arrays.asList(
            PublicationOuterClass.Publication.newBuilder()
                    .setName("George R. R. Martin").setTitle("A Song of Ice and Fire").build(),
            PublicationOuterClass.Publication.newBuilder()
                    .setName("C.S. Lewis").setTitle("The Silver Chair").build(),
            PublicationOuterClass.Publication.newBuilder()
                    .setName("C.S. Lewis").setTitle("Perelandra").build(),
            PublicationOuterClass.Publication.newBuilder()
                    .setName("George R. R. Martin").setTitle("Fire & Blood").build(),
            PublicationOuterClass.Publication.newBuilder()
                    .setName("J. R. R. Tolkien").setTitle("The Hobbit").build(),
            PublicationOuterClass.Publication.newBuilder()
                    .setName("J. R. R. Tolkien").setTitle("The Lord of the Rings").build(),
            PublicationOuterClass.Publication.newBuilder()
                    .setName("George R. R. Martin").setTitle("A Dream of Spring").build(),
            PublicationOuterClass.Publication.newBuilder()
                    .setName("J. R. R. Tolkien").setTitle("The Fellowship of the Ring").build(),
            PublicationOuterClass.Publication.newBuilder()
                    .setName("George R. R. Martin").setTitle("The Ice Dragon").build());
 
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", new ProtobufSerializer<PublicationOuterClass.Publication>().getClass());
 
        try (final Producer<String, PublicationOuterClass.Publication> producer = new KafkaProducer<>(props)) {
            TEST_PUBLICATIONS.stream()
                    .map(publication -> new ProducerRecord<String, PublicationOuterClass.Publication>("publications", publication))
                    .forEach(producer::send);
        }
    }
}