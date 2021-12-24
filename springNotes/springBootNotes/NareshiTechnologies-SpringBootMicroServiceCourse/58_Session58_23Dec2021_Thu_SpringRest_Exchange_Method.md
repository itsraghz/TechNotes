# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 58 \
23 Dec 2021 Thu \
7 10 AM IST - 07 45 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Mini Project - Part 5

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDUwMDI4NDMwMjU4/details

```
						Date : 23-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
RestTemplate(C):-
 Spring Rest Consumer can be implemented using this, it makes HTTP calls to Producer
 and gets ResponseEntity<T> back.

a. getForEntity(url,ResponseType,pathVariables): ResponseEntity<T>

b. postForEntity(url, requestEntity, responseType, pathVariables): ResponseEntity<T>

Here requestEntity = (HttpEntity) which is combination of Headers and Body

```
==========================================================================
c. exchange(
      url,  
      httpMethod,            // GET, POST, PUT, DELETE
      requestEntity,         // Headers + Body
      responseType,          // ex: String.class
      pathVariables)
   : ResponseEntity<T>
```
=> It is generic method, supports making any type of Http call.
  Specially for PUT and DELETE we use this method, as we do not have
  any putForEntity and deleteForEntity methods.

====Producer RestController======================================
```java
package in.nareshit.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/create")
	public ResponseEntity<String> createStudent(
			@RequestBody Student student
			)
	{
		return new ResponseEntity<String>(
				"Student created"+ student.toString(),
				HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeStudent(
			@PathVariable Integer id
			)
	{
		return new ResponseEntity<String>(
				"Student Removed",
				HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(
			@RequestBody Student student
			)
	{
		return new ResponseEntity<String>(
				"Student updated"+ student.toString(),
				HttpStatus.OK);
	}
}
```
=============Consumer Runners===========================================
1. GET using Exchange
```java
package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.nareshit.raghu.model.Student;

//@Component
public class GetMethodRunnerC implements CommandLineRunner {

	public void run(String... args) throws Exception {
		RestTemplate rt = new RestTemplate();

		String url = "http://localhost:8080/student/find/{id}";

		//ResponseEntity<String> response = rt.getForEntity(url, String.class,101);
		//System.out.println("Body =>" + response.getBody()); //JSON Output

		//ResponseEntity<Student> response = rt.getForEntity(url, Student.class,101);
		ResponseEntity<Student> response = rt.exchange(url, HttpMethod.GET,null,Student.class,101);

		System.out.println("Body =>" + response.getBody()); //Student toString Output
		System.out.println("Code =>" + response.getStatusCode().name());
		System.out.println("Value =>" + response.getStatusCode().value());
	}
}
```
----------------
2. POST using exchange
```java
package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class PostMethodRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		RestTemplate rt = new RestTemplate();

		String url = "http://localhost:8080/student/create";

		//headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		//body
		String body ="{\"id\":200,\"name\":\"SAM\",\"fee\":1200.0}";

		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);

		//post(url, requestEntity, responseType, pathVariables);
		//ResponseEntity<String> response = rt.postForEntity(url, requestEntity, String.class);
		ResponseEntity<String> response = rt.exchange(url,HttpMethod.POST, requestEntity, String.class);

		System.out.println("Body " + response.getBody());
		System.out.println("Status Code " + response.getStatusCode().name());
		System.out.println("Status Value " + response.getStatusCode().value());
		System.out.println("Response Headers " + response.getHeaders());
	}
}
```
----------------
3. delete
```java
package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class DeleteMethodRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		RestTemplate rt = new RestTemplate();

		String url = "http://localhost:8080/student/remove/{id}";

		ResponseEntity<String> response = rt.exchange(url,HttpMethod.DELETE, null, String.class,101);

		System.out.println("Body " + response.getBody());
		System.out.println("Status Code " + response.getStatusCode().name());
		System.out.println("Status Value " + response.getStatusCode().value());
		System.out.println("Response Headers " + response.getHeaders());
	}
}
```
----------------------
4. PUT method
```java
package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PutMethodRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		RestTemplate rt = new RestTemplate();

		String url = "http://localhost:8080/student/modify";

		//headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		//body
		String body ="{\"id\":200,\"name\":\"SAM\",\"fee\":1200.0}";

		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);

		ResponseEntity<String> response = rt.exchange(url,HttpMethod.PUT, requestEntity, String.class);

		System.out.println("Body " + response.getBody());
		System.out.println("Status Code " + response.getStatusCode().name());
		System.out.println("Status Value " + response.getStatusCode().value());
		System.out.println("Response Headers " + response.getHeaders());
	}
}
```
==============================================================================
