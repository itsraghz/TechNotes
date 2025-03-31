# Performance and Scaling Guide

This guide provides recommendations for optimizing performance and scaling the Spring Batch MongoDB Product Import application.

## 1. Chunk Size Optimization

The chunk size in batch processing determines how many items are processed before being written to the database. Current configuration:

```java
.<ProductDTO, Product>chunk(10, transactionManager)
```

Recommendations for chunk size:

| Data Volume | Chunk Size | Memory Usage | Transaction Time |
|------------|------------|--------------|------------------|
| < 10K      | 10-50      | Low          | Short           |
| 10K-100K   | 50-100     | Medium       | Medium          |
| > 100K     | 100-500    | High         | Long            |

To modify chunk size, update the `JobConfig` class:

```java
@Bean
public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("step1", jobRepository)
        .<ProductDTO, Product>chunk(100, transactionManager) // Adjusted chunk size
        .reader(jsonProductReader.createReader(new ClassPathResource("data/products.json")))
        .processor(productProcessor)
        .writer(mongoProductWriter)
        .build();
}
```

## 2. MongoDB Optimization

### Index Configuration

Create indexes for frequently queried fields:

```javascript
// MongoDB indexes
db.products.createIndex({ "sku": 1 }, { unique: true });
db.products.createIndex({ "category": 1 });
db.products.createIndex({ "manufacturer": 1 });
db.products.createIndex({ "price": 1 });
```

### Write Concern Configuration

Configure write concern in application.yml:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/product_batch_db
      write-concern: UNORDERED
      write-concern-w: 1
```

## 3. Parallel Processing

Enable parallel step execution:

```java
@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("batch-");
        return executor;
    }
}

@Configuration
public class JobConfig {
    @Autowired
    private TaskExecutor taskExecutor;

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
            .<ProductDTO, Product>chunk(100, transactionManager)
            .reader(jsonProductReader.createReader(new ClassPathResource("data/products.json")))
            .processor(productProcessor)
            .writer(mongoProductWriter)
            .taskExecutor(taskExecutor)
            .build();
    }
}
```

## 4. Memory Management

### JVM Configuration

Recommended JVM settings for different data volumes:

```bash
# Small datasets (< 10K records)
java -Xms512m -Xmx1g -jar app.jar

# Medium datasets (10K-100K records)
java -Xms1g -Xmx2g -jar app.jar

# Large datasets (> 100K records)
java -Xms2g -Xmx4g -jar app.jar
```

### Garbage Collection Tuning

```bash
# For large datasets with G1GC
java -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -jar app.jar
```

## 5. Monitoring and Metrics

### Spring Boot Actuator Configuration

Add to pom.xml:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Configure in application.yml:
```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,metrics,prometheus
  metrics:
    export:
      prometheus:
        enabled: true
```

### Key Metrics to Monitor

1. Batch Metrics:
   - Job completion time
   - Step execution time
   - Read/Write counts
   - Error counts

2. MongoDB Metrics:
   - Write operations/second
   - Connection pool utilization
   - Average operation time

3. JVM Metrics:
   - Heap usage
   - Garbage collection frequency
   - Thread pool utilization

## 6. Error Handling and Recovery

### Skip Policy Configuration

```java
@Bean
public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("step1", jobRepository)
        .<ProductDTO, Product>chunk(100, transactionManager)
        .reader(jsonProductReader.createReader(new ClassPathResource("data/products.json")))
        .processor(productProcessor)
        .writer(mongoProductWriter)
        .faultTolerant()
        .skip(ValidationException.class)
        .skipLimit(10)
        .build();
}
```

### Retry Policy

```java
@Bean
public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("step1", jobRepository)
        .<ProductDTO, Product>chunk(100, transactionManager)
        .reader(jsonProductReader.createReader(new ClassPathResource("data/products.json")))
        .processor(productProcessor)
        .writer(mongoProductWriter)
        .faultTolerant()
        .retry(OptimisticLockingFailureException.class)
        .retryLimit(3)
        .build();
}
```

## 7. Docker Container Optimization

### Container Resource Limits

```yaml
version: '3.8'
services:
  app:
    image: product-batch-import
    deploy:
      resources:
        limits:
          cpus: '2'
          memory: 2G
        reservations:
          cpus: '1'
          memory: 1G
```

### JVM Container Awareness

```Dockerfile
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
```

## 8. Testing Under Load

### JMeter Test Plan

Create a JMeter test plan to simulate concurrent job executions:

1. Thread Group Configuration:
   - Number of Threads (Users): 10
   - Ramp-up Period: 30 seconds
   - Loop Count: 5

2. HTTP Request:
   - Method: POST
   - Path: /api/batch/products/import

3. Response Assertions:
   - Status Code: 200
   - Response Time: < 5000ms

### Performance Test Data Generation

```java
@Test
void generateTestData() {
    int numberOfProducts = 100_000;
    List<ProductDTO> products = IntStream.range(0, numberOfProducts)
        .mapToObj(i -> new ProductDTO(
            "Product " + i,
            "Description " + i,
            "Category " + (i % 10),
            random.nextDouble() * 1000,
            random.nextInt(100),
            "Manufacturer " + (i % 5),
            "SKU-" + i
        ))
        .collect(Collectors.toList());
    
    // Write to JSON file
    objectMapper.writeValue(new File("src/test/resources/test-data.json"), products);
}
```

## 9. Scaling Strategies

### Horizontal Scaling

1. Partitioned Processing:
   - Split input file by category
   - Process each partition independently
   - Merge results if needed

2. Multi-Instance Deployment:
   - Deploy multiple application instances
   - Use load balancer for job distribution
   - Implement job execution locking

### Vertical Scaling

1. Resource Allocation:
   - Increase container resources
   - Optimize JVM heap size
   - Tune thread pool sizes

2. Database Scaling:
   - Increase MongoDB resources
   - Optimize indexes
   - Configure sharding if needed

## 10. Monitoring Checklist

- [ ] CPU Usage < 80%
- [ ] Memory Usage < 85%
- [ ] GC Pause Time < 200ms
- [ ] MongoDB Operation Time < 100ms
- [ ] Step Completion Rate > 95%
- [ ] Error Rate < 0.1%

Follow these guidelines to ensure optimal performance and scalability of your batch processing application.

