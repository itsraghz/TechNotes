# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 30 \
10 Nov 2021 Wed \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* JPA FindBy Queries
* Projections

# Task

* Watch the  Spring Boot Web MVC Video in the NareshIT YouTube Channel

# Lecture Notes - downloaded from Google Classroom Notes

```
                        Date : 10/11/2021
                        Spring Boot 7:15AM
                            Mr. RAGHU                        
            -----------------------------------------------------
```

Spring Boot WEB MVC:
https://www.youtube.com/watch?v=O8MtjB0Ru0E

findBy method

=> findBy Method is used to fetch data by generating
query at runtime.

=> No need to define any query like SQL/JPQL. (nothing required)
=> Dialect is involved and generates SQL finally using findBy
=> It is a abstract method. These findBy methods must be
defined inside Repository interfaces.

*Syntax:*
`<ReturnType> findBy<VariableKeyword>(<DataType> <param>);`

=> Used for Simple SELECT operations. Non-SELECT not supports
=> No Complex and Lengthy Queries supported.

=> as of now Possible ReturnTypes:
List<T>        : If your query returns more then one row
Optional<T>    : If your query returns zero or 1 row

=> if your query returns multiple rows and used Optional<T>
inplace of List, then exception is :
NonUniqueResultException: query did not return a unique result: <no.of rows>
=====Examples=======================================================
*Entity:*

```java
class Book
{
  int bookId;
  String bookName;
  String author;
  Double cost;
  String isbn;
}
//SQL: SELECT * FROM BOOK WHERE author IS NOT NULL
List<Book> findByAuthorIsNotNull();

//SQL: SELECT * FROM BOOK WHERE cost<=?
List<Book>  findByCostLessThanEqual(Double cost);

//SQL: SELECT * FROM BOOK WHERE bookName=?
`<ReturnType>  findBy<VariableKeyword>(<Params>);`
List<Book>   findByBookName(String bookName);

//SQL: SELECT * FROM BOOK WHERE bookId=?
Optional<Book> findByBookId(int bookId)
Optional<Book> findByBookIdIs(int bookId);
List<Book> findByBookIdEquals(int bookId);
```
___________________CODE____________________________
NAME : SpringBoot2DataJpaFindByEx
Dep  : Lombok, Data JPA, MySQL

1. application.properties
```java
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot730am
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```
2. Entity class

```java
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
@Table(name="book_tab")
public class Book {
@Id
@Column(name="bid")
private Integer bookId;

@Column(name="bname")
private String bookName;

@Column(name="bauth")
private String author;

@Column(name="bcost")
private Double cost;

@Column(name="bisbn")
private String isbn;
}
```

3. Repository Interface

```java
package in.nareshit.raghu.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

//SQL: SELECT * FROM BOOK WHERE author=?
List<Book> findByAuthor(String author);
//List<Book> findByAuthorIs(String author);
//List<Book> findByAuthorEquals(String author);

//SQL: SELECT * FROM BOOK WHERE cost<=?
List<Book> findByCostLessThanEqual(Double cost);

//SQL: SELECT * FROM BOOK WHERE author IS NOT NULL
List<Book> findByAuthorIsNotNull();

//SQL: SELECT * FROM BOOK WHERE bid=?
Optional<Book> findByBookId(Integer bid);

//Error case
//SQL: SELECT * FROM BOOK WHERE bid=?
//Optional<Book> findByBookIdNot(Integer bid);

//SQL: SELECT * FROM BOOK WHERE bid in (?)
List<Book> findByBookIdIn(List<Integer> bids);
//List<Book> findByBookIdNotIn(List<Integer> bids);

//SQL: SELECT * FROM BOOK WHERE author like ?
List<Book> findByAuthorLike(String name);

//adds % after to input => input%
List<Book> findByAuthorStartingWith(String name);

//adds % before to input => %input
List<Book> findByAuthorEndingWith(String name);

//adds % before and after to input => %input%
List<Book> findByAuthorContaining(String name);

//SQL: SELECT * FROM BOOK WHERE bname=? or author like ?
List<Book> findBybookNameIsOrAuthorLike(String bname,String author);

//SQL: SELECT * FROM BOOK WHERE bid>? AND cost != ? AND bookName Is Not null
List<Book> findByBookIdGreaterThanAndCostNotAndBookNameIsNotNull(Integer id,Double cost);

}

```

