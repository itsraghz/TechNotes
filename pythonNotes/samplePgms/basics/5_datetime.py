from datetime import date
from datetime import datetime

today = date.today()
print("Today's date:", today)

# datetime object containing current date and time
now = datetime.now()
 
print("now =", now)

# dd/mm/YY H:M:S
dt_string = now.strftime("%d/%m/%Y %H:%M:%S")
print("date and time =", dt_string)	

print(now.strftime("%Y"))
print(now.strftime("%a"))
print(now.strftime("%A"))
print(now.strftime("%a, %d %B, %Y"))
print(now.strftime("%a, %d %B, %Y %H:%M:%S"))
print(now.strftime("%A, %d %B, %Y %I:%M:%S %p"))
