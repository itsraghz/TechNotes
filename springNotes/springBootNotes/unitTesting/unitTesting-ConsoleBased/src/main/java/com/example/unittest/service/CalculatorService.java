package com.example.unittest.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(Double a, Double b) {
        validateInput(a, b);
        return a + b;
    }

    public double subtract(Double a, Double b) {
        validateInput(a, b);
        return a - b;
    }

    public double multiply(Double a, Double b) {
        validateInput(a, b);
        return a * b;
    }

    public double divide(Double a, Double b) {
        validateInput(a, b);
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    private void validateInput(Double a, Double b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }
    }
}

