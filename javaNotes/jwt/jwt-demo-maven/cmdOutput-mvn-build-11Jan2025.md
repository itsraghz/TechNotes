# Command line Output

```sh
=== JWT Demo Application ===

1. Generating JWT Token with custom claims...

```sh
Generated Token: eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiQURNSU4iLCJ1c2VybmFtZSI6ImpvaG4uZG9lIiwic3ViIjoidXNlcjEyMyIsImlhdCI6MTczNjYxMzY3OCwiZXhwIjoxNzM2NjQ5Njc4fQ.wXdspUZw7tO57PPBBM8mBdPXAZ3Odj6OiHQ5sRbwIy0
```

2. Validating the token...
```sh
Token is valid: true
```

3. Extracting claims from token...
```sh
Subject: user123
Username: john.doe
Role: ADMIN
Expiration: Sun Jan 12 08:11:18 IST 2025
```

4. Error Handling Demonstrations...
```java
Unexpected error occurred: Invalid JWT signature
io.jsonwebtoken.JwtException: Invalid JWT signature
	at com.example.jwt.JwtUtil.validateToken(JwtUtil.java:67)
	at com.example.jwt.Main.main(Main.java:45)
	at org.codehaus.mojo.exec.ExecJavaMojo.doMain(ExecJavaMojo.java:375)
	at org.codehaus.mojo.exec.ExecJavaMojo.doExec(ExecJavaMojo.java:364)
	at org.codehaus.mojo.exec.ExecJavaMojo.lambda$execute$0(ExecJavaMojo.java:286)
	at java.base/java.lang.Thread.run(Thread.java:1575)
```

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  14.860 s
[INFO] Finished at: 2025-01-11T22:11:18+05:30
[INFO] ------------------------------------------------------------------------
```
