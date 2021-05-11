# Learning - MySQL Foreign key

## Error 

```sql
errno: 150 "Foreign key constraint is incorrectly formed"
```

## SQL Queries

To get to know the details of the failure, There is an easy way to find what causes this error you can use: SHOW ENGINE INNODB STATUS;

This will show more details on error under section: `"LATEST FOREIGN KEY ERROR"`.

```sql
SHOW ENGINE INNODB STATUS;
```

### Sample output for the error 

```sql
------------------------
LATEST FOREIGN KEY ERROR
------------------------
2021-05-12 00:40:09 3780 Error in foreign key constraint of table `shade`.`if`:
Create  table `shade`.`if` with foreign key constraint failed. Referenced table `shade`.`tblappealinfo` not found in the data dictionary near ' FOREIGN KEY(AppealId) REFERENCES TblAppea
lInfo(Id),
        UNIQUE UK_TblBankAcct_1_AcctNo_IFSC (IFSCCode, AcctType, AcctNo)
)'.
```

### Detailed output 

```sql
MariaDB [shade]> CREATE TABLE IF NOT EXISTS TblBankAcct
    -> (
    ->  Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ->  AppealId INT,
    ->  Bank VARCHAR(25) NOT NULL COMMENT 'The Name of the Bank',
    ->  Branch VARCHAR(25) NOT NULL COMMENT 'The Branch of the Bank',
    ->  City VARCHAR(25) NOT NULL COMMENT 'The City where the Branch is located',
    ->  Address VARCHAR(150) DEFAULT NULL COMMENT 'The Postal Address of the Branch',
    ->  AcctNo VARCHAR(25) NOT NULL COMMENT 'The Actual Account Number with the Bank',
    ->  AcctType VARCHAR(25) NOT NULL COMMENT 'The Type of the Account - Savings, Current, Chequing etc.,',
    ->  IFSCCode VARCHAR(25) NOT NULL COMMENT 'The IFSC Code of the Branch',
    ->  NameRegd VARCHAR(100) NOT NULL COMMENT 'The Account Holders Name registered with the Bank',
    ->  VPA     VARCHAR(50) DEFAULT NULL COMMENT 'Virtual Private Address for the UPI (Unified Payment Interface) if any',
    ->  MobileRegd INT(10) COMMENT 'Mobile No registered with the Bank for the UPI payments',
    ->  Remarks VARCHAR(250) COMMENT 'Additional Remarks if any',
    ->  CREATED_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date by when the entry was created',
    ->  CREATED_BY VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Who created the Record - captures the Name or SGXYZ Id',
    ->  MODIFIED_DATE DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date by when the Entry was updated',
    ->  MODIFIED_BY VARCHAR(20) NULL DEFAULT 'SYSTEM' COMMENT 'Who Updated the Record - captures the Name or SGXYZ Id',
    ->  CONSTRAINT fK_TblBankAcct_1 FOREIGN KEY(AppealId) REFERENCES TblAppealInfo(Id),
    ->  UNIQUE UK_TblBankAcct_1_AcctNo_IFSC (IFSCCode, AcctType, AcctNo)
    -> );
ERROR 1005 (HY000): Can't create table `shade`.`tblbankacct` (errno: 150 "Foreign key constraint is incorrectly formed")
MariaDB [shade]> SHOW ENGINE INNODB STATUS
    -> ;
+--------+------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------+
| Type   | Name | Status




                                                                                                                      |
+--------+------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------+
| InnoDB |      |
=====================================
2021-05-12 00:40:48 3780 INNODB MONITOR OUTPUT
=====================================
Per second averages calculated from the last 16 seconds
-----------------
BACKGROUND THREAD
-----------------
srv_master_thread loops: 27 srv_active, 0 srv_shutdown, 34802 srv_idle
srv_master_thread log flush and writes: 34829
----------
SEMAPHORES
----------
OS WAIT ARRAY INFO: reservation count 69
OS WAIT ARRAY INFO: signal count 68
Mutex spin waits 206, rounds 2932, OS waits 30
RW-shared spins 34, rounds 1020, OS waits 34
RW-excl spins 0, rounds 0, OS waits 0
Spin rounds per wait: 14.23 mutex, 30.00 RW-shared, 0.00 RW-excl
------------------------
LATEST FOREIGN KEY ERROR
------------------------
2021-05-12 00:40:09 3780 Error in foreign key constraint of table `shade`.`if`:
Create  table `shade`.`if` with foreign key constraint failed. Referenced table `shade`.`tblappealinfo` not found in the data dictionary near ' FOREIGN KEY(AppealId) REFERENCES TblAppea
lInfo(Id),
        UNIQUE UK_TblBankAcct_1_AcctNo_IFSC (IFSCCode, AcctType, AcctNo)
)'.
------------
TRANSACTIONS
------------
Trx id counter 247437
Purge done for trx's n:o < 247413 undo n:o < 0 state: running but idle
History list length 1348
LIST OF TRANSACTIONS FOR EACH SESSION:
---TRANSACTION 0, not started
MySQL thread id 35, OS thread handle 0x3780, query id 159 localhost ::1 raghs init
SHOW ENGINE INNODB STATUS
--------
FILE I/O
--------
I/O thread 0 state: native aio handle (insert buffer thread)
I/O thread 1 state: native aio handle (log thread)
I/O thread 2 state: native aio handle (read thread)
I/O thread 3 state: native aio handle (read thread)
I/O thread 4 state: native aio handle (read thread)
I/O thread 5 state: native aio handle (read thread)
I/O thread 6 state: native aio handle (write thread)
I/O thread 7 state: native aio handle (write thread)
I/O thread 8 state: native aio handle (write thread)
I/O thread 9 state: native aio handle (write thread)
Pending normal aio reads: 0 [0, 0, 0, 0] , aio writes: 0 [0, 0, 0, 0] ,
 ibuf aio reads: 0, log i/o's: 0, sync i/o's: 0
Pending flushes (fsync) log: 0; buffer pool: 0
767 OS file reads, 557 OS file writes, 260 OS fsyncs
0.00 reads/s, 0 avg bytes/read, 0.00 writes/s, 0.00 fsyncs/s
-------------------------------------
INSERT BUFFER AND ADAPTIVE HASH INDEX
-------------------------------------
Ibuf: size 1, free list len 0, seg size 2, 0 merges
merged operations:
 insert 0, delete mark 0, delete 0
discarded operations:
 insert 0, delete mark 0, delete 0
0.00 hash searches/s, 0.00 non-hash searches/s
---
LOG
---
Log sequence number 169815426
Log flushed up to   169815426
Pages flushed up to 169815426
Last checkpoint at  169815426
Max checkpoint age    7782360
Checkpoint age target 7539162
Modified age          0
Checkpoint age        0
0 pending log writes, 0 pending chkp writes
101 log i/o's done, 0.00 log i/o's/second
----------------------
BUFFER POOL AND MEMORY
----------------------
Total memory allocated 17072128; in additional pool allocated 0
Total memory allocated by read views 336
Internal hash tables (constant factor + variable factor)
    Adaptive hash index 297300  (276764 + 20536)
    Page hash           9068 (buffer pool 0 only)
    Dictionary cache    122654  (69928 + 52726)
    File system         439320  (406136 + 33184)
    Lock system         21500   (21188 + 312)
    Recovery system     0       (0 + 0)
Dictionary memory allocated 52726
Buffer pool size        1023
Buffer pool size, bytes 16760832
Free buffers            766
Database pages          256
Old database pages      0
Modified db pages       0
Percent of dirty pages(LRU & free pages): 0.000
Max dirty pages percent: 75.000
Pending reads 0
Pending writes: LRU 0, flush list 0, single page 0
Pages made young 0, not young 0
0.00 youngs/s, 0.00 non-youngs/s
Pages read 503, created 94, written 355
0.00 reads/s, 0.00 creates/s, 0.00 writes/s
No buffer pool page gets since the last printout
Pages read ahead 0.00/s, evicted without access 0.00/s, Random read ahead 0.00/s
LRU len: 256, unzip_LRU len: 0
I/O sum[13]:cur[0], unzip sum[0]:cur[0]
--------------
ROW OPERATIONS
--------------
0 queries inside InnoDB, 0 queries in queue
0 read views open inside InnoDB
0 RW transactions active inside InnoDB
0 RO transactions active inside InnoDB
0 out of 1000 descriptors used
Main thread id 3952, state: sleeping
Number of rows inserted 1, updated 2, deleted 0, read 3950
0.00 inserts/s, 0.00 updates/s, 0.00 deletes/s, 0.00 reads/s
Number of system rows inserted 0, updated 0, deleted 0, read 0
0.00 inserts/s, 0.00 updates/s, 0.00 deletes/s, 0.00 reads/s
----------------------------
END OF INNODB MONITOR OUTPUT
============================
 |
+--------+------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)

MariaDB [shade]> 
```

