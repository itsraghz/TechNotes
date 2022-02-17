# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 91 \
17 Feb 2022 Thu \
7 00 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Reactive Programming

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDcwNzc4MjQ0NTM5/details

```
						Date : 17-02-2022
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
			*Spring Boot Reactive Programming*

>> Resource Utilization, Keep all threads busy by using Event looping.
>> Non-Blocking, Do no keep thread in silent mode if DB request is made
   (NIO call - Network Input and Output)
>> Spring Webflux is used, it is not a replacement to Spring Web.
   Added in Spring 5.x
>> Database API also reactive support : Spring Data Reactive MongoDB.
>> Publishers (output formats) Mono<T>, Flux<T>
   Mono<T> ==> 0/1 Element   (Just compare with Optional<T>)
   Flux<T> ==> 0..n Elements (JUst compare with List<T>)

=> We need to define two applications. Producer and Consumer.
=> Client is not RestTemplate this time. We have WebClient(I).
=> Producer annotations are almost similer to RestAPI
  @RestController, @GetMapping, @RequestBody, @PathVariable..etc

=> ResponseEntity<T> is replaced with  Mono<T>/Flux<T>.

=> server is used : Netty
========================================================================
MongoDB Download
Goto : https://www.mongodb.com/try/download/community
> Select details > Download and Install

create folders: C:\data\db\
  C:
   |-data
      |-db

>> set path in OS like JDK path
C:\Program Files\MongoDB\Server\4.2\bin

>> Start MongoDB server : mongod  (starts on 27017)
>> Start MongoDB client : mongo  

====Execution===================================
1. Start Mongodb server
cmd> mongod

2. Run Spring Boot application
> open main class and run

3. Open POSTMAN and make request

a) save
```
POST http://localhost:8080/student/create  SEND
    Body
       (*) raw       [JSON]
```
```json
{
    "sid" : 200,
    "sname" : "AA",
    "sfee" : 500.25
}
```
b) Fetch one
GET http://localhost:8080/student/fetch/200

c) FETCH ALL
GET http://localhost:8080/student/all

d) Delete One
DELETE http://localhost:8080/student/remove/200


4. Start MongoDB client
https://docs.mongodb.com/v4.0/crud/
cmd> mongo


5. Check collections and Documents
```
cmd> show dbs;
cmd> use nitdb;
cmd> show collections
cmd> db.student.find().pretty();
```
=================================================================
Spring Cloud Mini Project:-
```
>> Eureka Server
>> Config Server
>> Admin Server (+Acutator)
>> Gateway Server
>> Microservices

> MongoDB, CB(Hystrix,Turbine)
```
