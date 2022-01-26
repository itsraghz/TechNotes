# Adjust the Auto_increment values after removing the junk/duplicate entires in the tables in MySQL 

As part of the enhancement, instead of calling *Update*, the method in Java class (SpringBoot with JPA, Hibernate) was calling the *Save* method URL, which had indeed created a few more entries that jumbled the sequence ids. 

Hence I removed those junk entries (top of stack) and adjusted the `auto_increment* value in the respective/relevant DB tables in MySQL. 

We also verify the current auto_increment value in each table, after altering the same. 

The below SQL command and the results are self-explanatory. 

```sql
MariaDB [bkup-packtpub-freelearning]> use packtpub-freelearning;
Database changed
MariaDB [packtpub-freelearning]> select Id, created_date, order_date, substr(description, 1, 60) as description, book_id from tbl_free_learning_entry order
by id desc LIMIT 10;
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
| Id | created_date               | order_date                 | description                                                  | book_id |
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
| 71 | 2022-01-26 14:10:10.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      71 |
| 70 | 2022-01-26 14:09:50.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      70 |
| 69 | 2022-01-26 14:02:43.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      69 |
| 68 | 2022-01-26 14:01:43.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      68 |
| 67 | 2022-01-26 13:56:27.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      67 |
| 66 | 2022-01-26 13:52:42.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      66 |
| 65 | 2022-01-26 09:57:26.000000 | 2022-01-26 00:00:00.000000 | Security has always been a major concern for your applicatio |      65 |
| 64 | 2022-01-25 08:22:03.000000 | 2022-01-25 00:00:00.000000 | Moodle is the de facto standard for open source learning pla |      64 |
| 63 | 2022-01-24 08:51:54.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      63 |
| 62 | 2022-01-23 10:58:34.000000 | 2022-01-23 00:00:00.000000 | Microsoft Dynamics 365 is an all-in-one business management  |      62 |
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
10 rows in set (0.00 sec)

MariaDB [packtpub-freelearning]> delete from tbl_free_learning_entry where id>66;
Query OK, 5 rows affected (1.76 sec)

MariaDB [packtpub-freelearning]> select Id, created_date, order_date, substr(description, 1, 60) as description, book_id from tbl_free_learning_entry order
by id desc LIMIT 10;
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
| Id | created_date               | order_date                 | description                                                  | book_id |
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
| 66 | 2022-01-26 13:52:42.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      66 |
| 65 | 2022-01-26 09:57:26.000000 | 2022-01-26 00:00:00.000000 | Security has always been a major concern for your applicatio |      65 |
| 64 | 2022-01-25 08:22:03.000000 | 2022-01-25 00:00:00.000000 | Moodle is the de facto standard for open source learning pla |      64 |
| 63 | 2022-01-24 08:51:54.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      63 |
| 62 | 2022-01-23 10:58:34.000000 | 2022-01-23 00:00:00.000000 | Microsoft Dynamics 365 is an all-in-one business management  |      62 |
| 61 | 2022-01-22 17:06:11.000000 | 2022-01-22 00:00:00.000000 | This book has extensive coverage of techniques that will hel |      61 |
| 60 | 2022-01-21 08:17:22.000000 | 2022-01-21 00:00:00.000000 | This book has extensive coverage of techniques that will hel |      60 |
| 59 | 2022-01-21 01:01:54.000000 | 2022-01-20 00:00:00.000000 | Git is one of the most popular types of Source Code Manageme |      59 |
| 58 | 2022-01-19 07:12:32.000000 | 2022-01-19 00:00:00.000000 | Magento is an open source, enterprise-level e-commerce platf |      58 |
| 57 | 2022-01-18 12:24:13.000000 | 2022-01-18 00:00:00.000000 | OpenStack Networking is a pluggable, scalable, and API-drive |      57 |
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
10 rows in set (0.00 sec)

MariaDB [packtpub-freelearning]> delete from tbl_free_learning_entry where id>65;
Query OK, 1 row affected (0.00 sec)