## Cause

The DB Engines may not be same for both the tables. 

## Query to list all the supported engines in the MySQL Database

```sql
MariaDB [information_schema]> SHOW ENGINES;
+--------------------+---------+--------------------------------------------------------------------------------------------------+--------------+------+------------+
| Engine             | Support | Comment                                                                                          | Transactions | XA   | Savepoints |
+--------------------+---------+--------------------------------------------------------------------------------------------------+--------------+------+------------+
| CSV                | YES     | CSV storage engine                                                                               | NO           | NO   | NO         |
| InnoDB             | DEFAULT | Percona-XtraDB, Supports transactions, row-level locking, foreign keys and encryption for tables | YES          | YES  | YES        |
| MEMORY             | YES     | Hash based, stored in memory, useful for temporary tables                                        | NO           | NO   | NO         |
| MyISAM             | YES     | MyISAM storage engine                                                                            | NO           | NO   | NO         |
| MRG_MyISAM         | YES     | Collection of identical MyISAM tables                                                            | NO           | NO   | NO         |
| Aria               | YES     | Crash-safe tables with MyISAM heritage                                                           | NO           | NO   | NO         |
| PERFORMANCE_SCHEMA | YES     | Performance Schema                                                                               | NO           | NO   | NO         |
| SEQUENCE           | YES     | Generated tables filled with sequential values                                                   | YES          | NO   | YES        |
+--------------------+---------+--------------------------------------------------------------------------------------------------+--------------+------+------------+
8 rows in set (0.00 sec)

MariaDB [information_schema]> desc ENGINES;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| ENGINE       | varchar(64)  | NO   |     |         |       |
| SUPPORT      | varchar(8)   | NO   |     |         |       |
| COMMENT      | varchar(160) | NO   |     |         |       |
| TRANSACTIONS | varchar(3)   | YES  |     | NULL    |       |
| XA           | varchar(3)   | YES  |     | NULL    |       |
| SAVEPOINTS   | varchar(3)   | YES  |     | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
6 rows in set (0.01 sec)

MariaDB [information_schema]> 
```

