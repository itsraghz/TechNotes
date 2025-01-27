# Spring Boot Unit Testing Demo

## Project Overview

This project demonstrates unit testing in a Spring Boot application using JUnit 5. It implements a simple calculator service with basic arithmetic operations and comprehensive test coverage.

### Project Structure
```
src/
├── main/java/com/example/unittest/
│   ├── UnitTestDemoApplication.java
│   └── service/
│       └── CalculatorService.java
└── test/java/com/example/unittest/
    └── service/
        └── CalculatorServiceTest.java
```

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Your favorite IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Building and Running the Application

1. Clone the repository:
```bash
git clone <repository-url>
cd spring-boot-unittest-demo
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

### Expected Console Output
```
Calculator Demo Results:
Addition: 5 + 3 = 8
Subtraction: 10 - 4 = 6
Multiplication: 6 * 7 = 42
Division: 20 / 5 = 4
```

## Running Tests

Execute the test suite using Maven:
```bash
mvn test
```

Or run specific test classes in your IDE by right-clicking on the test file and selecting "Run Test".

## Test Scenarios

The test suite (`CalculatorServiceTest.java`) covers the following scenarios:

### Basic Operations
- Addition of positive numbers
- Addition with negative numbers
- Subtraction of positive numbers
- Subtraction with negative numbers
- Multiplication of positive numbers
- Multiplication with negative numbers
- Division of positive numbers
- Division with negative numbers

### Edge Cases and Error Handling
- Division by zero (throws ArithmeticException)
- Operations with null inputs (throws IllegalArgumentException)
- Operations with maximum and minimum integer values

### Sample Test Output
```
[INFO] Running com.example.unittest.service.CalculatorServiceTest
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
```

## Test Output Details

### Successful Test Cases
```
√ Addition of positive numbers (2 + 3 = 5)
√ Addition with negative numbers (-2 + 3 = 1)
√ Subtraction of positive numbers (5 - 3 = 2)
√ Multiplication test (4 * 5 = 20)
√ Division test (10 / 2 = 5)
```

### Exception Test Cases
```
√ Division by zero throws ArithmeticException
√ Null input throws IllegalArgumentException
```

## Contributing

Feel free to submit issues and enhancement requests or create pull requests with improvements.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

