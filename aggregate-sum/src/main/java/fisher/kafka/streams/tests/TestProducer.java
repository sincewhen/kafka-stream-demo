package fisher.kafka.streams.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import fisher.kafka.streams.proto.TicketSaleOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerializer;

public class TestProducer {
 
    private static final List<TicketSaleOuterClass.TicketSale> TEST_EVENTS = Arrays.asList(
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("Die Hard").setSaleTs("2019-07-18T10:00:00Z").setTicketTotalValue(12).build(),
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("Die Hard").setSaleTs("2019-07-18T10:01:00Z").setTicketTotalValue(12).build(),
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("The Godfather").setSaleTs("2019-07-18T10:01:31Z").setTicketTotalValue(12).build(),
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("Die Hard").setSaleTs("2019-07-18T10:01:36Z").setTicketTotalValue(24).build(),
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("The Godfather").setSaleTs("2019-07-18T10:00:00Z").setTicketTotalValue(18).build(),
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("The Big Lebowski").setSaleTs("2019-07-18T10:40:00Z").setTicketTotalValue(12).build(),
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("The Big Lebowski").setSaleTs("2019-07-18T10:50:00Z").setTicketTotalValue(12).build(),
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("The Godfather").setSaleTs("2019-07-18T10:00:550Z").setTicketTotalValue(36).build(),
            TicketSaleOuterClass.TicketSale.newBuilder().setTitle("The Godfather").setSaleTs("2019-07-18T10:00:34Z").setTicketTotalValue(18).build()
    );
 
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new ProtobufSerializer<TicketSaleOuterClass.TicketSale>().getClass());
 
        try (final Producer<String, TicketSaleOuterClass.TicketSale> producer = new KafkaProducer<>(props)) {
            TEST_EVENTS.stream().map(event ->
                    new ProducerRecord<String, TicketSaleOuterClass.TicketSale>("movie-ticket-sales", event)).forEach(producer::send);
        }
    }
}