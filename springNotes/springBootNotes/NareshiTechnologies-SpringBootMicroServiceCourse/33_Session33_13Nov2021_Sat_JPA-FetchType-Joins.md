# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 33 \
13 Nov 2021 Sat \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* JPA Fetch Types, Joins

# Lecture Notes - downloaded from Google Classroom

```
			 		Date : 13/11/2021
			 		Spring Boot 7AM
			  		Mr. RAGHU
	-----------------------------------------------
```
Link to learn Joins:-
https://www.w3schools.com/sql/sql_join.asp

FetchType :- (enum) 2 value EAGER and LAZY

EAGER :- When we fetch(SELECT) Parent Entity(Table) data
   then at same time also fetch Child entity(table) data.

LAZY :- When we fetch(SELECT) Parent Entity(Table) data
    only Fetch Parent, do not fetch its child Entity data.

=> Only for select Operation. Default values given based on type

       Non-Collection      Collection
         1...1              1...*
	 *...1              *...*
default	 EAGER              LAZY

=> Incase of Eager Fetching internally uses Joins concept
  to fetch data from both tables.
=============================================================
FetchType : EAGER
Hibernate:
 select peid, ploc , pname, pid_fk,
        panid , panpfname , panpname, panpcode
 from pertab
    left outer join
     pantab
 on person.pid_fk=pancard.pid
 where person.peid=?

 FetchType: LAZY
 Hibernate:
   select  peid, ploc,pname, pid_fk
   from    pertab
   where   peid=?

*) At Association Mapping annotation level we need to define
   this ex: @OneToOne(fetch = FetchType.LAZY)
-------------------------------------------------------
    Default                         What we can write even
-------------------------------------------------------
 @OneToOne(fetch=FetchType.EAGER)    FetchType.LAZY
 @OneToMany(fetch=FetchType.LAZY)    FetchType.EAGER
 @ManyToOne(fetch=FetchType.EAGER)   FetchType.LAZY
 @ManyToMany(fetch=FetchType.LAZY)   FetchType.EAGER
=======================================================
=> incase of LAZY do you want to fetch child table data
  then call findById() method of child or call parent
  class toString()

=======================================================
Q) When we delete parent data,
  do we need to delete child data also?
A) Based on Requirement.

 If we remove one Employee there can be Department data exist
  even without this.

  Employee ---------<> Department

  But, if we delete student data there is no meaning of Storing
  Exam Result

  Student -----<> ExamResult
  10  SYED       105 sid=10, result=PASS
========================================================
		   Association Types

*) Composition :- A Strong Relation created between Entities
                for data connection.
> ex:  Student -----<> ExamResult

*) Aggregation :- A Weak Relation Created between Entities
               for data connection.

ex:  Employee ---------<> Department

In simple Parent is one comes under Composition and
  Parent is Many comes under Aggregation
=========================================================
		      Cascading

>> Every  Association Mapping is default Aggregation only.
>> To make it Composition use Cascading (CascadeType)

>> CascadeType is a enum used to convert our relation into
   Composition (from Aggragation)

  cascade = CascadeType.ALL  (For every Parent operation)

  ie If we save student also save address
    if we remove student also remove address.

  >> CascadeType.ALL    : For all operations
  >> CascadeType.PERSIST : only for SAVE operation
  >> CascadeType.REMOVE : Only Remove operation
  >> CascadeType.MERGE  : only for UPDATE Operation

--Example-------
@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinColumn(name="sidFk")
private List<Address> addr;//HAS-A
=============================================================
			Joins

>> To fetch Data(SELECT OPERATION) from multiple tables
    using single SELECT SQL.

>> Genral Output is : List<Object[]>

JPQL/HQL Joins Syntax:-

SELECT parent.variables, child.variables

FROM  ParentEntity  parent
       [Join Type]
   parent.hasAVariable as child

WHERE <condition>;

I. INNER JOIN | JOIN
   Fecthing data from both table which are connected rows only

II. OUTER JOIN
 a. LEFT OUTER JOIN | LEFT JOIN
    Fetching all rows from Parent(left side table) rows
    only connected rows from Child(right side table) rows

 b. RIGHT OUTER JOIN | RIGHT JOIN
    Fetching all rows from Child(Right side table) rows
    only connected rows from Parent(left side table) rows

 c. FULL OUTER JOIN | FULL JOIN
    Fetching all rows from parent and child
    (both connected and non-connected rows)

