# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 50 \
11 Dec 2021 Sat \
7 05 AM IST - 7 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Producer

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ1NTU5OTA4OTM3/details

```
						Date : 11-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Spring ReST Producer Coding

*) HttpMethod Types
   GET          : Fetch Resource From Producer
   POST         : Create new Resource at Producer
   PUT          : To Modify existed Resource at Producer
   DELETE       : To Remove existed Resource at Producer
   PATCH        : To partially modify existed Resource at Producer

*) ReturnType : ResponseEntity<T> It is a class (equal to Http Response)
  It should have mainly 2 things : Body(Data) and HttpStatus(Enum).

*) Class must have annotation : @RestController ( @Controller + @ResponseBody)
  [added in Spring 4.x]

===Producer code====================================
1.
  Name : SpringBoot2RestProducerBasicEx
  Dep  : Web, Devtools

2. RestController class
```java
package in.nareshit.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@GetMapping("/fetch")
	public ResponseEntity<String> fetchEmployee() {
		ResponseEntity<String> response =
				new ResponseEntity<String>(
						"HELLO FROM FETCH",  //Body
						HttpStatus.OK);      //Status
		return response;
	}

	@PostMapping("/save")
	public ResponseEntity<String> createEmployee() {
		ResponseEntity<String> response =
				new ResponseEntity<String>(
						"HELLO FROM CREATE",  //Body
						HttpStatus.OK);      //Status
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<String> modifyEmployee() {
		ResponseEntity<String> response =
				new ResponseEntity<String>(
						"HELLO FROM UPDATE",  //Body
						HttpStatus.OK);      //Status
		return response;
	}

	@DeleteMapping("/remove")
	public ResponseEntity<String> removeEmployee() {
		ResponseEntity<String> response =
				new ResponseEntity<String>(
						"HELLO FROM DELETE",  //Body
						HttpStatus.OK);      //Status
		return response;
	}

	@PatchMapping("/emailUpdate")
	public ResponseEntity<String> modifyEmployeeEmail() {
		ResponseEntity<String> response =
				new ResponseEntity<String>(
						"HELLO FROM UPDATE EMAIL",  //Body
						HttpStatus.OK);      //Status
		return response;
	}
}
```

3. Download and install postman tool
Link: https://www.postman.com/downloads/
> Double click to install
> Do not register, skip to goto app
> use ctrl+ and ctrl- to zoom out/in


=> postman behaves like consumer, it supports making request to any language application.

----------------POSTMAN SCREEN----------------------
|GET | http://localhost:8080/employee/fetch | SEND |
----------------------------------------------------

----------------POSTMAN SCREEN----------------------
|POST| http://localhost:8080/employee/create | SEND |
----------------------------------------------------

=> if Request URL is invalid, Http Status is : 404 - Not Found
=> if Request URL is valid and http method is invalid,
   Http Status is : 405 - Method Not Allowed.
=> If Status 200 - OK, indicates Success.
---------------------------------------------------------------------------------------
