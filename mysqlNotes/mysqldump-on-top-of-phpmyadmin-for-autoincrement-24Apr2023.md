# SQL Export - `mysqldump`

*Date* : 24 Apr 2023 Monday

> *Reference* : https://simplebackups.com/blog/the-complete-mysqldump-guide-with-examples/

## Reason to use `mysqldump`

While I had been exporting the database `itsraghz` in the `phymyadmin` of MAMP (`manager-osx`) in Macbook Pro, the `AUTO_INCREMENT` was skipped. When I tried importing the sql file (`itsraghz.sql`, `itsraghz.sql.zip`) on the Windows Laptop (Lenovo Legion Y540) using XAMPP, the import was successful however the subsequent inserts was NOT having the right auto_increment PK, it was started with `0`!

Hence, I had attempted with the `mysqldump` and luckily it had helped with the right level of SQL export with the `AUTO_INCREMENT` value at the end of each *table*. This was proven with the `grep` command below - `line 884:)`.

## Command

```sh
./mysqldump -u raghs -p --databases <dbName> --single-transaction > <file>.sql
```

```sh
./mysqldump -u raghs -p --databases itsraghz --single-transaction > ~/Downloads/itsraghz.sql
```

```sql
➜  bin pwd
/Applications/XAMPP/xamppfiles/bin
➜  bin ./mysqldump -u raghs -p --databases itsraghz --single-transaction > ~/Downloads/itsraghz.sql
Enter password:
➜  bin ls -ltrh ~/Downloads/itsraghz.sql
-rw-r--r--  1 raghavan.muthu  staff    28M Apr 25 01:09 /Users/raghavan.muthu/Downloads/itsraghz.sql
➜  bin bat ~/Downloads/itsraghz.sql
```

### Output - Verification on `AUTO_INCREMENT=`

```sh
➜  bin bat ~/Downloads/raghs/Localhost-24Apr2023-Mon/itsraghz.sql | grep -in AUTO_INCREMENT=
268:) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
297:) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=latin1;
504:) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1;
536:) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;
574:) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=latin1;
834:) ENGINE=InnoDB AUTO_INCREMENT=9457 DEFAULT CHARSET=latin1;
884:) ENGINE=InnoDB AUTO_INCREMENT=13558 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
934:) ENGINE=InnoDB AUTO_INCREMENT=6077 DEFAULT CHARSET=latin1;
1032:) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
1076:) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
1124:) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
1170:) ENGINE=InnoDB AUTO_INCREMENT=333 DEFAULT CHARSET=latin1;
1199:) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;
1243:) ENGINE=InnoDB AUTO_INCREMENT=5204 DEFAULT CHARSET=latin1;
1330:) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
1393:) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=latin1;
1419:) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='A table to store the article/lecture details';
1483:) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='A table to store the details of the lecture and its location';
1517:) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
1551:) ENGINE=InnoDB AUTO_INCREMENT=656 DEFAULT CHARSET=latin1;
1592:) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=latin1 COMMENT='A table to deal with the day to day tasks and the dates';
1617:) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='A table to have all the 1st level categories';
1642:) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COMMENT='A table to have all the 2nd level categories (sub categories';
1667:) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1 COMMENT='A table to have all the 3rd level categories (sub-sub catego';
1692:) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='A table to have all the status meta data information';
1728:) ENGINE=InnoDB AUTO_INCREMENT=472 DEFAULT CHARSET=latin1 COMMENT='A table to hold the events like birthday, wedding etc., ';
1761:) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='A table to have all the user related information';
1820:) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
1864:) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
1890:) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
➜  bin
```

## Sample Table that triggered `tblexpenses11jul19`

```sql
DROP TABLE IF EXISTS `tblexpenses11jul19`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblexpenses11jul19` (
  `TxId` int(11) NOT NULL AUTO_INCREMENT,
  `DateOfTx` date DEFAULT NULL,
  `TimeOfTx` time DEFAULT NULL,
  `DayOfTx` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TxType` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Debit',
  `Country` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'India' COMMENT 'Country at which the expense is made',
  `Currency` varchar(5) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'INR' COMMENT 'Currency at which the expense is made',
  `City` varchar(40) COLLATE utf8_unicode_ci DEFAULT 'Bangalore',
  `Place` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ShopName` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Area` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Landmark` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Category` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SubCategory` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Beneficiary` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Source` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Amount` double(10,2) DEFAULT NULL,
  `Description` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Remarks` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Tags` varchar(255) COLLATE utf8_unicode_ci DEFAULT 'uncategorized' COMMENT 'set of tags separated by comma for quick filtering and logical grouping of expense',
  `YetTo` int(1) DEFAULT 0,
  `Balance` double(10,2) DEFAULT NULL COMMENT 'Balance amount in the respective Bank Acct',
  `MODIFIED_ON` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `MODIFIED_BY` varchar(20) COLLATE utf8_unicode_ci DEFAULT 'SYSTEM',
  `CREATED_ON` timestamp NOT NULL DEFAULT current_timestamp(),
  `CREATED_BY` varchar(20) COLLATE utf8_unicode_ci DEFAULT 'SYSTEM',
  PRIMARY KEY (`TxId`)
) ENGINE=InnoDB AUTO_INCREMENT=13558 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
```

```sql
) ENGINE=InnoDB AUTO_INCREMENT=13558 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```

> Note: After exporting the files from *phymyadmin*, the actual `.sql` file alone was manually exported via `mysqldump` and replaced the .sql file generated by PhpMyAdmin.

> Also deleted the `itsraghz.sql.zip` file exported by PhpMyAdmin, and manually compressed the `itsraghz.sql` that regenerated the `itsraghz.sql.zip` to be consistent!
