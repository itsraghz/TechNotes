package com.example.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class JwtUtil {
    private final SecretKey key;
    private static final long DEFAULT_EXPIRATION = 1000 * 60 * 60 * 10; // 10 hours

    public JwtUtil() {
        // Generate a secure key for HS256 algorithm
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    /**
    * Generates a JWT token with custom claims
    * @param claims Map of claims to include in the token
    * @param subject Subject of the token (usually username)
    * @param expirationMs Token expiration time in milliseconds
    * @return Generated JWT token
    */
    public String generateToken(Map<String, Object> claims, String subject, long expirationMs) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }

    /**
    * Generates a JWT token with default expiration time
    * @param claims Map of claims to include in the token
    * @param subject Subject of the token
    * @return Generated JWT token
    */
    public String generateToken(Map<String, Object> claims, String subject) {
        return generateToken(claims, subject, DEFAULT_EXPIRATION);
    }

    /**
    * Validates a JWT token
    * @param token JWT token to validate
    * @return true if token is valid, false otherwise
    */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            throw new JwtException("Invalid JWT signature");
        } catch (MalformedJwtException e) {
            throw new JwtException("Invalid JWT token");
        } catch (ExpiredJwtException e) {
            throw new JwtException("JWT token is expired");
        } catch (IllegalArgumentException e) {
            throw new JwtException("JWT claims string is empty");
        }
    }

    /**
    * Extracts all claims from a token
    * @param token JWT token
    * @return Claims object containing all claims
    */
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
    * Extracts a specific claim from a token using a resolver function
    * @param token JWT token
    * @param claimsResolver Function to resolve the desired claim
    * @return Resolved claim value
    */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
    * Extracts the subject from a token
    * @param token JWT token
    * @return Subject claim from the token
    */
    public String extractSubject(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
    * Extracts the expiration date from a token
    * @param token JWT token
    * @return Expiration date from the token
    */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
    * Checks if a token has expired
    * @param token JWT token
    * @return true if token is expired, false otherwise
    */
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
    * Gets the signing key used for token operations
    * @return The signing key
    */
    public Key getSigningKey() {
        return this.key;
    }
}

