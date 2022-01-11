# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 72 \
11 Jan 2022 Tue \
7 30 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Config Client - Working

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUyMjE5NDc4Mjkx/details

```
						Date : 11-01-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*Config Client Workflow*

=> When we add Config Client Dependency at MS# and start MS#, then
  ConfigDataLoader is executed first. That will try to Fetch data from config server
  located at : http://localhost:8888 (default)

```
  ConfigDataLoader(I)
     IS-A
  ConfigServerConfigDataLoader(C)
```
Q) What will happen if run MS# with Config Client ?
  (or) How Config Client fetch data from Config Server?

A)
 => Config Client is a dependency(JAR) added to Project(MS#)
 => It contains interface ConfigDataLoader(I) and Impl class is ConfigServerConfigDataLoader(C)
 => It will use RestTemplate object internally
 => Reads input like location of Config server(uri)
   [ex: http://localhost:8888]
 => From there it will try to read data (Evironment)
 => Get as ResponseEntity<Environment>
 => This Environment object is converted back into Map<K,V> at MS#
 => MS# also contains one Environment object, this Map is added to local Environment.

=====================================================================================
Statement: If we modify value for a KEY at Github(Config Server) then it will not be
	   updating MS# application Environment.

Solution:-
a. Re-start Config server and MS# applications

b. Use ``@RefreshScope` Endpoint (****)
  No need to restart ms# application, just make only call to "ConfigDataLoader"
   that gets latest data and merge with local Environment.


Step#1 Add Actuator Dependency in MS# application
```
 > Right click on Project > Spring > Add Starters > Search Actuator > select
 > Next > pom.xml > next > Finish
```

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Step#2 Add below key at MS# Properties file
```
management.endpoints.web.exposure.include=refresh
```
         (any one)
```				 
management.endpoints.web.exposure.include=*
```

Step#3 At RestController provide annotation: `@RefreshScope`

----Execution----
```
=> Starter All Applications in order
=> Modify Value at Github
=> Execute a Request using POSTMAN
   POST http://localhost:9906/actuator/refresh  SEND

=> now come and check URL of MS#
   http://localhost:9906/stock/show
```
