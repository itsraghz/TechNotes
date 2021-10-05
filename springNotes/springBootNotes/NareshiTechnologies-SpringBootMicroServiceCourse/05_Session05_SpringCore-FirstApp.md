# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT 

Session 05
05 Oct 2021 Tue
7 30 AM IST - 08 45 AM IST

> New Classroom link is created and invite will be given by the Admin Srikanth Sir- for tomorrow's class. 

# Agenda 

* Spring Core First Application
* Error Scenarios
* Interview Questions

## Create a new Maven Project in STS IDE

* Create a new Maven Project 
* Changes in the `pom.xml`
  * Maven Compiler Dependency for Java 11
  * Add Spring Core Dependency
* Ctrl + A , Ctrl + I (Indentation) + Ctrl + S  (Save)
* Right Click -> Update Project 

### Spring Bean

```java
package in.nareshit.bean;

public class MyDataSource {
  private String database;
  private String mode; 
  
  public MyDataSource() {
  }
  
  // Getters and Setters
  
  // toString()
}
```

### Config file `config.xml`

```xml
<beans>
  <bean id="myds" class="in.nareshit.bean.MyDataSource">
  </bean>
</beans>
```

### Test Class 

### Execute 

> `Ctrl  + F11` - Shortcut to run a Java class in the STS IDE.

## Notes 

* <bean id="" class=""> creates an Object using a Default Constructor.
* When you create a Container via `ApplicationContext`, the `config.xml` file is read, all the beans / objects are created. 
  * Scan classes
  * Create Objects 
  * Set Data / Link objects 
* `getBean()` method is to look up/ read the object. 

## Lazy Object Creation 

* Create an Object only when we read the object via `getBean()` for the first time.   
* Add an attribute `lazy-init="true"` in the `<bean>` element. 
* default value of the attribute is `false`.

```xml
<bean id="myds" class="FQCN" lazy-init="true">
</bean>
```

> The default value of the `lazy-init` is `false`.


## Error Scenarios 

* `NoSuchBeanDefinitionException` - when there is no bean available in the `config.xml`.

* `TypeMismatchException` - Spring Container throws this exception backed up by a `NumberFormatException` when the value 
  supplied in the `config.xml` does not match with the datatype of the corresponding memebr variable of the Bean class.
  
* `SAXParserException` - if there is any Syntax error in the `config.xml` file, the Spring Container will throw the SAXParserException. 

* `NotWritablePropertyException` - Invalid property `xyz`. 
  * It is of type `org.springframework.beans` - when there is no matching setter method for the corresponding `<property>` tag, 
    or the data type mismatch with the Setter method and the variable datatype
    
* `ClassNotFoundException` - there is a mismatch in the FQCN (Fully Qualified Class Name) in the `class` attribute of the `<bean>` tag 
  * Example: `in.nareshit.beanMyDataSource` instead of `in.nareshit.bean.MyDataSource`.

* `NoClassDefFoundError` - there is a wrong mentioning of the Class name. 
  * Example: `myDataSource` instead of `MyDataSource`

## Homework 

* What is the difference between `ClassNotFoundException` and `NoClassDefFoundError` ? 
  Post the answer in the Google Classroom or send an email. 
  
> ClassNotFound - no such class exists.. \
> NoClassDefFound - the class was compiled successfully, but not avaiable to load at the runtime.

> URL : https://www.baeldung.com/java-classnotfoundexception-and-noclassdeffounderror
  
* Refer the `Lombok` Video in `NareshIT YouTube Channel`. --> https://www.youtube.com/watch?v=kSceQH4fFi4

## Steps to create a new Gradle Project in STS IDE 

* Create a New project 
* Override the settings
* Switch to `Project Explorer` instead of `Package Explorer` to see only one project and the `lib` will come under the main project. 
* Add values in the `build.gradle`
* Delete files created by default inside the `src/main/java` and `src/test/java`.

> Gradle supports different projects - `Java`, `C++`, `Kotlin` etc., we need to pick the right one using `id`.

  
