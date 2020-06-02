package fisher.kafka.streams;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
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
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.Windowed;

import fisher.kafka.streams.proto.RatingOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerdes;
 
public class TumblingWindow {
 
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("This program takes one argument: the path to an environment configuration file.");
        }
 
        new TumblingWindow().runRecipe(args[0]);
    }
 
    private Properties loadEnvProperties(String fileName) throws IOException {
        Properties envProps = new Properties();
        try (FileInputStream input = new FileInputStream(fileName)) {
            envProps.load(input);
        }
        return envProps;
    }
 
    private void runRecipe(final String configPath) throws Exception {
        Properties envProps = this.loadEnvProperties(configPath);
        Properties streamProps = this.createStreamsProperties(envProps);
 
        Topology topology = this.buildTopology(envProps);
        this.preCreateTopics(envProps);
 
        final KafkaStreams streams = new KafkaStreams(topology, streamProps);
        final CountDownLatch latch = new CountDownLatch(1);
 
        // Attach shutdown handler to catch Control-C.
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
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);
 
    }
 
 
    private Topology buildTopology(final Properties envProps) {
        final StreamsBuilder builder = new StreamsBuilder();
        final String ratingTopic = envProps.getProperty("rating.topic.name");
        final String ratingCountTopic = envProps.getProperty("rating.count.topic.name");
 
        builder.stream(ratingTopic, Consumed.with(Serdes.String(), ratingProtobufSerdes()))
                .map((key, rating) -> new KeyValue<>(rating.getTitle(), rating))
                .groupByKey(Grouped.with(Serdes.String(), ratingProtobufSerdes()))
                .windowedBy(TimeWindows.of(Duration.ofMinutes(10)))
                .count()
                .toStream()
                .<String, String>map((Windowed<String> key, Long count) -> new KeyValue(windowedKeyToString(key), count.toString()))
                .to(ratingCountTopic);
 
        return builder.build();
    }
 
 
    private static void preCreateTopics(Properties envProps) throws Exception {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        String inputTopic = envProps.getProperty("rating.topic.name");
        String outputTopic = envProps.getProperty("rating.count.topic.name");
        Map<String, String> topicConfigs = new HashMap<>();
        topicConfigs.put("retention.ms", Long.toString(Long.MAX_VALUE));
 
 
        try (AdminClient client = AdminClient.create(config)) {
            Collection<TopicListing> existingTopics = client.listTopics().listings().get();
 
            List<NewTopic> topics = new ArrayList<>();
            List<String> topicNames = existingTopics.stream().map(TopicListing::name).collect(Collectors.toList());
            if (!topicNames.contains(inputTopic))
                topics.add(new NewTopic(
                        inputTopic,
                        Integer.parseInt(envProps.getProperty("rating.topic.partitions")),
                        Short.parseShort(envProps.getProperty("rating.topic.replication.factor"))).configs(topicConfigs));
 
            if (!topicNames.contains(outputTopic))
                topics.add(new NewTopic(
                        outputTopic,
                        Integer.parseInt(envProps.getProperty("rating.count.topic.partitions")),
                        Short.parseShort(envProps.getProperty("rating.count.topic.replication.factor"))).configs(topicConfigs));
 
            if (!topics.isEmpty())
                client.createTopics(topics).all().get();
        }
    }
 
    private Properties createStreamsProperties(Properties envProps) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, envProps.getProperty("application.id"));
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, RatingTimestampExtractor.class.getName());
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        try {
            props.put(StreamsConfig.STATE_DIR_CONFIG,
                    Files.createTempDirectory("tumbling-windows").toAbsolutePath().toString());
        } catch (IOException ignored) {
        }
        return props;
    }
 
    private String windowedKeyToString(Windowed<String> key) {
        return String.format("[%s@%s/%s]", key.key(), key.window().start(), key.window().end());
    }
 
    private static ProtobufSerdes<RatingOuterClass.Rating> ratingProtobufSerdes() {
        return new ProtobufSerdes<>(RatingOuterClass.Rating.parser());
    }
}