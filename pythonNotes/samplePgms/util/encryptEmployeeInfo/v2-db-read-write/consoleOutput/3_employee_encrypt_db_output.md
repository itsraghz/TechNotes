# Script that reads value from a DB table and stores them after encryption into a new table

```
C:\rags\TechNotes\pythonNotes\samplePgms\util\encryptEmployeeInfo\v2-db-read-write (master)
¿ python 3_employee_encrypt_db.py
=============================================
Executed at :  Tuesday, 07 April, 2020 12:05:48 AM
=============================================
MySQL client is imported sucessfully!
Connected to MySQL DB - successfully!
Query to execute : SELECT * FROM EMPLOYEE
Database connection closed successfully
processedQueryList count : #  7
ProcessedQueryList has : INSERT INTO EMPLOYEE_ENCRYPTED (EMP_NAME, USER_ID, PASSWORD) VALUES ('Karthiga Karpagam R', 'karthiga', 'gAAAAABei3aGN-UmiR2e5HW9D1_vJWYGcmeiySeorjDmoqCnS4JCS_-Rdrlh5km3XX9moefPyFEHo9r7shaPwX28F4zUFGGL0w==')
ProcessedQueryList has : INSERT INTO EMPLOYEE_ENCRYPTED (EMP_NAME, USER_ID, PASSWORD) VALUES ('Karthick Muthu R', 'karthick', 'gAAAAABei3aGqosIPQYVmt6XWetvlH1vBCfTjgX39fEN3gqwVKRINcrrdTvv_TiHDP7-iCjPpne9DLKWzyK0xW3Q3vrR3T0-kQ==')
ProcessedQueryList has : INSERT INTO EMPLOYEE_ENCRYPTED (EMP_NAME, USER_ID, PASSWORD) VALUES ('Raghavan Muthu', 'itsraghz', 'gAAAAABei3aGLsdKnSdhHCqH5rm264EUCf2KbJMqDTarw_bkzDnHWB_kiZ1hlNk-UOne8UZmTFdZN-W17oly0iUX2ABySwKitg==')
ProcessedQueryList has : INSERT INTO EMPLOYEE_ENCRYPTED (EMP_NAME, USER_ID, PASSWORD) VALUES ('Meenakshi Murugappan', 'meena13', 'gAAAAABei3aG6MVmFZXoQ0PeVAzlJA17B6sJ9SNOsjewPICCIDoo-ErFNlAGmwLEo4ubWumOxvn3m-d_2FyNthsYkn0KyhJRZA==')
ProcessedQueryList has : INSERT INTO EMPLOYEE_ENCRYPTED (EMP_NAME, USER_ID, PASSWORD) VALUES ('Karthiga Karpagam R', 'karthiga', 'gAAAAABei3aGpk5Sr7gboX5mmDh5NWvRqBOs6nuu7l4dYUDkIkNrlukdMKvPJSu_4Eey6VHCmTrCm68SeFq13_Bmt7RbAZTXig==')
ProcessedQueryList has : INSERT INTO EMPLOYEE_ENCRYPTED (EMP_NAME, USER_ID, PASSWORD) VALUES ('Karthick Muthu R', 'karthick', 'gAAAAABei3aG57z28sWdZmCQXqMyQKev3eubXnvxT9H4gmwwsun_vRbNfo84DwTsu3D63UWn7huVEzrONDXqu1TZzvC270JoOA==')
ProcessedQueryList has : INSERT INTO EMPLOYEE_ENCRYPTED (EMP_NAME, USER_ID, PASSWORD) VALUES ('Ravi Narasimhan', 'nravi2000', 'gAAAAABei3aGnO5_bjS9Kw1vh2YPSUbraTdz-sn3KpccOsLpxKC6S7tzM7gJ60HtQ8zbvOBgvwrZAebVmfOIZT1bKxxCp2hg4Q==')
Connected to MySQL DB - successfully!
Record inserted into the table successfully!
Record inserted into the table successfully!
Record inserted into the table successfully!
Record inserted into the table successfully!
Record inserted into the table successfully!
Record inserted into the table successfully!
Record inserted into the table successfully!

C:\rags\TechNotes\pythonNotes\samplePgms\util\encryptEmployeeInfo\v2-db-read-write (master)
¿
```
