# Java DateTime Format Demonstration: 'yyyy' vs 'YYYY' Across Java Versions

## Purpose

This project demonstrates the critical difference between `yyyy` and `YYYY` date format patterns across different Java versions (7, 8, 11, 17, and 21). The demonstration shows how these patterns behave differently, especially around the year-end dates.

### Key Differences
- `yyyy`: Represents the calendar year
- `YYYY`: Represents the week-based year (ISO-8601)

## Code Implementation

### DateTimeExample.java
```java
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;

public class DateTimeExample {
    public static void main(String[] args) {
        // Date to test: December 30, 2024 (which is in week 1 of 2025)
        
        // Java 7 Style (Legacy)
        System.out.println("=== Java 7 Style (SimpleDateFormat) ===");
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.DECEMBER, 30);
        Date date = cal.getTime();
        
        SimpleDateFormat sdfYyyy = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfYYYY = new SimpleDateFormat("YYYY-MM-dd");
        
        System.out.println("yyyy format: " + sdfYyyy.format(date));
        System.out.println("YYYY format: " + sdfYYYY.format(date));
        
        // Java 8+ Style (Modern)
        System.out.println("\n=== Java 8+ Style (DateTimeFormatter) ===");
        LocalDate modernDate = LocalDate.of(2024, 12, 30);
        
        DateTimeFormatter dtfYyyy = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtfYYYY = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        
        System.out.println("yyyy format: " + modernDate.format(dtfYyyy));
        System.out.println("YYYY format: " + modernDate.format(dtfYYYY));
    }
}
```

## Docker Setup

### Base Dockerfiles

#### Dockerfile.java7
```dockerfile
FROM openjdk:7-jdk
WORKDIR /app
COPY DateTimeExample.java .
RUN javac DateTimeExample.java
CMD ["java", "DateTimeExample"]
```

#### Dockerfile.java8
```dockerfile
FROM openjdk:8-jdk
WORKDIR /app
COPY DateTimeExample.java .
RUN javac DateTimeExample.java
CMD ["java", "DateTimeExample"]
```

#### Dockerfile.java11
```dockerfile
FROM openjdk:11-jdk
WORKDIR /app
COPY DateTimeExample.java .
RUN javac DateTimeExample.java
CMD ["java", "DateTimeExample"]
```

#### Dockerfile.java17
```dockerfile
FROM openjdk:17-jdk
WORKDIR /app
COPY DateTimeExample.java .
RUN javac DateTimeExample.java
CMD ["java", "DateTimeExample"]
```

#### Dockerfile.java21
```dockerfile
FROM openjdk:21-jdk
WORKDIR /app
COPY DateTimeExample.java .
RUN javac DateTimeExample.java
CMD ["java", "DateTimeExample"]
```

### Docker Compose Configuration
```yaml
version: '3'
services:
java7:
    build:
    context: .
    dockerfile: Dockerfile.java7
    container_name: datetime-java7

java8:
    build:
    context: .
    dockerfile: Dockerfile.java8
    container_name: datetime-java8

java11:
    build:
    context: .
    dockerfile: Dockerfile.java11
    container_name: datetime-java11

java17:
    build:
    context: .
    dockerfile: Dockerfile.java17
    container_name: datetime-java17

java21:
    build:
    context: .
    dockerfile: Dockerfile.java21
    container_name: datetime-java21
```

## Running the Examples

### Without Docker

1. Compile the Java file:
```bash
javac DateTimeExample.java
```

2. Run with your installed Java version:
```bash
java DateTimeExample
```

### With Docker

#### Using the Shell Script

The included shell script (`run-all-versions.sh`) automates the process of running all versions:

```bash
#!/bin/bash

echo "Building and running DateTime examples across Java versions..."

# Build all images
docker-compose build

# Run each version
for version in 7 8 11 17 21; do
    echo -e "\n=== Running Java $version Version ==="
    docker-compose run --rm java$version
done

# Cleanup
docker-compose down

echo -e "\nAll versions completed."
```

To run using the script:
```bash
chmod +x run-all-versions.sh
./run-all-versions.sh
```

#### Manual Docker Execution
```bash
# Build all images
docker-compose build

# Run specific version
docker-compose run --rm java7
docker-compose run --rm java8
docker-compose run --rm java11
docker-compose run --rm java17
docker-compose run --rm java21
```

## Expected Output

For all Java versions, you'll see output similar to:

```
=== Java 7 Style (SimpleDateFormat) ===
yyyy format: 2024-12-30
YYYY format: 2025-12-30

=== Java 8+ Style (DateTimeFormatter) ===
yyyy format: 2024-12-30
YYYY format: 2025-12-30
```

## Important Notes and Warnings

1. **Version-Specific Behaviors**
- Java 7 uses the legacy `SimpleDateFormat` class
- Java 8+ uses the modern `DateTimeFormatter` class
- Both implementations show the same behavior, but Java 8+ is recommended for new code

2. **Week-Based Year (YYYY)**
- December 30, 2024, falls in the first week of 2025 (ISO-8601)
- This is why YYYY shows 2025 instead of 2024
- Use YYYY only when you specifically need week-based year calculations

3. **Best Practices**
- Always use `yyyy` for regular calendar year formatting
- Use `YYYY` only when implementing ISO-8601 week date systems
- For Java 8+, prefer the modern `java.time` API over legacy date/time classes

4. **Docker Considerations**
- Ensure Docker and Docker Compose are installed
- Some images are large and may take time to download initially
- The Java 7 image is deprecated but included for demonstration

## Additional Resources

- [Java SimpleDateFormat Documentation](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html)
- [Java DateTimeFormatter Documentation](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)
- [ISO-8601 Week Date Standard](https://en.wikipedia.org/wiki/ISO_week_date)

