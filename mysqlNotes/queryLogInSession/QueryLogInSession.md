# How to get the queries stored in the current session?

 We will look at the necessary data in the following subsections.

 * Pre-requisites
 * The precursory data
 * Actual Query to get the desired query history

## References
 
  * https://dev.mysql.com/doc/refman/8.0/en/show-variables.html
  * https://stackoverflow.com/questions/303994/log-all-queries-in-mysql
  * https://www.thegeekstuff.com/2010/01/disable-mysql-history-clear-mysql_history-and-mysql_histfile/
  * https://alvinalexander.com/blog/post/mysql/how-show-open-database-connections-mysql/
  * https://stackoverflow.com/questions/7432241/mysql-show-status-active-or-total-connections
  * https://stackoverflow.com/questions/3613704/mysql-show-current-connection-info/8155601

## Prerequisites

 There are so many ways you can log the queries being used in the current MySQL Session. 
 We can use the `tee` command to log all the queries and the output as well into a log file, which we can see it later in detail.
 This article is to explain the steps within MySQL to store the queries being fired. 

 We need to enable a setting in MySQL Server to facilitate the logging of the queries as follows.

 We can do so in two different fashions - File leve, or the DB table level. 

### Enable Logging at the File level

You can use any file extension  - like `.log`, `.txt` etc., 

```sql
mysql> SET GLOBAL general_log = 'ON';
mysql> SET GLOBAL general_log_file = '/path/to/log/queries.log';
```

> Note: The path specified shoudl be resolved to the proper file system path and the MySQL process should have RW access to it. Kindly ensure that!

### Enable Logging at the Table Level

```sql
mysql> SET GLOBAL general_log = 'ON';
mysql> SET global log_output = 'table';
```
### Queries to see the Server Variables (Settings)

```sql
mysql> SHOW VARIABLES; -- general query to see all the variables
mysql> SHOW VARIABLES LIKE '%log%'; -- a specific query to filter out the variables whose name has the text 'log' in it
mysql> SHOW VARIABLES LIKE '%general%log%; -- even more specific query to restrict the output
```

#### Sample Query Output

A sample output shows the status of my MySQL Server as below

```sql
MariaDB [itsraghz]> show variables like '%general%log%';
+------------------+---------------------------+
| Variable_name    | Value                     |
+------------------+---------------------------+
| general_log      | ON                        |
| general_log_file | Raghs-LegionY540-TPIN.log |
+------------------+---------------------------+
2 rows in set (0.00 sec)

MariaDB [itsraghz]>

```

## The precursory data

If we enabled the log (query history) to be saved in the Tables, MySQL gets them recorded in a special called `general_log` inside the schema `mysql`. We should query the table in the uusual format as follows.

```sql
mysql> SELECT * FROM MYSQL.GENERAL_LOG;
```

Let us take a look at the schema of this table, to have a better understanding of the columns being available and what values they could take. 

```sql
MariaDB [itsraghz]> DESC MYSQL.GENERAL_LOG;
+--------------+---------------------+------+-----+-------------------+-----------------------------+
| Field        | Type                | Null | Key | Default           | Extra                       |
+--------------+---------------------+------+-----+-------------------+-----------------------------+
| event_time   | timestamp           | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
| user_host    | mediumtext          | NO   |     | NULL              |                             |
| thread_id    | bigint(21) unsigned | NO   |     | NULL              |                             |
| server_id    | int(10) unsigned    | NO   |     | NULL              |                             |
| command_type | varchar(64)         | NO   |     | NULL              |                             |
| argument     | mediumtext          | NO   |     | NULL              |                             |
+--------------+---------------------+------+-----+-------------------+-----------------------------+
6 rows in set (0.01 sec)

MariaDB [itsraghz]>
```

Though most of the columnns are self explanatory, I would like to emphasize on the `thread_id` column which is very helpful and we should be relying on this colummn to bifurcate the queries fired in a particular session, on demand. 

> Note: Interesting piece to note here is that MySQL logs all queries into the `MYSQL.GENERAL_LOG` table irrespective of the status/results, even if the query had a compilation or syntax error. It just logs all the queries *attempted* and NOT just the successfully executed queries.

