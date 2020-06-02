package fisher.kafka.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;

public class SelectKeyStreamsApp {


    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("Environment configuration file must be specified.");
        }
 
        SelectKeyStreamsApp app = new SelectKeyStreamsApp();
        Properties envProps = app.loadEnvProperties(args[0]);
        Properties streamProps = app.buildStreamsProperties(envProps);
 
        app.preCreateTopics(envProps);
 
        Topology topology = app.buildTopology(envProps);
 
        final KafkaStreams streams = new KafkaStreams(topology, streamProps);
        final CountDownLatch latch = new CountDownLatch(1);
 
        Runtime.getRuntime().addShutdownHook(new Thread("streams-jvm-shutdown-hook") {
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
 
        final String inputTopic = envProps.getProperty("input.topic.name");
        final String outputTopic = envProps.getProperty("output.topic.name");
 
        builder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()))
                .selectKey((noKey, value) -> {
                    String[] fields = value.split("\\|");
                    return fields[fields.length - 1].trim().substring(0, 4);
                }).to(outputTopic);
        return builder.build();
    }
 
    private Properties buildStreamsProperties(Properties envProps) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, envProps.getProperty("application.id"));
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, envProps.getProperty("bootstrap.servers"));
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        return props;
    }
 
    private void preCreateTopics(Properties envProps) throws Exception {
        Map<String, Object> config = new HashMap<>();
        config.put("bootstrap.servers", envProps.getProperty("bootstrap.servers"));
        try (AdminClient client = AdminClient.create(config)) {
            Set<String> existingTopics = client.listTopics().names().get();
 
            List<NewTopic> topics = new ArrayList<>();
            String inputTopic = envProps.getProperty("input.topic.name");
            if (!existingTopics.contains(inputTopic)) {
                topics.add(new NewTopic(inputTopic,
                        Integer.parseInt(envProps.getProperty("input.topic.partitions")),
                        Short.parseShort(envProps.getProperty("input.topic.replication.factor"))));
 
            }
 
            String outputTopic = envProps.getProperty("output.topic.name");
            if (!existingTopics.contains(outputTopic)) {
                topics.add(new NewTopic(outputTopic,
                        Integer.parseInt(envProps.getProperty("output.topic.partitions")),
                        Short.parseShort(envProps.getProperty("output.topic.replication.factor"))));
            }
 
            client.createTopics(topics);
        }
    }
 
    private Properties loadEnvProperties(String filePath) throws IOException {
        Properties envProps = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            envProps.load(input);
        }
        return envProps;
    }

}
