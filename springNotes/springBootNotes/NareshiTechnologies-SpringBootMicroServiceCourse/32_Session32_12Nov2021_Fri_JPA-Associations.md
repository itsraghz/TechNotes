# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 32 \
12 Nov 2021 Fri \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* JPA Assocation Mappings

# Lecture Notes - downloaded from Google Classroom

```
					Date : 12/11/2021
		      Spring Boot 7AM
		        Mr. RAGHU
	----------------------------------------------
```
Q) What will happen if we do not specify
      @JoinColumn or @JoinTable?

Q) What is the diff b/w Composition and Aggregation?

Q) What are FetchTypes?

Q) What is cascading?

Q) Why Joins Required? How many types? What are they?



		Association Mapping (HAS-A)
		  [ Database-Multiplicity ]

*) 2 types :-
  --------------------------------------------
    Non-Collection          Collection Type
  --------------------------------------------
      1...1                      1...*
      *...1                      *...*
  --------------------------------------------

--Coding steps-----
1. Define two classes
2. Create HAS-A Relation
(child Reference variable in parent class)
3. Check for Collection Type
4. Apply Mapping Annotation at HAS-A Variabel
   @OneToOne     1...1
   @OneToMany    1...*
   @ManyToOne    *...1
   @ManyToMany   *...*

5. Provide JoinColumn[FK] (or) JoinTable (for ManyToMany)
   at HAS-A Variabel
---------------------------------------------------------  

*) Note:
> Foreign key can
    have null values (NULLs allowed)
    have duplicates ( Duplicate data is allowed)
    only values allowed which are exist at Connected
      PK Column.

------------------code------------------------------
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
import org.springframework.data.jpa.repository.JpaRepository;
import in.nareshit.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
4. Runner class
package in.nareshit.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.Department;
import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.repo.DepartmentRepository;
import in.nareshit.raghu.repo.EmployeeRepository;

@Component
public class DataInsertRunner implements CommandLineRunner {

	@Autowired
	private DepartmentRepository drepo;

	@Autowired
	private EmployeeRepository erepo;

	public void run(String... args) throws Exception {
		Department d1 = new Department(550, "Development", "DEV");
		Department d2 = new Department(551, "Support", "SUP");

		drepo.save(d1);
		drepo.save(d2);

		Employee e1 = new Employee(101, "SYED", 500.0, d1);
		Employee e2 = new Employee(102, "AJAY", 600.0, d1);
		Employee e3 = new Employee(103, "SAM", 700.0, d2);
		Employee e4 = new Employee(104, "KUMAR", 800.0, d2);

		erepo.save(e1);
		erepo.save(e2);
		erepo.save(e3);
		erepo.save(e4);
	}

}
======Ex#1 1...* ===================================================
Name : SpringBoot2DataJpaOneToMany
Dep  : Lombok, Data Jpa, MySQL

1. application.properties
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot7am
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
#spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
------------------
2. Entity
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
@Table(name="addrtab")
public class Address {
	@Id
	@Column(name="aid")
	private Integer addrId;

	@Column(name="ahno")
	private String addrHno;

	@Column(name="aloc")
	private String location;
}
---------
package in.nareshit.raghu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stdtab")
public class Student {
	@Id
	@Column(name="sid")
	private Integer stdId;
	@Column(name="sname")
	private String stdName;
	@Column(name="sfee")
	private Double stdFee;

	@OneToMany
	@JoinColumn(name="sidFk")
	private List<Address> addr;//HAS-A
}

3. Repository Interface
package in.nareshit.raghu.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import in.nareshit.raghu.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
-----------
package in.nareshit.raghu.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import in.nareshit.raghu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

4. Runner class
package in.nareshit.raghu.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.Address;
import in.nareshit.raghu.entity.Student;
import in.nareshit.raghu.repo.AddressRepository;
import in.nareshit.raghu.repo.StudentRepository;

@Component
public class DataInsertRunner implements CommandLineRunner {

	@Autowired
	private AddressRepository arepo;

	@Autowired
	private StudentRepository srepo;

	public void run(String... args) throws Exception {
		Address addr1 = new Address(1501, "5-85/A", "AMEERPET-HYD");
		Address addr2 = new Address(1502, "2-98-7", "SRNARAG-HYD");

		Address addr3 = new Address(1503, "95/A/3", "DNYP-BAN");
		Address addr4 = new Address(1504, "54-A", "CHRT-BAN");

		arepo.save(addr1);
		arepo.save(addr2);
		arepo.save(addr3);
		arepo.save(addr4);

		Student s1 = new Student(2014, "AJAY", 500.0, Arrays.asList(addr1,addr2));
		Student s2 = new Student(2015, "SAM", 600.0, Arrays.asList(addr3,addr4));

		srepo.save(s1);
		srepo.save(s2);
	}

}
____________________________________________________
	EX#3 Many-To-Many

