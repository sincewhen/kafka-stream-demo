package fisher.kafka.streams.tests;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import fisher.kafka.streams.proto.MovieTicketSalesOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerializer;

public class TestProducer {
    private static final List<MovieTicketSalesOuterClass.MovieTicketSales> TEST_EVENTS = Arrays.asList(
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2019).setTitle("Avengers: Endgame").setTotalSales(856980506).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2019).setTitle("Captain Marvel").setTotalSales(426829839).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2019).setTitle("Toy Story 4").setTotalSales(401486230).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2019).setTitle("The Lion King").setTotalSales(385082142).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2018).setTitle("Black Panther").setTotalSales(700059566).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2018).setTitle("Avengers: Infinity War").setTotalSales(678815482).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2018).setTitle("Deadpool 2").setTotalSales(324512774).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2017).setTitle("Beauty and the Beast").setTotalSales(517218368).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2017).setTitle("Wonder Woman").setTotalSales(412563408).build(),
            MovieTicketSalesOuterClass.MovieTicketSales.newBuilder()
                    .setReleaseYear(2017).setTitle("Star Wars Ep. VIII: The Last Jedi").setTotalSales(517218368).build());

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new ProtobufSerializer<MovieTicketSalesOuterClass.MovieTicketSales>().getClass());

        try (final Producer<String, MovieTicketSalesOuterClass.MovieTicketSales> producer = new KafkaProducer<>(props)) {
            TEST_EVENTS.stream().map(event ->
                    new ProducerRecord<String, MovieTicketSalesOuterClass.MovieTicketSales>("movie-ticket-sales", event)).forEach(producer::send);
        }
    }
}