*Note*: It is pretty evident that,

 * `INNODB` is the default engine. 
     * Not sure how the tables got `MYISAM`, perhaps they might have either explicitly got declared in the `CREATE TABLE` statement OR 
       they would have been the default engine in the earlier versions of MySQL when these tables were created.
 * `INNODB` supports the very important features like `Transactions`, Locking`, `SavePoints`, 
    and also `XA` (Extended Architecture for _2PC_ (Two Phase Commits) etc., 
    making it the must-to-have choice.

> Better to update the DB Engine as `INNODB` for all the tables in the `shade` database at one shot.

### Query to get the engine used for a table

#### Query to get the engine for a particular table

```sql
SELECT Table_name, ENGINE
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'shade'
AND TABLE_NAME = 'TblAppealInfo';
```

#### Output

```sql
MariaDB [shade]> SELECT ENGINE
    -> FROM information_schema.TABLES
    -> WHERE TABLE_SCHEMA = 'shade'
    -> AND TABLE_NAME = 'TblAppealInfo';
+--------+
| ENGINE |
+--------+
| MyISAM |
+--------+
1 row in set (0.01 sec)

MariaDB [shade]> 
```

#### Query to get the engine for all the tables in a schema

```sql
SELECT Table_name, ENGINE
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'shade';
```

#### Output

```sql
MariaDB [shade]> SELECT Table_name, ENGINE
    -> FROM information_schema.TABLES
    -> WHERE TABLE_SCHEMA = 'shade';
+-----------------------+--------+
| Table_name            | ENGINE |
+-----------------------+--------+
| ksftblcommunity       | InnoDB |
| ksftbldestitute       | InnoDB |
| ksftbldisability      | InnoDB |
| ksftblfamilydetails   | InnoDB |
| ksftblfamilymember    | InnoDB |
| ksftbllanddetails     | InnoDB |
| ksftblliteracy        | InnoDB |
| ksftbluser            | InnoDB |
| ksftblvillage         | InnoDB |
| raghstest             | MyISAM |
| shadetx               | MyISAM |
| tblappealinfo         | MyISAM |
| tblbeneficiary        | MyISAM |
| tblbookpermonth       | MyISAM |
| tblbookpermonthcoupon | MyISAM |
| tblbookpermonthvendor | MyISAM |
| tblcomments           | MyISAM |
| tblfeedback           | InnoDB |
| tblmasterappealstatus | MyISAM |
| tblmember             | MyISAM |
| tblraffledrawentry    | MyISAM |
| tblraffledrawinfo     | MyISAM |
| tblseverity           | MyISAM |
| tblstatus             | MyISAM |
| tbltask               | MyISAM |
| tbltxdetails          | MyISAM |
| tbluserlogin          | InnoDB |
| tblversionhistory     | InnoDB |
+-----------------------+--------+
28 rows in set (0.00 sec)

MariaDB [shade]> 
```

## Fix

Update the DB Engine from `MYISAM` to `INNODB`.

> *Note*: it is *_NOT_* recommended to do this on a large table on a busy production website without taking the site down first etc etc. 
  And, in the case of a large table, you are probably better to run the SQL query from the MySQL command line then using phpMyAdmin 
  in case of timeouts or other issues.

### Query

```sql
ALTER TABLE TblAppealInfo ENGINE = innodb;
```

### Output

```sql
MariaDB [shade]> ALTER TABLE TblAppealInfo ENGINE = innodb;
Query OK, 158 rows affected (0.04 sec)
Records: 158  Duplicates: 0  Warnings: 0

