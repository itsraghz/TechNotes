# Console output of a script that reads the entries from the DB table

The `employee_info.csv` file has only 5 entries. However the DB table `EMPLOYEE` has two entries during the table creation itself. 
Hence you see 7 entries in the output below.

```
C:\rags\TechNotes\pythonNotes\samplePgms\util\encryptEmployeeInfo\v2-db-read-write (master)
¿ python 2_mysql-fetchall.py
MySQL client is imported sucessfully!
Connected to MySQL DB - successfully!
Query to execute : SELECT * FROM EMPLOYEE
Employee Name : Karthiga Karpagam R, User Id : karthiga, password : ItsMeKKR$
Employee Name : Karthick Muthu R, User Id : karthick, password : ItsMeKMR#
Employee Name : Raghavan Muthu, User Id : itsraghz, password : HelloRaghs!
Employee Name : Meenakshi Murugappan, User Id : meena13, password : HaiMeena@
Employee Name : Karthiga Karpagam R, User Id : karthiga, password : ItsMeKKR#
Employee Name : Karthick Muthu R, User Id : karthick, password : ItsMeKMR$
Employee Name : Ravi Narasimhan, User Id : nravi2000, password : SuperBoss#!
Database connection closed successfully

C:\rags\TechNotes\pythonNotes\samplePgms\util\encryptEmployeeInfo\v2-db-read-write (master)
¿
```
