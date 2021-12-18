# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 55 \
18 Dec 2021 Sat \
7 10 AM IST - 8 15 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* SpringBoot ReST Mini Project - Part 2

# Lecture Notes - downloaded from Google Classroom

* URL to the classroom notes : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz/m/NDQ5NTE1MTc3OTQ5/details

```
						Date : 18-12-2021
						Spring Boot 7AM
 						    Mr. RAGHU
-------------------------------------------------------------
```
Mini Project : Spring Rest + Spring Data JPA
		      [ API Creation for a Application/Crud]

*) If we writing any non-select custom query then must use
    @Query() + @Modifying + @Transactional

    Only : @Query() behaves like SELECT Operation

    @Query() + @Modifying : behaves like NON-SELECT OPERATION (ex: Update,Delete)

    @Transactional: Will begin Tx and commit(save on success)
			or rollback(cancel on exception) after operation

--today modified code---
1. Repository

package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.nareshit.raghu.entity.Product;

public interface ProductRepository
	extends JpaRepository<Product, Integer> {

	@Modifying
	@Query("UPDATE Product SET prodVendor=:vendor WHERE prodId=:id")
	int updateProductVendor(String vendor,Integer id);
}

2. Service Interface
package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.entity.Product;

public interface IProductService {

	Integer saveProduct(Product p);
	List<Product> findAllProducts();
	Product findOneProduct(Integer id);
	void deleteProduct(Integer id);
	void updateProduct(Product p);
	int updateProductVendor(String vendor,Integer id);
}

3. ServiceImpl
package in.nareshit.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public int updateProductVendor(String vendor, Integer id) {
		if(id!=null &&
				repo.existsById(id) ) {
			return repo.updateProductVendor(vendor, id);
		}
		else {
			throw new ProductNotFoundException("Product Not exist with id "+id);
		}
	}

}

4. RestController
package in.nareshit.raghu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteProduct(
			@PathVariable Integer id
			)
	{
		ResponseEntity<String> resp = null;
		try {
			service.deleteProduct(id);
			resp = new ResponseEntity<String>(
					"Product Deleted=>"+id,
					HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}


	//5. update one product
	@PutMapping("/modify")
	public ResponseEntity<String> updateProduct(
			@RequestBody Product product
			)
	{
		ResponseEntity<String> resp = null;
		try {
			service.updateProduct(product);
			resp = new ResponseEntity<String>(
					"Product Updated",
					HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	//6. Patch: Partial Data Update
	@PatchMapping("/update/vendor/{id}/{venName}")
	public ResponseEntity<String> updateProductVendor(
			@PathVariable Integer id,
			@PathVariable String venName
			)
	{
		ResponseEntity<String> resp = null;
		try {
			service.updateProductVendor(venName, id);
			resp = new ResponseEntity<String>(
					"Product Vendor Updated",
					HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

}

5. Entity and Exception class are same as before

======================================================================================
Swagger UI : (API/Tool)
> POSTMAN is tool used to Test Web/Webservice applications.
> Here we need to enter all details manually, like URL, httpMethod, Headers,Body..etc

> Swagger UI will scan all possible methods and their URLs from Application
   and creates one dynamic UI (Docket).
   No need to enter URLs, Method Types manually.

> In case of Project, it contains multiple RestControllers (ex: 10, Employee,Student,
   Course..etc) then Swagger is better.

> Swagger is not from Spring Boot, this is 3rd party ie SpringFox company.

Swagger UI
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

Swagger 2
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>


*)Swagger Config:-
package in.nareshit.raghu.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("in.nareshit.raghu.rest"))
			.paths(PathSelectors.ant("/api/**"))
			.build()
			.apiInfo(apiInfo())
			;
	}
	//only display content
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"NIT CURD", //title
				"HELLO SAMPLE APP", //description
				"3.2GA",  //version
				"http://nareshit.in", //serviceURL
				new Contact("RAGHU", "http://nareshit.in", "javabyraghu@gmail.com"), //conact
				"NIT LICENSE", "http://nareshit.in", //License details
				List.of());
	}
}


*) Run App and enter URL:
http://localhost:8080/swagger-ui.html

a. Final Output of Swagger is Docket(Dynamic UI)
b. select RestControllers from our application
   using one basePackage

   .select()
   .apis(RequestHandlerSelectors.basePackage("in.nareshit.raghu.rest"))

c. Specify common Path to sortout
   .paths(PathSelectors.ant("/api/**"))

/** indicates any multi-level path : ex: /api/employee/find/email/{id}/{mail}


Q) How can we avoid showing a method at Swagger UI ?
A) Add @ApiIgnore on top of method.


@Api(description="PRODUCT OPERATIONS") : Insted of Showing controller name
@ApiOperation("CREATING ONE PRODUCT") : Insted of Showing method name at Swagger UI