MariaDB [shade]> SELECT Table_name, ENGINE
    -> FROM information_schema.TABLES
    -> WHERE TABLE_SCHEMA = 'shade'
    -> AND TABLE_NAME = 'TblAppealInfo';
+---------------+--------+
| Table_name    | ENGINE |
+---------------+--------+
| tblappealinfo | InnoDB |
+---------------+--------+
1 row in set (0.00 sec)

MariaDB [shade]>
```

## Verification

```sql
MariaDB [shade]> DROP TABLE IF EXISTS TblBankAcct;
Query OK, 0 rows affected, 1 warning (0.00 sec)

MariaDB [shade]>
MariaDB [shade]> CREATE TABLE IF NOT EXISTS TblBankAcct
    -> (
    ->  Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ->  AppealId INT NOT NULL COMMENT 'The reference appeal if any',
    ->  Bank VARCHAR(25) NOT NULL COMMENT 'The Name of the Bank',
    ->  Branch VARCHAR(25) NOT NULL COMMENT 'The Branch of the Bank',
    ->  City VARCHAR(25) NOT NULL COMMENT 'The City where the Branch is located',
    ->  Address VARCHAR(150) DEFAULT NULL COMMENT 'The Postal Address of the Branch',
    ->  AcctNo VARCHAR(25) NOT NULL COMMENT 'The Actual Account Number with the Bank',
    ->  AcctType VARCHAR(25) NOT NULL COMMENT 'The Type of the Account - Savings, Current, Chequing etc.,',
    ->  IFSCCode VARCHAR(25) NOT NULL COMMENT 'The IFSC Code of the Branch',
    ->  NameRegd VARCHAR(100) NOT NULL COMMENT 'The Account Holders Name registered with the Bank',
    ->  VPA     VARCHAR(50) DEFAULT NULL COMMENT 'Virtual Private Address for the UPI (Unified Payment Interface) if any',
    ->  MobileRegd INT(10) COMMENT 'Mobile No registered with the Bank for the UPI payments',
    ->  Remarks VARCHAR(250) COMMENT 'Additional Remarks if any',
    ->  CREATED_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date by when the entry was created',
    ->  CREATED_BY VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT 'Who created the Record - captures the Name or SGXYZ Id',
    ->  MODIFIED_DATE DATETIME NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date by when the Entry was updated',
    ->  MODIFIED_BY VARCHAR(20) NULL DEFAULT 'SYSTEM' COMMENT 'Who Updated the Record - captures the Name or SGXYZ Id',
    ->  CONSTRAINT fK_TblBankAcct_1_AplId FOREIGN KEY(AppealId) REFERENCES TblAppealInfo(Id),
    ->  UNIQUE UK_TblBankAcct_1_AcctNo_IFSC (IFSCCode, AcctType, AcctNo)
    -> );
Query OK, 0 rows affected (0.02 sec)

MariaDB [shade]> desc TblBankAcct;
+---------------+--------------+------+-----+-------------------+-----------------------------+
| Field         | Type         | Null | Key | Default           | Extra                       |
+---------------+--------------+------+-----+-------------------+-----------------------------+
| Id            | int(11)      | NO   | PRI | NULL              | auto_increment              |
| AppealId      | int(11)      | NO   | MUL | NULL              |                             |
| Bank          | varchar(25)  | NO   |     | NULL              |                             |
| Branch        | varchar(25)  | NO   |     | NULL              |                             |
| City          | varchar(25)  | NO   |     | NULL              |                             |
| Address       | varchar(150) | YES  |     | NULL              |                             |
| AcctNo        | varchar(25)  | NO   |     | NULL              |                             |
| AcctType      | varchar(25)  | NO   |     | NULL              |                             |
| IFSCCode      | varchar(25)  | NO   | MUL | NULL              |                             |
| NameRegd      | varchar(100) | NO   |     | NULL              |                             |
| VPA           | varchar(50)  | YES  |     | NULL              |                             |
| MobileRegd    | int(10)      | YES  |     | NULL              |                             |
| Remarks       | varchar(250) | YES  |     | NULL              |                             |
| CREATED_DATE  | datetime     | NO   |     | CURRENT_TIMESTAMP |                             |
| CREATED_BY    | varchar(20)  | NO   |     | SYSTEM            |                             |
| MODIFIED_DATE | datetime     | YES  |     | NULL              | on update CURRENT_TIMESTAMP |
| MODIFIED_BY   | varchar(20)  | YES  |     | SYSTEM            |                             |
+---------------+--------------+------+-----+-------------------+-----------------------------+
17 rows in set (0.01 sec)

MariaDB [shade]> show create table TblBankAcct;
+-------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------+
| Table       | Create Table




                                                                                                                    |
