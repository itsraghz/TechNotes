# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 76 \
20 Jan 2022 Thu \
7 15 AM IST - 08 30 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* JMS API - ActiveMQ Examples

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU2NzAyNjMzMDEy/details

```
						Date : 20-01-2022
						Spring Boot 7:15AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*JMS API - MQs Coding Part*

*) Sun Microsystems/Oracle has provided JMS API (Java Message Services)
   which is called as 1st party (Specification)

*) Apache ActiveMQ 5 Tool and API is a Implementation (or) vendor (or) 3rd party.

*) Programmer can use JMS API and one Vendor to write Project which is called
   as Application (2nd Party).

*) We need to create Producer/Consumer applications using ActiveMQ 5 Dependencies
  spring-boot-starter-activemq (Spring for Apache ActiveMQ 5)

**** There is no direct connection between producer and consumer.
    Both are connected using MOMs Destination name.
    At Both apps side Destination Name must be same.


*) There must be a connection created between Producer/Consumer and MOM.
   For that we need to pass below keys

```java
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
spring.jms.pub-sub-domain=false
my.mq.desti-name=my-data
```

*** You must start ActiveMQ 5 server/MOM before Producer/Consumer Application start.
    Else you will get : `ConnectException: Connection refused: connect`

*** Press `ctrl+C` to cancel/stop activeMQ5 software.

===========Producer code===============================================
Name : *SpringBootJmsProducerEx*
Dep  : Spring for Apache ActiveMQ 5

1. application.properties
```java
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin

#false-P2P, true-Pub/Sub
spring.jms.pub-sub-domain=false

#Queue name
my.mq.desti-name=my-data
```

2. Producer Service
```java
package in.nareshit.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

	@Autowired
	private JmsTemplate jt;

	@Value("${my.mq.desti-name}")
	private String destinationName;

	public void sendMessage(String message) {
		MessageCreator messageCreator = session -> session.createTextMessage(message);

		jt.send(destinationName, messageCreator);
	}
}
```
3. Test class
```java
package in.nareshit.raghu.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.service.ProducerService;

@Component
public class TestProducerRunner { //implements CommandLineRunner {

	@Autowired
	private ProducerService service;

	@Scheduled(fixedDelay = 2000) //mill sec
	public void run() throws Exception {
		service.sendMessage("Hello " + new Date());
		System.out.println("SENT");
	}
}
```
*) At main class: `@EnableScheduling`
=====Consumer code======================================================
Name : *SpringBootJmsConsumerEx*
Dep  : Spring for Apache ActiveMQ 5

1. application.properties
```java
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin

#false-P2P, true-Pub/Sub
spring.jms.pub-sub-domain=false

#Queue name
my.mq.desti-name=my-data
```

2. Consumer service
```java
package in.nareshit.raghu.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

	@JmsListener(destination = "${my.mq.desti-name}")
	public void readMsg(String message) {
		System.out.println(message);
	}
}
```

3. At main class: `@EnableJms`

===Execution order========================
1. Start ActiveMQ
2. Run Consumer
3. Run Producer (multiple times even)
