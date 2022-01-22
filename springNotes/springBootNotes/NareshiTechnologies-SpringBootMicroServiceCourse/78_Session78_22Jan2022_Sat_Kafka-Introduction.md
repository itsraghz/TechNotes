# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 78 \
22 Jan 2022 Sat \
7 15 AM IST - 08 00 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* ActiveMQ Vs Kafka, Kafka Introduction

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU3MzI2MDY2MTEy/details

```
						Date : 22-01-2022
						Spring Boot 7:15AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*Advantages of ActiveMQ5:-*

a. Best suitable for Small and Medium Scale Apps.
 ex: intra net based apps, warehouse apps, Hotel Apps..etc

b. Good only if Java Applications want to communicate.
   No need of Data conversion to Global Format is required.

c. Data persistency support given for Messages. If consumer is down.
   [for a period of time]

*Limitations in ActiveMQ5:-*

a. It is a Single Broker system (No Load Balance) [1 MOM S/w]
  If no.of Producer and Consumers are increased then it becomes slow.

b. It is protocol Dependent. Uses TCP for communication.
  Our app may use HTTP (or Other) Protocols, but this time, we need to add
  some more code/jar/apis to work on TCP protocol and formats.

c. Data lose may occure if it is slow/down as it single broker.

d. Language Dependent. Works only between Java Producer and Consumer.

====================================================================================

			        *Apache Kafka*

=> Open Source, Distributed MQs software given by Apache Vendor.
=> Supports to connect any type of application for Message Trasfer.
   [Stream, Database, Apps..etc]

=>** It is protocol and language independent.
=> There is no P2P(Queues) concept, only Pub/Sub (Topic) exist in Kafka.
   Even to send message to 1 consumer use Topic only.

=>** It is multi-broker based software to handle multiple consumers (load balance).
=>** It supports Global Data formats with Data Serialization and Deserialization.
     [ Object --> Serialization --> Network Format (JSON/String) ]


====KAFKA S/W COMPONENTS==============

1. TOPICS : It is a memory that holds all messages sent by Producer.
             It will store data in Partitions.

2. MESSAGE BROKER : When Kafka s/w started there is only 1 broker is created default.
	   one message broker will read data from topics and send to consumer.

3. CLUSTER  : Group of message brokers.

4. ZOO KEEPER : It controls both Topics and Cluster.
               Like create topic, allocate broker to consumer..etc

5. ECO SYSTEM : Full Kafka setup is called as EcoSystem
         EcoSystem = Zookeeper + Topics + Cluster

6. CONSUMER : It is a application that is connected using one topic name to read data.

7. PRODUCER : It is a application that will send data to Kafka s/w.

=> Both Producer and Consumer are connected using TopicName only.

--Producer Flow---

1. Producer app holds data in KEY=VAL format. Where KEY=TopicName, V=Data.
2. It will send data to Kafka S/w
3. Zookeeper creates one toic at Topics Section.
4. Topic is created using programmer inputs like
   topicName, partitions count, replicatation count..etc

5. Data partitions are created to store large data in part by part.
6. offset ids (index numbers) are allocated to parts.
7. Finally data stored at Topic name.

--Consumer Flow---

8. Now Define one consumer application with same topic name.
   Else data will not be received.

9. Consumer request to Kafka (Zookeeper) for Data using topicname.
   Zookeeper allocates one broker.

10. Broker reads topic name and check at topics section for existency.

11. If exist Message Replica (Cloned Object).
    will read topic data and creates one clone.

12. Clone is created finally from partitions.

13. broker reads clone partitions based on offset.

14. Broker will send data after deserialize to consumer.

15. Consumer will receive all partitions and creates final message.