+-------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------+
| TblBankAcct | CREATE TABLE `tblbankacct` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AppealId` int(11) NOT NULL COMMENT 'The reference appeal if any',
  `Bank` varchar(25) COLLATE utf8_bin NOT NULL COMMENT 'The Name of the Bank',
  `Branch` varchar(25) COLLATE utf8_bin NOT NULL COMMENT 'The Branch of the Bank',
  `City` varchar(25) COLLATE utf8_bin NOT NULL COMMENT 'The City where the Branch is located',
  `Address` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT 'The Postal Address of the Branch',
  `AcctNo` varchar(25) COLLATE utf8_bin NOT NULL COMMENT 'The Actual Account Number with the Bank',
  `AcctType` varchar(25) COLLATE utf8_bin NOT NULL COMMENT 'The Type of the Account - Savings, Current, Chequing etc.,',
  `IFSCCode` varchar(25) COLLATE utf8_bin NOT NULL COMMENT 'The IFSC Code of the Branch',
  `NameRegd` varchar(100) COLLATE utf8_bin NOT NULL COMMENT 'The Account Holders Name registered with the Bank',
  `VPA` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'Virtual Private Address for the UPI (Unified Payment Interface) if any',
  `MobileRegd` int(10) DEFAULT NULL COMMENT 'Mobile No registered with the Bank for the UPI payments',
  `Remarks` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT 'Additional Remarks if any',
  `CREATED_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date by when the entry was created',
  `CREATED_BY` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT 'SYSTEM' COMMENT 'Who created the Record - captures the Name or SGXYZ Id',
  `MODIFIED_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date by when the Entry was updated',
  `MODIFIED_BY` varchar(20) COLLATE utf8_bin DEFAULT 'SYSTEM' COMMENT 'Who Updated the Record - captures the Name or SGXYZ Id',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UK_TblBankAcct_1_AcctNo_IFSC` (`IFSCCode`,`AcctType`,`AcctNo`),
  KEY `fK_TblBankAcct_1_AplId` (`AppealId`),
  CONSTRAINT `fK_TblBankAcct_1_AplId` FOREIGN KEY (`AppealId`) REFERENCES `tblappealinfo` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin |
+-------------+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------+
1 row in set (0.00 sec)

MariaDB [shade]> 
```
## Verify the `CONSTRAINTS` table in the `INFORMATION_SCHEMA`.

There are two different Constraint tables in the Schema `INFORMATION_SCHEMA`.

```sql
MariaDB [shade]> use information_schema;
Database changed

MariaDB [information_schema]> show tables like '%Constraint%';
+---------------------------------------------+
| Tables_in_information_schema (%Constraint%) |
+---------------------------------------------+
| REFERENTIAL_CONSTRAINTS                     |
| TABLE_CONSTRAINTS                           |
+---------------------------------------------+
2 rows in set (0.00 sec)

MariaDB [information_schema]> desc TABLE_CONSTRAINTS;
+--------------------+--------------+------+-----+---------+-------+
| Field              | Type         | Null | Key | Default | Extra |
+--------------------+--------------+------+-----+---------+-------+
| CONSTRAINT_CATALOG | varchar(512) | NO   |     |         |       |
| CONSTRAINT_SCHEMA  | varchar(64)  | NO   |     |         |       |
| CONSTRAINT_NAME    | varchar(64)  | NO   |     |         |       |
| TABLE_SCHEMA       | varchar(64)  | NO   |     |         |       |
| TABLE_NAME         | varchar(64)  | NO   |     |         |       |
| CONSTRAINT_TYPE    | varchar(64)  | NO   |     |         |       |
+--------------------+--------------+------+-----+---------+-------+
6 rows in set (0.01 sec)

MariaDB [information_schema]> desc REFERENTIAL_CONSTRAINTS;
+---------------------------+--------------+------+-----+---------+-------+
| Field                     | Type         | Null | Key | Default | Extra |
+---------------------------+--------------+------+-----+---------+-------+
| CONSTRAINT_CATALOG        | varchar(512) | NO   |     |         |       |
| CONSTRAINT_SCHEMA         | varchar(64)  | NO   |     |         |       |
| CONSTRAINT_NAME           | varchar(64)  | NO   |     |         |       |
| UNIQUE_CONSTRAINT_CATALOG | varchar(512) | NO   |     |         |       |
| UNIQUE_CONSTRAINT_SCHEMA  | varchar(64)  | NO   |     |         |       |
| UNIQUE_CONSTRAINT_NAME    | varchar(64)  | YES  |     | NULL    |       |
| MATCH_OPTION              | varchar(64)  | NO   |     |         |       |
| UPDATE_RULE               | varchar(64)  | NO   |     |         |       |
| DELETE_RULE               | varchar(64)  | NO   |     |         |       |
| TABLE_NAME                | varchar(64)  | NO   |     |         |       |
| REFERENCED_TABLE_NAME     | varchar(64)  | NO   |     |         |       |
+---------------------------+--------------+------+-----+---------+-------+
11 rows in set (0.01 sec)

