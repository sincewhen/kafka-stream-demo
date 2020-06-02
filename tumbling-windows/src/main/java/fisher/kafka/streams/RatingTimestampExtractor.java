package fisher.kafka.streams;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

import fisher.kafka.streams.proto.RatingOuterClass;
 
public class RatingTimestampExtractor implements TimestampExtractor {
 
    @Override
    public long extract(ConsumerRecord<Object, Object> record, long partitionTime) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String eventTime = ((RatingOuterClass.Rating)record.value()).getTimestamp();
        try {
            return sdf.parse(eventTime).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }
}