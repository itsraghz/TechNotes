# Kafka Configuration Explanation

This document explains the Kafka configuration setup in our Domain Events application, including both the Java configuration and properties settings.

## Table of Contents
- [Configuration Overview](#configuration-overview)
- [Producer Configuration](#producer-configuration)
- [Consumer Configuration](#consumer-configuration)
- [Error Handling & Retry Policies](#error-handling--retry-policies)
- [Best Practices](#best-practices)

## Configuration Overview

The Kafka configuration is split into two main parts:
1. Java-based configuration (`KafkaConfig.java`)
2. Properties-based configuration (`application.properties`)

### Key Components

- Producer Factory configuration for sending domain events
- Consumer Factory configuration for receiving events
- Retry policies and error handling
- Topic configurations
- Serialization/Deserialization settings

## Producer Configuration

### Key Settings

```java
configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
configProps.put(ProducerConfig.RETRIES_CONFIG, 3);
configProps.put(ProducerConfig.ACKS_CONFIG, "all");
configProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
```

These settings ensure:
- Reliable message delivery with retries
- Strong durability guarantees (acks=all)
- Exactly-once semantics through idempotence
- JSON serialization for domain events

## Consumer Configuration

### Key Settings

```java
props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
```

Features:
- Manual commit mode for better control
- Consumer group management
- Earliest offset reset strategy for new consumers
- JSON deserialization with trusted package configuration

## Error Handling & Retry Policies

The configuration includes:
1. Retry Template with 3 retry attempts
2. Error handler for failed message processing
3. Dead Letter Queue capability (commented implementation)

```java
@Bean
public RetryTemplate retryTemplate() {
    RetryTemplate retryTemplate = new RetryTemplate();
    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    retryPolicy.setMaxAttempts(3);
    retryTemplate.setRetryPolicy(retryPolicy);
    return retryTemplate;
}
```

## Best Practices

1. **Producer Best Practices**:
   - Enable idempotence for exactly-once semantics
   - Use "all" acknowledgment for critical data
   - Configure reasonable retry attempts

2. **Consumer Best Practices**:
   - Use manual commit mode for better control
   - Configure reasonable batch sizes
   - Implement proper error handling
   - Use consumer groups for scalability

3. **General Best Practices**:
   - Keep serialization consistent across services
   - Monitor consumer lag
   - Use appropriate timeout configurations
   - Implement proper error handling and dead letter queues

## Properties Configuration Details

### Application Properties

```properties
# Kafka cluster configuration
spring.kafka.bootstrap-servers=localhost:9092

# Consumer group configuration
spring.kafka.consumer.group-id=domain-events-group

# Topic configurations
kafka.topic.order-events=order-events
kafka.topic.notification-events=notification-events
```

These properties can be overridden for different environments through Spring Boot's property resolution mechanism.

## Security Considerations

1. Enable SSL for production environments
2. Implement authentication mechanisms
3. Use ACLs for topic access control
4. Configure trusted package scanning for deserialization

## Monitoring & Maintenance

1. Use Kafka's built-in metrics
2. Monitor consumer lag
3. Set up alerting for error scenarios
4. Regular maintenance of topics and partitions

## Common Issues and Solutions

1. **Message Loss**:
   - Ensure proper acks configuration
   - Use idempotent producer
   - Implement retry mechanism

2. **Performance Issues**:
   - Tune batch sizes
   - Configure appropriate timeouts
   - Monitor and adjust partition count

3. **Deserialization Errors**:
   - Ensure consistent schema across services
   - Configure trusted packages
   - Implement proper error handling

