package com.example.unittest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.unittest.service.CalculatorService;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class UnitTestDemoApplication implements CommandLineRunner {

    private final CalculatorService calculatorService;

    public UnitTestDemoApplication(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UnitTestDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ZonedDateTime now = ZonedDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z (VV)"));
        
        System.out.println("\n===========================================");
        System.out.println("Calculator Operations Demo");
        System.out.println("Execution Time: " + timestamp);
        System.out.println("===========================================\n");

        double num1 = 10.5;
        double num2 = 5.5;

        // Addition Section
        System.out.println("Addition Operation");
        System.out.println("----------------");
        System.out.printf("%.2f + %.2f = %.2f%n%n", 
            num1, num2, calculatorService.add(num1, num2));

        // Subtraction Section
        System.out.println("Subtraction Operation");
        System.out.println("--------------------");
        System.out.printf("%.2f - %.2f = %.2f%n%n", 
            num1, num2, calculatorService.subtract(num1, num2));

        // Multiplication Section
        System.out.println("Multiplication Operation");
        System.out.println("-----------------------");
        System.out.printf("%.2f * %.2f = %.2f%n%n", 
            num1, num2, calculatorService.multiply(num1, num2));

        // Division Section
        System.out.println("Division Operation");
        System.out.println("-----------------");
        try {
            System.out.printf("%.2f / %.2f = %.2f%n", 
                num1, num2, calculatorService.divide(num1, num2));
        } catch (IllegalArgumentException e) {
            System.out.println("Error performing division: " + e.getMessage());
        }

        // Closure
        System.out.println("\n===========================================");
        System.out.println("Calculator Demo Completed Successfully");
        System.out.println("===========================================");
    }
}