MariaDB [information_schema]> 
```

## Query to get the constraints of `TblBankAcct` Table from the 'INFORMATION_SCHEMA.TABLE_CONSTRAINTS' table

```sql
MariaDB [information_schema]> select * from INFORMATION_SCHEMA.TABLE_CONSTRAINTS WHERE CONSTRAINT_SCHEMA='shade' and UPPER(TABLE_NAME)=UPPER('TblBankAcct');
+--------------------+-------------------+------------------------------+--------------+-------------+-----------------+
| CONSTRAINT_CATALOG | CONSTRAINT_SCHEMA | CONSTRAINT_NAME              | TABLE_SCHEMA | TABLE_NAME  | CONSTRAINT_TYPE |
+--------------------+-------------------+------------------------------+--------------+-------------+-----------------+
| def                | shade             | PRIMARY                      | shade        | tblbankacct | PRIMARY KEY     |
| def                | shade             | UK_TblBankAcct_1_AcctNo_IFSC | shade        | tblbankacct | UNIQUE          |
| def                | shade             | fK_TblBankAcct_1_AplId       | shade        | tblbankacct | FOREIGN KEY     |
+--------------------+-------------------+------------------------------+--------------+-------------+-----------------+
3 rows in set (0.01 sec)

MariaDB [information_schema]>

```

## Query to get the constaints of `TblBankAcct` table from the `INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS` table

```sql
MariaDB [information_schema]> select * from INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS WHERE CONSTRAINT_SCHEMA='shade';
+--------------------+-------------------+------------------------+---------------------------+--------------------------+------------------------+--------------+-------------+---------
----+-------------+-----------------------+
| CONSTRAINT_CATALOG | CONSTRAINT_SCHEMA | CONSTRAINT_NAME        | UNIQUE_CONSTRAINT_CATALOG | UNIQUE_CONSTRAINT_SCHEMA | UNIQUE_CONSTRAINT_NAME | MATCH_OPTION | UPDATE_RULE | DELETE_R
ULE | TABLE_NAME  | REFERENCED_TABLE_NAME |
+--------------------+-------------------+------------------------+---------------------------+--------------------------+------------------------+--------------+-------------+---------
----+-------------+-----------------------+
| def                | shade             | fK_TblBankAcct_1_AplId | def                       | shade                    | PRIMARY                | NONE         | RESTRICT    | RESTRICT
    | tblbankacct | tblappealinfo         |
+--------------------+-------------------+------------------------+---------------------------+--------------------------+------------------------+--------------+-------------+---------
----+-------------+-----------------------+
1 row in set (0.00 sec)
```

*Query*

```sql
select 
	CONSTRAINT_CATALOG as Catalog, 
	CONSTRAINT_SCHEMA as C_Schema, 
	CONSTRAINT_NAME as C_Constraint, 
	UNIQUE_CONSTRAINT_CATALOG as UQC_CTLG, 
	UNIQUE_CONSTRAINT_SCHEMA as UQC_SCHEMA, 
	UNIQUE_CONSTRAINT_NAME as UQC_NAME,
	MATCH_OPTION as MatchOption,
	UPDATE_RULE, 
	TABLE_NAME,
	REFERENCED_TABLE_NAME
from 
	INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS 
WHERE 
	CONSTRAINT_SCHEMA='shade';
```

*Query Execution and Result*

```sql
MariaDB [information_schema]> select
    ->  CONSTRAINT_CATALOG as Catalog,
    ->  CONSTRAINT_SCHEMA as C_Schema,
    ->  CONSTRAINT_NAME as C_Constraint,
    ->  UNIQUE_CONSTRAINT_CATALOG as UQC_CTLG,
    ->  UNIQUE_CONSTRAINT_SCHEMA as UQC_SCHEMA,
    ->  UNIQUE_CONSTRAINT_NAME as UQC_NAME,
    ->  MATCH_OPTION as MatchOption,
    ->  UPDATE_RULE,
    ->  TABLE_NAME,
    ->  REFERENCED_TABLE_NAME
    -> from
    ->  INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS
    -> WHERE
    ->  CONSTRAINT_SCHEMA='shade';
+---------+----------+------------------------+----------+------------+----------+-------------+-------------+-------------+-----------------------+
| Catalog | C_Schema | C_Constraint           | UQC_CTLG | UQC_SCHEMA | UQC_NAME | MatchOption | UPDATE_RULE | TABLE_NAME  | REFERENCED_TABLE_NAME |
+---------+----------+------------------------+----------+------------+----------+-------------+-------------+-------------+-----------------------+
| def     | shade    | fK_TblBankAcct_1_AplId | def      | shade      | PRIMARY  | NONE        | RESTRICT    | tblbankacct | tblappealinfo         |
+---------+----------+------------------------+----------+------------+----------+-------------+-------------+-------------+-----------------------+
1 row in set (0.00 sec)

