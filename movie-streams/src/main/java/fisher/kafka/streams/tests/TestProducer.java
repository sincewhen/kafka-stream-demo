package fisher.kafka.streams.tests;
 
import fisher.kafka.streams.proto.RawMovieOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
 
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
 
public class TestProducer {
 
    // 测试输入事件
    private static final List<RawMovieOuterClass.RawMovie> TEST_RAW_MOVIES = Arrays.asList(
            RawMovieOuterClass.RawMovie.newBuilder()
                    .setId(294).setTitle("Die Hard::1988").setGenre("action").build(),
 
            RawMovieOuterClass.RawMovie.newBuilder()
                    .setId(354).setTitle("Tree of Life::2011").setGenre("drama").build(),
 
            RawMovieOuterClass.RawMovie.newBuilder()
                    .setId(782).setTitle("A Walk in the Clouds::1995").setGenre("romance").build(),
 
            RawMovieOuterClass.RawMovie.newBuilder()
                    .setId(128).setTitle("The Big Lebowski::1998").setGenre("comedy").build());
 
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", new ProtobufSerializer<RawMovieOuterClass.RawMovie>().getClass());
 
        try (final Producer<String, RawMovieOuterClass.RawMovie> producer = new KafkaProducer<>(props)) {
            TEST_RAW_MOVIES.stream()
                    .map(rawMovie -> new ProducerRecord<String, RawMovieOuterClass.RawMovie>("raw-movies", rawMovie))
                    .forEach(producer::send);
        }
    }
}