In order to fetch the queries pertaining to the current session, we need to filter them with the right `thread_id` which can be obtained in any of the 2 ways.

 * `INFORMATION_SCHEMA.PROCESSLIST` table which has the `Id` column - for the `thread_id`
 * `CONNECTION_ID` Server Variable or `CONNECTION_ID()` helper method.

 > Preferred way is to query the `SELECT CONNECTION_ID() FROM DUAL;` as it is 100% matching with the *current* session in effect, the only best way is to filter out the records in the `PROCESSLIST` table with the `user` column and it gets defeated when the same user has created more than one session with MySQL via different terminals.
> Of Course, you can still take help from the `COMMAND_TYPE` column which can either be of `Sleep` or `Query` mode, depends on the last used time of the session, but again it is *not* 100% guaranteed. Better to go with the `CONNECTION_ID` value instead. 

## Actual query to get the desired query history

```sql
select distinct a.* from mysql.general_log a, information_schema.processlist b where a.thread_id=b.Id and b.user='raghs';
```

A better query would be 

```sql
select distinct a.* from mysql.general_log a where a.thread_id IN (select connection_id() from dual);
```

And a refined version of this query is as follows

```sql
select distinct a.event_time, substr(a.user_host, 1,30) as user_host, substr(a.thread_id, 1, 5) as thread, substr(a.server_id, 1, 5) as server, substr(a.command_type
, 1, 8) as CMDType, substr(a.argument,1,60) as argument from mysql.general_log a where a.thread_id IN (select connection_id() from dual);
```

### Sample Ouptut

