# Troubleshooting Guide

This guide helps diagnose and resolve common issues in the Spring Batch MongoDB Product Import application.

## Common Issues and Solutions

### 1. Job Execution Failures

#### Issue: Job Fails to Start
```
JobInstanceAlreadyCompleteException: A job instance already exists and is complete for parameters={time=1234567890}
```

**Cause**: Spring Batch prevents the same job with identical parameters from running twice.

**Solution**:
- Ensure unique job parameters for each run:
```java
JobParameters params = new JobParametersBuilder()
    .addLong("time", System.currentTimeMillis())
    .addString("uuid", UUID.randomUUID().toString())
    .toJobParameters();
```

#### Issue: Step Execution Failure
```
org.springframework.batch.core.step.skip.SkipLimitExceededException: Skip limit of 10 exceeded
```

**Solution**:
1. Increase skip limit:
```java
.faultTolerant()
.skip(ValidationException.class)
.skipLimit(20)
```

2. Review and fix data quality issues:
```java
@Component
public class ProductProcessor implements ItemProcessor<ProductDTO, Product> {
    @Override
    public Product process(ProductDTO dto) {
        // Add validation
        if (dto.price() < 0) {
            throw new ValidationException("Price cannot be negative");
        }
        // Processing logic
    }
}
```

### 2. MongoDB Connection Issues

#### Issue: Connection Timeout
```
com.mongodb.MongoTimeoutException: Timed out after 30000 ms while waiting to connect
```

**Solutions**:
1. Check MongoDB status:
```bash
docker-compose ps
docker-compose logs mongodb
```

2. Verify connection settings in application.yml:
```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/product_batch_db
      connection-timeout: 5000
      socket-timeout: 60000
```

#### Issue: Authentication Failed
```
com.mongodb.MongoSecurityException: Authentication failed
```

**Solution**:
1. Check credentials in application.yml:
```yaml
spring:
  data:
    mongodb:
      uri: mongodb://user:password@localhost:27017/product_batch_db
```

2. Verify MongoDB user permissions:
```javascript
use product_batch_db
db.grantRolesToUser("user", ["readWrite"])
```

### 3. Memory Issues

#### Issue: OutOfMemoryError
```
java.lang.OutOfMemoryError: Java heap space
```

**Solutions**:
1. Adjust JVM settings:
```bash
export JAVA_OPTS="-Xms1g -Xmx2g -XX:+HeapDumpOnOutOfMemoryError"
```

2. Reduce chunk size:
```java
.<ProductDTO, Product>chunk(50, transactionManager)
```

3. Enable garbage collection logging:
```bash
export JAVA_OPTS="$JAVA_OPTS -Xlog:gc*:file=gc.log:time,uptime:filecount=5,filesize=10M"
```

### 4. Performance Issues

#### Issue: Slow Job Execution

**Solutions**:
1. Enable MongoDB query logging:
```yaml
logging:
  level:
    org.springframework.data.mongodb.core.MongoTemplate: DEBUG
```

2. Check MongoDB indexes:
```javascript
db.products.getIndexes()
db.products.createIndex({"sku": 1}, {unique: true})
```

3. Monitor resource usage:
```bash
# CPU and Memory
top -pid $(pgrep -f app.jar)

# JVM Metrics
jcmd <pid> GC.stats
```

### 5. Data Issues

#### Issue: Duplicate SKU Values
```
com.mongodb.DuplicateKeyException: E11000 duplicate key error collection
```

**Solutions**:
1. Skip duplicates:
```java
.faultTolerant()
.skip(DuplicateKeyException.class)
.skipLimit(100)
```

2. Handle in processor:
```java
public Product process(ProductDTO dto) {
    if (productRepository.findBySku(dto.sku()).isPresent()) {
        return null; // Skip duplicate
    }
    return new Product(...);
}
```

### 6. Docker Issues

#### Issue: Container Resource Limits

```
Container killed due to memory limit
```

**Solutions**:
1. Update docker-compose.yml:
```yaml
services:
  app:
    deploy:
      resources:
        limits:
          memory: 3G
```

2. Adjust JVM settings in Dockerfile:
```Dockerfile
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
```

### 7. Logging and Monitoring

#### Issue: Insufficient Logging

**Solution**:
1. Configure detailed logging in application.yml:
```yaml
logging:
  level:
    com.learning.springbatch: DEBUG
    org.springframework.batch: DEBUG
    org.springframework.data.mongodb: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
```

2. Add custom step listener:
```java
public class CustomStepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Starting step: {}", stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("Step complete: {}, Read: {}, Written: {}",
            stepExecution.getStepName(),
            stepExecution.getReadCount(),
            stepExecution.getWriteCount());
        return stepExecution.getExitStatus();
    }
}
```

### 8. Testing Issues

#### Issue: TestContainers Startup Failure

```
org.testcontainers.containers.ContainerLaunchException: Container startup failed
```

**Solutions**:
1. Check Docker service:
```bash
docker info
docker system prune
```

2. Update TestContainers configuration:
```java
@TestConfiguration
public class MongoTestConfig {
    static {
        System.setProperty("testcontainers.reuse.enable", "true");
    }
    
    @Bean(initMethod = "start", destroyMethod = "stop")
    public MongoDBContainer mongoDBContainer() {
        return new MongoDBContainer(DockerImageName.parse("mongo:5.0.15"))
            .withStartupTimeout(Duration.ofMinutes(2));
    }
}
```

## Diagnostic Commands

### Application Status
```bash
# Check application status
curl -X GET http://localhost:8080/actuator/health

# View metrics
curl -X GET http://localhost:8080/actuator/metrics

# Check specific job execution
curl -X GET http://localhost:8080/api/batch/jobs/{jobId}
```

### MongoDB Status
```bash
# MongoDB status
mongosh --eval "db.serverStatus()"

# Check indexes
mongosh --eval "db.products.getIndexes()"

# View collection stats
mongosh --eval "db.products.stats()"
```

### Log Analysis
```bash
# View application logs
tail -f logs/application.log

# Search for errors
grep "ERROR" logs/application.log

# View GC logs
jcmd <pid> GC.heap_info
```

## Prevention Checklist

- [ ] Validate input data before processing
- [ ] Configure appropriate chunk sizes
- [ ] Set up proper indexes in MongoDB
- [ ] Configure adequate memory settings
- [ ] Enable detailed logging for troubleshooting
- [ ] Set up monitoring and alerts
- [ ] Regular backup strategy
- [ ] Test with representative data volumes

## Support Resources

- Spring Batch Documentation: https://spring.io/projects/spring-batch
- MongoDB Documentation: https://docs.mongodb.com
- Docker Documentation: https://docs.docker.com
- TestContainers Documentation: https://www.testcontainers.org

