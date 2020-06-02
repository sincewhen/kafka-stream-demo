package fisher.kafka.streams.tests;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import fisher.kafka.streams.proto.RatingOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerializer;
 
public class TestProducer {
    private static final List<RatingOuterClass.Rating> TEST_EVENTS = Arrays.asList(
            RatingOuterClass.Rating.newBuilder().setTitle("Die Hard").setReleaseYear(1998).setRating(8.2)
                    .setTimestamp("2019-04-25T18:00:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Die Hard").setReleaseYear(1998).setRating(4.5)
                    .setTimestamp("2019-04-25T18:03:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Die Hard").setReleaseYear(1998).setRating(5.1)
                    .setTimestamp("2019-04-25T18:04:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Die Hard").setReleaseYear(1998).setRating(2.0)
                    .setTimestamp("2019-04-25T18:07:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Die Hard").setReleaseYear(1998).setRating(8.3)
                    .setTimestamp("2019-04-25T18:32:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Die Hard").setReleaseYear(1998).setRating(3.4)
                    .setTimestamp("2019-04-25T18:36:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Die Hard").setReleaseYear(1998).setRating(4.2)
                    .setTimestamp("2019-04-25T18:43:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Die Hard").setReleaseYear(1998).setRating(7.6)
                    .setTimestamp("2019-04-25T18:44:00-0700").build(),
 
            RatingOuterClass.Rating.newBuilder().setTitle("Tree of Life").setReleaseYear(2011).setRating(4.9)
                    .setTimestamp("2019-04-25T20:01:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Tree of Life").setReleaseYear(2011).setRating(5.6)
                    .setTimestamp("2019-04-25T20:02:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Tree of Life").setReleaseYear(2011).setRating(9.0)
                    .setTimestamp("2019-04-25T20:03:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Tree of Life").setReleaseYear(2011).setRating(6.5)
                    .setTimestamp("2019-04-25T20:12:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Tree of Life").setReleaseYear(2011).setRating(2.1)
                    .setTimestamp("2019-04-25T20:13:00-0700").build(),
 
 
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1995).setRating(3.6)
                    .setTimestamp("2019-04-25T22:20:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1995).setRating(6.0)
                    .setTimestamp("2019-04-25T22:21:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1995).setRating(7.0)
                    .setTimestamp("2019-04-25T22:22:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1995).setRating(4.6)
                    .setTimestamp("2019-04-25T22:23:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1995).setRating(7.1)
                    .setTimestamp("2019-04-25T22:24:00-0700").build(),
 
 
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1998).setRating(9.9)
                    .setTimestamp("2019-04-25T21:15:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1998).setRating(8.9)
                    .setTimestamp("2019-04-25T21:16:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1998).setRating(7.9)
                    .setTimestamp("2019-04-25T21:17:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1998).setRating(8.9)
                    .setTimestamp("2019-04-25T21:18:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1998).setRating(9.9)
                    .setTimestamp("2019-04-25T21:19:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("A Walk in the Clouds").setReleaseYear(1998).setRating(9.9)
                    .setTimestamp("2019-04-25T21:20:00-0700").build(),
 
            RatingOuterClass.Rating.newBuilder().setTitle("Super Mario Bros.").setReleaseYear(1993).setRating(3.5)
                    .setTimestamp("2019-04-25T13:00:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Super Mario Bros.").setReleaseYear(1993).setRating(4.5)
                    .setTimestamp("2019-04-25T13:07:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Super Mario Bros.").setReleaseYear(1993).setRating(5.5)
                    .setTimestamp("2019-04-25T13:30:00-0700").build(),
            RatingOuterClass.Rating.newBuilder().setTitle("Super Mario Bros.").setReleaseYear(1993).setRating(6.5)
                    .setTimestamp("2019-04-25T13:34:00-0700").build());
 
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new ProtobufSerializer<RatingOuterClass.Rating>().getClass());
 
        try (final Producer<String, RatingOuterClass.Rating> producer = new KafkaProducer<>(props)) {
            TEST_EVENTS.stream().map(event ->
                    new ProducerRecord<String, RatingOuterClass.Rating>("ratings", event)).forEach(producer::send);
        }
    }
}