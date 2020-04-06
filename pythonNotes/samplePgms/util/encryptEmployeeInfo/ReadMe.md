# Python Utility - Encrypt Employee Info

## Objective

 A small utility has been written in Python to encrypt the sensitive information of an employee details like `SSN`, `Password` etc.,
 The encrypted data is stored separately (database or file) and the decryption utility does the reverse on the stored data but before
 it can act on the data further - like sending it to any downstream application.

## Flavors

 The utility has two flavors in the order of preparation/implementation as explained below.

### Main Encryption logic

 * The Python Crytography module is installed via `PIP` - Python Installation Package
 * The API Class `Fernet` inside the cryptography pacakge is used - for the *`Symmetric Encryption`* - using a single key to encrypt and decrypt the data.
 * The Fernet class generates a key - for encryption and decryption. 
 * The generated key is stored in a separate file - `key.key` (user defined file name) for the safe retrieval during the decryption
 * The Fernet class deals with the data in *binary* format. _Conversion of the data to and from binary_ is essential, for both the `data` and the `key`

### File Read and write

#### Encryption

 * The employee information is stored in a flat file (`.csv`) - `employee_info.csv`
 * The details are read by using a CSV Reader (`csv` modul from Python) and handled one at a time
 * The sensitive data is encrypted using the `Fernet` class (as explained above)
 * Using the `Fernet` class as explained above, a key is generated and stored in a file called `key.key` (in byte format)
 * The processed data (after encryption of the sensitive data) is stored in a different output file (which is again a `.csv` - flat file)

#### Decryption

 * The decryption utility reads the entries from the newly created file that has the encrypted data (`employee_info_encrypted.csv`)
 * It reads the the key stored in the file `key.key`. _String to Byte_ conversion should take place for both the key and the encrypted data
 * The `Fernet` API Class is used to decrypt the data using the key and data in *byte* format.
 * The processed data (decryptd data) of employee information is stored in a different output file (which is again a `.csv` - flat file) - `employee_info_decrypted.csv`

### Database Read and write

  Similary to the File Read and write, this utility handles the data to and from the database tables. MySQL has been used to test this functionality on a Windows 10 machine.

#### Encryption

 * The employee information is assumed to be stored in the `EMPLOYEE` table. (Schema: `PYTHON_MYSQL_DEMO`)
   * A script helps reading the employee information from a flat file `employee_info.csv` and loads into the `EMPLOYEE` table for easy adminstrative tasks.
 * The encryption utility reads the employee details from the `EMPLOYEE` table and handles them one row at a time
 * Using the `Fernet` class as explained above, a key is generated and stored in a file called `key.key` (in byte format)
 * The `Fernet` class encrypts the sensitive data - `password` here in this case
 * The processed data (after encryption) is stored in a different table `EMPLOYEE_ENCRYPTED` in the same schema

#### Decryption

 * The decryption utility reads the encrypted data from the `EMPLOYEE_ENCRYPTED` table 
 * It reads the encryption key (to decrypt as well - we use *Symmetric Encryption*) from the file `key.key`
 * Using the `Fernet` API class and the key retrieved, the  data is decrypted further.
 * The processed data (after decryption) is stored in the flat file (`employee_info_decrypted.csv`)