MariaDB [packtpub-freelearning]> select Id, created_date, order_date, substr(description, 1, 60) as description, book_id from tbl_free_learning_entry order
by id desc LIMIT 10;
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
| Id | created_date               | order_date                 | description                                                  | book_id |
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
| 65 | 2022-01-26 09:57:26.000000 | 2022-01-26 00:00:00.000000 | Security has always been a major concern for your applicatio |      65 |
| 64 | 2022-01-25 08:22:03.000000 | 2022-01-25 00:00:00.000000 | Moodle is the de facto standard for open source learning pla |      64 |
| 63 | 2022-01-24 08:51:54.000000 | 2022-01-24 00:00:00.000000 | Node.js, a modern development environment that enables devel |      63 |
| 62 | 2022-01-23 10:58:34.000000 | 2022-01-23 00:00:00.000000 | Microsoft Dynamics 365 is an all-in-one business management  |      62 |
| 61 | 2022-01-22 17:06:11.000000 | 2022-01-22 00:00:00.000000 | This book has extensive coverage of techniques that will hel |      61 |
| 60 | 2022-01-21 08:17:22.000000 | 2022-01-21 00:00:00.000000 | This book has extensive coverage of techniques that will hel |      60 |
| 59 | 2022-01-21 01:01:54.000000 | 2022-01-20 00:00:00.000000 | Git is one of the most popular types of Source Code Manageme |      59 |
| 58 | 2022-01-19 07:12:32.000000 | 2022-01-19 00:00:00.000000 | Magento is an open source, enterprise-level e-commerce platf |      58 |
| 57 | 2022-01-18 12:24:13.000000 | 2022-01-18 00:00:00.000000 | OpenStack Networking is a pluggable, scalable, and API-drive |      57 |
| 56 | 2022-01-17 14:33:44.000000 | 2022-01-17 00:00:00.000000 | As computer networks become ubiquitous, it has become increa |      56 |
+----+----------------------------+----------------------------+--------------------------------------------------------------+---------+
10 rows in set (0.00 sec)

MariaDB [packtpub-freelearning]> ALTER TABLE tbl_free_learning_entry AUTO_INCREMENT = 66;
Query OK, 0 rows affected (0.06 sec)
Records: 0  Duplicates: 0  Warnings: 0
```

## Verify the current Auto_increment value in the table 

The syntax to verify the current `auto_increment` value of a table is given below.

```sql
SELECT `AUTO_INCREMENT`
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA = 'yourDatabaseName'
AND TABLE_NAME = 'yourTableName';
```

*Actual Usage:*

```
MariaDB [packtpub-freelearning]> SELECT `AUTO_INCREMENT`
    -> FROM INFORMATION_SCHEMA.TABLES
    -> WHERE TABLE_SCHEMA = 'packtpub-freelearning'
    -> AND TABLE_NAME = 'tbl_free_learning_entry';
+----------------+
| AUTO_INCREMENT |
+----------------+
|             66 |
+----------------+
1 row in set (0.00 sec)

```sql
MariaDB [packtpub-freelearning]>
SELECT `AUTO_INCREMENT`
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA = 'packtpub-freelearning'
AND TABLE_NAME = 'tbl_free_learning_entry';
```

```sql
SELECT `AUTO_INCREMENT`
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA = 'packtpub-freelearning'
AND TABLE_NAME = 'tbl_book';
```

# Tbl_book entries 