4. Data Insert Runner

```java
package in.nareshit.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import in.nareshit.raghu.entity.Book;
import in.nareshit.raghu.repo.BookRepository;

//@Component
public class BookDataInsertRunner implements CommandLineRunner {

@Autowired
private BookRepository repo;

public void run(String... args) throws Exception {
repo.save(new Book(101, "Core Java", "SYED", 350.0, "NIT-54126AA"));
repo.save(new Book(102, "Adv Java", "SYED", 480.0, "NIT-5006RT"));
repo.save(new Book(103, "Hibernate", "AJAY", 550.0, "NIT-741126UI"));
repo.save(new Book(104, "Spring", "AJAY", 600.0, "NIT-65016AY"));
repo.save(new Book(105, "SB MS", "SAM", 1000.0, "NIT-9985QA"));
repo.save(new Book(106, "HTML CSS", null, 100.0, "NIT-QA88569ER"));
}

}
```

5. Data FindBy test Runner

```java
package in.nareshit.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.repo.BookRepository;

@Component
public class BookTestFindByRunner implements CommandLineRunner {

@Autowired
private BookRepository repo;

public void run(String... args) throws Exception {
//repo.findByAuthor("SYED").forEach(System.out::println);
//repo.findByCostLessThanEqual(800.0).forEach(System.out::println);
//repo.findByAuthorIsNotNull().forEach(System.out::println);

/*Optional<Book> opt = repo.findByBookId(101);
Book b = opt.orElseThrow(()->new RuntimeException("No Data Found"));
System.out.println(b);*/

/*Optional<Book> opt = repo.findByBookIdNot(101);
Book b = opt.orElseThrow(()->new RuntimeException("No Data Found"));
System.out.println(b);*/

//repo.findByBookIdIn(Arrays.asList(101,105,107,109)).forEach(System.out::println);

//Starts with S
//repo.findByAuthorLike("S%").forEach(System.out::println);
//repo.findByAuthorStartingWith("S").forEach(System.out::println);

//ending with Y
//repo.findByAuthorLike("%Y").forEach(System.out::println);
//repo.findByAuthorEndingWith("Y").forEach(System.out::println);

//conatins Y
//repo.findByAuthorLike("%Y%").forEach(System.out::println);
//repo.findByAuthorContaining("Y").forEach(System.out::println);
//repo.findBybookNameIsOrAuthorLike("Core Java", "S%").forEach(System.out::println);
//repo.findByBookIdGreaterThanAndCostNotAndBookNameIsNotNull(101, 200.0).forEach(System.out::println);
}

}
```

## Console Ouptut - with my own meantingful hints/disclaimers for each Query

