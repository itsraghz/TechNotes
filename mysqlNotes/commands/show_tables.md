# Show tables

 The `show tables` command lists down the tables in the selected database. Remember, it treats the views also as a table and lists down. If you want to know the type as well, you should use `show full table` command.  

## Syntax

 The Syntax is : `show tables`. 

 *Note*: Ensure you use the `use <database>` command to get yourself switched on to the preferred database of your choice.

## Examples

```
MariaDB [mysql]> use itsraghz;
Database changed
MariaDB [itsraghz]> show tables;
+------------------------------------------------+
| Tables_in_itsraghz                             |
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
42 rows in set (0.00 sec)

MariaDB [itsraghz]>
```