```sql
MariaDB [packtpub-freelearning]> SELECT `AUTO_INCREMENT`
    -> FROM INFORMATION_SCHEMA.TABLES
    -> WHERE TABLE_SCHEMA = 'packtpub-freelearning'
    -> AND TABLE_NAME = 'tbl_book';
+----------------+
| AUTO_INCREMENT |
+----------------+
|             72 |
+----------------+
1 row in set (0.00 sec)

MariaDB [packtpub-freelearning]> select Id, created_date, title from tbl_book order by id desc LIMIT 10;
+----+----------------------------+-----------------------------------------------------------------------+
| Id | created_date               | title                                                                 |
+----+----------------------------+-----------------------------------------------------------------------+
| 71 | 2022-01-26 14:10:10.000000 | Mastering Node.js - Second Edition                                    |
| 70 | 2022-01-26 14:09:50.000000 | Mastering Node.js - Second Edition                                    |
| 69 | 2022-01-26 14:02:43.000000 | Mastering Node.js - Second Edition                                    |
| 68 | 2022-01-26 14:01:43.000000 | Mastering Node.js - Second Edition                                    |
| 67 | 2022-01-26 13:56:27.000000 | Mastering Node.js - Second Edition                                    |
| 66 | 2022-01-26 13:52:42.000000 | Mastering Node.js - Second Edition                                    |
| 65 | 2022-01-26 09:59:13.000000 | Penetration Testing with Shellcode                                    |
| 64 | 2022-01-25 08:22:03.000000 | Moodle 3 Administration - Third Edition                               |
| 63 | 2022-01-24 08:51:54.000000 | Mastering Node.js - Second Edition                                    |
| 62 | 2022-01-23 10:58:34.000000 | Mastering Microsoft Dynamics 365 Customer Engagement - Second Edition |
+----+----------------------------+-----------------------------------------------------------------------+
10 rows in set (0.00 sec)

MariaDB [packtpub-freelearning]> delete from tbl_book where id>=66;
Query OK, 6 rows affected (0.33 sec)

MariaDB [packtpub-freelearning]> select Id, created_date, title from tbl_book order by id desc LIMIT 10;
+----+----------------------------+-----------------------------------------------------------------------+
| Id | created_date               | title                                                                 |
+----+----------------------------+-----------------------------------------------------------------------+
| 65 | 2022-01-26 09:59:13.000000 | Penetration Testing with Shellcode                                    |
| 64 | 2022-01-25 08:22:03.000000 | Moodle 3 Administration - Third Edition                               |
| 63 | 2022-01-24 08:51:54.000000 | Mastering Node.js - Second Edition                                    |
| 62 | 2022-01-23 10:58:34.000000 | Mastering Microsoft Dynamics 365 Customer Engagement - Second Edition |
| 61 | 2022-01-22 17:06:11.000000 | Mastering Linux Security and Hardening                                |
| 60 | 2022-01-21 08:17:22.000000 | Mastering Linux Security and Hardening                                |
| 59 | 2022-01-21 01:01:54.000000 | Mastering Git                                                         |
| 58 | 2022-01-19 07:12:32.000000 | Magento 2 Development Quick Start Guide                               |
| 57 | 2022-01-18 12:24:13.000000 | Learning OpenStack Networking - Third Edition                         |
| 56 | 2022-01-17 14:37:23.000000 | Learn pfSense 2.4                                                     |
+----+----------------------------+-----------------------------------------------------------------------+
10 rows in set (0.00 sec)

MariaDB [packtpub-freelearning]> ALTER TABLE tbl_book AUTO_INCREMENT = 66;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

MariaDB [packtpub-freelearning]> SELECT `AUTO_INCREMENT`
    -> FROM INFORMATION_SCHEMA.TABLES
    -> WHERE TABLE_SCHEMA = 'packtpub-freelearning'
    -> AND TABLE_NAME = 'tbl_book';
+----------------+
| AUTO_INCREMENT |
+----------------+
|             66 |
+----------------+
1 row in set (0.00 sec)

MariaDB [packtpub-freelearning]>
```

## Final Touch 

```sql
MariaDB [packtpub-freelearning]> select count(*), max(id) from tbl_book;
+----------+---------+
| count(*) | max(id) |
+----------+---------+
|       65 |      65 |
+----------+---------+
1 row in set (0.01 sec)

MariaDB [packtpub-freelearning]> select count(*), max(id) from tbl_free_learning_entry;
+----------+---------+
| count(*) | max(id) |
+----------+---------+
|       65 |      65 |
+----------+---------+
1 row in set (0.00 sec)

MariaDB [packtpub-freelearning]>
```