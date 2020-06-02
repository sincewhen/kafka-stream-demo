package fisher.kafka.streams;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import fisher.kafka.streams.proto.SongEventOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerdes;
 
public class MergeStreams {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("Config file path must be specified.");
        }
 
        MergeStreams app = new MergeStreams();
        Properties envProps = app.loadEnvProperties(args[0]);
        Properties streamProps = app.createStreamsProperties(envProps);
        Topology topology = app.buildTopology(envProps);
 
        app.preCreateTopics(envProps);
 
        final KafkaStreams streams = new KafkaStreams(topology, streamProps);
        final CountDownLatch latch = new CountDownLatch(1);
 
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });
 
        try {
            streams.start();
            latch.await();
        } catch (Exception e) {
            System.exit(1);
        }
        System.exit(0);
    }
 
    private Topology buildTopology(Properties envProps) {
        final StreamsBuilder builder = new StreamsBuilder();
        final String rockEvents = envProps.getProperty("input.rock.topic.name");
        final String classicalEvents = envProps.getProperty("input.classical.topic.name");
        final String allEvents = envProps.getProperty("output.topic.name");
 
 
        KStream<String, SongEventOuterClass.SongEvent> rockStreams =
                builder.stream(rockEvents, Consumed.with(Serdes.String(), songEventProtobufSerdes()));
        KStream<String, SongEventOuterClass.SongEvent> classicalStreams =
                builder.stream(classicalEvents, Consumed.with(Serdes.String(), songEventProtobufSerdes()));
        KStream<String, SongEventOuterClass.SongEvent> allStreams = rockStreams.merge(classicalStreams);
 
        allStreams.to(allEvents, Produced.with(Serdes.String(), songEventProtobufSerdes()));
        return builder.build();
    }
 
    private Properties createStreamsProperties(Properties envProps) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, envProps.getProperty("application.id"));
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        return props;
    }
 
    private void preCreateTopics(Properties envProps) throws Exception {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        String inputTopic1 = envProps.getProperty("input.rock.topic.name");
        String inputTopic2 = envProps.getProperty("input.classical.topic.name");
        String outputTopic = envProps.getProperty("output.topic.name");
        try (AdminClient client = AdminClient.create(config)) {
            Collection<TopicListing> existingTopics = client.listTopics().listings().get();
 
            List<NewTopic> topics = new ArrayList<>();
            List<String> topicNames = existingTopics.stream().map(TopicListing::name).collect(Collectors.toList());
            if (!topicNames.contains(inputTopic1))
                topics.add(new NewTopic(
                        envProps.getProperty("input.rock.topic.name"),
                        Integer.parseInt(envProps.getProperty("input.rock.topic.partitions")),
                        Short.parseShort(envProps.getProperty("input.rock.topic.replication.factor"))));
 
            if (!topicNames.contains(inputTopic2))
                topics.add(new NewTopic(
                        envProps.getProperty("input.classical.topic.name"),
                        Integer.parseInt(envProps.getProperty("input.classical.topic.partitions")),
                        Short.parseShort(envProps.getProperty("input.classical.topic.replication.factor"))));
 
            if (!topicNames.contains(outputTopic))
                topics.add(new NewTopic(
                        envProps.getProperty("output.topic.name"),
                        Integer.parseInt(envProps.getProperty("output.topic.partitions")),
                        Short.parseShort(envProps.getProperty("output.topic.replication.factor"))));
 
            if (!topics.isEmpty())
                client.createTopics(topics).all().get();
        }
    }
 
    private Properties loadEnvProperties(String fileName) throws IOException {
        Properties envProps = new Properties();
        try (FileInputStream input = new FileInputStream(fileName)) {
            envProps.load(input);
        }
        return envProps;
    }
 
    private static ProtobufSerdes<SongEventOuterClass.SongEvent> songEventProtobufSerdes() {
        return new ProtobufSerdes<>(SongEventOuterClass.SongEvent.parser());
    }
}