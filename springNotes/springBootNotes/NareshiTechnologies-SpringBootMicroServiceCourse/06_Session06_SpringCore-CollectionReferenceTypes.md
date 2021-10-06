# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT 

Session 06
06 Oct 2021 Wed
7 30 AM IST - 08 45 AM IST

> Zoom Link (Old - Used for the Demo) : https://us02web.zoom.us/w/89992674319?tk=jMFucLHR5gPkDbXBf4XKrurDoKUkGFZu3u1yihkHNG8.DQMAAAAU8_s8DxZwSlg4UEozQlRjTzcxMmZtSnpXZEVnAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA#success


# Agenda 

* Spring Core - Collection and References Dependency Types 

## Collection Types 

| Tyype | Tag | Implementation (Selected by Spring Container) |
| ---- | --- | -------------- |
| List  |  <list>  | ArrayList | 
| Set   |  <set>  | LinkedHashSet |
| Map   |  <map>  | LinkedHashMap | 
| Properties | <props> | N/A |

### New Project in Spring Tool Suite (STS) IDE 

*Project* : Spring5CoreCollectionsEx

* Create a new Maven Project 
* Update the `pom.xml` file with the following
  * Java Dependency from the default 5 to 11
  * Spring Core dependencies
* Ctrl+A, Ctrl+I, Ctrl+S (Indentaion) 
* Update the Maven Project 

### Java Bean - Product 

```java
package in.nareshit.bean;

import java.util.List;

public class Product {
  private int id;
  private List<String> codes;
  
  
  //Default Constructor
  
  //Getters and Setters
  
  //toString() method
}
```

### Config file 

*File*: `config.xml`

```xml
... Prolog 
<beans>
  <bean id="pob" class="in.nareshit.bean.Product">
    <property name="id">
      <value>850</value>
    </property>
    <property name="codes">
      <list>
        <value>A</value>
        <value>B</value>
        <value>C</value>
      </list>
    </property>    
  </bean>
</beans>

```

### Test Class 

> property.getClass().getName() - to see the actual implementation class.

## Core Java 

* Map Interface
* Entry Interface (Inner Interface) `Map.Entry`, 
  * Entry<String,String> has a Key, Value 
* Iterate a Map using Iterator

### Example Program 

```java

```

## Spring Core - Set 

## Spring Core - Map 

```java
```

```xml
  <bean...>
    <property name="codes">
      <map>
        <entry key="101" value="AA"/>
        <entry key="102" value="BB"/>
        <entry key="102" value="CC"/>
      </map>
    </property>
  </bean>
```

## Spring Core - Properties 

```java
package in.nareshit.bean;

import java.util.Properties;

public class Product {
  ...
  private Properties info;
}
```

```xml
  <bean...>
    <property name="info">
      <props>
        <prop key="driver">V1</prop>
        <prop key="url">V2</prop>
      </props>
    </property>
  </bean>
```

## Notes/ Pointers

* If a list or set has only one value, the `<list>` or `<set>` tags are optional in the `config.xml` file. 

## Links 

Spring Boot & MS @ 7:30 AM | Mr. Raghu

* Day-1: https://youtu.be/sWj8zY-iits
* Day-2: https://youtu.be/1R11lpSWKf4
* Day-3: Not Recorded 
* Day-4: https://youtu.be/bTrPAyqZ8e8
* Day-5: https://youtu.be/Lw0bRSVCrxw
* Day-6: https://youtu.be/41j3ylw7Zq4
* Day-7: https://youtu.be/TospBHUvu_M
* Day-8: https://youtu.be/ajctkgqX7zk
