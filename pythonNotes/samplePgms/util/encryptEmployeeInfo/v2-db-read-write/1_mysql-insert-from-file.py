# Ref URL : https://www.tutorialspoint.com/python/python_database_access.htm
# Ref URL : https://stackoverflow.com/questions/3595363/properties-file-in-python-similar-to-java-properties
# Direct URL : https://stackoverflow.com/a/8220790/1001242
# Ref URL: https://docs.python.org/3/library/configparser.html
# Ref URL : https://stackoverflow.com/a/26221097/1001242 (for properties file)

import MySQLdb
import configparser
import sys
import csv

print(f'MySQL client is imported sucessfully!')

config = configparser.RawConfigParser()
config.read('db.properties')

dbName = config.get('Database', 'dbName')
host = config.get('Database', 'host')
userName = config.get('Authentication', 'userName')
password = config.get('Authentication', 'password')

# Open database connection
db = MySQLdb.connect(host, userName, password, dbName)

print(f'Connected to MySQL DB - successfully!')

# Prepare a cursor object using cursor() method
cursor = db.cursor()

# Prepare the SQL Query to insert a record into the database table
tableName = config.get('Database', 'tableName')
sql = "INSERT INTO " + tableName + "(EMP_NAME,USER_ID,PASSWORD) VALUES "

print(f'Base SQL Query to execute :: {sql}')


def get_emp_names():
    empList = []
    with open('employee_info.csv') as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0
        for row in csv_reader:
            if(line_count == 0):
                print(f'Column names are {", ".join(row)}')
                line_count += 1
            else:
                empList.append(f'{row[0]}, {row[1]}, {row[2]}')
                line_count += 1
    return empList


empList = get_emp_names()
length = len(empList)
print(f'Employee List contains # {length} elements')
# print(empList)


def process_emp_records():
    for x in empList:
        # print(f'empList has : {x}')
        emp_details = x.split(',')
        # print(f'\t... emp_details list has : {emp_details}')
        emp_name = emp_details[0].strip()
        user_id = emp_details[1].strip()
        password = emp_details[2].strip()
        # print(f'\t\t[#] Password : [{password}]')
        query = sql + "('"+ emp_name + "', '" + user_id + "', '" + password + "')"
        print(f'SQL Query to be executed for an employee: {query}')
        insert_record(query)
    return


def insert_record(sql):
    try:
        # Execute the SQL command
        cursor.execute(sql)
        # commit your changes in the database
        db.commit()
        print(f'Record inserted into the database successfully!')
    except:
        # Rollback in case of any exceptions
        db.rollback()
        print(f'Exception occurred. Rolled back!', sys.exc_info()[0])
        raise
    return


process_emp_records()

# close database connection
db.close()

print(f'Database connection closed successfully')