```java
--------------------------------------------
--------- BookDataInsertRunner - start -----
--------------------------------------------
Hibernate: select book0_.bid as bid1_0_0_, book0_.bauth as bauth2_0_0_, book0_.bname as bname3_0_0_, book0_.bcost as bcost4_0_0_, book0_.bisbn as bisbn5_0_0_ from book_tab book0_ where book0_.bid=?
Hibernate: select book0_.bid as bid1_0_0_, book0_.bauth as bauth2_0_0_, book0_.bname as bname3_0_0_, book0_.bcost as bcost4_0_0_, book0_.bisbn as bisbn5_0_0_ from book_tab book0_ where book0_.bid=?
Hibernate: select book0_.bid as bid1_0_0_, book0_.bauth as bauth2_0_0_, book0_.bname as bname3_0_0_, book0_.bcost as bcost4_0_0_, book0_.bisbn as bisbn5_0_0_ from book_tab book0_ where book0_.bid=?
Hibernate: select book0_.bid as bid1_0_0_, book0_.bauth as bauth2_0_0_, book0_.bname as bname3_0_0_, book0_.bcost as bcost4_0_0_, book0_.bisbn as bisbn5_0_0_ from book_tab book0_ where book0_.bid=?
Hibernate: select book0_.bid as bid1_0_0_, book0_.bauth as bauth2_0_0_, book0_.bname as bname3_0_0_, book0_.bcost as bcost4_0_0_, book0_.bisbn as bisbn5_0_0_ from book_tab book0_ where book0_.bid=?
Hibernate: select book0_.bid as bid1_0_0_, book0_.bauth as bauth2_0_0_, book0_.bname as bname3_0_0_, book0_.bcost as bcost4_0_0_, book0_.bisbn as bisbn5_0_0_ from book_tab book0_ where book0_.bid=?
--------------------------------------------
--------- BookTestFindByRunner - start -----
--------------------------------------------
---------------------------------
[*] findAll
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=103, bookName=Hibernate, author=AJAY, cost=550.0, isbn=NIT-741126UI)
Book(bookId=104, bookName=Spring, author=AJAY, cost=600.0, isbn=NIT-65016AY)
Book(bookId=105, bookName=SB MS, author=SAM, cost=1000.0, isbn=NIT-9985QA)
Book(bookId=106, bookName=HTML CSS, author=null, cost=100.0, isbn=NIT-QA88569ER)

---------------------------------
[*] findByAuthor -- SYED
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bauth=?
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)

---------------------------------
[*] findByCostLessThanEqual -- 800.0
------------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bcost<=?
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=103, bookName=Hibernate, author=AJAY, cost=550.0, isbn=NIT-741126UI)
Book(bookId=104, bookName=Spring, author=AJAY, cost=600.0, isbn=NIT-65016AY)
Book(bookId=106, bookName=HTML CSS, author=null, cost=100.0, isbn=NIT-QA88569ER)

---------------------------------
[*] findByAuthorIsNotNull
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bauth is not null
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=103, bookName=Hibernate, author=AJAY, cost=550.0, isbn=NIT-741126UI)
Book(bookId=104, bookName=Spring, author=AJAY, cost=600.0, isbn=NIT-65016AY)
Book(bookId=105, bookName=SB MS, author=SAM, cost=1000.0, isbn=NIT-9985QA)

---------------------------------
[*] findByAuthorIsNotNull
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bid=?
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)

---------------------------------
[*] findByBookIdIn(101,105,107,109)
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bid in (? , ? , ? , ?)
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=105, bookName=SB MS, author=SAM, cost=1000.0, isbn=NIT-9985QA)

---------------------------------
[*] findByAuthorLike(S%)
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bauth like ? escape ?
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=105, bookName=SB MS, author=SAM, cost=1000.0, isbn=NIT-9985QA)

---------------------------------
[*] findByAuthorStartingWith(S)
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bauth like ? escape ?
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=105, bookName=SB MS, author=SAM, cost=1000.0, isbn=NIT-9985QA)

---------------------------------
[*] findByAuthorLike(%Y)
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bauth like ? escape ?
Book(bookId=103, bookName=Hibernate, author=AJAY, cost=550.0, isbn=NIT-741126UI)
Book(bookId=104, bookName=Spring, author=AJAY, cost=600.0, isbn=NIT-65016AY)

---------------------------------
[*] findByAuthorEndingWith(Y)
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bauth like ? escape ?
Book(bookId=103, bookName=Hibernate, author=AJAY, cost=550.0, isbn=NIT-741126UI)
Book(bookId=104, bookName=Spring, author=AJAY, cost=600.0, isbn=NIT-65016AY)

---------------------------------
[*] findByAuthorLike(%Y%)
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bauth like ? escape ?
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=103, bookName=Hibernate, author=AJAY, cost=550.0, isbn=NIT-741126UI)
Book(bookId=104, bookName=Spring, author=AJAY, cost=600.0, isbn=NIT-65016AY)

---------------------------------
[*] findByAuthorContaining(Y)
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bauth like ? escape ?
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=103, bookName=Hibernate, author=AJAY, cost=550.0, isbn=NIT-741126UI)
Book(bookId=104, bookName=Spring, author=AJAY, cost=600.0, isbn=NIT-65016AY)

---------------------------------
[*] findBybookNameIsOrAuthorLike("Core Java", "S%")
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bname=? or book0_.bauth like ? escape ?
Book(bookId=101, bookName=Core Java, author=SYED, cost=350.0, isbn=NIT-54126AA)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=105, bookName=SB MS, author=SAM, cost=1000.0, isbn=NIT-9985QA)

---------------------------------
[*] findByBookIdGreaterThanAndCostNotAndBookNameIsNotNull(101, 200.0)
---------------------------------
Hibernate: select book0_.bid as bid1_0_, book0_.bauth as bauth2_0_, book0_.bname as bname3_0_, book0_.bcost as bcost4_0_, book0_.bisbn as bisbn5_0_ from book_tab book0_ where book0_.bid>? and book0_.bcost<>? and (book0_.bname is not null)
Book(bookId=102, bookName=Adv Java, author=SYED, cost=480.0, isbn=NIT-5006RT)
Book(bookId=103, bookName=Hibernate, author=AJAY, cost=550.0, isbn=NIT-741126UI)
Book(bookId=104, bookName=Spring, author=AJAY, cost=600.0, isbn=NIT-65016AY)
Book(bookId=105, bookName=SB MS, author=SAM, cost=1000.0, isbn=NIT-9985QA)
Book(bookId=106, bookName=HTML CSS, author=null, cost=100.0, isbn=NIT-QA88569ER)
```

