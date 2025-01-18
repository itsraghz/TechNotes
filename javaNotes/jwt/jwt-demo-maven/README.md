# JWT Implementation Demo

## Overview
This project demonstrates a basic implementation of JSON Web Tokens (JWT) in Java without using any heavy frameworks. It provides core JWT functionality including token generation, validation, and claim extraction.

## Prerequisites
- Java 11 or higher
- Maven 3.6+
- Your favorite IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Project Structure
```
jwt-demo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── jwt/
│       │               ├── JwtUtil.java
│       │               └── Main.java
│       └── resources/
├── pom.xml
├── README.md
└── JWT-THEORY.md
```

## Setup Instructions
1. Clone the repository:
```bash
git clone https://github.com/yourusername/jwt-demo.git
cd jwt-demo
```

2. Build the project:
```bash
mvn clean install
```

## Usage Examples

### Generate a JWT Token
```java
JwtUtil jwtUtil = new JwtUtil();

// Create claims
Map<String, Object> claims = new HashMap<>();
claims.put("userId", "123");
claims.put("role", "admin");

// Generate token
String token = jwtUtil.generateToken("user@example.com", claims);
```

### Validate a Token
```java
try {
    boolean isValid = jwtUtil.validateToken(token);
    if (isValid) {
        System.out.println("Token is valid!");
    }
} catch (JwtException e) {
    System.out.println("Token validation failed: " + e.getMessage());
}
```

### Extract Claims
```java
Claims claims = jwtUtil.extractAllClaims(token);
String userId = claims.get("userId", String.class);
String role = claims.get("role", String.class);
```

## Example Output
```
Generated Token: eyJhbGciOiJIUzI1NiJ9...
Token is valid: true
Claims:
- Subject: user@example.com
- UserId: 123
- Role: admin
- Issued At: 2023-07-10T10:30:00Z
```

## Contributing
Feel free to submit issues and enhancement requests!

## Further Reading
For detailed information about JWT concepts, security considerations, and best practices, please refer to [JWT-THEORY.md](JWT-THEORY.md).

## License
This project is licensed under the MIT License - see the LICENSE file for details.

