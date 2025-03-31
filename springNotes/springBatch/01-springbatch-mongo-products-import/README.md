## Quick Start with Docker Compose

The project includes a `docker-compose.yml` for easy local development and a convenience script `run.sh`.

1. Start the development environment:
```bash
./run.sh dev
```
This will:
- Start MongoDB and Mongo Express
- Build and run the application

2. Access Mongo Express UI:
```
http://localhost:8081
```

3. Run tests:
```bash
./run.sh test
```

4. Build Docker image:
```bash
./run.sh build
```

# Spring Batch MongoDB Product Import

A Spring Boot application demonstrating the use of Spring Batch with MongoDB for importing product data from JSON files.

## Technologies Used

- Spring Boot 3.2.3
- Spring Batch
- Spring Data MongoDB
- Java 17
- MongoDB
- TestContainers
- Docker

## Prerequisites

- JDK 17 or later
- MongoDB 5.0 or later
- Docker (for running tests and containerization)
- Maven 3.8+

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/learning/springbatch/mongo/
│   │       ├── batch/
│   │       │   ├── JsonProductReader.java
│   │       │   ├── ProductProcessor.java
│   │       │   └── MongoProductWriter.java
│   │       ├── config/
│   │       │   ├── BatchConfig.java
│   │       │   └── JobConfig.java
│   │       ├── controller/
│   │       │   └── BatchJobController.java
│   │       ├── domain/
│   │       │   └── Product.java
│   │       ├── dto/
│   │       │   └── ProductDTO.java
│   │       └── repository/
│   │           └── ProductRepository.java
│   └── resources/
│       ├── application.yml
│       └── data/
│           └── products.json
└── test/
    └── java/
        └── com/learning/springbatch/mongo/
            ├── BatchJobTest.java
            └── config/
                └── MongoTestConfig.java
```

## Build and Run

1. Build the project:
```bash
mvn clean package
```

2. Run the application:
```bash
java -jar target/mongo-products-import-1.0.0.jar
```

Or using Docker:
```bash
docker build -t product-batch-import .
docker run -p 8080:8080 product-batch-import
```

## API Endpoints

1. Trigger Product Import Job:
```bash
POST http://localhost:8080/api/batch/products/import
```

Example Response:
```json
{
    "jobId": 1,
    "status": "COMPLETED",
    "startTime": "2024-03-31T15:30:00.123Z",
    "endTime": "2024-03-31T15:30:05.456Z"
}
```

2. Check Job Status:
```bash
GET http://localhost:8080/api/batch/jobs/{jobId}
```

Example Response:
```json
{
    "jobId": 1,
    "status": "COMPLETED",
    "startTime": "2024-03-31T15:30:00.123Z",
    "endTime": "2024-03-31T15:30:05.456Z",
    "exitStatus": "COMPLETED",
    "stepExecutions": 1
}
```

## Features

- Batch import of products from JSON file to MongoDB
- RESTful endpoints for job control and monitoring
- Error handling and job status tracking
- Containerized deployment support
- Comprehensive test coverage using TestContainers

## Data Model

Product Record:
```java
public record Product(
    String id,
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

## Testing

Run the tests:
```bash
mvn test
```

The tests use TestContainers to spin up a MongoDB instance in a Docker container, so make sure Docker is running on your machine.

## Sample Data

The application comes with a sample dataset of 50+ products in various categories including:
- Smartphones
- Laptops
- Tablets
- Audio devices
- Gaming consoles
- Cameras
- TVs
- Wearables
- Accessories

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

