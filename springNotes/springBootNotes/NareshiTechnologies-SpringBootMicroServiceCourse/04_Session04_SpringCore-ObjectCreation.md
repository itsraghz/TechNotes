# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT 

Session 04
04 Oct 2021 Mon
7 30 AM IST - 08 45 AM IST

> Old Google Classroom (same used for the Demo) : https://classroom.google.com/u/0/c/Mzk4MTAwMjE3OTE3?cjc=janenmj \
> New Zoom link and Google Classroom link will be shared by Admin later. 

## Core Spring

There are 3 artifacts related to a Spring Bean. 

1. Spring Bean
2. Spring Config (XML file)
3. Test Class 

## Spring Bean 

A POJO class 

```java
package in.nareshit;

public class MyDialect {
  private String database;
  private String mode; 
  
  //getters and setters
}
```

## Spring Config - `config.xml`

The file name can be anything but it should be of type `.xml`. 

```xml
<beans>
  <bean id="md" type="in.nareshit.MyDialect">
    <property name="database">
      <value>MySQL</value>
    </property>
    <property name="mode">
      <value>CREATE</value>
    </property>    
  </bean>
</beans>
```

## Spring Container and Types 

There are two types. 

1. Old - BeanContainer (I)
2. New - ApplicationContext (I) (XML, Java, Annotation config)

*Implementation Classes* 

| Interface | Implementation Classes |
| --- | --------------- |
| BeanFactory (I) | XmlBeanFactory (C) |
| ApplicatinContext (I) | ClassPathXmlApplicationContext (C) |
| ApplicatinContext (I) | FileSystemXmlApplicationContext (C) |
| ApplicatinContext (I) | AnnotationConfigApplicationContext (C) |
| ApplicatinContext (I) | XmlWebApplicationContext (C) |

## Test Class 

```java
/**
 * 
 */
package com.raghsonline.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author raghs
 *
 */
public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Object object = context.getBean("student");	
		System.out.println(object);
		
		/* Issue: Resource leak: 'context' is never closed */
		
		/* Fix */
		// https://stackoverflow.com/questions/14184059/spring-applicationcontext-resource-leak-context-is-never-closed
		// Direct link : https://stackoverflow.com/a/27861869/1001242
		((ClassPathXmlApplicationContext) context).close();	
	}
}
```

## Console Output 

```
Student Class Constructor Invoked
Student Class setName() Invoked
Student Class setLocation() Invoked
Student [name=Raghavan, location=Karaikudi]
```