--LEFT JOIN----
>> Print All Employees data and their Depatment data
   (if not exist Print NULL)

SELECT emp.empName, dept.deptCode
FROM  Employee emp
     LEFT OUTER JOIN
   emp.dept as dept

--INNER JOIN---
>> Print Employees who are assigned with Department data
   (only Connected rows)

SELECT emp.empName, dept.deptCode
FROM  Employee emp
     INNER JOIN
   emp.dept as dept

--RIGHT JOIN---
>> Print All Departments and their Employee Data
   (if not exist print null)

SELECT emp.empName, dept.deptCode
FROM  Employee emp
     RIGHT JOIN
   emp.dept as dept

--FULL JOIN--- ****(All Dbs may not supports this)
>> Fetch all rows from both Employee and Dept also display
   NULL Details even.

(Not Supported in MySQL)

SELECT emp.empName, dept.deptCode
FROM  Employee emp
     FULL OUTER JOIN
   emp.dept as dept

===code====================
Name : SpringBoot2DataJpaManyToOne
Dep  : Data JPA, Lombok, MySQL

1. application.properties
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot7am
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
#spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

2. Entity classes
package in.nareshit.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="depttab")
public class Department {
	@Id
	@Column(name="did")
	private Integer deptId;

	@Column(name="dname")
	private String deptName;

	@Column(name="dcode")
	private String deptCode;

}
--------------
package in.nareshit.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emptab")
public class Employee {
	@Id
	@Column(name="eid")
	private Integer empId;

	@Column(name="ename")
	private String empName;

	@Column(name="esal")
	private Double empSal;

	@ManyToOne
	@JoinColumn(name="didFk")
	private Department dept; //HAS-A
}

3. Repository
package in.nareshit.raghu.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import in.nareshit.raghu.entity.Department;
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
---------
package in.nareshit.raghu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nareshit.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT emp.empName, dept.deptCode FROM  Employee emp LEFT OUTER JOIN emp.dept as dept")
	List<Object[]> fetchDataA();

	@Query("SELECT emp.empName, dept.deptCode FROM  Employee emp INNER JOIN emp.dept as dept")
	List<Object[]> fetchDataB();


	@Query("SELECT emp.empName, dept.deptCode FROM  Employee emp RIGHT OUTER JOIN emp.dept as dept")
	List<Object[]> fetchDataC();

	@Query("SELECT emp.empName, dept.deptCode FROM  Employee emp FULL OUTER JOIN emp.dept as dept")
	List<Object[]> fetchDataD();
}

4. Runner class
package in.nareshit.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import in.nareshit.raghu.entity.Department;
import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.repo.DepartmentRepository;
import in.nareshit.raghu.repo.EmployeeRepository;

//@Component
public class DataInsertRunnerForJoins implements CommandLineRunner {

	@Autowired
	private DepartmentRepository drepo;

	@Autowired
	private EmployeeRepository erepo;

	public void run(String... args) throws Exception {
		Department d1 = new Department(101, "Development", "DEV");
		Department d2 = new Department(102, "Quality", "QA");
		Department d3 = new Department(103, "Business", "BA");
		Department d4 = new Department(104, "Support", "SUP");

		drepo.save(d1);
		drepo.save(d2);
		drepo.save(d3);
		drepo.save(d4);

		Employee e1 = new Employee(10, "AA", 20.0, d2);
		Employee e2 = new Employee(11, "AB", 30.0, null);
		Employee e3 = new Employee(12, "CD", 40.0, d1);
		Employee e4 = new Employee(13, "NH", 50.0, null);

		erepo.save(e1);
		erepo.save(e2);
		erepo.save(e3);
		erepo.save(e4);
	}

}

5. Runner for Test Joins
package in.nareshit.raghu.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.repo.EmployeeRepository;

@Component
public class DataFetchRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository erpo;

	public void run(String... args) throws Exception {
		//List<Object[]> list = erpo.fetchDataA();
		//List<Object[]> list = erpo.fetchDataB();
		//List<Object[]> list = erpo.fetchDataC();
		List<Object[]> list = erpo.fetchDataD();
		for(Object[] ob:list) {
			System.out.println(ob[0] + " - " + ob[1]);
		}
	}

}
