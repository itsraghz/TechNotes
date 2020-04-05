import cryptography
import csv

from cryptography.fernet import Fernet
from datetime import datetime

print("=============================================")
now=datetime.now()
now_string=now.strftime("%A, %d %B, %Y %I:%M:%S %p")
print("Executed at : ", now.strftime("%A, %d %B, %Y %I:%M:%S %p"))
print("=============================================")

# Read the key from the file
file = open('key.key', 'rb')  # write binary data mode
key = file.read()  # The key is binary type data
file.close()

# prepare the data structure to hold the data in memory
empList = []

with open('encrypted_employee_info.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            print(f'Column names are {", ".join(row)}')
        else:
            print(f'\tEmployee Name {row[0]}, has the user Id {row[1]} and password {row[2]}')
        line_count += 1
        empList.append(row)
    print(f'Processed {line_count} lines.')

print("the processed data is given below...")

outputList = []
line_count = 0
for row in empList:
    # print(row)
    if line_count == 0:
        # do not process this line as it is a header
        # outputList.append("{row[0]},{row[1]},{row[2]}")
        outputList.append(f'{row[0]},{row[1]},{row[2]}')
        line_count += 1
    else:
        password = row[2].encode()
        # print(f'employee password retrieved is : {password}')
        f = Fernet(key)
        decrypted_password = f.decrypt(password)
        # print(f'Decrypted : {decrypted_password} for the original {password}')
        row[2] = decrypted_password.decode()
        # print(f'row : {row}')
        line_count += 1
        outputList.append(f'{row[0]},{row[1]},{row[2]}')

length2 = len(outputList)
print(f'OutputList has a total list of elements : {length2}')

file = open('decrypted_employee_info.csv', 'w')
for x in outputList:
    # print(x)
    file.write(x)
    file.write("\n")

file.close()
print(f'The modified data is written into the file - decrypted_emplooyee_info.csv')

