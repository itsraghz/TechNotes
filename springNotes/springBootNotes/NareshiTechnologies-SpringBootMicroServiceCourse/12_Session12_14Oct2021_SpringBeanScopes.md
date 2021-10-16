# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 12 \
14 Oct 2021 Thu \
7 30 AM IST - 08 45 AM IST

## Agenda

* Spring Bean Scopes

## Scopes

### Core Java Scopes

* Local Variable - Within a method - lives from the method start to method end.
* Instance Variable - Object creation to destroy (lifetime of an Object/Instance)
* Static variable - Class loading to unloading (lifetime of a class)


### Adv Java Scopes (Servlet/JSP)

* Page Context / Page Scope : Variable/data works within JSP Page.
* Request - Between Servlet/JSP OR until we redirect
* Session - From login to logout time
* Application / Context Scope - Server start to shutdown

### Spring Bean Scopes

* Singleton (default) - One Object is creation for configuration
* Prototype - One object is created for every access from Container
* Request - Only in Web Application Environment - Create object on request received by Server, destroy before committing the response.
* Session - Only in Web Application Environment - Creating object on Login Request and maintain until logout request.
* Global / Application / Context - Legacy and now Removed

## Specify the scopes

We can mention the scope of the Spring Bean objects in 3 different ways.

### XML

```xml
<bean id="" scope="____">
  ....
</bean>
```

## Annotation Configuration

```java
@Scope("____")
@Component("Name")
class _____ {

}
```

## Java Config

```java
@Configuration
class ____ {

  @Bean
  @Scope("______")
  public <ReturnType> <methodName>() {

  }
}
```

> Default scope is *Singletone*, until it is specified with any other value

# Task

* YouTube Video in NareshIT - Annotation and Enums Basics

## Example - via XML file

* Create a Maven Project - *Spring5ScopesEx*
* `pom.xml` dependencies
  * `SpringContext`
  * `Java Annotation API`

### Spring Bean

*File* : `Sample.java`

```java
package com.raghsonline.springcore.bean;

public class Sample {

	@Override
	public String toString() {
		return "Sample [obj]";
	}
}
```

### Configuration file

*File*: `config.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!--  Default scope is Singleton when no scope is provided -->
	<bean id="sobj" class="com.raghsonline.springcore.bean.Sample">
	</bean>

	<!--  Explicit Singleton scope is provided -->
	<bean id="sobjS" class="com.raghsonline.springcore.bean.Sample" scope="singleton">
	</bean>

	<!--  Prototype scope is provided -->
	<bean id="sobjP" class="com.raghsonline.springcore.bean.Sample" scope="prototype">
	</bean>
</beans>
```

### Test class

*File*: `Test.java`

```java
package com.raghsonline.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");

		// Creating/ Accessing the object twice, which was declared with a default scope
		Object ob1 = ac.getBean("sobj");
		Object ob2 = ac.getBean("sobj");
		System.out.println("Accessing the object twice, which was declared with a default scope ");
		System.out.println(ob1 + ", hashcode="+ob1.hashCode());
		System.out.println(ob2+ ", hashcode="+ob2.hashCode());
		System.out.println(ob1==ob2);
		System.out.println();

		// Accessing the object twice, which was declared with an explicit Singleton scope
		Object ob3 = ac.getBean("sobjS");
		Object ob4 = ac.getBean("sobjS");
		System.out.println("Accessing the object twice, which was declared with an explicit Singleton scope");
		System.out.println(ob3 + ", hashcode="+ob3.hashCode());
		System.out.println(ob4+ ", hashcode="+ob4.hashCode());
		System.out.println(ob3==ob4);
		System.out.println();

		// Accessing the object twice, which was declared with a Prototype scope
		Object ob5 = ac.getBean("sobjP");
		Object ob6 = ac.getBean("sobjP");
		System.out.println("Accessing the object twice, which was declared with a Prototype scope");
		System.out.println(ob5 + ", hashcode="+ob5.hashCode());
		System.out.println(ob6+ ", hashcode="+ob6.hashCode());
		System.out.println(ob5==ob6);

		((ClassPathXmlApplicationContext)ac).close();
	}
}
```

### Console Output

```
Accessing the object twice, which was declared with a default scope
Sample [obj], hashcode=1461149300
Sample [obj], hashcode=1461149300
true

Accessing the object twice, which was declared with an explicit Singleton scope
Sample [obj], hashcode=2075495587
Sample [obj], hashcode=2075495587
true

Accessing the object twice, which was declared with a Prototype scope
Sample [obj], hashcode=206835546
Sample [obj], hashcode=1997287019
false
```

## Task

* Find out the difference between Singleton Design Pattern Vs Spring Singleton

> Very Important Interview Question and Topic. Though they both look alike, they are NOT the same.

## Example - via Annotation Configuration

### Spring Bean - with Java Annotation

*File*: `SampleAnnoConfig.java`

```java
package com.raghsonline.springcore.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sobjPAnnoConfig")
@Scope("prototype")
public class SampleAnno {

	@Override
	public String toString() {
		return "SampleAnno [Obj]";
	}
}
```

### Configuration file

* No XML only Java Annotation Config

```java
package com.raghsonline.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.raghsonline.springcore")
public class AppConfig {

}
```

### Test File

*File*: `TestAnnoConfig.java`

```java
package com.raghsonline.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghsonline.springcore.config.AppConfig;

public class TestAnnoConfig {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		// Accessing the object twice, which was declared with a Prototype scope
		Object ob5 = ac.getBean("sobjPAnnoConfig");
		Object ob6 = ac.getBean("sobjPAnnoConfig");
		System.out.println("[AnnoConfig] Accessing the object twice, which was declared with a Prototype scope");
		System.out.println(ob5 + ", hashcode="+ob5.hashCode());
		System.out.println(ob6+ ", hashcode="+ob6.hashCode());
		System.out.println(ob5==ob6);

		((AnnotationConfigApplicationContext)ac).close();
	}
}
```

### Console Output

```java
[AnnoConfig] Accessing the object twice, which was declared with a Prototype scope
SampleAnno [Obj], hashcode=728115831
SampleAnno [Obj], hashcode=2131670196
false
```

## Example - via Java Configuration

* Spring Bean - is the same `Sample.java`
* App Config will have a `@Bean` declared for a method with a `@Scope`
* Test class will also be the same.

### Java Configuration file

*File*: `AppConfigJavaConf.java`

```java
package com.raghsonline.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.raghsonline.springcore.bean.Sample;

@Configuration
@ComponentScan("com.raghsonline.springcore")
public class AppConfigJavaConf {

	@Bean
	@Scope("prototype")
	public Sample sObjJavaConfig() {
		return new Sample();
	}
}
```

### Test Class

*File* : `TestJavaConfig.java`

```java
package com.raghsonline.springcore.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raghsonline.springcore.config.AppConfigJavaConf;

public class TestJavaConfig {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigJavaConf.class);

		// Accessing the object twice, which was declared with a Prototype scope
		Object ob1 = ac.getBean("sObjJavaConfig");
		Object ob2 = ac.getBean("sObjJavaConfig");
		System.out.println("[JavaConfig] Accessing the object twice, which was declared with a Prototype scope");
		System.out.println(ob1 + ", hashcode="+ob1.hashCode());
		System.out.println(ob2+ ", hashcode="+ob2.hashCode());
		System.out.println(ob1==ob2);

		((AnnotationConfigApplicationContext)ac).close();
	}
}
```

### Console Output


```java
[JavaConfig] Accessing the object twice, which was declared with a Prototype scope
Sample [obj], hashcode=1527953000
Sample [obj], hashcode=18242360
false
```
