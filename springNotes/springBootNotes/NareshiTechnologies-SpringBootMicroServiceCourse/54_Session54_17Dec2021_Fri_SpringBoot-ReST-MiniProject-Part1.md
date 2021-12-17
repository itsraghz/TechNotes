# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 54 \
17 Dec 2021 Fri \
7 10 AM IST - 8 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Mini Project - Part 1

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ3MTYwMzAwMjU3/details

```
						Date : 17-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Error and Exception Handling:-
https://www.youtube.com/watch?v=M-LRfrYHWrk

Rest crud:-
https://www.youtube.com/watch?v=LE3KvvhkUkM

		   Mini Project : Spring Rest + Spring Data JPA
		      [ API Creation for a Application/Crud]

=> We use 3 Layers
 a. DAL : Data Access Layer
 b. SL  : Service Layer
 c. IL  : Integration Layer

=> IL It is implemented using Spring ReST Webservices.
   Data format is JSON, For Primitive inputs PathVariables.

*)Note:
a. HttpStatus OK(200) indicates Request process is successful. (any operation)
b. HttpStatus CREATED(201) indicated Request process created one new Resource
		(new Row in DB, new File at Server...etc)

c. HttpStatus Internal Server Error(500) indicates there is a exception at
		Producer application.

d. If Producer method returnType can not be predicted (ie based on execution flow)
    then use Symbol - ? (wild card entry)

===========code==========================
1.
 Name : *SpringBoot2RestDataJpaMySQLCrudEx*
 Dep  : Spring web, Lombok, Devtools, Data Jpa, MySQL

2. application.properties
```
server.port=8080

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot7am
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=create
```
3. Entity
```java
package in.nareshit.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="prod_tab")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	private Integer prodId;

	@Column(name="pcode")
	private String prodCode;

	@Column(name="pcost")
	private Double prodCost;

	@Column(name="pvendor")
	private String prodVendor;
}
```
4. Repository
```java
package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.Product;

public interface ProductRepository
	extends JpaRepository<Product, Integer> {

}
```
5. Service Interface
```java
package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.entity.Product;

public interface IProductService {

	Integer saveProduct(Product p);
	List<Product> findAllProducts();
	Product findOneProduct(Integer id);
	void deleteProduct(Integer id);
	void updateProduct(Product p);
}
```
6. ServiceImpl
```java
package in.nareshit.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Product;
import in.nareshit.raghu.exception.ProductNotFoundException;
import in.nareshit.raghu.repo.ProductRepository;
import in.nareshit.raghu.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(Product p) {
		p = repo.save(p);
		return p.getProdId();
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> list = repo.findAll();
		return list;
	}

	@Override
	public Product findOneProduct(Integer id) {
		/*Optional<Product> opt = repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw new ProductNotFoundException("Product Not exist with id "+id);*/
		return repo.findById(id)
				.orElseThrow(
						()->new ProductNotFoundException("Product Not exist with id "+id)
						);
	}

	@Override
	public void deleteProduct(Integer id) {
		//repo.deleteById(id);
		repo.delete(findOneProduct(id));

	}

	@Override
	public void updateProduct(Product p) {
		if(p.getProdId()!=null &&
				repo.existsById(p.getProdId()) ) {
			repo.save(p);
		} else {
			throw new ProductNotFoundException("Product Not exist with id "+p.getProdId());
		}

	}

}
```
7. Rest Controller class
```java
package in.nareshit.raghu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.entity.Product;
import in.nareshit.raghu.exception.ProductNotFoundException;
import in.nareshit.raghu.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@Autowired
	private IProductService service;

	//1. save Product
	@PostMapping("/create")
	public ResponseEntity<String> createProduct(
			@RequestBody Product product
			)
	{
		Integer id = service.saveProduct(product);
		String message = "Product '"+id+"' created";
		return new ResponseEntity<String>(
				message,
				HttpStatus.CREATED); //201
	}

	//2. fetch all products
	@GetMapping("/all")
	public ResponseEntity<List<Product>> showAllProducts() {
		List<Product> list =  service.findAllProducts();
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}

	//3. fetch one product
	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchOneProduct(
			@PathVariable Integer id
			)
	{
		ResponseEntity<?> resp = null;
		try {
			Product prod = service.findOneProduct(id);
			resp = new ResponseEntity<Product>(prod,HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	//4. delete one product

	//5. update one product
}
```
8. Custom Exception
```java
package in.nareshit.raghu.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super(message);
	}
}
```
==============================================================
*) Test using POSTMANs.

*) task : Student(sid,sname,sfee,course).
