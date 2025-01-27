# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [2.0.0] - 2024-01-11

### Security
- Updated Spring Boot from 2.4.2/2.5.6 to 3.2.1 in all Spring projects
- Updated Apache Spark from 2.3.x/2.4.3 to 3.5.0 in all Spark projects
- Updated Kafka clients from 2.0.0/3.4.0 to 3.6.1 in all Kafka projects
- Replaced vulnerable json-simple with jackson-databind 2.15.3
- Updated SLF4J from 1.7.x to 2.0.9 across all projects
- Updated Lombok to 1.18.30
- Updated sparkjava-core from 2.5 to 2.9.4
- Updated Scala version from 2.11 to 2.12 for Spark compatibility

### Changed
- Upgraded minimum Java version requirement to 17 for all projects
- Updated Scala version to 2.12 for Spark 3.x compatibility
- Modernized all projects to use latest stable versions of dependencies

### Breaking Changes
- Spring Boot 3.x requires Java 17 or higher
- Spark 3.x has API changes from Spark 2.x
- Scala 2.12 is now required for Spark projects
- JSON processing code may need updates due to switch from json-simple to Jackson

### Migration Guide
#### Spring Boot 2.x to 3.x
- Review deprecated API usage
- Update any javax.* imports to jakarta.*
- Check for Spring Security configuration changes
- Review Spring Data repository interfaces
- Update test configurations

#### Spark 2.x to 3.x
- Review DataFrame API changes
- Update ML pipeline configurations
- Check for deprecated method usage
- Update Spark SQL queries if using catalog features

#### General Updates
- Verify Java 17 compatibility in CI/CD pipelines
- Update build tools and IDE configurations
- Review and test JSON processing code
- Update logging configurations for SLF4J 2.x

