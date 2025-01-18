# Apache Kafka Guide

## 1. Introduction to Kafka

Apache Kafka is a distributed streaming platform that enables building real-time data pipelines and streaming applications. It was originally developed by LinkedIn and later became an open-source Apache project.

Think of Kafka as a high-throughput distributed messaging system that works like a commit log, where:
- Messages are persisted on disk
- Data is replicated for fault tolerance
- Messages are immutable once written

## 2. Key Benefits and Problems it Solves

### Benefits:
- High Throughput: Can handle millions of messages per second
- Low Latency: Messages are processed in real-time (milliseconds)
- Fault Tolerance: Data is replicated across multiple nodes
- Durability: Messages are persisted on disk
- Scalability: Easy to scale horizontally

### Problems it Solves:
- Decoupling of Data Streams
- Real-time Data Processing
- System Integration at Scale
- Event Sourcing
- Stream Processing

## 3. Architecture Overview

```
+----------------+     +------------------+     +------------------+
|                |     |                  |     |                  |
|   Producers    |---->|   Kafka Cluster  |<----|   Consumers     |
|                |     |                  |     |                  |
+----------------+     +------------------+     +------------------+
                    |    Topic 1        |
                    |    [P0][P1][P2]   |
                    |    Topic 2        |
                    |    [P0][P1]       |
                    +------------------+

Where: P0, P1, P2 are partitions
```

### Key Components:
- **Topic**: A category/feed name to which records are published
- **Partition**: Topics are split into partitions for parallelism
- **Producer**: Publishes messages to topics
- **Consumer**: Subscribes to topics and processes messages
- **Broker**: Individual Kafka servers

## 4. Simple Producer-Consumer Example

### Maven Configuration (pom.xml)
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.kafka</groupId>
        <artifactId>kafka-clients</artifactId>
        <version>3.5.0</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>2.0.7</version>
    </dependency>
</dependencies>
```

### Producer Example
```java
import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        
        Producer<String, String> producer = new KafkaProducer<>(props);
        
        ProducerRecord<String, String> record = 
            new ProducerRecord<>("test-topic", "key", "Hello, Kafka!");
        
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Message sent successfully!");
                System.out.println("Topic: " + metadata.topic());
                System.out.println("Partition: " + metadata.partition());
                System.out.println("Offset: " + metadata.offset());
            } else {
                exception.printStackTrace();
            }
        });
        
        producer.close();
    }
}
```

### Consumer Example
```java
import org.apache.kafka.clients.consumer.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class SimpleConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        
        Consumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test-topic"));
        
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Received message:");
                System.out.println("Key: " + record.key());
                System.out.println("Value: " + record.value());
                System.out.println("Partition: " + record.partition());
                System.out.println("Offset: " + record.offset());
            }
        }
    }
}
```

## 5. Sample Console Output

### Producer Output
```
Message sent successfully!
Topic: test-topic
Partition: 0
Offset: 5
```

### Consumer Output
```
Received message:
Key: key
Value: Hello, Kafka!
Partition: 0
Offset: 5
```

## 6. Best Practices and Use Cases

### Best Practices
1. **Topic Configuration**
- Use appropriate number of partitions
- Configure retention policies
- Set proper replication factor

2. **Producer Best Practices**
- Use appropriate acknowledgment level
- Batch messages when possible
- Handle errors properly

3. **Consumer Best Practices**
- Process messages idempotently
- Commit offsets after processing
- Handle consumer group rebalancing

### Common Use Cases
1. **Messaging System**
- Decoupled communication between services

2. **Activity Tracking**
- User behavior analysis
- Application monitoring

3. **Metrics Collection**
- Gathering operational data
- System monitoring

4. **Log Aggregation**
- Centralized log collection
- Real-time log processing

5. **Stream Processing**
- Real-time analytics
- Complex event processing

6. **Event Sourcing**
- Storing state changes as events
- Audit trails

### Getting Started
1. Download and install Kafka
2. Start Zookeeper: `bin/zookeeper-server-start.sh config/zookeeper.properties`
3. Start Kafka Server: `bin/kafka-server-start.sh config/server.properties`
4. Create a topic: `bin/kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092`
5. Run the consumer and producer examples

