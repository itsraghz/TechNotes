# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 52 \
14 Dec 2021 Tue \
7 00 AM IST - 7 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST RequestBody

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ2MzU1OTU4ODEz/details

```
						Date : 14-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
All PDFs
https://www.mediafire.com/file/w5x9w5vcmkwkkdv/RaghuSirNareshITJavaPdfs.zip/file


			   MediaType Annotations

1. `@RequestBody`  : Input/MethodParameter/Request
2. `@ResponseBody` : Output/ReturnType/Response

*) `@RequestBody` : (We can compare with Spring MVC -- `@ModelAttribute`)

```
  Http Request (JSON/XML Data) ---> Object Format --> Method Parameter
```

Syntax:
  method(@RequestBody ClassName objName) { }

*) GET Method Type do not support Request Body. So, use POST or PUT types.
================================================================================
To work with XML Input/Output :
```xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
```
*) If Input/MethodParam (or) `@RequestBody` do not support XML then Output is
	415 - Unsupported MediaType

*) If Accept Header is provided and output (XML) not supported then
	406 - Not Acceptable

====code=======================================================
1.
  Name : *SpringBoot2RestInputEx*
  Dep  : Web, Lombok, Devtool

2. Entity class
```java
package in.nareshit.raghu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer pid;
	private String pcode;
	private Double pcost;

}
```
3. RestController
```java
package in.nareshit.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@PostMapping("/create")
	public ResponseEntity<String> createProduct(
			@RequestBody Product product)
	{
		return new ResponseEntity<String>(
				product.toString(), //body
				HttpStatus.OK);  //status
	}
}
```
======================================================================
```
POST | http://localhost:8080/product/create | SEND
	Body
		raw(*)   [JSON]
```
```json
{
    "pid" : 1150,
    "pcode" : "LAPTOP",
    "pcost" : 85000.0
}
```
-----------------------------------------------------------------------
```xml
<Product>
    <pid>101</pid>
    <pcode>ABC</pcode>
    <pcost>500.0</pcost>
</Product>
```
*) Note:
a. Sending Empty JSON : {} is valid input.
   It indicates creating object using default values.

b. In case of XML Input : Sending root tag
	<Product> </Product> is valid input.
  It indicates creating object using default values.

*) Hibernate Validator API
a. @NotNull: It will not accept null values as input data.
b. @Size (min,max): it is used to provide min and max size of a input string
c. @Pattern(regex): it is used to provide a Format to input String

*) @Valid Activates above all Hibernate Validation Annotations.
  But to work with these annotations we must add "Validator" Dependency
 or pom.xml
 ```xml
 <dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
 </dependency>
```

--Entity class with example validation annotations---
```java
package in.nareshit.raghu.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@NotNull(message = "Product id must be provided")
	private Integer pid;
	@NotNull
	//@Size(min = 3,max = 5, message = "Code must be 3-5 chars only")
	@Pattern(regexp = "[A-Z]{2,4}")
	private String pcode;
	private Double pcost;

}
```
------------------------------------
*) At RestController
(old)  : `@RequestBody Product product`

(new ) : `@Valid	@RequestBody Product product`
