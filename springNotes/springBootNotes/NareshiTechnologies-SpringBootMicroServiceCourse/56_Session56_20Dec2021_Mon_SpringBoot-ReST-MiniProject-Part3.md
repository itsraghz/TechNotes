# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 56 \
20 Dec 2021 Mon \
7 10 AM IST - 8 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Mini Project - Part 3

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ5NjI4OTUwNzc3/details

```
						Date : 20-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Eclipse Debugging:-
https://www.youtube.com/watch?v=HwwF4pvYWws

a. Global Exception handling:-
=> Spring Boot has given default exception handling code at
   BasicErrorController(C) and method error() that returns
   Map<String,Object> [JSON At Output].

=> For customized Exception class, follow steps
  1. Define a class and apply @RestControllerAdvice
  2. Define a method and apply @ExceptionHandler(ExceptionClassName.class)
  3. Read Exception Type as Method Param
  4. Throw Exception object from Restcontroller methods.

@RestControllerAdvice : Any Exception in RestController then execute this class
@ExceptionHandler(T.class): For which exception execute this method.

=> It reduced duplicate code in multiple catch blocks and makes
   error handling global, easy to modify.

=> If @ExceptionHandler Return type is String, then you will get Text Format Output
   If it is a classtype then output is JSON Format.


----Custom Exception Handler class code------------
1. Model class
package in.nareshit.raghu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

	private String message;
	private String module;
	private String dateTime;
}


2. Exception Handler code
package in.nareshit.raghu.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.nareshit.raghu.exception.ProductNotFoundException;
import in.nareshit.raghu.model.ErrorMessage;

@RestControllerAdvice
public class CustomExceptionHandler {

	/*@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(
			ProductNotFoundException e)
	{

		return new ResponseEntity<String>(
				e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}*/

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleProductNotFoundException(
			ProductNotFoundException e)
	{

		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						e.getMessage(),
						"PRODUCT",
						new Date().toString()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//handleEmployeeNotFound
	//handleStudentNotFound
	//..etc

}

3. Modified RestController method catch block

        } catch (ProductNotFoundException e) {
		e.printStackTrace();
		throw e; //calls exception handler
	}

===================================================================
Connection Pooling:-
 Group of connection objects which are made on app startup.
 That makes more SQLs execution in less time.
 [performance between Server and Database]

Pool : Group of Similer class Type objects.

https://github.com/brettwooldridge/HikariCP

=> HikariCP is a API (vendor: zaxxer) that handles Connection Pooling Concept
   for any Java Application that uses Database.

=> It is OpenSource and works faster compared to any other CP Concept.

=> Spring Boot internally uses HikariCP with default AutoConfiguration.
    ctrl+shift+T : HikariConfig (C)

=> This Dependeny is default added when we add Spring Data JPA or JDBC.
   No code and No JAR is required for this, taken care by Spring Boot.

1. DEFAULT_POOL_SIZE = 10
  When App started CP is created with no.of Connections 10.

2. CONNECTION_TIMEOUT = SECONDS(30);
  If All Connections are busy, please wait 30 sec, still no output
  you will get message Connection Timeout.

3 MAX_LIFETIME = MINUTES(30);
  How long a Connection must be ketp in CP, incase of marked IDLE.

4. IDLE_TIMEOUT = MINUTES(10);
  For 10 mins, if a connection is not used for any SQL, then marked as
  IDLE Connection.

---application.properties----
spring.datasource.hikari.pool-name=my-custom
spring.datasource.hikari.maximum-pool-size=30
spring.datasource.hikari.idle-timeout=45000
spring.datasource.hikari.connection-timeout=50000
spring.datasource.hikari.max-lifetime=95000
----------------------------------------

*) We can customize all these values using properties file
   with common prefix: spring.datasource.hikari.___=___

=> We can check our details are effected or not at console
HikariDataSource    : my-custom - Starting...
HikariDataSource    : my-custom - Start completed.

======================================================================
Logging:- Tracing all types messages into a Log File
https://www.youtube.com/watch?v=mblGoKU1aKo
https://www.youtube.com/watch?v=5oLfHiP_iJc
