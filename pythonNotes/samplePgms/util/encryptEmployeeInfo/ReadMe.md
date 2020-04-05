# Python Utility to encrypt the sensitive data of the employee info

This utility has two simple  python scripts that do the following.

1. Encrypting script : This script reads the employee details from a .csv file
`employee_info.csv` which has the columns 'EmployeeName,userId,Password'
and encrypts the sensitive data (password) using a generated key from a 3rd party
API class called `Fernet`. The key generated is stored in a file called `key.key`
so that the same key can be used back to decrypt the values further, as it is a
symmetric encryption. The same employee data along with the encrypted data is stored
in a different csv file `encrypted_employee_info.csv`.  The output can be actually
manipulated differently such that it can be written to a Database, or written into a socket etc., 

Note: This Fernet should be installed via `pip` (Python Installation Package)

2. Decrypting script: This script reads the encrypted data from the `encrypted_employee_info.csv`
and also reads the key from the `key.key` and decrypts the password field. The decrypted
data is stored in a different file `decrypted_employee_info.csv`. This is helpful when
we generate a report/data that can be sent to a downstream system. 

Note: The scripts are executed on Python V 3.8.0 on Windows 10 Machine. 
