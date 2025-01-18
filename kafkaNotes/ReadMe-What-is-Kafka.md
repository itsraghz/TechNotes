# What is Apache Kafka?

## Introduction

Apache Kafka is a distributed streaming platform designed to handle real-time data feeds. It provides a high-throughput, low-latency platform for handling real-time data feeds.

## Architecture Overview

```
+---------------+     +------------------+     +----------------+
|   Producer    | --> |  Kafka Cluster   | --> |   Consumer     |
+---------------+     |  +-----------+   |     +----------------+
|   Producer    | --> |  | Topic 1   |   | --> |   Consumer     |
+---------------+     |  +-----------+   |     +----------------+
                    |  | Topic 2   |   |
                    |  +-----------+   |
                    |  | Topic 3   |   |
                    |  +-----------+   |
                    +------------------+
```

### Key Components

1. **Broker:**
- The Kafka server that handles storage and message distribution
- Multiple brokers form a Kafka cluster

2. **Topics:**
- Named feeds or categories of messages
- Logical partitions of message streams

3. **Partitions:**
- Physical division of topics
- Enable parallel processing and scalability

4. **Producers:**
- Applications that publish messages to topics
- Can specify the partition for messages

5. **Consumers:**
- Applications that subscribe to topics and process messages
- Can be grouped for parallel processing

### Message Flow

```
Producer --> Topic Partition --> Consumer
            |
            v
        Replicated Partitions
        (For Fault Tolerance)
```

