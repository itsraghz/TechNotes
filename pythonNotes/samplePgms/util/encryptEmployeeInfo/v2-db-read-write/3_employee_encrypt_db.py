import cryptography
import csv
import MySQLdb
import configparser
import sys

from cryptography.fernet import Fernet
from datetime import datetime

print("=============================================")
now=datetime.now()
now_string=now.strftime("%A, %d %B, %Y %I:%M:%S %p")
print("Executed at : ", now.strftime("%A, %d %B, %Y %I:%M:%S %p"))
print("=============================================")

print(f'MySQL client is imported sucessfully!')

config = configparser.RawConfigParser()
config.read('db.properties')

dbName = config.get('Database', 'dbName')
host = config.get('Database', 'host')
userName = config.get('Authentication', 'userName')
password = config.get('Authentication', 'password')

def generate_and_store_key(fileName):
    # Generate the Key and store in a file for safety
    key = Fernet.generate_key()
    store_key_to_file(key, fileName)
    return key

def store_key_to_file(key, fileName):
    # Store it in a file
    file = open('key.key', 'wb')  # write binary data mode
    file.write(key)  # The key is binary type data
    file.close()
    return

'''
        password = row[2].encode()
        # print(f'employee password retrieved is : {password}')
        f = Fernet(key)
        encrypted_password = f.encrypt(password)
        # print(f'Encrypted : {encrypted_password} for the original {password}')
        row[2] = encrypted_password.decode()
'''

def get_db_connection(host,userName, password, dbName):
    # Open database connection
    db = MySQLdb.connect(host, userName, password, dbName)

    print(f'Connected to MySQL DB - successfully!')

    return db
    

def fetch_all_records(host,userName, password, dbName, key):
    tableName = config.get('Database','tableName')
    encryptedTableName = config.get('Database','encryptedTableName')
    processedQueryList = []

    db = get_db_connection(host,userName, password, dbName)

    # Preparea a cursor object using cursor() method
    cursor = db.cursor()

    sql = "SELECT * FROM " + tableName
    print(f'Query to execute : {sql}')

    insertBaseQuery = "INSERT INTO " + encryptedTableName + " (EMP_NAME, USER_ID, PASSWORD) VALUES "

    try:
        # Execute the sql query
        cursor.execute(sql)
        # Fetch all the rows in a list of lists.
        results = cursor.fetchall()
        for row in results:
            id = row[0]
            emp_name = row[1]
            user_id = row[2]
            password = row[3]
            # print(f'Employee Name : %s, User Id : %s, Password : %s' %
            #      (emp_name, user_id, password) % '\n')
            # print(f'Employee Name : {emp_name}, User Id : {user_id}, password : {password}')
            encrypted_password = encrypt_data(password, key)
            # print(f'Id : {id}, Employee Name : {emp_name}, User Id : {user_id}, password : {password}, encrypted_password : {encrypted_password}')
            processedEmpList.append(f'{id}, {emp_name}, {user_id}, {encrypted_password}')
            sqlToInsert = insertBaseQuery + "('"+ emp_name + "', '" + user_id + "', '" + encrypted_password + "')"
            processedQueryList.append(sqlToInsert)
    except:
        # print("Error occurred. Unable to fetch data")
        print(f'Exception occurred. Unable to fetch data!', sys.exc_info()[0])
        raise

    # close database connection
    db.close()

    print(f'Database connection closed successfully')
    return processedQueryList

def encrypt_data(data, key):
    # needed to conver to binary to get encrypted
    data = data.encode()
    f = Fernet(key)
    encrypted_data = f.encrypt(data)
    # decode to get back in string format
    encrypted_data_str = encrypted_data.decode()
    return encrypted_data_str

def insert_all_records(host,userName, password, dbName, myList):
    '''Insert into the new/target table - EMPLOYEE_ENCRYPTED'''
    # targetTableName = config.get('Database','encryptedTableName')

    db = get_db_connection(host,userName, password, dbName)

    cursor = db.cursor()

    for sql in myList:
        try:
            # Execute the sql query
            cursor.execute(sql)
            db.commit()
            print(f'Record inserted into the table successfully!')
        except:
            # print("Error occurred. Unable to fetch data")
            db.rollback()
            print(f'Exception occurred. Unable to insert record, rolling back!', sys.exc_info()[0])
            raise

    # close database connection
    db.close()

    return

# prepare the data structure to hold the data in memory
empList = []
processedEmpList = []
key = generate_and_store_key('key.key')
processedQueryList = fetch_all_records(host,userName, password, dbName, key)

print(f'processedQueryList count : # ', len(processedQueryList))

for x in processedQueryList:
    print(f'ProcessedQueryList has : {x}')

insert_all_records(host,userName, password, dbName, processedQueryList)

