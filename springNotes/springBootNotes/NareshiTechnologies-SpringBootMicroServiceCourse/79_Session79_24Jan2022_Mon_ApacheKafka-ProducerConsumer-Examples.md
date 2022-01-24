# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 79 \
24 Jan 2022 Mon \
7 15 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Apache Kafka - Producer, Consumer Examples

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU3NTQxMTI4ODYx/details

```
						Date : 24-01-2022
						Spring Boot 7:15AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Quick Start:- https://kafka.apache.org/quickstart

1. Apache Kafka Download
```
> Goto: https://kafka.apache.org/downloads
> Click on : Scala 2.12  - kafka_2.12-2.8.0.tgz
> Extract to a folder
> Copy Folder to Root location (or) C:/ drive [Optional]
```

*) Cmds location for Linux/MacOs : `C:\kafka_2.12-2.8.0\bin`
*) Cmds location for Windows     : `C:\kafka_2.12-2.8.0\bin\windows`
------------------------------------------------------------------------------
2. Apache Kafka Commands

*) Open cmd location at : `C:\kafka_2.12-2.8.0>`
*) Execute below commands one by one (at new cmd window)

a. Zookeeper (starts on 2181 port number)
```sh
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

b. Kafka Server (starts on 9092 port number)

```sh
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

c. Topic

```sh
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic nitone
```

d. Console Producer

```sh
.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic nitone
```

e. Console Consumer
```sh
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic nitone --from-beginning
```

> *** Must close them in reverse order to stop them in proper way. [use ctl+c]

------------------------------------------------------------------------------
3. Spring Boot + kafka Design

*) Spring Boot supports writing both Producer and Consumer applications using
   Apache Kafka Open Source API.

=> `KafkaTemplate<K,V>` to send data from Producer to Kafka S/w
=> `@KafkaListener(topics="")` to read data from Kafka  s/w to Consumer app.
=> Both are connected using topic Name only.
=> Topic created by Zookeeper with inputs topic name, replication factor, partitions count.
   [ if we did not provide replication factor,
     then based on no.of consumers are connected using one groupId, replications are created]
