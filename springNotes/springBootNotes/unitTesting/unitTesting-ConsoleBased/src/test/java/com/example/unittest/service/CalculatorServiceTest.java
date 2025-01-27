package com.example.unittest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Service Test")
class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {
        @Test
        @DisplayName("Adding two positive numbers")
        void addPositiveNumbers() {
            assertEquals(5.0, calculatorService.add(2.0, 3.0));
        }

        @Test
        @DisplayName("Adding positive and negative numbers")
        void addPositiveAndNegativeNumbers() {
            assertEquals(-1.0, calculatorService.add(2.0, -3.0));
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {
        @Test
        @DisplayName("Subtracting two positive numbers")
        void subtractPositiveNumbers() {
            assertEquals(2.0, calculatorService.subtract(5.0, 3.0));
        }

        @Test
        @DisplayName("Subtracting with negative result")
        void subtractWithNegativeResult() {
            assertEquals(-1.0, calculatorService.subtract(2.0, 3.0));
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {
        @Test
        @DisplayName("Multiplying two positive numbers")
        void multiplyPositiveNumbers() {
            assertEquals(6.0, calculatorService.multiply(2.0, 3.0));
        }

        @Test
        @DisplayName("Multiplying positive and negative numbers")
        void multiplyPositiveAndNegativeNumbers() {
            assertEquals(-6.0, calculatorService.multiply(2.0, -3.0));
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {
        @Test
        @DisplayName("Dividing two positive numbers")
        void dividePositiveNumbers() {
            assertEquals(2.0, calculatorService.divide(6.0, 3.0));
        }

        @Test
        @DisplayName("Division by zero throws exception")
        void divisionByZeroThrowsException() {
            assertThrows(ArithmeticException.class, () -> 
                calculatorService.divide(5.0, 0.0)
            );
        }
    }

    @Nested
    @DisplayName("Input Validation Tests")
    class InputValidationTests {
        @Test
        @DisplayName("Addition with null inputs throws exception")
        void additionWithNullInputs() {
            assertThrows(IllegalArgumentException.class, () -> 
                calculatorService.add(null, 3.0)
            );
            assertThrows(IllegalArgumentException.class, () -> 
                calculatorService.add(3.0, null)
            );
        }

        @Test
        @DisplayName("Subtraction with null inputs throws exception")
        void subtractionWithNullInputs() {
            assertThrows(IllegalArgumentException.class, () -> 
                calculatorService.subtract(null, 3.0)
            );
            assertThrows(IllegalArgumentException.class, () -> 
                calculatorService.subtract(3.0, null)
            );
        }

        @Test
        @DisplayName("Multiplication with null inputs throws exception")
        void multiplicationWithNullInputs() {
            assertThrows(IllegalArgumentException.class, () -> 
                calculatorService.multiply(null, 3.0)
            );
            assertThrows(IllegalArgumentException.class, () -> 
                calculatorService.multiply(3.0, null)
            );
        }

        @Test
        @DisplayName("Division with null inputs throws exception")
        void divisionWithNullInputs() {
            assertThrows(IllegalArgumentException.class, () -> 
                calculatorService.divide(null, 3.0)
            );
            assertThrows(IllegalArgumentException.class, () -> 
                calculatorService.divide(3.0, null)
            );
        }
    }
}

