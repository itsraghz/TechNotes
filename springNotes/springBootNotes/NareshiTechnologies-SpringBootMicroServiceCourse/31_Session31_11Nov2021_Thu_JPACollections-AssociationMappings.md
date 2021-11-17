# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 31 \
11 Nov 2021 Thu \
7 10 AM IST - 8 40 AM IST

> New Classroom Link : https://classroom.google.com/u/0/c/NDA2NDE1MDg1MzAz

# Agenda

* JPA Collections
* Assocation Mappings

# Lecture Notes - downloaded from Google Classroom

Date : 11/11/2021
			Spring Boot 7:15AM
			  Mr. RAGHU
	------------------------------------------------
	   Collection Mapping using Primitives

*) (JPA) Hibernate mainly supports 3 types of collections
    List, Set and Map.

ex: List<String>, Set<Integer> , Map<String,String>

	[ 1 collection variable = 1 child table (3columns) ]

*) Collection variable is created as one child table at database
   with 2/3 columns (key column, index column and element column)

*) Key column also known as Join Column (or) Foreign key column
*) index indicates position , only for List and Map.
        List contains index - 0,1,2,..
	Map Key behaves like index

	[Set doesnt contains index, only 2 columns]

*) On Collection (with Primitive) variable must apply
   one annotation @ElementCollection.

    [ Collection variable must have @ElementCollection ]

*) We can use below annotations,

@CollectionTable(
      name="_____", // child table name
      joinColumns = @JoinColumn(name="____")//(key)FK Column
 )

@Column(name="_____") //element column

@OrderColumn(name="____")//Index column (for List)

@MapKeyColumn(name="___") // Index column (for Map)

*) MAP KEY -- Index, MAP VALUE -- Element(Data)


*) Every Child table contains KEY column (FK Column)
   which joins to parent table PK column only.
   Here, Child table never contains PK column.

________CODE_________________________________________
1. Name : SpringBoot2DataJpaCollectionsWithPrimtivies
   Dep  : Lombok, Data JPA, MySQL

2. application.properties
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/boot730am
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
#spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

3. Entity class
package in.nareshit.raghu.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
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

	@ElementCollection
	@CollectionTable(
			name="std_subjects", //table name
			joinColumns = @JoinColumn(name="sidFk")//FK Column
			)
	@Column(name="subj")//element column
	private Set<String> subjects;

	@ElementCollection
	@CollectionTable(
			name="std_marks",
			joinColumns = @JoinColumn(name="sidFk")
			)
	@OrderColumn(name="position")//Index column
	@Column(name="marks")
	private List<Integer> marks;

	@ElementCollection
	@CollectionTable(
			name="std_grades",
			joinColumns = @JoinColumn(name="sidFk")
			)
	@MapKeyColumn(name="sexam") // Index columns
	@Column(name="sgrade")
	private Map<String,String> grades;


}

4. Repository Interface
package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

5. Insert Data Runner
package in.nareshit.raghu.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.entity.Student;
import in.nareshit.raghu.repo.StudentRepository;

@Component
public class StudentDataInsertRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;

	public void run(String... args) throws Exception {
		//JDK 1.9 [ImmutableCollections]
		//List<Integer> marks = List.of(95,95,85);
		//Set<String> subjects = Set.of("ENG","SCI","MAT");
		//Map<String,String> grades = Map.of("INT","A+","SEM","A","EXT","A");

		//JDK 1.7(Java 7): Collections Type Inference
		List<Integer> marks = new ArrayList<>();
		marks.add(95);
		marks.add(95);
		marks.add(85);

		Set<String> subjects = new HashSet<>();
		subjects.add("ENG");
		subjects.add("SCI");
		subjects.add("MAT");

		Map<String,String> grades = new HashMap<>();
		grades.put("INT", "A+");
		grades.put("SEM", "A");
		grades.put("EXT", "A");

		Student sob = new Student(
				908, "SYED", 200.0,
				subjects, marks, grades);

		repo.save(sob);
	}

}
=====================================================
		MySQL Commands

