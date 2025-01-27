# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 2024-01-09

### Security
- Updated Spring Boot from 2.4.2/2.5.6 to 3.2.1 across all projects
- Updated Kafka clients from 2.0.0 to 3.6.1
- Updated Spark dependencies from 2.4.3 to 3.5.0
- Updated SLF4J from 1.7.x to 2.0.9

### Changed
- Successfully migrated from json-simple to Jackson 2.15.3
- Updated all Java versions to 17 for better compatibility
- Replaced deprecated JSON parsing methods with modern Jackson API
- Updated Scala version from 2.11 to 2.12 for Spark compatibility

### Fixed
- Resolved critical security vulnerabilities in Spring Boot applications
- Fixed high-severity vulnerabilities in Kafka client dependencies
- Addressed outdated JSON library security concerns

### Known Issues
- Some deprecated API usage warnings in KafkaSparkIntegration.java remain
- Unchecked operations in KafkaSparkIntegration.java need attention
- Java module system configuration warnings present (--release flag needed)

