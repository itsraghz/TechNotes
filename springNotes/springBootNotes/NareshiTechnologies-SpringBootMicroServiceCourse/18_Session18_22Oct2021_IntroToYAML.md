# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 18 \
22 Oct 2021 Fri \
7 15 AM IST - 8 30 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* Intro to YAML - Continuation

# YAML

* YAML ain't language
* Yet Another Markup Language

## Two types of data

  a. static data/ setup content  : Before/While starting application.
      Database Connection:  driver class, url, username, password ..etc
         Email Properties, JPA(ORM) Properties..etc

    Such data is given using properties/yaml files.

  b. dynamic data/ runtime content:
       After running application, ex: User Register data, Login, ...etc

   Such data is given using HTML Forms.


## YAML:
-> This is new way of representing key-val format.
-> No Duplicate levels/keys in YAML.
-> Replace dot(.) with colon(:) and goto new line
-> Provide at least one space for new line (at most any)
-> Replace equal(=) with colon(:) and space before value.
-> Every level key must have same space count.
-> Keys order need not be followed.
-> file extension is .yml

---application.properties-------------
```
my.app.id=10
my.app.code=ABC
my.test.grade=A
```

------application.yml------------------
```
my:
  app:
    id: 10
    code: ABC
  test:
    grade: A
```    
> Tool : http://mageddo.com/tools/yaml-converter

## Reading YAML data

-> We can read yaml data using
  `@Value`
  `@ConfigurationProperties`

## Example

* Project Name : *SpringBoot2YamlEx*
* Project Type : *Spring Starter*
* Dependency  : Lombok

##E Configuration file

1. Rename properties file  (or F2)

> Right click on file > rename > enter name as : application.yml

---application.yml----
```
my:
  app:
    id: 10
    code: PEN
    cost: 200.0
```

### Spring Bean

```java
package com.raghsonline.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class ProductInfo {

	@Value("${my.app.id}")
	private int pId;

	@Value("${my.app.code}")
	private String pCode;

	@Value("${my.app.cost}")
	private Double amount;
}
```

### Runner Class

```java
package com.raghsonline.springboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raghsonline.springboot.bean.ProductInfo;

@Component
public class DataPrintRunner implements CommandLineRunner {

	@Autowired
	private ProductInfo pObj;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ProductInfo object created from YAML file is ");
		System.out.println("---------------------------------------------");
		System.out.println(pObj);
	}
}
```

### Main Class

```java
package com.raghsonline.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2YamlExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2YamlExApplication.class, args);
	}
}
```
