# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 16 \
19 Oct 2021 Tue \
7 15 AM IST - 8 30 AM IST

# Agenda

* Spring Boot Runners
* Config Readers
* Multiprofile Config Readers
* Bulk Config Readers

# Runners

* To add any logic you want to execute only once

Two types

* CommandLineRunner (since 1.0)
* ApplicationRunner (since 1.3)

Maven Project : *SpringBootRunnersEx*

* @Value - to read value from `application.properties` file
* @Autowired

## Example

* Use a MessageRunner of type CommandLineRunner.
* Use a Bean that reads values from the `application.properties` file and get this object `@Autowired` and print this in the Runner.

# BulkRead - Configuration `@ConfigurationProperties`

To read more than one config values at a time, to avoid using `@Value` as many times.

* `@Value` - Core Spring
* `@ConfigurationProperties` - Spring Boot

> *Rules:*\
> All the keys should have a common prefix for the keys. \
> There must be a getter and setter for each variable that is to be bound with a specific property

*Syntax*

```java
@ConfigurationProperties(prefix="_____")
```
## Example

Project : *SpringBoot2ConfigPropsEx*

> Note: If there are no Setters, or there are not values specified, no exeption is thrown instead `null` will be set for all the values.

## Try without `@Setter` but with the values in the properties file

## Try with `@Setter` but without the values in the properties file

# Multi-prefix in the properties

A Properties file can have multiple prefixes, but one class can have one prefix.

# Working with Complex types

* List/Set/Arrays ==> `prefix.variable[index]=value`
* Map / Properties ==> `prefix.variable.mapKey=mapValue`
* HAS-A Relation ==> `prefix.hasAVariable.variable=value`

# Introduction to YAML
