# mysqlshow

This command is an executable available in the mysql bin directory and shows the statistics on the tables, views etc., based on the privileges you have.

## Syntax

 The Syntax for the command is `mysqlshow [OPTIONS] [database [table [column]]]`

## Examples

```
C:\Users\ragha                                                                                                                                              
¿ mysqlshow                                                                                                                                                 
+--------------------+                                                                                                                                      
|     Databases      |                                                                                                                                      
+--------------------+                                                                                                                                      
| information_schema |                                                                                                                                      
| test               |                                                                                                                                      
+--------------------+                                                                                                                                      
                                                                                                                                                            
C:\Users\ragha                                                                                                                                              
¿ mysqlshow test                                                                                                                                            
Database: test                                                                                                                                              
+------------------+                                                                                                                                        
|      Tables      |                                                                                                                                        
+------------------+                                                                                                                                        
| groovyscripttest |                                                                                                                                        
+------------------+                                                                                                                                        
                                                                                                                                                            
C:\Users\ragha                                                                                                                                              
¿ mysqlshow test groovyscripttest                                                                                                                           
Database: test  Table: groovyscripttest                                                                                                                     
+--------------+-------------+-------------------+------+-----+-------------------+----------------+---------------------------------+---------+            
| Field        | Type        | Collation         | Null | Key | Default           | Extra          | Privileges                      | Comment |            
+--------------+-------------+-------------------+------+-----+-------------------+----------------+---------------------------------+---------+            
| Id           | int(11)     |                   | NO   | PRI |                   | auto_increment | select,insert,update,references |         |            
| NAME         | varchar(30) | latin1_swedish_ci | YES  |     |                   |                | select,insert,update,references |         |            
| COUNTRY      | varchar(20) | latin1_swedish_ci | YES  |     |                   |                | select,insert,update,references |         |            
| PRICE        | float(8,2)  |                   | YES  |     |                   |                | select,insert,update,references |         |            
| CURRENCY     | varchar(3)  | latin1_swedish_ci | YES  |     |                   |                | select,insert,update,references |         |            
| PAYMENT_MODE | varchar(10) | latin1_swedish_ci | YES  |     |                   |                | select,insert,update,references |         |            
| ORDER_DATE   | datetime    |                   | YES  |     | CURRENT_TIMESTAMP |                | select,insert,update,references |         |            
+--------------+-------------+-------------------+------+-----+-------------------+----------------+---------------------------------+---------+            
                                                                                                                                                            
C:\Users\ragha                                                                                                                                              
¿                                                                                                                                                           
                                                                                                                                                            
```

## Using with a different username and password credentials

 You can supply the username with the `-u` argument and the password with the `-p` similar to the `mysql` command.

```
C:\Users\ragha
¿ mysqlshow -u raghs -p
Enter password: \*\*\*\*\*\*\*\*\*\*\*\*\*
+--------------------+
|     Databases      |
+--------------------+
| angularphpdb       |
| easytodo           |
| emerald_butterfly  |
| hibernatedb        |
| information_schema |
| itsraghz           |
| mysql              |
| performance_schema |
| phpmyadmin         |
| python_mysql_demo  |
| shade              |
| simpletodo         |
| tamiltest          |
| test               |
+--------------------+

C:\Users\ragha
¿ mysqlshow -u raghs -p itsraghz
Enter password: \*\*\*\*\*\*\*\*\*\*\*\*\*
Database: itsraghz
+------------------------------------------------+
|                     Tables                     |
+------------------------------------------------+
| bkup_wrongdmlupated4address_tblexpenses11jul19 |
| blobtest                                       |
| blog                                           |
| creditcardreportmonthlytxdetailsvw             |
| creditcardreportmonthlytxsummaryvw             |
| ctstimesheet                                   |
| persons                                        |
| tbladdress                                     |
| tblbankacct                                    |
| tblbankpayment                                 |
| tblbankschedule                                |
| tblcreditcardcycle                             |
| tblebookperday                                 |
| tblemployee                                    |
| tblexpensepayment                              |
| tblexpensepaymentoct16                         |
| tblexpenses                                    |
| tblexpenses11jul19                             |
| tblexpenses20dec19                             |
| tblexpensesmonitoapp                           |
| tblexpensesoct16                               |
| tblexpensesoct16temp                           |
| tblexpensessep16                               |
| tblpasswordhistory                             |
| tblpasswordhistorytest                         |
| tblprfarticle                                  |
| tblprffeedback                                 |
| tblprflecturedetails                           |
| tblsecretqa                                    |
| tblsubscription                                |
| tbltask                                        |
| tbltaskcategory                                |
| tbltaskcategory2                               |
| tbltaskcategory3                               |
| tbltaskstatus                                  |
| tbltempevents                                  |
| tbluser                                        |
| temple_act_get_tx_details_vw                   |
| temple_act_tx_summary_vw                       |
| test                                           |
| testtblexpenses                                |
| users                                          |
+------------------------------------------------+

C:\Users\ragha
¿ mysqlshow -u raghs -p itsraghz tbladdress
Enter password: \*\*\*\*\*\*\*\*\*\*\*\*\*
Database: itsraghz  Table: tbladdress
+-----------+--------------+------------------+------+-----+-----------+-------+---------------------------------+--------------------------------------+
| Field     | Type         | Collation        | Null | Key | Default   | Extra | Privileges                      | Comment                              |
+-----------+--------------+------------------+------+-----+-----------+-------+---------------------------------+--------------------------------------+
| Id        | int(11)      |                  | NO   |     |           |       | select,insert,update,references |                                      |
| Country   | varchar(40)  | utf16_unicode_ci | YES  |     | India     |       | select,insert,update,references |                                      |
| City      | varchar(40)  | utf16_unicode_ci | YES  |     | Bangalore |       | select,insert,update,references |                                      |
| Place     | varchar(40)  | utf16_unicode_ci | YES  |     |           |       | select,insert,update,references |                                      |
| ShopName  | varchar(40)  | utf16_unicode_ci | YES  |     |           |       | select,insert,update,references |                                      |
| Area      | varchar(40)  | utf16_unicode_ci | YES  |     |           |       | select,insert,update,references |                                      |
| Landmark  | varchar(40)  | utf16_unicode_ci | YES  |     |           |       | select,insert,update,references |                                      |
| ShortName | varchar(100) | utf16_unicode_ci | NO   |     |           |       | select,insert,update,references | Unique name to identify this address |
| Remarks   | varchar(100) | utf16_unicode_ci | YES  |     |           |       | select,insert,update,references |                                      |
| IsDeleted | char(1)      | utf16_unicode_ci | YES  |     | N         |       | select,insert,update,references |                                      |
+-----------+--------------+------------------+------+-----+-----------+-------+---------------------------------+--------------------------------------+

C:\Users\ragha
¿
```


