# Ref URL : https://www.tutorialspoint.com/python/python_database_access.htm

import MySQLdb

print(f'MySQL client is imported sucessfully!')

# Open database connection
db = MySQLdb.connect("localhost", "<userName>", "<Password>", "PYTHON_MYSQL_DEMO");

print(f'Connected to MySQL DB - successfully!')

# close database connection
db.close()

print(f'Database connection closed successfully')
