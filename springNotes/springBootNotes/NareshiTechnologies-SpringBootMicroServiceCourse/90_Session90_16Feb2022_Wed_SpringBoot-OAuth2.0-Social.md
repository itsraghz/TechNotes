# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 90 \
16 Feb 2022 Wed \
7 00 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Spring Boot Oauth 2.x Login  Facebook

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDYyMDI0MTc5NTY2/details

```
						Date : 16-02-2022
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Oauth Security -- PART-2

*) Spring Boot REST + ReactJS Application:-
Facebook Login
clientId: 521415442624922
secret: b3b074518f4e410230bb548812ad6769

Google Login
clientId : 422070794205-d7u50a1agemgptusrq6ko8jcutgudl3q.apps.googleusercontent.com
secret:   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

Github Login
clientId : be1b19de0ed8188f7ade
secret: 9c125cbaeebc83a35ffe09289712fea2246bab6e

Spring Boot code:
https://github.com/javabyraghu/spring-social
ReactJS Code:
https://github.com/javabyraghu/react-social

cmd> npm install  to download all node_modules
cmd> npm start    to run app
Enter URL:
http://localhost:3000/

JSX

HTML (CSS/JS)

JS (HTML) --tags like XML Format

--IN backend----------
```java
		.and()
		.oauth2Login()
		.authorizationEndpoint()
		.baseUri("/oauth2/authorize")
		.authorizationRequestRepository(cookieAuthorizationRequestRepository())
		.and()
		.redirectionEndpoint()
		.baseUri("/oauth2/callback/*")
```
-----3 files-----------
```java
OAuth2UserInfo
OAuth2UserInfoFactory
FacebookOAuth2UserInfo/Github../Google...
```
---------------------------------------------

Blocking Concept:-
=> For one Request (made by browser) , server allocates one Thread.
=> Thread will process request.
=> Some time , thread needs database data, ie NIO call.
=> If Thread made DB call and waiting for DB response
   then it is called BLOCKED (3 sec NI call, 4 sec process, 3 sec NO call)
   total 10 Sec sitting silent.

=> Meanwhile (b/w 10 sec gap) if any other request comes,
   our first thread will not be allocated, server allocates new one.

=> IF Thread is waiting for DB response and doing nothing will waste
   resource time/memory. (Improper resource utilization).

=> Once thread gets data from Db and Response given, then it can be
   allocated to another request.

Non-Blocking :-
*) If thread is in waiting mode (Blocked) then allocate it to another request
   and hadle DB response to another thread-2 (same or diff thread gives response)

   This process is handled by a mediator (Event Loop).

=======================================================
Server : Tomcat(Blocking), Netty (non-blocking)

API: WEB MVC (Blocking), WebFlux (Spring 5.x) (non-blocking)

Code : ResponseEntity (Blocking), Mono/Flux (non-blocking)

Optional<T>   / Mono<T>
List<T>      / Flux<T>

DB: JPA,JDBC (Blocking), MongoDB (non-blocking)
