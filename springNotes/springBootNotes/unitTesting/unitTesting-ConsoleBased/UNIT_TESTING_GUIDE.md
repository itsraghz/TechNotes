# Comprehensive Guide to Unit Testing

## Table of Contents
1. [Introduction](#introduction)
2. [Unit Testing Fundamentals](#fundamentals)
3. [Testing Pyramid](#testing-pyramid)
4. [Best Practices](#best-practices)
5. [Patterns & Anti-patterns](#patterns)
6. [Test-Driven Development](#tdd)
7. [Code Coverage](#coverage)
8. [Mocking Frameworks](#mocking)
9. [Common Testing Scenarios](#scenarios)
10. [JUnit 5 Advanced Features](#junit5-advanced)
11. [CI/CD Integration](#cicd)
12. [Performance Testing](#performance)
13. [Troubleshooting](#troubleshooting)
14. [Microservices Testing](#microservices)
15. [Property-Based Testing](#property)
16. [Real-world Example](#example)
17. [JUnit 5 Tutorial](#junit5)

## Introduction <a name="introduction"></a>

Unit testing is the practice of testing individual components or units of source code to determine whether they are fit for use. A unit is the smallest testable part of any software.

```text
┌────────────────┐
│    Source Code │
└───────┬────────┘
        │
┌───────▼────────┐
│   Unit Tests   │
└───────┬────────┘
        │
┌───────▼────────┐
│  Verification  │
└────────────────┘
```

## Unit Testing Fundamentals <a name="fundamentals"></a>

### Key Principles
1. **Isolation**: Tests should run in isolation
2. **Single Responsibility**: One test, one assertion
3. **Repeatability**: Tests should be deterministic
4. **Self-checking**: Tests should be automated

### Advantages and Disadvantages

| Advantages | Disadvantages |
|------------|---------------|
| Early bug detection | Initial time investment |
| Documentation | Maintenance overhead |
| Design feedback | False sense of security |
| Regression safety | Learning curve |
| Confidence in changes | Test complexity |

## Testing Pyramid <a name="testing-pyramid"></a>

```text
                ▲
                ╱ ╲
                ╱E2E╲
            ╱─────╲
            ╱ Int.  ╲
            ╱─────────╲
            ╱   Unit    ╲
        ╱─────────────╲
        ╱───────────────╲
```

- **Unit Tests**: 70% (Base)
- **Integration Tests**: 20% (Middle)
- **End-to-End Tests**: 10% (Top)

## Best Practices <a name="best-practices"></a>

1. **F.I.R.S.T Principles**
- **F**ast
- **I**ndependent
- **R**epeatable
- **S**elf-validating
- **T**imely

2. **Naming Convention**
```
methodName_scenario_expectedBehavior
```

## Patterns & Anti-patterns <a name="patterns"></a>

### Patterns
```text
✓ Arrange-Act-Assert
✓ Test Doubles (Mocks/Stubs)
✓ Builder Pattern for Test Data
✓ Test Fixtures
```

### Anti-patterns
```text
✗ Testing Private Methods
✗ Test Interdependence
✗ Code Coverage Obsession
✗ Ignored Tests
```

## Real-world Example <a name="example"></a>

```java
public class BankAccount {
    private double balance;
    
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        balance += amount;
    }
    
    public double getBalance() {
        return balance;
    }
}

@Test
public void deposit_positiveAmount_increasesBalance() {
    // Arrange
    BankAccount account = new BankAccount();
    double initialAmount = 100.0;
    
    // Act
    account.deposit(initialAmount);
    
    // Assert
    assertEquals(initialAmount, account.getBalance());
}
```

## JUnit 5 Tutorial <a name="junit5"></a>

### Basic Annotations
```java
@Test               // Marks test method
@DisplayName        // Custom test name
@BeforeEach        // Setup method
@AfterEach         // Cleanup method
@Disabled          // Skip test
```

### Assertions
```java
assertEquals(expected, actual);
assertTrue(condition);
assertThrows(Exception.class, () -> {});
assertAll("group", () -> {});
```

### Test Organization
```text
src/
├── main/
│   └── java/
│       └── com/example/
│           └── BankAccount.java
└── test/
    └── java/
        └── com/example/
            ├── unit/
            │   └── BankAccountTest.java
            └── integration/
                └── BankAccountIntegrationTest.java
```

### Test Lifecycle

```text
┌────────────────┐
│  @BeforeAll    │
└───────┬────────┘
        ▼
┌────────────────┐
│  @BeforeEach   │◄─────┐
└───────┬────────┘      │
        ▼               │
┌────────────────┐      │
│    @Test       │      │
└───────┬────────┘      │
        ▼               │
┌────────────────┐      │
│   @AfterEach   │──────┘
└───────┬────────┘
        ▼
┌────────────────┐
│   @AfterAll    │
└────────────────┘
```

Remember: The key to successful unit testing is finding the right balance between coverage and maintainability while ensuring tests remain valuable and meaningful.

## Test-Driven Development <a name="tdd"></a>

TDD follows the Red-Green-Refactor cycle:

```text
┌──────────────►Write Test────────────┐
│                    │                 │
│                    ▼                 │
│      ┌─────────Red Phase──────────┐ │
│      │     (Test Fails First)     │ │
│      └──────────┬─────────────────┘ │
│                 │                    │
Refactor    Green Phase               │
│      (Make Code Better)    (Make Test Pass) 
│                 │                    │
└─────────────────┴────────────────────┘
```

### Example TDD Cycle
```java
// 1. Red: Write failing test
@Test
void calculateDiscount_premiumCustomer_returns20Percent() {
    assertThat(service.calculateDiscount("PREMIUM")).isEqualTo(20);
}

// 2. Green: Make it pass
public int calculateDiscount(String type) {
    return "PREMIUM".equals(type) ? 20 : 0;
}

// 3. Refactor: Improve code
public int calculateDiscount(CustomerType type) {
    return type.getDiscountPercentage();
}
```

## Code Coverage <a name="coverage"></a>

### Popular Tools
- JaCoCo
- Cobertura
- SonarQube

### Key Metrics
| Metric | Description | Target |
|--------|-------------|--------|
| Line Coverage | Lines executed | >80% |
| Branch Coverage | Decision points covered | >70% |
| Mutation Coverage | Code change detection | >60% |

## Mocking Frameworks <a name="mocking"></a>

### Framework Comparison

| Feature | Mockito | EasyMock | PowerMock |
|---------|---------|----------|------------|
| Static Methods | Limited | No | Yes |
| Final Classes | Yes (2.x+) | No | Yes |
| Private Methods | No | No | Yes |
| Ease of Use | High | Medium | Complex |
| Performance | Fast | Fast | Slower |

## Common Testing Scenarios <a name="scenarios"></a>

### Database Testing
```java
@Test
void testWithH2Database() {
    @Test
    @Sql("/test-data.sql")
    void whenFindByName_thenReturnUser() {
        User user = repository.findByName("John");
        assertThat(user).isNotNull();
    }
}
```

### Async Testing
```java
@Test
void testAsyncOperation() {
    CompletableFuture<String> future = service.asyncOperation();
    assertThat(future)
        .succeedsWithin(5, TimeUnit.SECONDS)
        .isEqualTo("result");
}
```

## JUnit 5 Advanced Features <a name="junit5-advanced"></a>

### Parameterized Tests
```java
@ParameterizedTest
@CsvSource({
    "1, 1, 2",
    "2, 3, 5",
    "10, -5, 5"
})
void testAdd(int a, int b, int expected) {
    assertEquals(expected, calculator.add(a, b));
}
```

### Dynamic Tests
```java
@TestFactory
Collection<DynamicTest> dynamicTests() {
    return Arrays.asList(
        dynamicTest("Add", () -> assertTrue(calculator.add(2, 2) == 4)),
        dynamicTest("Multiply", () -> assertTrue(calculator.multiply(2, 3) == 6))
    );
}
```

## CI/CD Integration <a name="cicd"></a>

```yaml
test:
stage: test
script:
    - mvn test
    - mvn jacoco:report
coverage: '/Total.*?([0-9]{1,3})%/'
artifacts:
    reports:
    junit: target/surefire-reports/TEST-*.xml
    coverage: target/site/jacoco/
```

## Performance Testing <a name="performance"></a>

### Benchmark Tests
```java
@Benchmark
public void benchmarkCalculation(Blackhole blackhole) {
    double result = complexCalculation();
    blackhole.consume(result);
}
```

## Troubleshooting <a name="troubleshooting"></a>

Common Issues:
```text
┌─────────────────────┐
│  Test Failures     │
├─────────────────────┤
│ ▪ Flaky Tests      │
│ ▪ Race Conditions  │
│ ▪ Resource Leaks   │
│ ▪ Wrong Assertions │
└─────────────────────┘
```

## Microservices Testing <a name="microservices"></a>

### Test Types
```text
┌─────────────────┐
│ Contract Tests  │
├─────────────────┤
│ Consumer Driven │
│ Provider Tests  │
└─────────────────┘
```

## Property-Based Testing <a name="property"></a>

```java
@Property
void concatenationLength(
    @ForAll String str1,
    @ForAll String str2
) {
    assertThat(str1.length() + str2.length())
        .isEqualTo((str1 + str2).length());
}
```
