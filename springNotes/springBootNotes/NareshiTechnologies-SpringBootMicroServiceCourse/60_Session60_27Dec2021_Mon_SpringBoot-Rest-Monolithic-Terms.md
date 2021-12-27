# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 60 \
27 Dec 2021 Mon \
7 30 AM IST - 08 25 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Monolithic Terms - Intro

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUwMTkyNzYxNDg5/details

```
						Date : 27-12-2021
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Monolithic Application

Monolithic Application :-
  Developing one application by grouping all servies together
  as a single (final) build.

Mono = one.

1 Project = multiple Modules | 1 Application = multiple Services

*) Build : Creating one final format of application.
             In Spring boot .jar/.war is used.
	     JAR - Java Archive (Standalone + Web Apps Having Embedded Server).
	     WAR - Web Archive  (Web Application deploy in external server).

*) Deploy : Place WAR file inside Server and run server.

*) Instance : A successful deployment of application (in a server) is called as Instance
        Instance = Application Running under server.

*) Request Thread:
    Server allocates one request to one thread (ie called as Request Thread)
    It will process current request and gives response.

*) Max no.of Request Threads allocated by Server
   (Max no.of Users allowed at a time)  is 200 (default value)

*) We can increase/decrease Request Threads, using below key.
  server.jetty.threads.max=<some value>
  server.tomcat.threads.max=<some value>

*) Load (or Current Load), Max Load , Load Factor
   Load / Current Load = Current no.of request under processing by server

   Max Load = Max no.of Request can be processed by a server

   Load Factor = Current Load / Max Load   ( 0<= LF <= 1)

   ex : Current Load = 100 Request
        Max Load     = 200 Request

	LF = 100/200 => 0.5


*) Scaling: Improving application performance for more no.of request/users.
a. Horizontal Scaling : Creating one more new instance for same build
b. Vertical Scaling   : Enhance Hardware configuration of same system/server.

*) Load Balancer Server : A mediator server that holds all Instance details
	along with Load Factors, when request comes it will choose an instance
	that has LESS LOAD FACTOR. If all/multiple Instance having Same LOAD FACTOR
	then choose any one Instance in RANDOM.

==========================================================
AWS Developer Basic (Zero/3+)
AWS SAA-II (3+/5+)

Fullstack = Angular + Spring Boot + DevOps(Docker/Kuberenetes)/AWS
