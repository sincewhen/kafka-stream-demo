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
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

import fisher.kafka.streams.proto.MovieTicketSalesOuterClass;
import fisher.kafka.streams.proto.YearlyMovieFiguresOuterClass;
import fisher.kafka.streams.serdes.ProtobufSerdes;

public class AggregatingMinMax {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("This program takes one argument: the path to an environnment configuration file.");
        }

        new AggregatingMinMax().runRecipe(args[0]);
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

        Topology topology = this.buildTopology(envProps, movieTicketSalesProtobufSerdes(), yearlyMovieFiguresProtobufSerdes());
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

    private static ProtobufSerdes<MovieTicketSalesOuterClass.MovieTicketSales> movieTicketSalesProtobufSerdes() {
        return new ProtobufSerdes<>(MovieTicketSalesOuterClass.MovieTicketSales.parser());
    }

    private static ProtobufSerdes<YearlyMovieFiguresOuterClass.YearlyMovieFigures> yearlyMovieFiguresProtobufSerdes() {
        return new ProtobufSerdes<>(YearlyMovieFiguresOuterClass.YearlyMovieFigures.parser());
    }

    private Topology buildTopology(final Properties envProps,
                                   final ProtobufSerdes<MovieTicketSalesOuterClass.MovieTicketSales> movieTicketSalesProtobufSerdes,
                                   final ProtobufSerdes<YearlyMovieFiguresOuterClass.YearlyMovieFigures> yearlyMovieFiguresProtobufSerdes) {
        final StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = envProps.getProperty("input.topic.name");
        final String outputTopic = envProps.getProperty("output.topic.name");

        builder.stream(inputTopic, Consumed.with(Serdes.String(), movieTicketSalesProtobufSerdes))
                .groupBy(
                        (k, v) -> v.getReleaseYear(),
                        Grouped.with(Serdes.Integer(), movieTicketSalesProtobufSerdes))
                .aggregate(
                        () -> YearlyMovieFiguresOuterClass.YearlyMovieFigures.newBuilder()
                                .setReleaseYear(0).setMaxTotalSales(Integer.MIN_VALUE).setMinTotalSales(Integer.MAX_VALUE).build(),
                        ((key, value, aggregate) ->
                                YearlyMovieFiguresOuterClass.YearlyMovieFigures.newBuilder().setReleaseYear(key)
                                        .setMinTotalSales(Math.min(value.getTotalSales(), aggregate.getMinTotalSales()))
                                        .setMaxTotalSales(Math.max(value.getTotalSales(), aggregate.getMaxTotalSales()))
                                        .build()),
                        Materialized.with(Serdes.Integer(), yearlyMovieFiguresProtobufSerdes))
                .toStream()
                .to(outputTopic, Produced.with(Serdes.Integer(), yearlyMovieFiguresProtobufSerdes));

        return builder.build();
    }


    private static void preCreateTopics(Properties envProps) throws Exception {
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

    private Properties createStreamsProperties(Properties envProps) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, envProps.getProperty("application.id"));
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        return props;
    }
}