Name : SpringBoot2DataJpaManyToMany
Dep  : Lombok, Data Jpa, MySQL

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
@Table(name="authtab")
public class Author {
	@Id
	@Column(name="aid")
	private Integer authId;
	@Column(name="aname")
	private String authName;
	@Column(name="aqu")
	private String qualfic;
}
----------
package in.nareshit.raghu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="booktab")
public class Book {
	@Id
	@Column(name="bid")
	private Integer bookId;
	@Column(name="bname")
	private String bookName;
	@Column(name="bamt")
	private Double amount;

	@ManyToMany
	@JoinTable(name="bookauthtab",
			joinColumns = @JoinColumn(name="bidFk"),
			inverseJoinColumns = @JoinColumn(name="aidFk")
			)
	private Set<Author> auths; //HAS-A
}

3. Repository Interface
package in.nareshit.raghu.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import in.nareshit.raghu.entity.Author;
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
--------
package in.nareshit.raghu.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import in.nareshit.raghu.entity.Book;
public interface BookRepository extends JpaRepository<Book, Integer> {

}
4. Runner for Data insert
package in.nareshit.raghu.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.Author;
import in.nareshit.raghu.entity.Book;
import in.nareshit.raghu.repo.AuthorRepository;
import in.nareshit.raghu.repo.BookRepository;

@Component
public class DataInsertRunner implements CommandLineRunner {

	@Autowired
	private AuthorRepository arepo;
	@Autowired
	private BookRepository brepo;

	public void run(String... args) throws Exception {
		Author a1 = new Author(5804, "SAM", "BA");
		Author a2 = new Author(5803, "SYED", "BTech");
		Author a3 = new Author(5802, "AJAY", "BCom");

		arepo.save(a1);
		arepo.save(a2);
		arepo.save(a3);

		Book b1 = new Book(850, "SAMPLE-1", 500.0, Set.of(a1,a2));
		Book b2 = new Book(851, "SAMPLE-2", 600.0, Set.of(a2,a3));
		Book b3 = new Book(853, "SAMPLE-3", 700.0, Set.of(a1,a3));

		brepo.save(b1);
		brepo.save(b2);
		brepo.save(b3);
	}

}
==========================================================
		Ex#4  One-To-One
	-----------------------------------
name : SpringBoot2DataJpaOneToOneEx
Dep  : Lombok, Data Jpa, MySQL

1. application.properties
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot7am
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
#spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

2. Entity class
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
@Table(name="pantab")
public class PanCard {
	@Id
	@Column(name="pid")
	private Integer pid;

	@Column(name="pcode")
	private String panCode;

	@Column(name="pname")
	private String name;

	@Column(name="pfname")
	private String fname;
}
------
package in.nareshit.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pertab")
public class Person {
	@Id
	@Column(name="peid")
	private Integer perId;
	@Column(name="pname")
	private String perName;
	@Column(name="ploc")
	private String location;

	@OneToOne
	@JoinColumn(name="pidFk")
	private PanCard pob;//HAS-A
}

3. Repository Interface
package in.nareshit.raghu.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import in.nareshit.raghu.entity.PanCard;

public interface PanCardRepository extends JpaRepository<PanCard, Integer> {

}
---
package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}

4. Runner class
package in.nareshit.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.PanCard;
import in.nareshit.raghu.entity.Person;
import in.nareshit.raghu.repo.PanCardRepository;
import in.nareshit.raghu.repo.PersonRepository;

@Component
public class DataInsertRunner implements CommandLineRunner {

	@Autowired
	private PanCardRepository pnrepo;

	@Autowired
	private PersonRepository prrepo;

	public void run(String... args) throws Exception {
		PanCard pob1 = new PanCard(5501, "AAAA1111B", "AA", "BB");
		PanCard pob2 = new PanCard(5502, "MMMM2222N", "MM", "NN");

		pnrepo.save(pob1);
		pnrepo.save(pob2);

		Person p1 = new Person(9850, "A-A", "HYD", pob1);
		Person p2 = new Person(9851, "M-M", "BAN", pob2);

		prrepo.save(p1);
		prrepo.save(p2);
	}
}
