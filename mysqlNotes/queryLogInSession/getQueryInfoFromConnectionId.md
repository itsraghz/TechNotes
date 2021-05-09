# Get Query Log from the CONNECTION_ID System Variable

The below SQL query and results explains the steps involved in getting to know the current `connection id` via the MySQL System Variable `CONNECTION_ID` which can be obtained in any of the two different ways.

 * SHOW CONNECTION_ID
 * SHOW CONNECTION_ID() FROM DUAL;


## SQL Query Execution and Results

```sql
mysql -D itsraghz --user=raghs --password=RaghsMySQL12#
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 340
Server version: 10.1.13-MariaDB mariadb.org binary distribution

Copyright (c) 2000, 2016, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [itsraghz]> show processlist;
+-----+-------+-----------------+----------+---------+------+------------------+------------------+----------+
| Id  | User  | Host            | db       | Command | Time | State            | Info             | Progress |
+-----+-------+-----------------+----------+---------+------+------------------+------------------+----------+
|  27 | raghs | localhost:50834 | itsraghz | Sleep   |  253 |                  | NULL             |    0.000 |
| 340 | raghs | localhost:49963 | itsraghz | Query   |    0 | Unlocking tables | show processlist |    0.000 |
+-----+-------+-----------------+----------+---------+------+------------------+------------------+----------+
2 rows in set (0.00 sec)

MariaDB [itsraghz]> select count(*) from mysql.general_log;
+----------+
| count(*) |
+----------+
|     2790 |
+----------+
1 row in set (0.03 sec)

MariaDB [itsraghz]> select count(*) from mysql.general_log where thread_id=340;
+----------+
| count(*) |
+----------+
|        5 |
+----------+
1 row in set (0.03 sec)

MariaDB [itsraghz]> select * from mysql.general_log where thread_id=340;
+---------------------+--------------------------------+-----------+-----------+--------------+------------------------------------------------------------+
| event_time          | user_host                      | thread_id | server_id | command_type | argument                                                   |
+---------------------+--------------------------------+-----------+-----------+--------------+------------------------------------------------------------+
| 2021-05-09 23:52:13 | [raghs] @ localhost [::1]      |       340 |         1 | Connect      | raghs@localhost as anonymous on itsraghz                   |
| 2021-05-09 23:52:13 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | select @@version_comment limit 1                           |
| 2021-05-09 23:52:19 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | show processlist                                           |
| 2021-05-09 23:52:40 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | select count(*) from mysql.general_log                     |
| 2021-05-09 23:52:47 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | select count(*) from mysql.general_log where thread_id=340 |
| 2021-05-09 23:53:03 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | select * from mysql.general_log where thread_id=340        |
+---------------------+--------------------------------+-----------+-----------+--------------+------------------------------------------------------------+
6 rows in set (0.05 sec)

MariaDB [itsraghz]> select Id, user, host, db, command, info from INFORMATION_SCHEMA.PROCESSLIST where USER='raghs';
+-----+-------+-----------------+----------+---------+-------------------------------------------------------------------------------------------------+
| Id  | user  | host            | db       | command | info                                                                                            |
+-----+-------+-----------------+----------+---------+-------------------------------------------------------------------------------------------------+
| 340 | raghs | localhost:49963 | itsraghz | Query   | select Id, user, host, db, command, info from INFORMATION_SCHEMA.PROCESSLIST where USER='raghs' |
|  27 | raghs | localhost:50834 | itsraghz | Sleep   | NULL                                                                                            |
+-----+-------+-----------------+----------+---------+-------------------------------------------------------------------------------------------------+
2 rows in set (0.01 sec)

MariaDB [itsraghz]> status
--------------
mysql  Ver 15.1 Distrib 10.1.13-MariaDB, for Win32 (AMD64)

Connection id:          340
Current database:       itsraghz
Current user:           raghs@localhost
SSL:                    Not in use
Using delimiter:        ;
Server:                 MariaDB
Server version:         10.1.13-MariaDB mariadb.org binary distribution
Protocol version:       10
Connection:             localhost via TCP/IP
Server characterset:    latin1
Db     characterset:    utf16
Client characterset:    cp850
Conn.  characterset:    cp850
TCP port:               3306
Uptime:                 6 hours 30 min 42 sec

Threads: 2  Questions: 2713  Slow queries: 0  Opens: 62  Flush tables: 1  Open tables: 72  Queries per second avg: 0.115
--------------

-- MariaDB [itsraghz]>  select distinct a.* from mysql.general_log a where a.thread_id IN (select connection_id() from dual);

MariaDB [itsraghz]> select distinct a.* from mysql.general_log a where a.thread_id IN (select connection_id() from dual) LIMIT 1;
+---------------------+---------------------------+-----------+-----------+--------------+------------------------------------------+
| event_time          | user_host                 | thread_id | server_id | command_type | argument                                 |
+---------------------+---------------------------+-----------+-----------+--------------+------------------------------------------+
| 2021-05-09 23:52:13 | [raghs] @ localhost [::1] |       340 |         1 | Connect      | raghs@localhost as anonymous on itsraghz |
+---------------------+---------------------------+-----------+-----------+--------------+------------------------------------------+
1 row in set (0.07 sec)

MariaDB [itsraghz]> select distinct a.* from mysql.general_log a where a.thread_id IN (select connection_id() from dual) LIMIT 6;
+---------------------+--------------------------------+-----------+-----------+--------------+------------------------------------------------------------+
| event_time          | user_host                      | thread_id | server_id | command_type | argument                                                   |
+---------------------+--------------------------------+-----------+-----------+--------------+------------------------------------------------------------+
| 2021-05-09 23:52:13 | [raghs] @ localhost [::1]      |       340 |         1 | Connect      | raghs@localhost as anonymous on itsraghz                   |
| 2021-05-09 23:52:13 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | select @@version_comment limit 1                           |
| 2021-05-09 23:52:19 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | show processlist                                           |
| 2021-05-09 23:52:40 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | select count(*) from mysql.general_log                     |
| 2021-05-09 23:52:47 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | select count(*) from mysql.general_log where thread_id=340 |
| 2021-05-09 23:53:03 | raghs[raghs] @ localhost [::1] |       340 |         1 | Query        | select * from mysql.general_log where thread_id=340        |
+---------------------+--------------------------------+-----------+-----------+--------------+------------------------------------------------------------+
6 rows in set (0.07 sec)

MariaDB [itsraghz]>
```

