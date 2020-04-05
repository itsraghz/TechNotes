# Ref URL : https://www.tutorialspoint.com/python/python_database_access.htm
# Ref URL : https://stackoverflow.com/questions/3595363/properties-file-in-python-similar-to-java-properties
# Direct URL : https://stackoverflow.com/a/8220790/1001242

import MySQLdb
import dbProps #to load the dbProps.py file directly

print(f'MySQL client is imported sucessfully!')

# Open database connection
db = MySQLdb.connect("localhost", "raghs", "RaghsMySQL12#", "PYTHON_MYSQL_DEMO");

print(f'Connected to MySQL DB - successfully!')

# close database connection
db.close()

print(f'Database connection closed successfully')
