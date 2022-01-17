# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 73 \
17 Jan 2022 Mon \
7 30 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Config Server - Revision

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ4MDMxMjAxNDYw/details

```
						Date : 17-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*Spring Cloud Config Server*

=> Config Server is used to handle common KEY=VALs in all MS# applications by storing them in a common/shared place.

=> We must provide git location details at Config Server, using below keys:

```java
spring.cloud.config.server.git.uri=https://github.com/sample2025nit/nit-config-test.git
spring.cloud.config.server.git.username=**************
spring.cloud.config.server.git.password=**************
spring.cloud.config.server.git.default-label=main
```

=> Here default-label indicates github branch name. If there is only one branch that is called as `master`/`main` branch.

=> At main class level : must add `@EnableConfigServer` (for Config server application)

=> Every MS# must have config client dependency that gets data from Config server.

=> Memory 'Environment' is created at server to store all KEY=VALs.

=> Config Server Recomanded port number is 8888.

=> At MS# even we need to provide Config Server location
```
	 spring.config.import=optional:configserver:http://localhost:8888
```

=> **** When we start MS# application, first it will execute Config Client only that has to get all common KEY-VALs, then app will be started.

[At Console/Log Lines]
```
 ConfigDataLoader  : Fetching config from server at : http://localhost:8888
```

===================================================================================
=> ConfigDataLoader(I) makes call to Config Server (not to Github).
=> ConfigDataLoader(I) Having Impl class : ConfigServerConfigDataLoader(C).
=> It uses RestTemplate and takes URI given by programmer in properties
 (ex: http://localhost:8888) makes HTTP call to get ResponseEntity<Environment>

=> This Environment memory is converted into Map<K,V> and merged with our local Environment.

=================================================================================
## RefreshScope

*Problem Statement:*
 If we modify any `KEY=VAL` data at Github, then it will _not_ reflect until we restart all MS# and Config Server applications.

Solution Statement: Use `@RefreshScope` annotation.

=> @RefreshScope is pre-defined Endpoint(from actuator services),
	it is internally calling ConfigDataLoader(I) only.

=> We must activate this one by adding key at MS# application
```
	 management.endpoints.web.exposure.include=refresh
```	 
								 (or)
```
	 management.endpoints.web.exposure.include=*
```	 

=> in pom.xml we need to add : `spring-boot-starter-actuator` dependency.
