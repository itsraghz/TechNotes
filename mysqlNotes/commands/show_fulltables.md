# Show Full table

 The `show full table` command helps you to view the table names and the type of each table - Base Table, View, Procedure etc., 

## Syntax

 The Syntax is : `show full table`. 

 *Note*: Ensure you use the `use <database>` command to get yourself switched on to the preferred database of your choice.

## Examples

```
MariaDB [itsraghz]> use itsraghz;
Database changed.
MariaDB [itsraghz]> show full tables;
+------------------------------------------------+------------+
| Tables_in_itsraghz                             | Table_type |
+------------------------------------------------+------------+
| bkup_wrongdmlupated4address_tblexpenses11jul19 | BASE TABLE |
| blobtest                                       | BASE TABLE |
| blog                                           | BASE TABLE |
| creditcardreportmonthlytxdetailsvw             | BASE TABLE |
| creditcardreportmonthlytxsummaryvw             | BASE TABLE |
| ctstimesheet                                   | BASE TABLE |
| persons                                        | BASE TABLE |
| tbladdress                                     | BASE TABLE |
| tblbankacct                                    | BASE TABLE |
| tblbankpayment                                 | BASE TABLE |
| tblbankschedule                                | BASE TABLE |
| tblcreditcardcycle                             | BASE TABLE |
| tblebookperday                                 | BASE TABLE |
| tblemployee                                    | BASE TABLE |
| tblexpensepayment                              | BASE TABLE |
| tblexpensepaymentoct16                         | BASE TABLE |
| tblexpenses                                    | BASE TABLE |
| tblexpenses11jul19                             | BASE TABLE |
| tblexpenses20dec19                             | BASE TABLE |
| tblexpensesmonitoapp                           | BASE TABLE |
| tblexpensesoct16                               | BASE TABLE |
| tblexpensesoct16temp                           | BASE TABLE |
| tblexpensessep16                               | BASE TABLE |
| tblpasswordhistory                             | BASE TABLE |
| tblpasswordhistorytest                         | BASE TABLE |
| tblprfarticle                                  | BASE TABLE |
| tblprffeedback                                 | BASE TABLE |
| tblprflecturedetails                           | BASE TABLE |
| tblsecretqa                                    | BASE TABLE |
| tblsubscription                                | BASE TABLE |
| tbltask                                        | BASE TABLE |
| tbltaskcategory                                | BASE TABLE |
| tbltaskcategory2                               | BASE TABLE |
| tbltaskcategory3                               | BASE TABLE |
| tbltaskstatus                                  | BASE TABLE |
| tbltempevents                                  | BASE TABLE |
| tbluser                                        | BASE TABLE |
| temple_act_get_tx_details_vw                   | VIEW       |
| temple_act_tx_summary_vw                       | VIEW       |
| test                                           | BASE TABLE |
| testtblexpenses                                | BASE TABLE |
| users                                          | BASE TABLE |
+------------------------------------------------+------------+
42 rows in set (0.00 sec)

MariaDB [itsraghz]>
```
