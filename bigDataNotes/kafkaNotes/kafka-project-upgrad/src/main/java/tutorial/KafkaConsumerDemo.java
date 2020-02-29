package tutorial;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * 
 * @author raghs
 *
 */
public class KafkaConsumerDemo {

	public static void main(String[] args) 
	{
		Properties props = new Properties();
		
		/** IP Address of the machine where Kafka Server is running (IPV4 Address of Amazon EC2 Instance */
		//props.put("bootstrap.servers", "localhost:9092");
		props.put("bootstrap.servers", "35.170.224.122:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.offset.reset", "earliest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		@SuppressWarnings("resource")
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList("my-topic"));
		
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
		
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("Topic = [%s], offset = %d, key = %s, value = %s", 
						record.topic(), record.offset(), record.key(), record.value());
				System.out.println();
			}
			
			//consumer.close();
		}
	}
}