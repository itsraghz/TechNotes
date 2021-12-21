# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 57 \
21 Dec 2021 Tue \
7 10 AM IST - 8 05 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Mini Project - Part 4

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ5Nzg0MzYyMjM5/details

```
						Date : 21-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring ReST Client
				[RestTemplate (C)]

RestTemplate(C) :
 => This is given by Spring ReST API, used to make HTTP calls to Producer Application.
 => It supports all HTTP methods like GET, POST, PUT, DELETE and PATCH..etc
 => Even supports sending data as input like JSON/XML + PathVariables..etc
 => We can get ResponseEntity<T> / T(String/Employee) along with HttpStatus.

 => ** Always Consumer Applications connected to Producer Apps using URL and HttpMethods
    not by using ClassName and method Names.

1. Create RestTemplate class object
2. Define URL String of Producer
3. Make Http Request using URL, HttpMethod, Inputs..etc
   Also Get Response at same time
4. Print Response/Result

=> ResponseType String can store any type of data (text/JSON/XML)

Q) If ReturnType is ComplexType (Class/Collection) then what is the default output format
	at REST producer application?
A) JSON

Q) Can we Store JSON data as String variable at Consumer?
A)  YES.
    Ex: String json="{\"sid\":101,\"sname\":\"ABC\"}";

*) At Consumer, Response Type String can can store any type of data (text/JSON/XML)
   Given By Producer application. Or Else we can convert data back to Object Format,
   supported by Consumer.

=======Code======================================================
1. Producer
Name : *SpringBoot2RestProducerEx*
Dep  : Spring Web, Lombok, Devtools

*) Model class
```java
package in.nareshit.raghu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Integer id;
	private String name;
	private Double fee;
}
```
*) RestController
```java
package in.nareshit.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.Student;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@GetMapping("/message")
	public ResponseEntity<String> showMessageA() {
		return new ResponseEntity<String>("HELLO MESAGE!",HttpStatus.OK);
	}

	@GetMapping("/data/{id}/{code}/{amt}")
	public ResponseEntity<String> showMessageB(
			@PathVariable Integer id,
			@PathVariable String code,
			@PathVariable Double amt
			)
	{
		return new ResponseEntity<String>(
				"HELLO DATA! =>"+ id+ "-"+ code +"-"+ amt,
				HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Student> showMessageC(
			@PathVariable Integer id
			)
	{
		return new ResponseEntity<Student>(
				new Student(id, "AAA", 500.0),
				HttpStatus.OK);
	}
}
```
==================================================================
2. Consumer Application

Name : *SpringBoot2RestConsumerEx*
Dep  : Spring Web, Lombok

*) Model class
```java
package in.nareshit.raghu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Integer id;
	private String name;
	private Double fee;
}
```

*) Consumer Runner class#1

```java
package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class GetMethodRunnerA implements CommandLineRunner {

	public void run(String... args) throws Exception {
		//1. Create RestTemplate class object
		RestTemplate rt = new RestTemplate();

		//2. Define URL String of Producer
		String url = "http://localhost:8080/student/message";

		//3. Make Http Request using URL, HttpMethod, Inputs..etc
		     //Also Get Response at same time
		// URL, ResponseType, PathVariables
		ResponseEntity<String> response = rt.getForEntity(url, String.class);

		//4. Print Response/Result
		System.out.println("Body =>" + response.getBody());
		System.out.println("Code =>" + response.getStatusCode().name());
		System.out.println("Value =>" + response.getStatusCode().value());
	}

}
```

*) Consumer Runner class#2
```java
package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class GetMethodRunnerB implements CommandLineRunner {

	public void run(String... args) throws Exception {
		RestTemplate rt = new RestTemplate();

		String url = "http://localhost:8080/student/data/{id}/{code}/{amt}";

		// URL, ResponseType, PathVariables
		ResponseEntity<String> response = rt.getForEntity(url, String.class,101,"ABC",500.0);

		System.out.println("Body =>" + response.getBody());
		System.out.println("Code =>" + response.getStatusCode().name());
		System.out.println("Value =>" + response.getStatusCode().value());
	}

}
```

*) Consumer Runner class#3
```java
package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.nareshit.raghu.model.Student;

@Component
public class GetMethodRunnerC implements CommandLineRunner {

	public void run(String... args) throws Exception {
		RestTemplate rt = new RestTemplate();

		String url = "http://localhost:8080/student/find/{id}";

		// URL, ResponseType, PathVariables
		// Response String holds JSON Data
		//ResponseEntity<String> response = rt.getForEntity(url, String.class,101);
		//System.out.println("Body =>" + response.getBody()); //JSON Output

		ResponseEntity<Student> response = rt.getForEntity(url, Student.class,101);
		System.out.println("Body =>" + response.getBody()); //Student toString Output

		System.out.println("Code =>" + response.getStatusCode().name());
		System.out.println("Value =>" + response.getStatusCode().value());
	}

}
```
=================================================================================