```sql

MariaDB [itsraghz]> select distinct a.event_time, substr(a.user_host, 1,30) as user_host, substr(a.thread_id, 1, 5) as thread, substr(a.server_id, 1, 5) as server, substr(a.command_type

    -> , 1, 8) as CMDType, substr(a.argument,1,60) as argument from mysql.general_log a where a.thread_id IN (select connection_id() from dual);
    +---------------------+--------------------------------+--------+--------+----------+--------------------------------------------------------------+
    | event_time          | user_host                      | thread | server | CMDType  | argument                                                     |
    +---------------------+--------------------------------+--------+--------+----------+--------------------------------------------------------------+
    | 2021-05-09 17:56:02 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log                              |
    | 2021-05-09 17:56:12 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show tables                                                  |
    | 2021-05-09 17:56:15 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log                              |
    | 2021-05-09 17:56:44 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show variables LIKE 'general%log%'                           |
    | 2021-05-09 18:05:31 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select TxId, DateOfTx, Substr(Beneficiary, 1, 10) as Benefic |
    | 2021-05-09 18:05:38 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log                              |
    | 2021-05-09 18:05:51 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_logg                             |
    | 2021-05-09 18:05:54 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log                              |
    | 2021-05-09 18:14:02 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select TxId, DateOfTx, Substr(Beneficiary, 1, 10) as Benefic |
    | 2021-05-09 18:16:35 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select TxId, DateOfTx, Substr(Beneficiary, 1, 10) as Benefic |
    | 2021-05-09 18:17:05 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select TxId, DateOfTx, Substr(Beneficiary, 1, 10) as Benefic |
    | 2021-05-09 19:27:07 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select TxId, DateOfTx, Substr(Beneficiary, 1, 10) as Benefic |
    | 2021-05-09 19:49:05 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show variables LIKE 'general%log%'                           |
    | 2021-05-09 19:49:09 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log                              |
    | 2021-05-09 19:49:47 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log                              |
    | 2021-05-09 19:53:08 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | desc mysql.general_log                                       |
    | 2021-05-09 19:53:28 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from myqsl.general_log where user_host like '%raghs |
    | 2021-05-09 19:53:30 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from myqsl.general_log where user_host like '%raghs |
    | 2021-05-09 19:53:40 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log where user_host like '%raghs |
    | 2021-05-09 20:29:37 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select distinct session_id from mysql.general_log            |
    | 2021-05-09 20:29:47 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | desc mysql.general_log                                       |
    | 2021-05-09 20:30:04 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select distinct thread_id from mysql.general_log             |
    | 2021-05-09 20:32:28 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show status where variable_name = 'threads_connected'        |
    | 2021-05-09 20:32:40 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show processlist                                             |
    | 2021-05-09 20:32:57 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show status where variable_name = 'threads_connected'        |
    | 2021-05-09 20:33:03 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show processlist                                             |
    | 2021-05-09 22:02:41 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show processlist                                             |
    | 2021-05-09 22:02:43 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show status where variable_name = 'threads_connected'        |
    | 2021-05-09 22:04:04 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select TxId, DateOfTx, Substr(Beneficiary, 1, 10) as Benefic |
    | 2021-05-09 22:50:08 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select TxId, DateOfTx, Substr(Beneficiary, 1, 10) as Benefic |
    | 2021-05-09 22:50:12 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log                              |
    | 2021-05-09 22:53:32 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | desc mysql.general_log                                       |
    | 2021-05-09 22:53:50 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select distinct server_id from mysql.general_log             |
    | 2021-05-09 22:56:12 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | SELECT * from sys.session                                    |
    | 2021-05-09 22:56:36 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show status like 'Conn%'                                     |
    | 2021-05-09 22:58:23 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show status like '%onn%'                                     |
    | 2021-05-09 22:58:55 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show processlist                                             |
    | 2021-05-09 22:59:30 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log where thread_id=27           |
    | 2021-05-09 22:59:55 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show ID from processlist                                     |
    | 2021-05-09 22:59:59 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show processlist                                             |
    | 2021-05-09 23:00:45 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | SELECT USER()                                                |
    | 2021-05-09 23:00:51 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | SELECT DATABASE()                                            |
    | 2021-05-09 23:00:58 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select DATABASE(), USER() limit 1                            |
    | 2021-05-09 23:00:58 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select @@character_set_client, @@character_set_connection, @ |
    | 2021-05-09 23:00:58 | raghs[raghs] @ localhost [::1] | 27     | 1      | Statisti |                                                              |
    | 2021-05-09 23:02:14 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show status where `variable_name` = 'Threads_connected'      |
    | 2021-05-09 23:02:57 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | SHOW STATUS WHERE `variable_name` = 'Max_used_connections'   |
    | 2021-05-09 23:03:06 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show session status                                          |
    | 2021-05-09 23:03:14 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show global status                                           |
    | 2021-05-09 23:24:59 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log where thread_id=27           |
    | 2021-05-09 23:25:41 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | SELECT DATABASE()                                            |
    | 2021-05-09 23:25:41 | raghs[raghs] @ localhost [::1] | 27     | 1      | Init DB  | information_schema                                           |
    | 2021-05-09 23:25:43 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show tables                                                  |
    | 2021-05-09 23:25:53 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show tables like '%process%'                                 |
    | 2021-05-09 23:25:58 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | desc processlist                                             |
    | 2021-05-09 23:26:05 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from processlist                                    |
    | 2021-05-09 23:26:33 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from INFORMATION_SCHEMA.PROCESS_LIST where USER='ra |
    | 2021-05-09 23:26:39 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from INFORMATION_SCHEMA.PROCESSLIST where USER='rag |
    | 2021-05-09 23:27:18 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select Id, user, host, db, command, info from INFORMATION_SC |
    | 2021-05-09 23:27:26 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | SELECT DATABASE()                                            |
    | 2021-05-09 23:27:26 | raghs[raghs] @ localhost [::1] | 27     | 1      | Init DB  | itsraghz                                                     |
    | 2021-05-09 23:27:34 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log where thread_id=27           |
    | 2021-05-09 23:28:23 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log a, information_schema.proces |
    | 2021-05-09 23:28:48 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select * from mysql.general_log a, information_schema.proces |
    | 2021-05-09 23:29:02 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select distinct thread_id from mysql.general_log a, informat |
    | 2021-05-09 23:29:36 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select a.* from mysql.general_log a, information_schema.proc |
    | 2021-05-09 23:29:43 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select distinct a.* from mysql.general_log a, information_sc |
    | 2021-05-09 23:42:27 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show variables like '%log%'                                  |
    | 2021-05-09 23:42:35 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | show variables like '%general%log%'                          |
    | 2021-05-09 23:47:48 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select distinct a.* from mysql.general_log a, information_sc |
    | 2021-05-09 23:48:05 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | DESC MYSQL.GENERAL_LOG                                       |
    | 2021-05-10 00:25:26 | raghs[raghs] @ localhost [::1] | 27     | 1      | Query    | select distinct a.event_time, substr(a.user_host, 1,30) as u |
    +---------------------+--------------------------------+--------+--------+----------+--------------------------------------------------------------+
    72 rows in set (0.04 sec)

    MariaDB [itsraghz]>
```
