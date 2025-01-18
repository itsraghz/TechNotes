# Kafka Java Examples

This directory contains simple examples demonstrating Kafka producer and consumer implementations in Java.

## Prerequisites

1. **Java Development Kit (JDK)**
- JDK 11 or later
- JAVA_HOME environment variable set

2. **Apache Maven**
- Maven 3.6.0 or later
- MVN_HOME environment variable set

3. **Apache Kafka**
- Kafka 2.8.0 or later
- Running Kafka broker on localhost:9092

## Setup Instructions

1. **Clone the Repository**
```bash
git clone <repository-url>
cd kafka-java-maven
```

2. **Build the Project**
```bash
mvn clean package
```

This command does two things:
- `clean`: Removes all previously compiled files and artifacts
- `package`: Compiles the code and packages it into a JAR file

During execution, Maven will:
1. Download required dependencies (first run only)
2. Compile Java source files
3. Run any tests
4. Create a JAR file in the `target` directory

Common issues:
- If dependencies fail to download, check your internet connection
- If compilation fails, ensure your JDK version matches the one in pom.xml

3. **Create Kafka Topic**
```bash
kafka-topics.sh --create --topic example-topic --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
```

This command creates a new Kafka topic with the following parameters:
- `--create`: Specifies that we want to create a new topic
- `--topic example-topic`: Sets the topic name to "example-topic"
- `--bootstrap-server localhost:9092`: Specifies the Kafka broker address
- `--partitions 3`: Creates 3 partitions for parallel processing
- `--replication-factor 1`: Creates one copy of each partition (suitable for development)

Expected output: "Created topic example-topic"

Common issues:
- "Topic already exists" - Use --if-not-exists flag or delete existing topic
- Connection refused - Ensure Kafka broker is running at specified address

## Running the Examples

### Producer Example

1. **Run the Producer**
```bash
mvn exec:java -Dexec.mainClass="com.example.kafka.SimpleProducer"
```

This command:
- Uses Maven's exec plugin to run the Java application
- `-Dexec.mainClass`: Specifies the main class to execute
- The producer will generate and send sample messages to the Kafka topic

During execution:
1. Producer establishes connection to Kafka broker
2. Generates sample messages
3. Sends messages with increasing sequence numbers
4. Prints confirmation for each sent message

Common issues:
- Connection timeout: Check if Kafka broker is running
- SerializationException: Ensure message format matches configuration
- Topic not found: Verify topic was created successfully

2. **Expected Output**
```
Sent message: Message-1 to topic: example-topic
Sent message: Message-2 to topic: example-topic
Sent message: Message-3 to topic: example-topic
```

### Consumer Example

1. **Run the Consumer**
```bash
mvn exec:java -Dexec.mainClass="com.example.kafka.SimpleConsumer"
```

This command:
- Launches the Kafka consumer application
- Consumer automatically joins the consumer group
- Begins polling for messages from the topic

Process explanation:
1. Consumer connects to the Kafka broker
2. Subscribes to the specified topic
3. Begins polling for new messages
4. Processes and displays received messages

Tips:
- Run multiple consumers to see partition rebalancing
- Consumer will wait indefinitely for new messages
- Use Ctrl+C to stop the consumer

Common issues:
- Group coordination failed: Check broker connectivity
- Offset out of range: May occur if topic was recently created
- Deserialization errors: Verify message format configuration

2. **Expected Output**
```
Received message: Message-1 from partition 0
Received message: Message-2 from partition 1
Received message: Message-3 from partition 2
```

## Troubleshooting

1. **Connection Issues**
- Verify Kafka broker is running
- Check broker address in configuration
- Ensure topic exists

2. **Build Issues**
- Check Maven installation
- Verify pom.xml dependencies
- Clean and rebuild project

