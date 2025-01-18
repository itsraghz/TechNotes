package com.example.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            JwtUtil jwtUtil = new JwtUtil();
            
            System.out.println("=== JWT Demo Application ===\n");
            
            // 1. Generate a token with custom claims
            System.out.println("1. Generating JWT Token with custom claims...");
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", "john.doe");
            claims.put("role", "ADMIN");
            
            String token = jwtUtil.generateToken(claims, "user123");
            System.out.println("Generated Token: " + token + "\n");
            
            // 2. Validate the token
            System.out.println("2. Validating the token...");
            boolean isValid = jwtUtil.validateToken(token);
            System.out.println("Token is valid: " + isValid + "\n");
            
            // 3. Extract claims
            System.out.println("3. Extracting claims from token...");
            Claims extractedClaims = jwtUtil.extractAllClaims(token);
            System.out.println("Subject: " + extractedClaims.getSubject());
            System.out.println("Username: " + extractedClaims.get("username"));
            System.out.println("Role: " + extractedClaims.get("role"));
            System.out.println("Expiration: " + extractedClaims.getExpiration() + "\n");
            
            // 4. Demonstrate error handling
            System.out.println("4. Error Handling Demonstrations...");
            
            // 4.1 Invalid signature
            try {
                String invalidToken = token.substring(0, token.length() - 4) + "invalid";
                jwtUtil.validateToken(invalidToken);
            } catch (SignatureException e) {
                System.out.println("Caught expected SignatureException: " + e.getMessage());
            }
            
            // 4.2 Invalid subject
            try {
                jwtUtil.validateToken(token);
                System.out.println("Token validation should have failed!");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected IllegalArgumentException: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

