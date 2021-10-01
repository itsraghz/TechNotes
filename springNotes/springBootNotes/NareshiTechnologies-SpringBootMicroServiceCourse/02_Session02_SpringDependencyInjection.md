# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT 

Session 2
01 Oct 2021 Fri
7 30 AM IST - 08 20 AM IST


## Spring Container 

A Spring Container does the following for the DI (Dependency Injection)

* Scan your class
* Create Objects
* Provide Data
* Link Classes (based on the HAS-A relation)
* Destroy the Objects when the Container/Server is shutdown 

The Programmer should specify the following 2 inputs.

* A Spring Bean (Class + rules given by Container)
* Spring Configuration (XML / Java / Annotation**)

## Spring Bean 

For the Spring Container to create objects and inject dependencies, a class must follow the rules as below. 

* Basic Rules
  * Package Statement 
  * Class must be Public 
  * Variables are optional, and if exists they must be private (including HAS-A members)
  * Define one default and/or parameterized Constructor. 
  * If variables exist, provide getters/setters for them. 
  > (Note: Java Compiler provides a default Constructor if a Class has zero/no constructors). 
* Override Rules
  *  A method must be non-private, final, static, for it to be overridden on demand.
* Inheritance Rules 
  * Your class can implement/extend other Spring Beans  which are predefined/programmer defined.
* Annotation Rules
  * All Spring framework Annotations are allowed. (Ex, @Component, @Bean, @Value etc.,)
* Integration Rules 
  * Spring + ORM (Hibernate) Annotations (@Entity, @Table etc.,)
  * Spring + Apache Kafka

## Spring Configuration file 

We can write in 3 ways.

* XML which will take the `<bean>` element inside the `<beans>` element.
  ```xml
    <beans>
      <bean id="" class=""/>
    </beans>
  ```
* Java Configuration (`@Configuration`)

  ```java
  @Configuration 
  public class MyClass {
    @Bean
    public Sample sampleObj(){
    }
  }
  ```
* Annotation  Configuration

  ```java
  @Component 
  class Sample {
  }
  ```
