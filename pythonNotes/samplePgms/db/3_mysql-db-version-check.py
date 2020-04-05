# Ref URL : https://www.tutorialspoint.com/python/python_database_access.htm

import MySQLdb

print(f'MySQL client is imported sucessfully!')

# Open database connection
db = MySQLdb.connect("localhost", "Raghs", "RaghsMySQL12#", "PYTHON_MYSQL_DEMO");

print(f'Connected to the Database')

# prepare a cursor object using cursor() method
cursor = db.cursor()

# execute SQL Query using execute() method
cursor.execute("SELECT VERSION()")

# Fetch a single row using fetchone() method
data  = cursor.fetchone()
print "Database version : %s" %data

# disconnect from server
db.close()

print(f'Connection is successfully closed.')
