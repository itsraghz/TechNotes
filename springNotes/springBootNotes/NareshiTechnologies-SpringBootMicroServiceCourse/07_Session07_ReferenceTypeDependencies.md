# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 07 \
07 Oct 2021 Thu \
7 30 AM IST - 08 45 AM IST

> Spring Boot & MS @ 7:30 AM (IST) by `Mr.Raghu_NEW` Link \
> Link: zoom.us/j/98599236248 \
> Registered myself in the new link. \

# Agenda

*  Reference Type Dependency  - Has-a Relationship - Tag: <ref>

* IS-A - Inheritance using extends/implements linked with the classes
* HAS-A - Association using one class/interface as a data type , and create variable in other class.


## Example

An `Employee` class will have an `Address` class.

* Employee - Parent
* Address - Child.
* Employee `HAS-A` variable of `Address`.

### Syntax

```xml
<bean id="childObj" class="FQCN"
	...
</bean>

<bean id="parentObj" class="FQCN">
	...
	<property name="HasARefVariableName">
		<ref bean="childObj"/>
	</property>
</bean>
```

### Java Class

*Child class* - `Address.java`

```java
/**
 *
 */
package com.raghsonline.springcore.bean;

/**
 * @author raghs
 *
 */
public class Address {

	private String houseNo;
	private String location;

	// Alt + Shift + S > o > D (Deselect All) > OK
	public Address() {
		super();		
		System.out.println("Address class Instantiated");
	}

	// Alt + Shift + S > r > A (Select All) > OK
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
		System.out.println("Address setHouseNo() invoked with - [" + houseNo + "]");
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		System.out.println("Address setLocation() invoked with - [" + location + "]");
	}

	// Alt + Shift + S > S > OK
	@Override
	public String toString() {
		System.out.println("Address toString() invoked");
		return "Address [houseNo=" + houseNo + ", location=" + location + "]";
	}
}
```

*Parent Class* : `Employee.java`

```java
/**
 *
 */
package com.raghsonline.springcore.bean;

/**
 * @author raghs
 *
 */
public class Employee {

	private int empId;
	private String empName;

	private Address addr;

	public Employee() {
		super();
		System.out.println("Employee class Instantiated");
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
		System.out.println("Employee setEmpId() invoked with - [" + empId + "]");
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
		System.out.println("Employee setEmpName() invoked with - [" + empName + "]");
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		System.out.println("Employee toString() invoked");
		return "Employee [empId=" + empId + ", empName=" + empName + ", addr=" + addr + "]";
	}
}
```

### Config file

*Config* : `beans.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 1. Child class -->
	<bean id="addrObj" class="com.raghsonline.springcore.bean.Address">
		<property name="houseNo">
			<value>F-1</value>
		</property>
		<property name="location">
			<value>KKDI, TN</value>
		</property>
	</bean>

	<!-- 2. Parent class  -->
    <bean id="emp" class="com.raghsonline.springcore.bean.Employee">
    	<property name="empId">
    		<value>2351</value>
    	</property>
    	<property name="empName">
    		<value>Raghavan</value>
    	</property>
    	<property name="addr">
    		<ref bean="addrObj"/>
    	</property>
    </bean>

</beans>
```

### Test Class

*Test Class* : `Test.java`

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
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Object obj = ac.getBean("emp");
		System.out.println(obj);
	}

}
```

### Execution and Output

```java
Address class Instantiated
Address setHouseNo() invoked with - [F-1]
Address setLocation() invoked with - [KKDI, TN]
Employee class Instantiated
Employee setEmpId() invoked with - [2351]
Employee setEmpName() invoked with - [Raghavan]
Employee toString() invoked
Address toString() invoked
Employee [empId=2351, empName=Raghavan, addr=Address [houseNo=F-1, location=KKDI, TN]]
```
