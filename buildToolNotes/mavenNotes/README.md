# Maven Build Tool Guide

Maven is a powerful build automation and project management tool used primarily for Java projects. It simplifies the build process by providing a uniform build system, dependency management, and project information management.

## Project Structure
```
my-project/
│
├── pom.xml                 # Project configuration file
│
└── src/
    ├── main/
    │   ├── java/          # Java source files
    │   ├── resources/     # Application resources
    │   └── webapp/        # Web application files
    │
    └── test/
        ├── java/          # Test source files
        └── resources/     # Test resources
```

## Common Maven Commands

- `mvn clean`: Cleans the project by deleting the target directory
- `mvn compile`: Compiles source code
- `mvn test`: Runs unit tests
- `mvn package`: Creates JAR/WAR package
- `mvn install`: Installs package in local repository
- `mvn deploy`: Deploys package to remote repository

## Maven Examples and Output

### 1. Lifecycle Phase Examples

#### Compile Phase
```bash
$ mvn compile
[INFO] Scanning for projects...
[INFO] Building sample-project 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] Compiling 10 Java source files to target/classes
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

#### Test Phase
```bash
$ mvn test
[INFO] Scanning for projects...
[INFO] Building sample-project 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] Running com.example.AppTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

### 2. Running Multiple Phases
```bash
$ mvn clean install
[INFO] Scanning for projects...
[INFO] Cleaning target directory
[INFO] Compiling source files
[INFO] Running tests
[INFO] Building jar: target/sample-project-1.0-SNAPSHOT.jar
[INFO] Installing to local repository
[INFO] BUILD SUCCESS
```

### 3. Profile Examples
```bash
# Running with development profile
$ mvn package -P dev
[INFO] Active Profile: dev
[INFO] Using development database configuration
[INFO] BUILD SUCCESS

# Running with production profile
$ mvn package -P prod
[INFO] Active Profile: prod
[INFO] Using production database configuration
[INFO] BUILD SUCCESS
```

### 4. Running Specific Tests
```bash
# Running a specific test class
$ mvn test -Dtest=UserServiceTest
[INFO] Running com.example.UserServiceTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

# Running a specific test method
$ mvn test -Dtest=UserServiceTest#testAuthentication
[INFO] Running single test: testAuthentication
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```

### 5. Skip Options Examples
```bash
# Skip tests
$ mvn package -DskipTests
[INFO] Tests are skipped
[INFO] Building jar: target/sample-project-1.0-SNAPSHOT.jar

# Skip test compilation and execution
$ mvn package -Dmaven.test.skip=true
[INFO] Not compiling test sources
[INFO] Building jar: target/sample-project-1.0-SNAPSHOT.jar

# Skip integration tests
$ mvn verify -DskipITs
[INFO] Integration tests are skipped
[INFO] BUILD SUCCESS
```

## Maven Build Lifecycle

1. **validate** - Validate project structure
2. **compile** - Compile source code
3. **test** - Run tests
4. **package** - Package compiled code
5. **verify** - Run integration tests
6. **install** - Install to local repository
7. **deploy** - Deploy to remote repository

## Best Practices

1. **Dependency Management**
- Keep dependencies up to date
- Use dependency versions explicitly
- Avoid snapshot dependencies in production

2. **Project Structure**
- Follow standard directory layout
- Maintain clean separation of source and test code
- Keep POM files organized and documented

3. **Build Configuration**
- Use properties for version management
- Configure plugins in build section
- Maintain profile-specific configurations

## Troubleshooting

Common Maven issues and their solutions are documented in the following files:

- [Invalid Target Release Error](mavenError-InvalidTargetRelease.md)
- [IDE Dependency Download Issues](mavenError-NotDowloadingDependencies-IDE.md)
- [Common Maven Errors Summary](mavenErrors-summary.md)

For additional help, consult the [official Maven documentation](https://maven.apache.org/guides/).

