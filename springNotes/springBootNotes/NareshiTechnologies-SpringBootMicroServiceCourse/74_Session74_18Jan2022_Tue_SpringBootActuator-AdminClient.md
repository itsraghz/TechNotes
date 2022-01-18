# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 74 \
18 Jan 2022 Tue \
7 15 AM IST - 08 30 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Cloud Config Server - Revision

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU2MDMwMDEwODE1/details

```
						Date : 18-01-2022
						Spring Boot 7:15AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*Spring Boot Actuator + Admin (Client/Server)*

=> Our application almost works fine in Developer machine. But once it is moved to
   Production server (Actual Server Deployed to give service to endusers).

=> To find problems and moniter issues we have lot of tools at Production server.
=> One of such services/tools is "Actuator".


*) Actuator : Production Ready Endpoints.

Endpoint: It is a pre-defined service that is used to find/execute a work like,

a. App started properly or not?
b. Object created or nor?
c. Properties data loaded or not?
..etc

*** These Endpoints can be used with any Spring Boot application (web dependency)

===============================================================================
Name : *SpringBootActuatorTest*
Dep  : Web, Devtools, Lombok, Actuator

*) application.properties

```java
#management.endpoints.web.base-path=/sample
management.endpoints.web.exposure.include=*
#management.endpoints.web.exposure.include=beans,info,env,health

info.my.app.client=NIT
info.my.app.name=SAMPLE
info.my.app.version=3.2GA
info.test.ven.model=NEW
info.test.ven.accept=bind

management.endpoint.health.show-details=always

#management.endpoint.health.enabled=false
#management.endpoint.beans.enabled=false
#management.endpoints.web.exposure.exclude=health,beans,info

spring.boot.admin.client.url=http://localhost:9999
```
-------------------------------------------------------------------------
*) Run application and check at console/log
  EndpointLinksResolver : Exposing 1 endpoint(s) beneath base path '/actuator'

=> Enter URL: http://localhost:8080/actuator

=======================================================

Q) How many endpoints are activated by default?
A)
  version >= Spring Boot 2.5.x , 1 endpoint is exposed : health
  version <= Spring Boot 2.4.x , 2 endpoints are exposed: info, health

Q) How can we activate/use all endpoints?
A) By using key : management.endpoints.web.exposure.include
   if the value is '*' then we can get activated message like
 EndpointLinksResolver  : Exposing 13 endpoint(s) beneath base path '/actuator'

 Or we can activate selected endpoints too.

```java
management.endpoints.web.exposure.include=*
```
    (or)
```		
 management.endpoints.web.exposure.include=beans,info,env,health
```

Q) can we modify basePath of Actuator services?
A) YES. By using key : `management.endpoints.web.base-path`
ex: `management.endpoints.web.base-path=/sample`
Now URL is : http://localhost:8080/sample


Q) How can one endpoint or multiple endpoints are disabled?
A)  To disable one endpoint

```java
management.endpoint.<endpoint-name>.enabled=false
```
  ex:
```
management.endpoint.health.enabled=false
management.endpoint.beans.enabled=false
```

To disable multiple endpoints
```
management.endpoints.web.exposure.exclude=health,beans,info
```
=========================================================================

1. beans : [http://localhost:8080/actuator/beans]
  To find/check what are all objects created inside spring container.


2. env : http://localhost:8080/actuator/env
  To know what are KEY=VALs loaded into Application Environment
  from different sources (JDK, OS, TimeZone, System Args/VM args, Properties/YAML..etc)

3. configprops : http://localhost:8080/actuator/configprops
 To find only keys what are loaded using : @ConfigurationProperties(prefix="")

4. mappings: http://localhost:8080/actuator/mappings
  To find URL, Http Method mapping details to a Controller/RestController.
  It is internally HandlerMapping object that holds details of
   URL + Method to a Controller + Method, even details ReturnType, Params etc.

5. info: http://localhost:8080/actuator/info
  It is static information of application given by Dev/Support Team.

  You must add data in KEY=VAL format at Properties file starts with info.

```java
info.my.app.client=NIT
info.my.app.name=SAMPLE
info.my.app.version=3.2GA
info.test.ven.model=NEW
info.test.ven.accept=bind
```

6. health: http://localhost:8080/actuator/health
  To know application is started or not properly? Even disk related information we can see.

```
management.endpoint.health.show-details=always
```
================================================================================
Admin Server : It is cental Server for All MS# used to execute Actuator Services
  and gets result into one UI Format.

*) codecentric has developed this API as opensource and Integrated by Spring boot.

-- code(onetime)---
Name : *SpringCloudAdminServerEx*
Dep  : Admin Server

At main class: ``@EnableAdminServer`

*application.properties*

```java
server.port=9999
```
-- code(for every project/MS# application) ---
S#1 Add two Dependencies
    `Admin Client`, `Actuator`

S#2 activate all endpoints

```java
management.endpoints.web.exposure.include=*
```

S#3 Link to Admin Server URL
```
spring.boot.admin.client.url=http://localhost:9999
```

*) Execution Order:
a. Run Admin Server
b. Run MS# /applications
c. Enter URL: http://localhost:9999/applications
d. Click on Application name > Application Id (not on URL)