=============================================================
Projection: Display selected columns insted of all columns.

*) findBy default gets data as List<T> where T = Entity class
*) To fetch selected variables(columns) define one inner interface
using variables getter methods. Use same as returnType.

Step#1
define one inner interface with any name
Step#2
select variables from entity for projection
Step#3
write inside inner interface using syntax:
DataType  get<Variable>();
Step#4
Use this new interface as returnType to findBy method

List<ViewType> (or) Optional<ViewType>
----------------------------------------------------------
```java
interface ___Repository extends JpaRepository<Book, Integer> {

interface <ViewType> {
DataType  getVariable();
DataType  getVariable();
...
}

List<ViewType> findBy___(<Params>);
//or
Optional<ViewType> findBy___(<Params>);
}
```

____CODE____________________________
1. Repository

```java
public interface BookRepository extends JpaRepository<Book, Integer> {

interface MyView {
Integer getBookId();
String getBookName();
}

//SQL: SELECT booId,bookName from Book WHERE author?
List<MyView> findByAuthor(String author);

}
```

2. Runner class:

```java
@Component
public class BookTestFindByRunner implements CommandLineRunner {

@Autowired
private BookRepository repo;

public void run(String... args) throws Exception {

  List<MyView> list = repo.findByAuthor("SYED");
  for(MyView m : list ) {
    System.out.println(m.getBookName()+"-"+m.getBookId());
}
  }
}
```
===============================================================================
*) Hibernate Date and Time:-
Date(java.util)
@Temporal supports for Date/Time mapping using Enum:
TemporalType ( DATE, TIME, TIMESTAMP)

example:-
DATE - 10/11/2021
TIME - 11:59 AM
TIMESTAMP - 10/11/2021 11:59 AM

*) Hibernate Lobs (BLOB and CLOB):-
BLOB - Binary Large OBject  (PDF, Image, Audio, Excel..etc)

=> byte[] + @Lob

CLOB - Character Large OBject (Lengthy Characters Data)

=> chart[] + @Lob

=> @Lob is given by JPA (javax.persistence)

____CODE_____________________________
Name : SpringDataJpaDateAndTimeLobs
Dep  : Lombok, Data JPA, MySQL

a. application.properties

```
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot730am
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
#spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

b. Entity

```java
package in.nareshit.raghu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

@Temporal(TemporalType.DATE)
private Date dteA;

@Temporal(TemporalType.TIME)
private Date dteB;

@Temporal(TemporalType.TIMESTAMP)
private Date dteC;

@Lob
private byte[] eimg;

@Lob
private char[] edata;
}
```

c. Repository
```java
package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```
d. Runner class

```java
package in.nareshit.raghu.runner;

import java.io.FileInputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.repo.EmployeeRepository;

@Component
public class DataInsertRunner implements CommandLineRunner {

@Autowired
private EmployeeRepository repo;

public void run(String... args) throws Exception {
FileInputStream fis = new FileInputStream("F:\\Images\\emp.png");
byte[] barr = new byte[fis.available()];
fis.read(barr);

String note = " Employee abcd, FROM NIT HYD SAMPLE DATA HELLO 1234....";
char[] cdata = note.toCharArray();

repo.save(new Employee(
  109, "AJAY",
  new Date(), new Date(), new Date(),
  barr,
  cdata
  ));
fis.close();
}

}
```
