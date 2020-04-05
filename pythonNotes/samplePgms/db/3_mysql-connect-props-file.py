# Ref URL : https://www.tutorialspoint.com/python/python_database_access.htm
# Ref URL : https://stackoverflow.com/questions/3595363/properties-file-in-python-similar-to-java-properties
# Direct URL : https://stackoverflow.com/a/8220790/1001242

# Ref URL : https://stackoverflow.com/a/26221097/1001242 (for properties file)

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

# close database connection
db.close()

print(f'Database connection closed successfully')
