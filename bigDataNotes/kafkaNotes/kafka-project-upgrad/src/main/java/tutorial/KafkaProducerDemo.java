/**
 * 
 */
package tutorial;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author raghs
 *
 */
public class KafkaProducerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Properties props = new Properties();
		
		// IP Address of the machine where Kafka Server is running (IPV4 Address of Amazon EC2 Instance
		props.put("bootstrap.servers", "35.170.224.122:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		
		for (int i = 0; i < 100; i++)
			producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)));
		
		producer.close();
	}

}
