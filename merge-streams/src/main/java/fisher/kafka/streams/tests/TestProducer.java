package fisher.kafka.streams.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import fisher.kafka.streams.proto.SongEventOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerializer;

public class TestProducer {
    // 测试输入消息集1
    private static final List<SongEventOuterClass.SongEvent> TEST_SONG_EVENTS1 = Arrays.asList(
            SongEventOuterClass.SongEvent.newBuilder().setName("Metallica").setTitle("Fade to Black").build(),
            SongEventOuterClass.SongEvent.newBuilder().setName("Smashing Pumpkins").setTitle("Today").build(),
            SongEventOuterClass.SongEvent.newBuilder().setName("Pink Floyd").setTitle("Another Brick in the Wall").build(),
            SongEventOuterClass.SongEvent.newBuilder().setName("Van Halen").setTitle("Jump").build(),
            SongEventOuterClass.SongEvent.newBuilder().setName("Led Zeppelin").setTitle("Kashmir").build()
    );
 
    // 测试输入消息集2
    private static final List<SongEventOuterClass.SongEvent> TEST_SONG_EVENTS2 = Arrays.asList(
            SongEventOuterClass.SongEvent.newBuilder().setName("Wolfgang Amadeus Mozart").setTitle("The Magic Flute").build(),
            SongEventOuterClass.SongEvent.newBuilder().setName("Johann Pachelbel").setTitle("Canon").build(),
            SongEventOuterClass.SongEvent.newBuilder().setName("Ludwig van Beethoven").setTitle("Symphony No. 5").build(),
            SongEventOuterClass.SongEvent.newBuilder().setName("Edward Elgar").setTitle("Pomp and Circumstance").build()
    );
 
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Must specify a test set (1 or 2).");
        }
        int choice = Integer.parseInt(args[0]);
        if (choice != 1 && choice != 2) {
            throw new IllegalArgumentException("Must specify a test set (1 or 2).");
        }
 
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.8.17.118:9092,10.8.17.119:9092,10.8.17.120:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new ProtobufSerializer<SongEventOuterClass.SongEvent>().getClass());
 
        try (final Producer<String, SongEventOuterClass.SongEvent> producer = new KafkaProducer<>(props)) {
            if (choice == 1) {
                TEST_SONG_EVENTS1.stream().map(song ->
                        new ProducerRecord<String, SongEventOuterClass.SongEvent>("rock-song-events", song))
                        .forEach(producer::send);
            } else {
                TEST_SONG_EVENTS2.stream().map(song ->
                        new ProducerRecord<String, SongEventOuterClass.SongEvent>("classical-song-events", song))
                        .forEach(producer::send);
            }
        }
 
    }
}