A more refined query fitting the page would be as follows.

*Query*: `select distinct a.event_time, substr(a.user_host, 1,30) as user_host, substr(a.thread_id, 1, 5) as thread, substr(a.server_id, 1, 5) as server, substr(a.command_type
, 1, 8) as CMDType, substr(a.argument,1,60) as argument from mysql.general_log a where a.thread_id IN (select connection_id() from dual);`

*Query Result* : Added a `LIMIT 6 clause` for the brevity.


```sql

MariaDB [itsraghz]> select distinct a.event_time, substr(a.user_host, 1,30) as user_host, substr(a.thread_id, 1, 5) as thread, substr(a.server_id, 1, 5) as server, substr(a.command_type
, 1, 8) as CMDType, substr(a.argument,1,60) as argument from mysql.general_log a where a.thread_id IN (select connection_id() from dual) LIMIT 6;
+---------------------+--------------------------------+--------+--------+---------+------------------------------------------------------------+
| event_time          | user_host                      | thread | server | CMDType | argument                                                   |
+---------------------+--------------------------------+--------+--------+---------+------------------------------------------------------------+
| 2021-05-09 23:52:13 | [raghs] @ localhost [::1]      | 340    | 1      | Connect | raghs@localhost as anonymous on itsraghz                   |
| 2021-05-09 23:52:13 | raghs[raghs] @ localhost [::1] | 340    | 1      | Query   | select @@version_comment limit 1                           |
| 2021-05-09 23:52:19 | raghs[raghs] @ localhost [::1] | 340    | 1      | Query   | show processlist                                           |
| 2021-05-09 23:52:40 | raghs[raghs] @ localhost [::1] | 340    | 1      | Query   | select count(*) from mysql.general_log                     |
| 2021-05-09 23:52:47 | raghs[raghs] @ localhost [::1] | 340    | 1      | Query   | select count(*) from mysql.general_log where thread_id=340 |
| 2021-05-09 23:53:03 | raghs[raghs] @ localhost [::1] | 340    | 1      | Query   | select * from mysql.general_log where thread_id=340        |
+---------------------+--------------------------------+--------+--------+---------+------------------------------------------------------------+
6 rows in set (0.05 sec)

MariaDB [itsraghz]>
```
