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
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.Produced;

import fisher.kafka.streams.proto.TicketSaleOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerdes;
 
public class AggregatingSum {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException(
                    "This program takes one argument: the path to an environment configuration file.");
        }
        new AggregatingSum().runRecipe(args[0]);
    }
 
    private void runRecipe(final String configPath) throws Exception {
        Properties envProps = this.loadEnvProperties(configPath);
        Properties streamProps = this.createStreamsProperties(envProps);
 
        Topology topology = this.buildTopology(envProps, ticketSaleProtobufSerdes());
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
 
    private Properties createStreamsProperties(Properties envProps) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, envProps.getProperty("application.id"));
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        return props;
    }
 
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
                        inputTopic,
                        Integer.parseInt(envProps.getProperty("input.topic.partitions")),
                        Short.parseShort(envProps.getProperty("input.topic.replication.factor"))));
 
            if (!topicNames.contains(outputTopic))
                topics.add(new NewTopic(
                        outputTopic,
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
 
    private Topology buildTopology(Properties envProps, final ProtobufSerdes<TicketSaleOuterClass.TicketSale> ticketSaleSerde) {
        final StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = envProps.getProperty("input.topic.name");
        final String outputTopic = envProps.getProperty("output.topic.name");
 
        builder.stream(inputTopic, Consumed.with(Serdes.String(), ticketSaleSerde))
                .map((k, v) -> new KeyValue<>(v.getTitle(), v.getTicketTotalValue()))
                .groupByKey(Grouped.with(Serdes.String(), Serdes.Integer()))
                .reduce(Integer::sum)
                .toStream()
                .to(outputTopic, Produced.with(Serdes.String(), Serdes.Integer()));
        return builder.build();
    }
 
    private static ProtobufSerdes<TicketSaleOuterClass.TicketSale> ticketSaleProtobufSerdes() {
        return new ProtobufSerdes<>(TicketSaleOuterClass.TicketSale.parser());
    }
}