MariaDB [information_schema]>
```

## Attempt to update all the tables at one shot 

Attempted but it threw an error due to insufficient privileges. Perhaps I should have attempted with a `root` user, or after granting the necessary privileges to 
the currently logged in user `raghs` to modify the `INFORMATION_SCHEMA` database.

```sql
MariaDB [information_schema]> UPDATE INFORMATION_SCHEMA.TABLES SET ENGINE='InnoDB' WHERE TABLE_SCHEMA='shade' and TABLE_NAME LIKE 'tbl%' and ENGINE <> 'INNODB';
ERROR 1044 (42000): Access denied for user 'raghs'@'localhost' to database 'information_schema'
MariaDB [information_schema]>
```

*Root Access*

Even with the Root user, it was not successful! 

```sql
 12/05/2021   01:47.07   /drives/c/installedSoft/xampp/mysql/bin  cmd /c mysql -D shade -u root -p
Enter password: *************
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 37
Server version: 10.1.13-MariaDB mariadb.org binary distribution

Copyright (c) 2000, 2016, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [shade]> MariaDB [shade]> UPDATE INFORMATION_SCHEMA.TABLES SET ENGINE='InnoDB' WHERE TABLE_SCHEMA='shade' and TABLE_NAME LIKE 'tbl%' and ENGINE <> 'INNODB';
ERROR 1044 (42000): Access denied for user 'root'@'localhost' to database 'information_schema'
MariaDB [shade]>
```

*Further Steps*

 1. Check and grant the required privileges to the user for modifying the `INFORMATION_SCHEMA` database
 2. Use PhpMyAdmin tool to update this
 3. Use `ALTER' query for each of the tables, one after the other, which was working fine even for the User `raghs`.

### Queries gradual steps

