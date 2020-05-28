package fisher.kafka.streams;
 
import fisher.kafka.streams.proto.ParsedMovie;
import fisher.kafka.streams.proto.RawMovieOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerdes;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
 
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
 
public class MovieStreamApp {
 
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("Config file path must be specified.");
        }
 
        MovieStreamApp app = new MovieStreamApp();
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
 
 
    /**
     * 构建Streams拓扑对象实例
     *
     * @param envProps
     * @return
     */
    private Topology buildTopology(Properties envProps) {
        final StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = envProps.getProperty("input.topic.name");
        final String outputTopic = envProps.getProperty("output.topic.name");
 
        builder.stream(inputTopic, Consumed.with(Serdes.String(), rawMovieProtobufSerdes()))
                .map((key, rawMovie) -> new KeyValue<>(rawMovie.getId(), parseRawMovie(rawMovie)))
                .to(outputTopic, Produced.with(Serdes.Long(), movieProtobufSerdes()));
 
        return builder.build();
    }
 
    /**
     *
     * @param envProps
     * @return
     */
    private Properties createStreamsProperties(Properties envProps) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, envProps.getProperty("application.id"));
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        return props;
    }
 
    /**
     *
     * @param envProps
     * @throws Exception
     */
    private void preCreateTopics(Properties envProps) throws Exception {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        String inputTopic = envProps.getProperty("input.topic.name");
        String outputTopic = envProps.getProperty("output.topic.name");
        try (AdminClient client = AdminClient.create(config)) {
            Collection<TopicListing> existingTopics = client.listTopics().listings().get();
 
            List<NewTopic> topics = new ArrayList<>();
            List<String> topicNames = existingTopics.stream().map(TopicListing::name).collect(Collectors.toList());
            if (!topicNames.contains(inputTopic))
                topics.add(new NewTopic(
                        envProps.getProperty("input.topic.name"),
                        Integer.parseInt(envProps.getProperty("input.topic.partitions")),
                        Short.parseShort(envProps.getProperty("input.topic.replication.factor"))));
 
            if (!topicNames.contains(outputTopic))
                topics.add(new NewTopic(
                        envProps.getProperty("output.topic.name"),
                        Integer.parseInt(envProps.getProperty("output.topic.partitions")),
                        Short.parseShort(envProps.getProperty("output.topic.replication.factor"))));
 
            if (!topics.isEmpty())
                client.createTopics(topics).all().get();
        }
    }
 
    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    private Properties loadEnvProperties(String fileName) throws IOException {
        Properties envProps = new Properties();
        try (FileInputStream input = new FileInputStream(fileName)) {
            envProps.load(input);
        }
        return envProps;
    }
 
    /**
     *
     * @return
     */
    private static ProtobufSerdes<ParsedMovie.Movie> movieProtobufSerdes() {
        return new ProtobufSerdes<>(ParsedMovie.Movie.parser());
    }
 
    /**
     *
     * @return
     */
    private static ProtobufSerdes<RawMovieOuterClass.RawMovie> rawMovieProtobufSerdes() {
        return new ProtobufSerdes<>(RawMovieOuterClass.RawMovie.parser());
    }
 
    /**
     *
     * @param rawMovie
     * @return
     */
    private static ParsedMovie.Movie parseRawMovie(RawMovieOuterClass.RawMovie rawMovie) {
        String[] titleParts = rawMovie.getTitle().split("::");
        String title = titleParts[0];
        int releaseYear = Integer.parseInt(titleParts[1]);
        return ParsedMovie.Movie.newBuilder()
                .setId(rawMovie.getId())
                .setTitle(title)
                .setReleaseYear(releaseYear)
                .setGenre(rawMovie.getGenre())
                .build();
    }
}
