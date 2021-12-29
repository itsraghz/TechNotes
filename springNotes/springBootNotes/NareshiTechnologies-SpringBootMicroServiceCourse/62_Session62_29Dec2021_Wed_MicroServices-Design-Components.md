# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 62 \
29 Dec 2021 Wed \
7 30 AM IST - 08 25 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* MicroServices Design Components

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDA2NDE1MDg1MzAz/details

```
						Date : 29-12-2021
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Microservices Components
			      [Spring Cloud]

[Theory/Design]
Microservices : it is a design to implement application,
		by creating every service as a small application
		and connect using Webservices.

=> It is a independent deployable component.
=> De-Coupled Architecture.

```
OOPs --- Core Java
ORM  --- JPA with Hibernate
DI   --- Spring Container
Microservices --- Spring Cloud
```
Spring Cloud : it is a Java API (pre-defined classes/interfaces)
              that implement Microservices Design.

```
    Microservices                                Spring Cloud
      [Theory]                                     [API]

 1. Register and Discovery                    Netflix Eureka Server

 2. Config Server                             Spring Cloud Config [Git]

 3. Admin Server                              Codecentric - Admin {server/client}

 4. Message Queue                             Apache ActiveMQ, Apache Kafka

 5. API Gateway				      Spring Cloud Gateway (Zuul-Removed)

 5(a). SSO[Single Sign On]                          JWT / OAuth 2.x [Social Login]
   Stateless Authentication

 5(b). Load Balancing                             Horizontal Scaling/ Multiple Instance

 5(c). Filters                                         Gatweay Filters

 6. Circuit Breaker			      Spring cloud Resilience4j [Hystix/Turbine Removed]

 7. Secured Vault                             Hashicorp vault

 8. Log Aggregator                            Elastic - ELK API
 						[Elasticsearch, Logstash, and Kibana]

 9. Intra Communication                       DiscoveryServer/LoadBaancerServer + RestTemplate
   [Consumers/Clients]				  ** Open Feign [Feign Client]

 10. Independent Service                             ReSTFul Webservices

 11. Distributed Tracing                         Spring Cloud Zipkin and Sleuth

 12. Cache Support                               Redis Cahce
```

*) State : Holding data
   Stateful : Hold data of a user at server for a period of time (login-logout)
   		Server creates HttpSession and store user data
   Stateless : no Session is created at server to store current user data.
               Only Client/Browser side store user data and token data.


*) Eureka Server: It is a Register and Discovery Server.
  It holds details of every Microservice Instance.
```
  -------------------------------Register ------------------------------------------
    ServiceId         InstanceId        Host/IP         PORT        LoadFactor(LF)
   [projectname]     [RandomVal ]
 ------------------------------------------------------------------------------------
   SEARCH-SERVICE     SERACH-26473    192.168.0.1        8686            0/200
   SEARCH-SERVICE     SERACH-85471    192.168.0.2        8080            0/200
 ------------------------------------------------------------------------------------
```
*) Config Server [Git Vendor ]
   If multiple MS# having common key-val, those we can externalize [write at common place]
   ie called as Spring Cloud Config server.


*) Codecentric - Admin server/client : Production Ready Endpoints
			[Ready made services for support]

 > Is Application Started or not?
 > Are objects created or not?
 > Is Properties load or not?
 > Mapping details?
 > Heap/Thread Dumps?
 > Logging levels?


*) Message Queues : Continioues Data flow between two applications
   implemented using : Apache ActiveMQ, Apache Kafka
Ex:
Swiggy Delivery Status
Cricket Score
Ola Cab status
Stock Market Data

*) Spring Cloud Gateway:-
   API Gateway is a only one entry/exit point to MS# application, like FC.
   All MS# components are running at different server and in private locations.
   Direct access is not provided.

*) Circuit Breaker :-
   If MS# is failed for more no.of request process in continioues manner
   then stop execution for a period of time [Resilience4j]

*) Secured Vault :- Storing secured data like password, token secret, usernames ..etc
      [These are stored in encoded format] , ie : Hashicorp(Vendor) Vault

*) Log Aggregator :-
  For every MS# there can be one logfile created, all log files data
  is taken into one common place (Common UI). So, that search/filter, trace are easy

*) Distributed Tracing:- Finding execution path of Multiple MS# when request comes
   [execution time, execution flow..etc] , Spring Cloud : Zipkin and Sleuth

*) Cache Support :- There can be multiple data bases used by multiple MS# apps.
             Common Data can be stored at Temp memory at server side
	     ie Cache (Store for a period of time).