```sql
MariaDB [information_schema]> desc tables;
+-----------------+---------------------+------+-----+---------+-------+
| Field           | Type                | Null | Key | Default | Extra |
+-----------------+---------------------+------+-----+---------+-------+
| TABLE_CATALOG   | varchar(512)        | NO   |     |         |       |
| TABLE_SCHEMA    | varchar(64)         | NO   |     |         |       |
| TABLE_NAME      | varchar(64)         | NO   |     |         |       |
| TABLE_TYPE      | varchar(64)         | NO   |     |         |       |
| ENGINE          | varchar(64)         | YES  |     | NULL    |       |
| VERSION         | bigint(21) unsigned | YES  |     | NULL    |       |
| ROW_FORMAT      | varchar(10)         | YES  |     | NULL    |       |
| TABLE_ROWS      | bigint(21) unsigned | YES  |     | NULL    |       |
| AVG_ROW_LENGTH  | bigint(21) unsigned | YES  |     | NULL    |       |
| DATA_LENGTH     | bigint(21) unsigned | YES  |     | NULL    |       |
| MAX_DATA_LENGTH | bigint(21) unsigned | YES  |     | NULL    |       |
| INDEX_LENGTH    | bigint(21) unsigned | YES  |     | NULL    |       |
| DATA_FREE       | bigint(21) unsigned | YES  |     | NULL    |       |
| AUTO_INCREMENT  | bigint(21) unsigned | YES  |     | NULL    |       |
| CREATE_TIME     | datetime            | YES  |     | NULL    |       |
| UPDATE_TIME     | datetime            | YES  |     | NULL    |       |
| CHECK_TIME      | datetime            | YES  |     | NULL    |       |
| TABLE_COLLATION | varchar(32)         | YES  |     | NULL    |       |
| CHECKSUM        | bigint(21) unsigned | YES  |     | NULL    |       |
| CREATE_OPTIONS  | varchar(2048)       | YES  |     | NULL    |       |
| TABLE_COMMENT   | varchar(2048)       | NO   |     |         |       |
+-----------------+---------------------+------+-----+---------+-------+
21 rows in set (0.01 sec)

MariaDB [information_schema]> select TABLE_SCHEMA, TABLE_NAME, TABLE_TYPE, ENGINE from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='shade';
+--------------+-----------------------+------------+--------+
| TABLE_SCHEMA | TABLE_NAME            | TABLE_TYPE | ENGINE |
+--------------+-----------------------+------------+--------+
| shade        | ksftblcommunity       | BASE TABLE | InnoDB |
| shade        | ksftbldestitute       | BASE TABLE | InnoDB |
| shade        | ksftbldisability      | BASE TABLE | InnoDB |
| shade        | ksftblfamilydetails   | BASE TABLE | InnoDB |
| shade        | ksftblfamilymember    | BASE TABLE | InnoDB |
| shade        | ksftbllanddetails     | BASE TABLE | InnoDB |
| shade        | ksftblliteracy        | BASE TABLE | InnoDB |
| shade        | ksftbluser            | BASE TABLE | InnoDB |
| shade        | ksftblvillage         | BASE TABLE | InnoDB |
| shade        | raghstest             | BASE TABLE | MyISAM |
| shade        | shadetx               | BASE TABLE | MyISAM |
| shade        | tblappealinfo         | BASE TABLE | InnoDB |
| shade        | tblbankacct           | BASE TABLE | InnoDB |
| shade        | tblbeneficiary        | BASE TABLE | MyISAM |
| shade        | tblbookpermonth       | BASE TABLE | MyISAM |
| shade        | tblbookpermonthcoupon | BASE TABLE | MyISAM |
| shade        | tblbookpermonthvendor | BASE TABLE | MyISAM |
| shade        | tblcomments           | BASE TABLE | MyISAM |
| shade        | tblfeedback           | BASE TABLE | InnoDB |
| shade        | tblmasterappealstatus | BASE TABLE | MyISAM |
| shade        | tblmember             | BASE TABLE | MyISAM |
| shade        | tblraffledrawentry    | BASE TABLE | MyISAM |
| shade        | tblraffledrawinfo     | BASE TABLE | MyISAM |
| shade        | tblseverity           | BASE TABLE | MyISAM |
| shade        | tblstatus             | BASE TABLE | MyISAM |
| shade        | tbltask               | BASE TABLE | MyISAM |
| shade        | tbltxdetails          | BASE TABLE | MyISAM |
| shade        | tbluserlogin          | BASE TABLE | InnoDB |
| shade        | tblversionhistory     | BASE TABLE | InnoDB |
+--------------+-----------------------+------------+--------+
29 rows in set (0.00 sec)

MariaDB [information_schema]> select TABLE_SCHEMA, TABLE_NAME, TABLE_TYPE, ENGINE from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='shade' and TABLE_NAME LIKE 'tbl%';
+--------------+-----------------------+------------+--------+
| TABLE_SCHEMA | TABLE_NAME            | TABLE_TYPE | ENGINE |
+--------------+-----------------------+------------+--------+
| shade        | tblappealinfo         | BASE TABLE | InnoDB |
| shade        | tblbankacct           | BASE TABLE | InnoDB |
| shade        | tblbeneficiary        | BASE TABLE | MyISAM |
| shade        | tblbookpermonth       | BASE TABLE | MyISAM |
| shade        | tblbookpermonthcoupon | BASE TABLE | MyISAM |
| shade        | tblbookpermonthvendor | BASE TABLE | MyISAM |
| shade        | tblcomments           | BASE TABLE | MyISAM |
| shade        | tblfeedback           | BASE TABLE | InnoDB |
| shade        | tblmasterappealstatus | BASE TABLE | MyISAM |
| shade        | tblmember             | BASE TABLE | MyISAM |
| shade        | tblraffledrawentry    | BASE TABLE | MyISAM |
| shade        | tblraffledrawinfo     | BASE TABLE | MyISAM |
| shade        | tblseverity           | BASE TABLE | MyISAM |
| shade        | tblstatus             | BASE TABLE | MyISAM |
| shade        | tbltask               | BASE TABLE | MyISAM |
| shade        | tbltxdetails          | BASE TABLE | MyISAM |
| shade        | tbluserlogin          | BASE TABLE | InnoDB |
| shade        | tblversionhistory     | BASE TABLE | InnoDB |
+--------------+-----------------------+------------+--------+
18 rows in set (0.01 sec)

MariaDB [information_schema]> UPDATE INFORMATION_SCHEMA.TABLES SET ENGINE='InnoDB' WHERE TABLE_SCHEMA='shade' and TABLE_NAME LIKE 'tbl%' and ENGINE <> 'INNODB';
ERROR 1044 (42000): Access denied for user 'raghs'@'localhost' to database 'information_schema'
MariaDB [information_schema]>
```


## Reference 

 * https://stackoverflow.com/questions/49220697/errno-150-foreign-key-constraint-is-incorrectly-formed
 * https://stackoverflow.com/questions/37939255/why-is-this-foreign-key-constraint-incorrectly-formed
 * Direct Ref to the solution : https://stackoverflow.com/a/63941745/1001242
 * https://mariadb.org/mariadb-innodb-foreign-key-constraint-errors/
 * https://electrictoolbox.com/mysql-table-storage-engine/
 * https://electrictoolbox.com/mysql-change-table-storage-engine/
 * https://stackoverflow.com/questions/4233816/what-are-mysql-database-engines
 * https://www.mysqltutorial.org/mysql-change-storage-engine/