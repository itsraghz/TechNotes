# Ref URL : https://www.tutorialspoint.com/python/python_database_access.htm


import MySQLdb
import configparser

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

#prepare a cursor object using cursor() method
cursor = db.cursor()

# execute SQL Query using execute() method
cursor.execute("SELECT VERSION()")

# Fetch a single row using fetchone() method
data  = cursor.fetchone()
print(f'Database version : {data}')

# disconnect from server
db.close()

print(f'Connection is successfully closed.')
