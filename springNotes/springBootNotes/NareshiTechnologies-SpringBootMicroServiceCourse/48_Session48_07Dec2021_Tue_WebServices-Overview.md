# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 48 \
07 Dec 2021 Tue \
7 05 AM IST - 8 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Web Services Overview

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQyNDkwNTU1Njcx/details

```
						Date : 07-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Webservices#1
https://www.youtube.com/watch?v=fvG7FEU1Rt8
Webservices#2
https://www.youtube.com/watch?v=tX1Wtv8Gdpo
	     -------------------------------------------------------------
			            Webservices

*) Webservices:-
 It is a concept of Integration of Applications which are running at two different servers.

=> link applications for communication/data exchange. (Project to Project Link)
=> Two applications are connected using HTTP protocol.
=> Data is exchanged using XML(eXtensible Markup Language)
     or JSON (Java Script Object Notation) ***

=> In two applications, one behaves like Producer and another one behaves like consumer.
=> Producer contains Skeleton (Code that gives service).
=> Consumer contains Stub (Code that reads service).

=> Two develop application we may use 3 layers : PL, SL and DAL/DL.
=> To link applications (for Webservices) 4th layer is used : IL (Integration Layer).

-HTTP----------------------------------------------------------------
=> It is protocol used to send/receive data b/w Client-Server.
=> HTTP - Hyper Text Trasfer Protocol.
=> It supports 2 types of Messages
  a. Request Message
  b. Response Message

=> Either Request or Response contains 2 parts Head and Body.
=> Head Contains Initial Line + Header Params (KEY=VAL).
=> Body contains Data (in any Format).

=> Http Request mainly contains Http Method (indicates a task)
  https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods

  GET : Fetch Resource(Text/File/Database) from Producer/server
  POST: Create Resource at Producer/server.
  PUT : Modify Existed Resource at Producer/server.
  DELETE : Remove existed Resource at Producer/server.
  PATCH : Partially Modify Existed Resource at Producer/server.

  HEAD : Just Do task (no Request Body + no Response body)
  TRACE: Find Location/Path/Folder of a Given Resource
  OPTIONS: Check possible set of operations for a Resource.

  CONNECT : Check active connection b/w Producer and Consumer.

=> Http Response mainly contains Status ( What happen after request processing? )
   https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

 1xx (100,101,102) ... Informational
 2xx (200,201,202)...  Success
 3xx (300,301..)  ...  Redirect
 4xx (400,401...) ...  Client Side Error
 5xx (500,501,502) .. Server Side Error

-Data-----------------------------------------------------
*) Data is exchanged in Global formats. (XML/JSON)
*) JAXB API is used to convert Java Object to XML (even reverse)
*) JACKSON API is used to convert Java Object to JSON (even reverse)

============================================================
