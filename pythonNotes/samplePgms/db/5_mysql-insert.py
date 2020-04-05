# Ref URL : https://www.tutorialspoint.com/python/python_database_access.htm
# Ref URL : https://stackoverflow.com/questions/3595363/properties-file-in-python-similar-to-java-properties
# Direct URL : https://stackoverflow.com/a/8220790/1001242
# Ref URL: https://docs.python.org/3/library/configparser.html
# Ref URL : https://stackoverflow.com/a/26221097/1001242 (for properties file)

import MySQLdb
import configparser
import sys

print(f'MySQL client is imported sucessfully!')

config=configparser.RawConfigParser()
config.read('db.properties')

dbName = config.get('Database','dbName')
host = config.get('Database', 'host')
userName = config.get('Authentication', 'userName')
password = config.get('Authentication', 'password')

# Open database connection
db = MySQLdb.connect(host, userName, password, dbName);

print(f'Connected to MySQL DB - successfully!')

# Prepare a cursor object using cursor() method
cursor = db.cursor()

# Prepare the SQL Query to insert a record into the database table
tableName = config.get('Database', 'tableName')
sql = "INSERT INTO " + tableName + "(EMP_NAME,USER_ID,PASSWORD) VALUES ('%s', '%s', '%s')" % ('Raghavan', 'itsraghz', 'HelloRaghs!')

print(f'SQL Query to execute :: {sql}')

# Execute
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
 
# close database connection
db.close()

print(f'Database connection closed successfully')
