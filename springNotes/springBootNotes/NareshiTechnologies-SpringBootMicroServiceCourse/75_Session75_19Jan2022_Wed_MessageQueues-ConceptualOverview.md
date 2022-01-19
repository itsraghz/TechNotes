# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 75 \
19 Jan 2022 Wed \
7 15 AM IST - 08 30 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Message Queues Conceptual Overview

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU2MzY4NjM2MjQ2/details

```
						Date : 19-01-2022
						Spring Boot 7:15AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*Message Queues (MQs)*

*) Continioues Data flow between two devices (Producer and Consumer).
 If one time connection is created between Producer and Consumer,
  then Producer will send data and consumer will read data.
 (need not to make request multiple time from consumer).

=> Over a period of time, data must be sent from one device to another device.

Examples:-
a. Swiggy Delivery Status
b. Ola/Uber cab status
c. Live Train Status
  (Main server -> RailYtri, XYZ Service)
d. Live Cricket Score
  (Main server --> ESPN/CRICKBUZZ)
e. Stock Market data
 (Actual Stock server to all vendor apps)
f. Order Tracking
..etc
=========================================================================================
*) Producer and Consumer are connected using Mediator/Broker server.
*) Mediator Server is called as MOM - Message Oriented Middleware.
*) MOM contains a memory that holds all Messages, known as -'DESTINATION'.

*) Communication Type:
a. Peer-To-Peer (P2P) :
    If one message is sent to only one consumer.

b. Publish/Subscribe (Pub/Sub) :
    If one message is sent to multiple consumers.

*) Destination Types:-
1. Queue : It is a destination type created for Peer-To-Peer (P2P) .
       There can be multiple Queues exist. Every queue must be identified
       using one unique name.

2. Topic : It is a destination type created for Publish/Subscribe (Pub/Sub) .
       There can be multiple Topics exist. Every topic must be identified
       using one unique name.

==== MQs Vendor APIS =====================================================================
a. ActiveMQ using JMS (Rabbit MQ,..etc)
b. Apache Kafka ***
https://kafka.apache.org/quickstart
https://data-flair.training/blogs/apache-kafka-tutorial/
----------------------------------------------------------------------------------------

a. ActiveMQ using JMS (Java Message Service)

## Steps to run ActiveMQ in the local machine

a. Goto : https://activemq.apache.org/components/classic/download/
b. Choose OS based link: (Windows : apache-activemq-5.16.3-bin.zip)
c. Extract to a folder after download
d. Goto : C:\Downloads\apache-activemq-5.16.3\bin\win64
e. Double click "activemq.bat" to start.
f. Check for message : WebConsole available at http://127.0.0.1:8161/admin/
g. Enter username and password : admin / admin


*) by using ActiveMQ, we can implement both P2P and Pub/Sub Programming.
*) MQs uses in general TCP protocol (`tcp`://localhost:61616 )
*) Here ActiveMQ behaves like MOM Software.
