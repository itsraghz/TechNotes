# ERROR 

java.lang.ClassNotFoundException: org.slf4j.LoggerFactory

# FIX

Solution : Added sl4j-api.jar being added in the classpath which has the required class - org.slf4j.LoggerFactory


[main] INFO org.apache.kafka.clients.producer.ProducerConfig - ProducerConfig values: 
	acks = 1
	batch.size = 16384
	bootstrap.servers = [35.170.224.122:9092]
	buffer.memory = 33554432
	client.id = 
	compression.type = none
	connections.max.idle.ms = 540000
	enable.idempotence = false
	interceptor.classes = []
	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
	linger.ms = 0
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 0
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.StringSerializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
[kafka-producer-network-thread | producer-1] WARN org.apache.kafka.clients.NetworkClient - [Producer clientId=producer-1] Error while fetching metadata with correlation id 1 : {my-topic=LEADER_NOT_AVAILABLE}
[kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - Cluster ID: mIbxF6u7RGaV7CRY4TvA6w
[main] INFO org.apache.kafka.clients.producer.KafkaProducer - [Producer clientId=producer-1] Closing the Kafka producer with timeoutMillis = 9223372036854775807 ms.



--------------------------

https://stackoverflow.com/questions/35788697/leader-not-available-kafka-in-console-producer


What solved it for me is to set listeners like so:

advertised.listeners = PLAINTEXT://my.public.ip:9092
listeners = PLAINTEXT://0.0.0.0:9092

This makes KAFKA broker listen to all interfaces.

https://stackoverflow.com/a/46706677/1001242 - link to direct answer

# PROPER OUTPUT
----------------
[main] INFO org.apache.kafka.clients.producer.ProducerConfig - ProducerConfig values: 
	acks = 1
	batch.size = 16384
	bootstrap.servers = [35.170.224.122:9092]
	buffer.memory = 33554432
	client.id = 
	compression.type = none
	connections.max.idle.ms = 540000
	enable.idempotence = false
	interceptor.classes = []
	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
	linger.ms = 0
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 0
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.StringSerializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
[kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - Cluster ID: mIbxF6u7RGaV7CRY4TvA6w
[main] INFO org.apache.kafka.clients.producer.KafkaProducer - [Producer clientId=producer-1] Closing the Kafka producer with timeoutMillis = 9223372036854775807 ms.

------------------------------------------------------------------------------------

# Kafka Consumer Demo

## ERROR - as the source code has a `consumer.close()` method invocation.

```
[main] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values: 
	auto.commit.interval.ms = 5000
	auto.offset.reset = earliest
	bootstrap.servers = [35.170.224.122:9092]
	check.crcs = true
	client.id = 
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = test
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 500
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	session.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
Exception in thread "main" java.lang.IllegalStateException: This consumer has already been closed.
	at org.apache.kafka.clients.consumer.KafkaConsumer.acquireAndEnsureOpen(KafkaConsumer.java:2202)
	at org.apache.kafka.clients.consumer.KafkaConsumer.poll(KafkaConsumer.java:1158)
	at org.apache.kafka.clients.consumer.KafkaConsumer.poll(KafkaConsumer.java:1154)
	at tutorial.KafkaConsumerDemo.main(KafkaConsumerDemo.java:35)
```

## Source Code

```
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
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		consumer.subscribe(Arrays.asList("my-topic"));
		
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
		
			for (ConsumerRecord<String, String> record : records)
				System.out.printf("Topic = [%s], offset = %d, key = %s, value = %s", record.topic(), record.offset(), record.key(), record.value());
			
			consumer.close(); // closes the consumer and hence the error is thrown in the console. However, the Eclipse IDE threw a warning stating that the consumer resource was never closed.
		}
	}
}
```

## Proper Output

```
[main] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values: 
	auto.commit.interval.ms = 5000
	auto.offset.reset = earliest
	bootstrap.servers = [35.170.224.122:9092]
	check.crcs = true
	client.id = 
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = test
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 500
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	session.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
[main] INFO org.apache.kafka.clients.Metadata - Cluster ID: mIbxF6u7RGaV7CRY4TvA6w
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] Discovered group coordinator 35.170.224.122:9092 (id: 2147483647 rack: null)
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=test] Revoking previously assigned partitions []
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] (Re-)joining group
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] Successfully joined group with generation 1
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=test] Setting newly assigned partitions [my-topic-0]
[main] INFO org.apache.kafka.clients.consumer.internals.Fetcher - [Consumer clientId=consumer-1, groupId=test] Resetting offset for partition my-topic-0 to offset 0.
Topic = [my-topic], offset = 0, key = 0, value = 0Topic = [my-topic], offset = 1, key = 1, value = 1Topic = [my-topic], offset = 2, key = 2, value = 2Topic = [my-topic], offset = 3, key = 3, value = 3Topic = [my-topic], offset = 4, key = 4, value = 4Topic = [my-topic], offset = 5, key = 5, value = 5Topic = [my-topic], offset = 6, key = 6, value = 6Topic = [my-topic], offset = 7, key = 7, value = 7Topic = [my-topic], offset = 8, key = 8, value = 8Topic = [my-topic], offset = 9, key = 9, value = 9Topic = [my-topic], offset = 10, key = 10, value = 10Topic = [my-topic], offset = 11, key = 11, value = 11Topic = [my-topic], offset = 12, key = 12, value = 12Topic = [my-topic], offset = 13, key = 13, value = 13Topic = [my-topic], offset = 14, key = 14, value = 14Topic = [my-topic], offset = 15, key = 15, value = 15Topic = [my-topic], offset = 16, key = 16, value = 16Topic = [my-topic], offset = 17, key = 17, value = 17Topic = [my-topic], offset = 18, key = 18, value = 18Topic = [my-topic], offset = 19, key = 19, value = 19Topic = [my-topic], offset = 20, key = 20, value = 20Topic = [my-topic], offset = 21, key = 21, value = 21Topic = [my-topic], offset = 22, key = 22, value = 22Topic = [my-topic], offset = 23, key = 23, value = 23Topic = [my-topic], offset = 24, key = 24, value = 24Topic = [my-topic], offset = 25, key = 25, value = 25Topic = [my-topic], offset = 26, key = 26, value = 26Topic = [my-topic], offset = 27, key = 27, value = 27Topic = [my-topic], offset = 28, key = 28, value = 28Topic = [my-topic], offset = 29, key = 29, value = 29Topic = [my-topic], offset = 30, key = 30, value = 30Topic = [my-topic], offset = 31, key = 31, value = 31Topic = [my-topic], offset = 32, key = 32, value = 32Topic = [my-topic], offset = 33, key = 33, value = 33Topic = [my-topic], offset = 34, key = 34, value = 34Topic = [my-topic], offset = 35, key = 35, value = 35Topic = [my-topic], offset = 36, key = 36, value = 36Topic = [my-topic], offset = 37, key = 37, value = 37Topic = [my-topic], offset = 38, key = 38, value = 38Topic = [my-topic], offset = 39, key = 39, value = 39Topic = [my-topic], offset = 40, key = 40, value = 40Topic = [my-topic], offset = 41, key = 41, value = 41Topic = [my-topic], offset = 42, key = 42, value = 42Topic = [my-topic], offset = 43, key = 43, value = 43Topic = [my-topic], offset = 44, key = 44, value = 44Topic = [my-topic], offset = 45, key = 45, value = 45Topic = [my-topic], offset = 46, key = 46, value = 46Topic = [my-topic], offset = 47, key = 47, value = 47Topic = [my-topic], offset = 48, key = 48, value = 48Topic = [my-topic], offset = 49, key = 49, value = 49Topic = [my-topic], offset = 50, key = 50, value = 50Topic = [my-topic], offset = 51, key = 51, value = 51Topic = [my-topic], offset = 52, key = 52, value = 52Topic = [my-topic], offset = 53, key = 53, value = 53Topic = [my-topic], offset = 54, key = 54, value = 54Topic = [my-topic], offset = 55, key = 55, value = 55Topic = [my-topic], offset = 56, key = 56, value = 56Topic = [my-topic], offset = 57, key = 57, value = 57Topic = [my-topic], offset = 58, key = 58, value = 58Topic = [my-topic], offset = 59, key = 59, value = 59Topic = [my-topic], offset = 60, key = 60, value = 60Topic = [my-topic], offset = 61, key = 61, value = 61Topic = [my-topic], offset = 62, key = 62, value = 62Topic = [my-topic], offset = 63, key = 63, value = 63Topic = [my-topic], offset = 64, key = 64, value = 64Topic = [my-topic], offset = 65, key = 65, value = 65Topic = [my-topic], offset = 66, key = 66, value = 66Topic = [my-topic], offset = 67, key = 67, value = 67Topic = [my-topic], offset = 68, key = 68, value = 68Topic = [my-topic], offset = 69, key = 69, value = 69Topic = [my-topic], offset = 70, key = 70, value = 70Topic = [my-topic], offset = 71, key = 71, value = 71Topic = [my-topic], offset = 72, key = 72, value = 72Topic = [my-topic], offset = 73, key = 73, value = 73Topic = [my-topic], offset = 74, key = 74, value = 74Topic = [my-topic], offset = 75, key = 75, value = 75Topic = [my-topic], offset = 76, key = 76, value = 76Topic = [my-topic], offset = 77, key = 77, value = 77Topic = [my-topic], offset = 78, key = 78, value = 78Topic = [my-topic], offset = 79, key = 79, value = 79Topic = [my-topic], offset = 80, key = 80, value = 80Topic = [my-topic], offset = 81, key = 81, value = 81Topic = [my-topic], offset = 82, key = 82, value = 82Topic = [my-topic], offset = 83, key = 83, value = 83Topic = [my-topic], offset = 84, key = 84, value = 84Topic = [my-topic], offset = 85, key = 85, value = 85Topic = [my-topic], offset = 86, key = 86, value = 86Topic = [my-topic], offset = 87, key = 87, value = 87Topic = [my-topic], offset = 88, key = 88, value = 88Topic = [my-topic], offset = 89, key = 89, value = 89Topic = [my-topic], offset = 90, key = 90, value = 90Topic = [my-topic], offset = 91, key = 91, value = 91Topic = [my-topic], offset = 92, key = 92, value = 92Topic = [my-topic], offset = 93, key = 93, value = 93Topic = [my-topic], offset = 94, key = 94, value = 94Topic = [my-topic], offset = 95, key = 95, value = 95Topic = [my-topic], offset = 96, key = 96, value = 96Topic = [my-topic], offset = 97, key = 97, value = 97Topic = [my-topic], offset = 98, key = 98, value = 98Topic = [my-topic], offset = 99, key = 99, value = 99Topic = [my-topic], offset = 100, key = 0, value = 0Topic = [my-topic], offset = 101, key = 1, value = 1Topic = [my-topic], offset = 102, key = 2, value = 2Topic = [my-topic], offset = 103, key = 3, value = 3Topic = [my-topic], offset = 104, key = 4, value = 4Topic = [my-topic], offset = 105, key = 5, value = 5Topic = [my-topic], offset = 106, key = 6, value = 6Topic = [my-topic], offset = 107, key = 7, value = 7Topic = [my-topic], offset = 108, key = 8, value = 8Topic = [my-topic], offset = 109, key = 9, value = 9Topic = [my-topic], offset = 110, key = 10, value = 10Topic = [my-topic], offset = 111, key = 11, value = 11Topic = [my-topic], offset = 112, key = 12, value = 12Topic = [my-topic], offset = 113, key = 13, value = 13Topic = [my-topic], offset = 114, key = 14, value = 14Topic = [my-topic], offset = 115, key = 15, value = 15Topic = [my-topic], offset = 116, key = 16, value = 16Topic = [my-topic], offset = 117, key = 17, value = 17Topic = [my-topic], offset = 118, key = 18, value = 18Topic = [my-topic], offset = 119, key = 19, value = 19Topic = [my-topic], offset = 120, key = 20, value = 20Topic = [my-topic], offset = 121, key = 21, value = 21Topic = [my-topic], offset = 122, key = 22, value = 22Topic = [my-topic], offset = 123, key = 23, value = 23Topic = [my-topic], offset = 124, key = 24, value = 24Topic = [my-topic], offset = 125, key = 25, value = 25Topic = [my-topic], offset = 126, key = 26, value = 26Topic = [my-topic], offset = 127, key = 27, value = 27Topic = [my-topic], offset = 128, key = 28, value = 28Topic = [my-topic], offset = 129, key = 29, value = 29Topic = [my-topic], offset = 130, key = 30, value = 30Topic = [my-topic], offset = 131, key = 31, value = 31Topic = [my-topic], offset = 132, key = 32, value = 32Topic = [my-topic], offset = 133, key = 33, value = 33Topic = [my-topic], offset = 134, key = 34, value = 34Topic = [my-topic], offset = 135, key = 35, value = 35Topic = [my-topic], offset = 136, key = 36, value = 36Topic = [my-topic], offset = 137, key = 37, value = 37Topic = [my-topic], offset = 138, key = 38, value = 38Topic = [my-topic], offset = 139, key = 39, value = 39Topic = [my-topic], offset = 140, key = 40, value = 40Topic = [my-topic], offset = 141, key = 41, value = 41Topic = [my-topic], offset = 142, key = 42, value = 42Topic = [my-topic], offset = 143, key = 43, value = 43Topic = [my-topic], offset = 144, key = 44, value = 44Topic = [my-topic], offset = 145, key = 45, value = 45Topic = [my-topic], offset = 146, key = 46, value = 46Topic = [my-topic], offset = 147, key = 47, value = 47Topic = [my-topic], offset = 148, key = 48, value = 48Topic = [my-topic], offset = 149, key = 49, value = 49Topic = [my-topic], offset = 150, key = 50, value = 50Topic = [my-topic], offset = 151, key = 51, value = 51Topic = [my-topic], offset = 152, key = 52, value = 52Topic = [my-topic], offset = 153, key = 53, value = 53Topic = [my-topic], offset = 154, key = 54, value = 54Topic = [my-topic], offset = 155, key = 55, value = 55Topic = [my-topic], offset = 156, key = 56, value = 56Topic = [my-topic], offset = 157, key = 57, value = 57Topic = [my-topic], offset = 158, key = 58, value = 58Topic = [my-topic], offset = 159, key = 59, value = 59Topic = [my-topic], offset = 160, key = 60, value = 60Topic = [my-topic], offset = 161, key = 61, value = 61Topic = [my-topic], offset = 162, key = 62, value = 62Topic = [my-topic], offset = 163, key = 63, value = 63Topic = [my-topic], offset = 164, key = 64, value = 64Topic = [my-topic], offset = 165, key = 65, value = 65Topic = [my-topic], offset = 166, key = 66, value = 66Topic = [my-topic], offset = 167, key = 67, value = 67Topic = [my-topic], offset = 168, key = 68, value = 68Topic = [my-topic], offset = 169, key = 69, value = 69Topic = [my-topic], offset = 170, key = 70, value = 70Topic = [my-topic], offset = 171, key = 71, value = 71Topic = [my-topic], offset = 172, key = 72, value = 72Topic = [my-topic], offset = 173, key = 73, value = 73Topic = [my-topic], offset = 174, key = 74, value = 74Topic = [my-topic], offset = 175, key = 75, value = 75Topic = [my-topic], offset = 176, key = 76, value = 76Topic = [my-topic], offset = 177, key = 77, value = 77Topic = [my-topic], offset = 178, key = 78, value = 78Topic = [my-topic], offset = 179, key = 79, value = 79Topic = [my-topic], offset = 180, key = 80, value = 80Topic = [my-topic], offset = 181, key = 81, value = 81Topic = [my-topic], offset = 182, key = 82, value = 82Topic = [my-topic], offset = 183, key = 83, value = 83Topic = [my-topic], offset = 184, key = 84, value = 84Topic = [my-topic], offset = 185, key = 85, value = 85Topic = [my-topic], offset = 186, key = 86, value = 86Topic = [my-topic], offset = 187, key = 87, value = 87Topic = [my-topic], offset = 188, key = 88, value = 88Topic = [my-topic], offset = 189, key = 89, value = 89Topic = [my-topic], offset = 190, key = 90, value = 90Topic = [my-topic], offset = 191, key = 91, value = 91Topic = [my-topic], offset = 192, key = 92, value = 92Topic = [my-topic], offset = 193, key = 93, value = 93Topic = [my-topic], offset = 194, key = 94, value = 94Topic = [my-topic], offset = 195, key = 95, value = 95Topic = [my-topic], offset = 196, key = 96, value = 96Topic = [my-topic], offset = 197, key = 97, value = 97Topic = [my-topic], offset = 198, key = 98, value = 98Topic = [my-topic], offset = 199, key = 99, value = 99
```

## Next Run of `KafkaConsumerDemo.java`

No more messages to be read.

```
[main] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values: 
	auto.commit.interval.ms = 5000
	auto.offset.reset = earliest
	bootstrap.servers = [35.170.224.122:9092]
	check.crcs = true
	client.id = 
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = test
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 500
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	session.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
[main] INFO org.apache.kafka.clients.Metadata - Cluster ID: mIbxF6u7RGaV7CRY4TvA6w
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] Discovered group coordinator 35.170.224.122:9092 (id: 2147483647 rack: null)
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=test] Revoking previously assigned partitions []
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] (Re-)joining group
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] Successfully joined group with generation 3
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=test] Setting newly assigned partitions [my-topic-0]
```

Run the `KafkaProducerDemo.java` to push another 100 messages while the consumer is still running. Now the consumer produces the following output (modified a bit with the better intendation on the console)

## KafkaProcuderDemo - Output

```
[main] INFO org.apache.kafka.clients.producer.ProducerConfig - ProducerConfig values: 
	acks = 1
	batch.size = 16384
	bootstrap.servers = [35.170.224.122:9092]
	buffer.memory = 33554432
	client.id = 
	compression.type = none
	connections.max.idle.ms = 540000
	enable.idempotence = false
	interceptor.classes = []
	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
	linger.ms = 0
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 0
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.StringSerializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
[kafka-producer-network-thread | producer-1] INFO org.apache.kafka.clients.Metadata - Cluster ID: mIbxF6u7RGaV7CRY4TvA6w
[main] INFO org.apache.kafka.clients.producer.KafkaProducer - [Producer clientId=producer-1] Closing the Kafka producer with timeoutMillis = 9223372036854775807 ms.
```

## KafkaConsumerDemo Output

```
[main] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values: 
	auto.commit.interval.ms = 5000
	auto.offset.reset = earliest
	bootstrap.servers = [35.170.224.122:9092]
	check.crcs = true
	client.id = 
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = test
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 500
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	session.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
[main] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
[main] INFO org.apache.kafka.clients.Metadata - Cluster ID: mIbxF6u7RGaV7CRY4TvA6w
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] Discovered group coordinator 35.170.224.122:9092 (id: 2147483647 rack: null)
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=test] Revoking previously assigned partitions []
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] (Re-)joining group
[main] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-1, groupId=test] Successfully joined group with generation 5
[main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-1, groupId=test] Setting newly assigned partitions [my-topic-0]
Topic = [my-topic], offset = 200, key = 0, value = 0
Topic = [my-topic], offset = 201, key = 1, value = 1
Topic = [my-topic], offset = 202, key = 2, value = 2
Topic = [my-topic], offset = 203, key = 3, value = 3
Topic = [my-topic], offset = 204, key = 4, value = 4
Topic = [my-topic], offset = 205, key = 5, value = 5
Topic = [my-topic], offset = 206, key = 6, value = 6
Topic = [my-topic], offset = 207, key = 7, value = 7
Topic = [my-topic], offset = 208, key = 8, value = 8
Topic = [my-topic], offset = 209, key = 9, value = 9
Topic = [my-topic], offset = 210, key = 10, value = 10
Topic = [my-topic], offset = 211, key = 11, value = 11
Topic = [my-topic], offset = 212, key = 12, value = 12
Topic = [my-topic], offset = 213, key = 13, value = 13
Topic = [my-topic], offset = 214, key = 14, value = 14
Topic = [my-topic], offset = 215, key = 15, value = 15
Topic = [my-topic], offset = 216, key = 16, value = 16
Topic = [my-topic], offset = 217, key = 17, value = 17
Topic = [my-topic], offset = 218, key = 18, value = 18
Topic = [my-topic], offset = 219, key = 19, value = 19
Topic = [my-topic], offset = 220, key = 20, value = 20
Topic = [my-topic], offset = 221, key = 21, value = 21
Topic = [my-topic], offset = 222, key = 22, value = 22
Topic = [my-topic], offset = 223, key = 23, value = 23
Topic = [my-topic], offset = 224, key = 24, value = 24
Topic = [my-topic], offset = 225, key = 25, value = 25
Topic = [my-topic], offset = 226, key = 26, value = 26
Topic = [my-topic], offset = 227, key = 27, value = 27
Topic = [my-topic], offset = 228, key = 28, value = 28
Topic = [my-topic], offset = 229, key = 29, value = 29
Topic = [my-topic], offset = 230, key = 30, value = 30
Topic = [my-topic], offset = 231, key = 31, value = 31
Topic = [my-topic], offset = 232, key = 32, value = 32
Topic = [my-topic], offset = 233, key = 33, value = 33
Topic = [my-topic], offset = 234, key = 34, value = 34
Topic = [my-topic], offset = 235, key = 35, value = 35
Topic = [my-topic], offset = 236, key = 36, value = 36
Topic = [my-topic], offset = 237, key = 37, value = 37
Topic = [my-topic], offset = 238, key = 38, value = 38
Topic = [my-topic], offset = 239, key = 39, value = 39
Topic = [my-topic], offset = 240, key = 40, value = 40
Topic = [my-topic], offset = 241, key = 41, value = 41
Topic = [my-topic], offset = 242, key = 42, value = 42
Topic = [my-topic], offset = 243, key = 43, value = 43
Topic = [my-topic], offset = 244, key = 44, value = 44
Topic = [my-topic], offset = 245, key = 45, value = 45
Topic = [my-topic], offset = 246, key = 46, value = 46
Topic = [my-topic], offset = 247, key = 47, value = 47
Topic = [my-topic], offset = 248, key = 48, value = 48
Topic = [my-topic], offset = 249, key = 49, value = 49
Topic = [my-topic], offset = 250, key = 50, value = 50
Topic = [my-topic], offset = 251, key = 51, value = 51
Topic = [my-topic], offset = 252, key = 52, value = 52
Topic = [my-topic], offset = 253, key = 53, value = 53
Topic = [my-topic], offset = 254, key = 54, value = 54
Topic = [my-topic], offset = 255, key = 55, value = 55
Topic = [my-topic], offset = 256, key = 56, value = 56
Topic = [my-topic], offset = 257, key = 57, value = 57
Topic = [my-topic], offset = 258, key = 58, value = 58
Topic = [my-topic], offset = 259, key = 59, value = 59
Topic = [my-topic], offset = 260, key = 60, value = 60
Topic = [my-topic], offset = 261, key = 61, value = 61
Topic = [my-topic], offset = 262, key = 62, value = 62
Topic = [my-topic], offset = 263, key = 63, value = 63
Topic = [my-topic], offset = 264, key = 64, value = 64
Topic = [my-topic], offset = 265, key = 65, value = 65
Topic = [my-topic], offset = 266, key = 66, value = 66
Topic = [my-topic], offset = 267, key = 67, value = 67
Topic = [my-topic], offset = 268, key = 68, value = 68
Topic = [my-topic], offset = 269, key = 69, value = 69
Topic = [my-topic], offset = 270, key = 70, value = 70
Topic = [my-topic], offset = 271, key = 71, value = 71
Topic = [my-topic], offset = 272, key = 72, value = 72
Topic = [my-topic], offset = 273, key = 73, value = 73
Topic = [my-topic], offset = 274, key = 74, value = 74
Topic = [my-topic], offset = 275, key = 75, value = 75
Topic = [my-topic], offset = 276, key = 76, value = 76
Topic = [my-topic], offset = 277, key = 77, value = 77
Topic = [my-topic], offset = 278, key = 78, value = 78
Topic = [my-topic], offset = 279, key = 79, value = 79
Topic = [my-topic], offset = 280, key = 80, value = 80
Topic = [my-topic], offset = 281, key = 81, value = 81
Topic = [my-topic], offset = 282, key = 82, value = 82
Topic = [my-topic], offset = 283, key = 83, value = 83
Topic = [my-topic], offset = 284, key = 84, value = 84
Topic = [my-topic], offset = 285, key = 85, value = 85
Topic = [my-topic], offset = 286, key = 86, value = 86
Topic = [my-topic], offset = 287, key = 87, value = 87
Topic = [my-topic], offset = 288, key = 88, value = 88
Topic = [my-topic], offset = 289, key = 89, value = 89
Topic = [my-topic], offset = 290, key = 90, value = 90
Topic = [my-topic], offset = 291, key = 91, value = 91
Topic = [my-topic], offset = 292, key = 92, value = 92
Topic = [my-topic], offset = 293, key = 93, value = 93
Topic = [my-topic], offset = 294, key = 94, value = 94
Topic = [my-topic], offset = 295, key = 95, value = 95
Topic = [my-topic], offset = 296, key = 96, value = 96
Topic = [my-topic], offset = 297, key = 97, value = 97
Topic = [my-topic], offset = 298, key = 98, value = 98
Topic = [my-topic], offset = 299, key = 99, value = 99
```