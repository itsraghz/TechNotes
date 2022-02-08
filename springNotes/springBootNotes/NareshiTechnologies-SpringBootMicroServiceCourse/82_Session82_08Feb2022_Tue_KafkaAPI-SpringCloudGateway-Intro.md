# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 82 \
08 Feb 2022 Tue \
7 30 AM IST - 08 20 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot Kafka Realtime Project

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU5MDU4Mzc3NDQ0/details

```
						Date : 08-02-2022
						Spring Boot 7:30AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Github Link:
https://github.com/javabyraghu/SpringBoot2ApacheKafkaEx

*) Must create a Connection between Producer/Consumer to Kafka S/w.
  using keys
    `spring.kafka.producer / spring.kafka.consumer`

*) Full setup of Kafka s/w is called as bootstrap server. Runs on port 9092
   Do not use any Protocol.

*) Must provide one topic name shared by Both Producer and consumer.

*) To create a Topic = name + partitions count + replication factor + zookeeper details

            name = Topic name
partitions count = No.of Parts (default is 1)
replication factor = No.of copies to be created for Consumer delivery (default 1)

*) Use either replication factor to specify no.of consumers or use GroupId
   to select no.of consumer connected using topicName.

*) For every partition one index number is provided ie called as offset.
   [starts from zero #0,#1,#2...etc]

*) `KafkaTemplate<K,V>` this is a class given by Spring boot used to send messages
   to topicSection. (K=TopicName, V=Value).


----------------------------
```
package : org.apache.kafka.clients.producer
class   : ProducerRecord<K, V>
package : org.apache.kafka.clients.consumer
class   : ConsumerRecord<K,V>

internal code:

ProducerRecord<K, V> producerRecord = new ProducerRecord<>(topic, data);
```

*) Kafka Listener internally uses one `MessageListener`(C) that gets data
   based on topic name, creates `ConsumerRecord`.

```
package: org.apache.kafka.common.serialization
class  : StringSerializer
class  : StringDeserializer
```

These are not Java Serializers, these are designed to send/receive data
  to/from Kafka.

*) This StringSerializer is called by default for Producer Application.
   Even `StringDeserializer` is called by default for Consumer Application

*) JSON - JACKSON API
```
class: ObjectMapper(C)
method:
   writeValueAsString(obj): JSON String
   readValue(json,ClassType): Object ClassType
```

*) If Topic name of consumer is not matched with Producer then no error and exception
   Just consumer will be waiting for data for a given topic name which will
   never happen. Just in Waiting stage.
===========================================================================

Eureka Server : Register that holds MS# details serviceInstance(SID,IID,HOST, PORT, LF)
Config Server : Common KEY=VAL of All MS# are kept outside of all projects using github
Admin Server (+Actuator) : Actuator gives production ready endpoints
	for this UI is "Admin Server"
--------------------------------------------------------------------------------
Cloud Gateway : This is common entry and exit point to full MS# setup
 here we can handle Routing, Filters, Security.


1. Routing : Identify MS# and execute it based on request PATH.

Static Routing:
  Execute Directly MS# (need not to goto Eureka) incase of single instance.

Dynamic Routing:
  Goto Eureka, Get an instance that has less load factor,
  get ServiceInstance data, now make call to MS#.


2. Filters: Add/Modify Request/Response Headers, Body..etc

3. Security : Token based[JWT] or Oauth 2.x

Q) What is old gateway name?
A) Netfilx Zuul (it is removed).
