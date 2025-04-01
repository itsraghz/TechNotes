# Event Publisher Service Documentation

## Overview
The EventPublisher service is responsible for publishing domain events to Kafka topics. It provides a reliable, asynchronous event publishing mechanism with built-in retry capabilities and comprehensive error handling.

## Key Features

### 1. Asynchronous Event Publishing
- Uses Spring's `@Async` support for non-blocking event publication
- Returns `CompletableFuture` for handling publish results
- Enables high throughput and responsive service operations

### 2. Retry Mechanism
```java
@Retryable(
    value = { EventPublishException.class },
    maxAttempts = 3,
    backoff = @Backoff(delay = 1000, multiplier = 2)
)
```
- Automatic retry on failure with exponential backoff
- Max 3 attempts with delays: 1s, 2s, 4s
- Custom `EventPublishException` for handling Kafka-specific errors

### 3. Comprehensive Logging
- Logs event details before publishing
- Logs successful publication with offset information
- Detailed error logging for troubleshooting

## Usage Examples

### Publishing Order Created Event
```java
OrderCreatedEvent event = OrderCreatedEvent.builder()
    .orderId("order123")
    .customerEmail("customer@example.com")
    .orderAmount(100.00)
    .build();

eventPublisher.publishOrderCreatedEvent(event)
    .thenAccept(result -> {
        // Handle successful publication
    })
    .exceptionally(ex -> {
        // Handle publication error
        return null;
    });
```

### Publishing Order Status Changed Event
```java
OrderStatusChangedEvent event = OrderStatusChangedEvent.builder()
    .orderId("order123")
    .oldStatus(OrderStatus.PENDING)
    .newStatus(OrderStatus.CONFIRMED)
    .build();

eventPublisher.publishOrderStatusChangedEvent(event)
    .thenAccept(result -> {
        // Handle successful publication
    })
    .exceptionally(ex -> {
        // Handle publication error
        return null;
    });
```

## Configuration Requirements

### Kafka Properties
```properties
# application.properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.acks=all
spring.kafka.producer.retries=3
```

### Required Dependencies
```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

## Error Handling

The service handles various types of errors:
1. Serialization errors when converting events to JSON
2. Kafka connection issues
3. Topic configuration problems
4. Network timeouts

Errors are:
- Logged with detailed information
- Wrapped in `EventPublishException`
- Retried according to the retry policy
- Propagated to the caller via CompletableFuture

## Best Practices

1. **Event Idempotency**
   - Include unique event IDs
   - Design events to be safely replayable

2. **Event Schema**
   - Include version information
   - Maintain backward compatibility
   - Use clear naming conventions

3. **Error Handling**
   - Always handle the CompletableFuture result
   - Implement proper fallback mechanisms
   - Monitor failed publications

4. **Monitoring**
   - Track publication success rates
   - Monitor retry attempts
   - Set up alerts for repeated failures

## Common Pitfalls to Avoid

1. Not handling CompletableFuture results
2. Missing proper event versioning
3. Insufficient error logging
4. Not monitoring publication failures
5. Missing idempotency guarantees


# Event Publisher Documentation

This document explains the Event Publisher component of our domain events system, which is responsible for reliably publishing domain events to Kafka topics.

## Components Overview

### 1. EventPublisher Interface

The `EventPublisher` interface defines the contract for publishing domain events:

```java
public interface EventPublisher {
    void publish(DomainEvent event, String topic) throws EventPublishingException;
    void publishWithRetry(DomainEvent event, String topic, int retryAttempts, long retryDelayMs) 
        throws EventPublishingException;
}
```

Key features:
- Simple publish method for basic event publishing
- Enhanced publish method with retry capabilities
- Consistent exception handling through `EventPublishingException`

### 2. KafkaEventPublisher Implementation

The Kafka implementation provides:
- Reliable event publishing to Kafka topics
- Configurable retry mechanism
- Comprehensive logging
- Timeout handling
- Thread safety

## Usage Examples

### Basic Event Publishing

```java
@Service
public class OrderService {
    private final EventPublisher eventPublisher;
    
    public void createOrder(Order order) {
        // Business logic...
        
        OrderCreatedEvent event = new OrderCreatedEvent(order.getId(), order);
        eventPublisher.publish(event, "order-events");
    }
}
```

### Publishing with Retry

```java
@Service
public class OrderService {
    private final EventPublisher eventPublisher;
    
    public void updateOrderStatus(String orderId, OrderStatus newStatus) {
        // Business logic...
        
        OrderStatusChangedEvent event = new OrderStatusChangedEvent(orderId, newStatus);
        eventPublisher.publishWithRetry(event, "order-events", 3, 1000); // 3 retries, 1 second delay
    }
}
```

## Error Handling

The system implements a robust error handling strategy:

1. **Immediate Failures:**
   - Network issues
   - Serialization problems
   - Invalid configurations
   
2. **Retry Scenarios:**
   - Temporary network glitches
   - Kafka broker unavailability
   - Timeout issues

All errors are wrapped in `EventPublishingException` with detailed error messages and cause preservation.

## Logging Strategy

The implementation includes comprehensive logging:

1. **INFO level:**
   - Event publication attempts
   - Retry attempts
   
2. **DEBUG level:**
   - Successful publication details
   - Kafka offset information
   
3. **ERROR level:**
   - Publication failures
   - Retry exhaustion
   - Exception details

## Best Practices

1. **Event Persistence:**
   - Consider implementing an outbox pattern for critical events
   - Store events before publishing for guaranteed delivery

2. **Retry Configuration:**
   - Use exponential backoff for retries
   - Set appropriate timeout values
   - Configure maximum retry attempts based on business requirements

3. **Monitoring:**
   - Implement metrics for failed publications
   - Monitor retry counts
   - Track event publishing latency

4. **Error Handling:**
   - Always catch and handle EventPublishingException
   - Implement appropriate fallback mechanisms
   - Consider dead letter queues for failed events

## Configuration

Example configuration in application.properties:

```properties
# Kafka Producer Configuration
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
spring.kafka.producer.acks=all

# Retry Configuration
event.publisher.retry.max-attempts=3
event.publisher.retry.initial-interval=1000
event.publisher.retry.multiplier=2.0
event.publisher.retry.max-interval=10000
```

## Dependencies

- Spring Kafka
- SLF4J for logging
- Spring Retry for retry mechanism

