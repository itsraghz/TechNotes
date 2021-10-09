# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT 

Session 08
09 Oct 2021 Sat
7 30 AM IST - 08 45 AM IST

> Spring Boot & MS @ 7:30 AM (IST) by `Mr.Raghu_NEW` Link \
> Link: zoom.us/j/98599236248 \
> Registered myself in the new link. \

# Agenda

* Reference Type Injection 
  * Example : `Product` has a `Vendor` 
  * wiring 
* Annotation Configuration 

## Revision of Reference Type Injection 

### Spring Bean 

#### Vendor Bean 

*File*: `Vendor.java`

```java
/**
 * 
 */
package com.raghsonline.springcore.bean;

/**
 * @author raghs
 *
 */
public class Vendor {

	private int id;
	private String name;
	
	public Vendor() {
		super();
		System.out.println("Vendor is created");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + "]";
	}	
}
```

#### Product Bean 

*File*: `Product.java`

```java
/**
 * 
 */
package com.raghsonline.springcore.bean;

/**
 * @author raghs
 *
 */
public class Product {
	
	private int id;
	private String code;
	private Vendor ven;
	
	public Product() {		
		super();
		System.out.println("Product is created");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Vendor getVen() {
		return ven;
	}

	public void setVen(Vendor ven) {
		System.out.println("Vendor object is set - [" + ven + "]");
		this.ven = ven;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", ven=" + ven + "]";
	}	
}
```

### Config file

*File:*  `config.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 1. Child class -->
	<bean id="vendorObj" class="com.raghsonline.springcore.bean.Vendor">
		<property name="id" value="101"/>
		<property name="name" value="RaghsOnline" />		
	</bean>
	
	<!-- 2. Parent class  -->
    <bean id="productObj" class="com.raghsonline.springcore.bean.Product">
		<property name="id" value="101"/>
		<property name="code" value="PEN" />
    	<property name="ven">
    		<ref bean="vendorObj"/>
    	</property>
    </bean>
</beans>

```

### Test Class

*File:* `Test.java`

```java
/**
 * 
 */
package com.raghsonline.springcore.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author raghs
 *
 */
public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		Object ob = ac.getBean("productObj");
		System.out.println(ob);
	}
}
```

### Output 

```java
Vendor is created
Product is created
Vendor object is set - [Vendor [id=101, name=RaghsOnline]]
Product [id=101, code=PEN, ven=Vendor [id=101, name=RaghsOnline]]
```

#### Scenario 1 - No reference is passed

*Config file*: `config.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 1. Child class -->
	<bean id="vendorObj" class="com.raghsonline.springcore.bean.Vendor">
		<property name="id" value="101"/>
		<property name="name" value="RaghsOnline" />		
	</bean>
	
	<!-- 2. Parent class  -->
    <bean id="productObj" class="com.raghsonline.springcore.bean.Product">
		<property name="id" value="101"/>
		<property name="code" value="PEN" />
    	<!-- <property name="ven">
    		<ref bean="vendorObj"/>
    	</property> -->
    </bean>
</beans>
```

*Console Output*

```java
Vendor is created
Product is created
Product [id=101, code=PEN, ven=null]	
```

#### Scenario 2 - Alter the object sequences 

First declare the parent bean `productObj` and then the child - `vendorObj`  in the `config.xml` file

*Config file*: `config.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- 2. Parent class  -->
    <bean id="productObj" class="com.raghsonline.springcore.bean.Product">
		<property name="id" value="101"/>
		<property name="code" value="PEN" />
    	<property name="ven">
    		<ref bean="vendorObj"/>
    	</property>
    </bean>
    
  <!-- 1. Child class -->
	<bean id="vendorObj" class="com.raghsonline.springcore.bean.Vendor">
		<property name="id" value="101"/>
		<property name="name" value="RaghsOnline" />		
	</bean>
</beans>
```

*Console Output*

```java
Product is created
Vendor is created
Vendor object is set - [Vendor [id=101, name=RaghsOnline]]
Product [id=101, code=PEN, ven=Vendor [id=101, name=RaghsOnline]]
```

> See the sequence in the output. First the Parent (Product) object is created, and then the Child (Vendor).

> *Note : * The order of creating the objects (Parent,Child) is immaterial. However they both should have been created,
> prior to establishing the link (injecting the dependency).

## Annotation 

* StereoType  - There are 5 types - used to create object to a given Programmer class. 
  * `@Component` - object creation 
  * `@Repository` - creating object + database operations (Implicit in SpringBoot)
  * `@Service` - creating object +  Operations/Logics + Transaction Management
  * `@Controller` - Creating object + Web Applications + HTTP Operations 
  * `@RestController` - Creating Object + REST API creation (Web Services)
  
> Common Operation : Creating Objects

> They are for Programmer defined classes only, and *NOT* for the predefined classes.

> We must provide one common package 

### Example 

*Gradle Project * : `Spring5CoreAnnotationExGradle`

#### Build File 

*File Name :* `build.gradle`

```
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.9/userguide/building_java_projects.html
 */

plugins {
    id 'java'
}

repositories {
	mavenCentral()
}

sourceCompatibility = 14
targetCompatibility = 14

dependencies {
	// https://mvnrepository.com/artifact/org.springframework/spring-context
	implementation group: 'org.springframework', name: 'spring-context', version: '5.3.10'	
}
```

#### Java Class 

*File Name*: `Product.java`

```java
/**
 * 
 */
package com.raghsonline.springcore.bean;

import org.springframework.stereotype.Component;

/**
 * @author raghs
 *
 */
@Component("Product")
public class Product {

	@Override
	public String toString() {
		return  "Product is created";
	}
}
```

### Java class 

*File Name :* `Person.java`

```java
/**
 * 
 */
package com.raghsonline.springcore.bean;

import org.springframework.stereotype.Component;

/**
 * @author raghs
 *
 */
@Component
public class Person {

	@Override
	public String toString() {
		return  "Person is created";
	}
}
```

> Notice that the `@Component` annotation does not have any value inside. 

### Test Class 

*File Name *: `Test.java`

```java 
/**
 * 
 */
package com.raghsonline.springcore.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author raghs
 *
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com.raghsonline.springcore.bean");
		ac.refresh();
		Object ob = ac.getBean("Product");
		System.out.println(ob);
		
		/* 
		 * If the @Component was given a name, by default the object name is same 
		 * as that of the Class, but with the letter in small case!
		 */
		Object ob2 = ac.getBean("person");
		System.out.println(ob2);
		
		((AnnotationConfigApplicationContext)ac).close();
	}
}
```

### Console Output 

```java
Product is created
Person is created
```

## Homework 

> Spring Core Session - 1 | By Mr. Raghu -> https://www.youtube.com/watch?v=xusQhpQuODk \
> Spring Core Session - 2 | By Mr. Raghu -> https://www.youtube.com/watch?v=-FlszP92JVM


