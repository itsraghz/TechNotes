# Gradle Project Guide

## Gradle Introduction
Gradle is a powerful build automation tool that supports multi-language development. It's highly extensible, fast, and widely used in the Java ecosystem.

### Key Features
- Declarative builds and convention over configuration
- Powerful dependency management
- Build-by-convention
- Groovy/Kotlin DSL
- Excellent IDE support

## Basic Concepts
### Build Scripts
Build scripts (`build.gradle`) define the project configuration:
```groovy
plugins {
    id 'java'  // Adds Java compilation capabilities
}

repositories {
    mavenCentral()  // Defines where to find dependencies
}
```

### Project Structure
```
project-root/
├── build.gradle          # Project build script
├── settings.gradle       # Project settings
├── src/
│   ├── main/
│   │   ├── java/        # Source files
│   │   └── resources/   # Resource files
│   └── test/
│       ├── java/        # Test source files
│       └── resources/   # Test resources
└── build/               # Generated files
```

## Building Blocks

### Plugins
Plugins extend Gradle's functionality:
- `java`: Adds Java compilation
- `application`: For creating executable JVM applications
- `maven-publish`: For publishing artifacts

### Dependencies
```groovy
dependencies {
    implementation 'group:artifact:version'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'
}
```

### Tasks
Tasks are the building blocks of Gradle:
- `build`: Assembles and tests the project
- `clean`: Deletes the build directory
- `test`: Runs tests
- `jar`: Assembles the JAR file

## Common Tasks

### Building the Project
```bash
./gradlew build
```

### Running Tests
```bash
./gradlew test
```

### Cleaning Build Directory
```bash
./gradlew clean
```

### Checking Dependencies
```bash
./gradlew dependencies
```

### Project Reports
```bash
./gradlew projects   # Lists projects
./gradlew tasks      # Lists tasks
```

