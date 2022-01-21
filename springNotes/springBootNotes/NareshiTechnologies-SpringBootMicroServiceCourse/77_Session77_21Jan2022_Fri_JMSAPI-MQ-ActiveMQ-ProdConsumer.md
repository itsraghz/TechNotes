# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 77 \
21 Jan 2022 Fri \
7 15 AM IST - 08 30 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* JMS API - ActiveMQ - Producer and Consumer Examples

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDU3MDMwODMyNzcw/details

```
						Date : 21-01-2022
						Spring Boot 7:15AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
*) Sun MicroSystem/Oracle has provided JMS API (Specification) -- 1st Party
*) Apache ActiveMQ5 is a Vendor that has given implementation to JMS.
*) We are using them and creating applications.

[javax.jms]
```
Session(I)
```

Message(I)
```
TextMessage(I)
```

[org.apache.activemq]
```
ActiveMQSession(C)

ActiveMQTextMessage(C)
```

--code-----------------
```java
interface Session {
 TextMessage createTextMessage(String text);
}

class ActiveMQSession implements Session {

 TextMessage createTextMessage(String text) {
   ActiveMQTextMessage tm = new ActiveMQTextMessage(text);
   return tm;
 }
}
```
--Spring container--------------------
```java
Session session = new ActiveMQSession();
```

----------Spring JMS-------------------------------
```java
public interface MessageCreator {
  Message createMessage(Session session) throws JMSException;
}
```
---Programmer code-----------------------
```java
Lambda Expression Syntax:

Interface ob = (methodParam) -> {methodBody};

MessageCreator messageCreator = (session) -> {
                                   TextMessage tm = session.createTextMessage("HELLO");
                                   return tm;
				};
```

--in short format--
```java
MessageCreator messageCreator = session -> session.createTextMessage("HELLO");
```

*) JmsTemplate(C):-
  it will reduce boiler plate code (common code)
  ie creating session, creating message, casting to type and send to destination.

> They just take inputs and send message to destination.

*) spring.jms.pub-sub-domain=true (pub/sub)
   spring.jms.pub-sub-domain=false(p2p) [default]

*) We can define one new consumer application at another workspace(same also fine)
  with all keys and code as same.

*) Then run ActiveMQ , Consumer and Producer appliations.
========================================================================================
