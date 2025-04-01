# Event Handler Components Explanation

This document explains the event handling components in our domain events system, their responsibilities, and implementation details.

## Component Overview

The event handling system consists of the following key components:

1. `EventHandler` interface
2. `OrderEventHandler` implementation
3. `EventProcessingException`
4. `DeadLetterTopicPublisher`

## EventHandler Interface

The `EventHandler` interface defines the contract for processing domain events:

```java
public interface EventHandler<T extends DomainEvent> {
    void handleEvent(T event) throws EventProcessingException;
    void handleError(T event, Exception exception);
    Class<T> getEventType();
}
```

Key features:
- Generic type parameter `T` ensures type safety
- Clear separation of success and error handling
- Event type introspection capability

## OrderEventHandler Implementation

The `OrderEventHandler` processes order-related events using Kafka listeners:

### Key Features

1. **Kafka Listener Configuration**
   ```java
   @KafkaListener(
       topics = ORDER_EVENTS_TOPIC,
       groupId = CONSUMER_GROUP,
       containerFactory = "kafkaListenerContainerFactory"
   )
   ```

2. **Retry Mechanism**
   ```java
   @Retryable(
       value = {EventProcessingException.class},
       maxAttempts = 3,
       backoff = @Backoff(delay = 1000, multiplier = 2)
   )
   ```

3. **Comprehensive Logging**
   - Entry/exit logging
   - Error logging with full context
   - Success confirmation logging

4. **Dead Letter Topic Integration**
   - Failed events are redirected to DLT
   - Preserves failed events for analysis
   - Enables manual recovery processes

## Error Handling Strategy

1. **Multiple Retry Attempts**
   - Initial 1-second delay
   - Exponential backoff (multiplier = 2)
   - Maximum 3 attempts

2. **Dead Letter Topic**
   - Final destination for failed events
   - Includes error context
   - Enables offline processing

3. **Exception Hierarchy**
   - Custom `EventProcessingException`
   - Clear error categorization
   - Facilitates retry decisions

## Monitoring and Observability

1. **Logging**
   - Uses SLF4J for consistent logging
   - Structured log format
   - Includes event context, topic, partition, offset

2. **Metrics (TODO)**
   - Event processing time
   - Success/failure rates
   - Retry statistics
   - DLT statistics

## Usage Example

```java
@Autowired
private OrderEventHandler orderEventHandler;

// Event will be handled automatically via Kafka listener
// Manual handling example:
OrderCreatedEvent event = new OrderCreatedEvent(orderId);
try {
    orderEventHandler.handleEvent(event);
} catch (EventProcessingException e) {
    orderEventHandler.handleError(event, e);
}
```

## Best Practices

1. **Event Processing**
   - Keep processing idempotent
   - Maintain event ordering when required
   - Use appropriate transaction boundaries

2. **Error Handling**
   - Always log errors with context
   - Use appropriate retry policies
   - Implement circuit breakers for external services

3. **Monitoring**
   - Monitor DLT queue size
   - Track processing latencies
   - Set up alerts for repeated failures

## Configuration Properties

```properties
# Kafka Topics
kafka.topic.orders=order-events
kafka.topic.orders.dlt=order-events.dlt

# Consumer Group
kafka.consumer.group.orders=order-processing-group

# Retry Configuration
spring.kafka.listener.retry.max-attempts=3
spring.kafka.listener.retry.initial-interval=1000
spring.kafka.listener.retry.multiplier=2.0
```

## Future Enhancements

1. **Circuit Breaker Integration**
   - Implement circuit breaker pattern
   - Protect downstream services
   - Handle partial failures

2. **Enhanced Monitoring**
   - Prometheus metrics
   - Grafana dashboards
   - Custom health indicators

3. **Recovery Mechanisms**
   - DLT recovery processor
   - Manual intervention API
   - Automated recovery rules