mysql> drop database boot730am;

mysql> create database boot730am;

mysql> use boot730am;
Database changed

mysql> show tables;
+---------------------+
| Tables_in_boot730am |
+---------------------+
| std_grades          |
| std_marks           |
| std_subjects        |
| stdtab              |
+---------------------+


mysql> select * from stdtab;
+-----+------+-------+
| sid | sfee | sname |
+-----+------+-------+
| 908 |  200 | SYED  |
+-----+------+-------+


mysql> select * from std_marks;
+--------+-------+----------+
| sid_fk | marks | position |
+--------+-------+----------+
|    908 |    95 |        0 |
|    908 |    95 |        1 |
|    908 |    85 |        2 |
+--------+-------+----------+


mysql> select * from std_subjects;
+--------+------+
| sid_fk | subj |
+--------+------+
|    908 | MAT  |
|    908 | SCI  |
|    908 | ENG  |
+--------+------+


mysql> select * from std_grades;
+--------+--------+-------+
| sid_fk | sgrade | sexam |
+--------+--------+-------+
|    908 | A      | EXT   |
|    908 | A+     | INT   |
|    908 | A      | SEM   |
+--------+--------+-------+

=====================================================
Note:-
*) @ElementCollection must be applied over collection variable
   (using Primitives). Else Child table with columns not created.
 Else: MappingException: Could not determine type for...

*) @CollectionTable(name="", joinColumns="")
   @OrderColumn, @Column are optional.

  if we did not specify child table name, then
     Table Name =  ClassName_CollectionVariableName
     ex:  student_subjects

  if we did not specify FK/Key column name:
     Join Column name = ClassName_PKColumnName
     ex: student_sid,

  if we did not specify element column (or column), then
      Element Column name = CollectionVariableName
      ex:    subjects

*) @OrderColumn(name="___") is optional, if we did not give
   this, then table never contains positions/index column.

   ||  Bag  = List - Index (no @OrderColumn )  ||

*) For Map, index column is created even if we did not specify
   @MapKeyColumn(name="_____"), using

      collectionVariableName_key
     ex: grades_key
==============================================================
		Association Mapping (HAS-A)

*) Association Mapping between two entities.
   HAS-A Relation between two classes.

*) Database : Multiplicity
    1...1
    1...*
    *...1
    *...*

*) One table PK is taken as another table FK (Join) Column

Examples:
   (Inheritance)IS-A   HAS-A (Association Mapping)

  Employee  _______  Person

  Employee  _______ PanCard

    Book ________ Author

    Bus  _____ Vehicle

    Product ______ Vendor

    Admin  _____ Employee

      User  ____ Role
============================================
1.
              1...*
    Employee  HAS-A  Address

2.
             1...1    
     Person  HAS-A  PanCard

3. One Book can have multiple Authors and Author can write multiple books

	  1..* / *...*
     Book  HAS-A  Author

4.           *...*   
      Student HAS-A Course

5.
         *...1 / *...*
        User HAS-A Role

----------------------------------------------------------
*)Hint: One FK Column is created at many(*) side table.
*) If child is many then we must use collection variable
   else we use simple HAS-A Variable without collection.

```
   ------------------------------------------------------
	Non-Collection Type  |    Collection Type
   ------------------------------------------------------
            1...1                    1...*
	          *...1                    *...*
   ------------------------------------------------------
```

*) Annotations:
```
   1...1           @OneToOne
   1...*           @OneToMany
   *...1           @ManyToOne
   *...*           @ManyToMany
```

*) To provide FK Column:
            ``@JoinColumn(name="FKColumnName")``

*) JoinColumn is created at many side,
   but for case *...* one additional table (`JoinTable`)
   is created with 2 FK columns (`joinColumn`, `inverseJoinColumn`)

*) In case of 1...1 , parent table gets FK column.
