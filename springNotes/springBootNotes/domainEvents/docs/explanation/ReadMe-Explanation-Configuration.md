# Application Configuration Explanation

This document explains the configuration setup for the Order Management application with Domain Events.

## ApplicationConfig.java

The `ApplicationConfig` class serves as the main configuration class for the application, setting up various Spring Boot features and configurations.

### Key Features

1. **JPA Auditing**
   ```java
   @EnableJpaAuditing(auditorAwareRef = "auditorProvider")
   ```
   - Enables automatic field population for `@CreatedDate`, `@LastModifiedDate`, `@CreatedBy`, and `@LastModifiedBy`
   - The `auditorProvider` bean provides the current user for auditing
   - Useful for tracking entity creation and modification metadata

2. **Transaction Management**
   ```java
   @EnableTransactionManagement
   ```
   - Enables Spring's annotation-driven transaction management
   - Allows use of `@Transactional` annotation
   - Ensures data consistency across database operations

3. **Auditor Provider**
   ```java
   @Bean
   public AuditorAware<String> auditorProvider()
   ```
   - Provides the current user for JPA auditing
   - In a production environment, this should be integrated with your security context
   - Currently returns "SYSTEM" as a placeholder

## OpenApiConfig.java

The `OpenApiConfig` class configures Swagger/OpenAPI documentation for the API.

### Key Features

1. **OpenAPI Configuration**
   ```java
   @Bean
   public OpenAPI orderManagementOpenAPI()
   ```
   - Configures OpenAPI documentation properties
   - Sets API title, description, version, and license information
   - Accessible at `/swagger-ui.html` when application is running

### Usage

1. **Accessing Swagger UI**
   - Run the application
   - Navigate to `http://localhost:8080/swagger-ui.html`
   - View and test API endpoints

2. **Adding API Documentation**
   - Use OpenAPI annotations in controllers
   - Example:
     ```java
     @Operation(summary = "Create new order")
     @ApiResponse(responseCode = "201", description = "Order created")
     ```

## Best Practices

1. **Transaction Management**
   - Use `@Transactional` at service layer
   - Configure appropriate isolation levels
   - Handle transaction rollbacks properly

2. **Auditing**
   - Implement proper user context for auditing
   - Use auditing fields in all relevant entities
   - Consider custom audit trail implementations for sensitive operations

3. **API Documentation**
   - Keep API documentation up-to-date
   - Include clear descriptions and examples
   - Document error responses and edge cases

## Additional Configuration Options

1. **Custom Transaction Management**
   ```java
   @Bean
   public PlatformTransactionManager transactionManager() {
       return new JpaTransactionManager();
   }
   ```

2. **Custom ObjectMapper Configuration**
   ```java
   @Bean
   public ObjectMapper objectMapper() {
       ObjectMapper mapper = new ObjectMapper();
       mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
       return mapper;
   }
   ```

## Security Considerations

1. Protect sensitive endpoints using appropriate security configurations
2. Implement proper authentication and authorization
3. Use secure communication protocols
4. Handle sensitive data appropriately

## Monitoring and Metrics

1. Consider adding actuator endpoints for monitoring
2. Configure appropriate logging levels
3. Implement health checks and metrics collection


