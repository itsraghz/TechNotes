# Technical Deep Dive: Spring Batch MongoDB Product Import

This document provides a detailed technical explanation of each component in the Spring Batch MongoDB Product Import project.

## 1. Domain Model and DTO

### Product Record (Product.java)
```java
@Document(collection = "products")
public record Product(
    @Id String id,
    String name,
    String description,
    String category,
    Double price,
    Integer stockQuantity,
    String manufacturer,
    String sku,
    Boolean active,
    String createdDate,
    String lastModifiedDate
) {}
```

**Key Points:**
- Uses Java 17's record feature for immutable data class
- `@Document` annotation marks it as a MongoDB document
- `@Id` marks the primary key field
- Immutability ensures thread safety in batch processing

### ProductDTO Record (ProductDTO.java)
```java
public record ProductDTO(
    String name,
    String description,
    String category,
    Double price,
    Integer stockQuantity,
    String manufacturer,
    String sku
) {}
```

**Key Points:**
- Separates input data structure from domain model
- Omits metadata fields that are generated during processing
- Provides clean data contract for JSON input

## 2. Repository Layer

### ProductRepository Interface
```java
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findBySku(String sku);
    List<Product> findByCategory(String category);
    List<Product> findByManufacturer(String manufacturer);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByActiveTrue();
}
```

**Key Points:**
- Extends MongoRepository for standard CRUD operations
- Custom query methods using Spring Data's method naming convention
- Optional return type for nullable results
- Query methods are automatically implemented by Spring Data

## 3. Batch Processing Components

### JsonProductReader
```java
@Component
public class JsonProductReader {
    public JsonItemReader<ProductDTO> createReader(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonJsonObjectReader<ProductDTO> jsonObjectReader = 
            new JacksonJsonObjectReader<>(ProductDTO.class);
        jsonObjectReader.setMapper(objectMapper);
        
        JsonItemReader<ProductDTO> jsonItemReader = 
            new JsonItemReader<>();
        jsonItemReader.setResource(resource);
        jsonItemReader.setJsonObjectReader(jsonObjectReader);
        jsonItemReader.setName("productJsonItemReader");
        
        return jsonItemReader;
    }
}
```

**Key Points:**
- Uses Spring Batch's JsonItemReader for efficient JSON parsing
- Jackson ObjectMapper for JSON deserialization
- Resource-based reading allows flexibility in input source
- Named reader for better job monitoring

### ProductProcessor
```java
@Component
public class ProductProcessor implements ItemProcessor<ProductDTO, Product> {
    @Override
    public Product process(ProductDTO dto) {
        return new Product(
            UUID.randomUUID().toString(),
            dto.name(),
            dto.description(),
            dto.category(),
            dto.price(),
            dto.stockQuantity(),
            dto.manufacturer(),
            dto.sku(),
            true,
            LocalDateTime.now().toString(),
            LocalDateTime.now().toString()
        );
    }
}
```

**Key Points:**
- Implements ItemProcessor for DTO to Domain transformation
- Generates UUID for new products
- Sets metadata fields (active status, timestamps)
- Stateless design for thread safety

### MongoProductWriter
```java
@Component
public class MongoProductWriter implements ItemWriter<Product> {
    private final ProductRepository productRepository;

    @Autowired
    public MongoProductWriter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void write(Chunk<? extends Product> products) {
        productRepository.saveAll(products.getItems());
    }
}
```

**Key Points:**
- Implements ItemWriter for batch writing to MongoDB
- Uses chunk-oriented processing for better performance
- Leverages MongoDB's bulk insert capabilities
- Constructor injection for better testability

## 4. Configuration

### BatchConfig
```java
@Configuration
@EnableBatchProcessing
@EnableTransactionManagement
public class BatchConfig {
    // Base configuration class
}
```

**Key Points:**
- Enables Spring Batch infrastructure
- Enables transaction management
- Acts as a marker configuration class

### JobConfig
```java
@Configuration
public class JobConfig {
    @Autowired
    private JsonProductReader jsonProductReader;

    @Autowired
    private ProductProcessor productProcessor;

    @Autowired
    private MongoProductWriter mongoProductWriter;

    @Bean
    public Job importProductsJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("importProductsJob", jobRepository)
            .start(step1)
            .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
            .<ProductDTO, Product>chunk(10, transactionManager)
            .reader(jsonProductReader.createReader(new ClassPathResource("data/products.json")))
            .processor(productProcessor)
            .writer(mongoProductWriter)
            .build();
    }
}
```

**Key Points:**
- Configures job and step definitions
- Uses chunk size of 10 for balanced performance
- Integrates reader, processor, and writer
- Transaction management for data consistency

## 5. REST Controller

### BatchJobController
```java
@RestController
@RequestMapping("/api/batch")
public class BatchJobController {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importProductsJob;

    @PostMapping("/products/import")
    public ResponseEntity<Map<String, Object>> importProducts() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

            JobExecution jobExecution = jobLauncher.run(importProductsJob, jobParameters);

            Map<String, Object> response = new HashMap<>();
            response.put("jobId", jobExecution.getJobId());
            response.put("status", jobExecution.getStatus());
            response.put("startTime", jobExecution.getStartTime());
            response.put("endTime", jobExecution.getEndTime());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Failed to start job: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<Map<String, Object>> getJobStatus(@PathVariable Long jobId) {
        // Implementation details...
    }
}
```

**Key Points:**
- RESTful endpoints for job control
- Unique job parameters ensure rerunability
- Error handling with appropriate HTTP status codes
- Detailed job execution information in response

## 6. Application Properties

### application.yml
```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/product_batch_db
      database: product_batch_db
  batch:
    jdbc:
      initialize-schema: always
    job:
      enabled: false  # Disable automatic job execution

mongock:
  migration-scan-package:
    - com.learning.springbatch.mongo.config.migration
  enabled: true
```

**Key Points:**
- YAML format for better readability
- MongoDB connection configuration
- Batch job execution control
- MongoDB migration support with Mongock

## 7. Test Configuration

### MongoTestConfig
```java
@TestConfiguration
public class MongoTestConfig {
    @Bean(initMethod = "start", destroyMethod = "stop")
    public MongoDBContainer mongoDBContainer() {
        return new MongoDBContainer(DockerImageName.parse("mongo:5.0.15"));
    }

    @Bean
    public MongoClient mongoClient(MongoDBContainer mongoDBContainer) {
        return MongoClients.create(mongoDBContainer.getReplicaSetUrl());
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "test");
    }
}
```

**Key Points:**
- TestContainers for isolated MongoDB testing
- Automatic container lifecycle management
- Test-specific MongoDB configuration
- Clean test environment for each run

## 8. Test Cases

### BatchJobTest
```java
@SpringBootTest
@SpringBatchTest
@Import(MongoTestConfig.class)
@ActiveProfiles("test")
class BatchJobTest {
    // Test implementation details...
}
```

**Key Points:**
- Integration testing with Spring Boot Test
- Spring Batch test utilities
- MongoDB TestContainer integration
- Profile-based test configuration

This technical deep dive should help you understand:
- The architecture and design decisions
- Component interactions and dependencies
- Performance considerations
- Testing strategies
- Configuration management

Each component has been designed with:
- Modularity and reusability in mind
- Proper separation of concerns
- Best practices for Spring Batch
- Effective error handling
- Scalability considerations
- Comprehensive testing approach

