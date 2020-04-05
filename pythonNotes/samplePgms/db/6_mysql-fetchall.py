# Ref URL : https://www.tutorialspoint.com/python/python_database_access.htm
# Ref URL : https://stackoverflow.com/questions/3595363/properties-file-in-python-similar-to-java-properties
# Direct URL : https://stackoverflow.com/a/8220790/1001242
# Ref URL: https://docs.python.org/3/library/configparser.html
# Ref URL : https://stackoverflow.com/a/26221097/1001242 (for properties file)

import MySQLdb
import configparser
import sys

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

# Preparea a cursor object using cursor() method
cursor = db.cursor()

sql = "SELECT * FROM EMPLOYEE"

print(f'Query to execute : {sql}')

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
        print(
            f'Employee Name : {emp_name}, User Id : {user_id}, password : {password}')
except:
    # print("Error occurred. Unable to fetch data")
    print(f'Exception occurred. Unable to fetch data!', sys.exc_info()[0])
    raise

# close database connection
db.close()

print(f'Database connection closed successfully')
