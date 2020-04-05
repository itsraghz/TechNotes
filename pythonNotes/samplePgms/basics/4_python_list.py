# URL: https://www.geeksforgeeks.org/python-list/

myList = []
print("Intial List : ")
print(myList)

# Addition of Elements in the list
myList.append(1)
myList.append(2)
myList.append(4)
print("\nList after addition of three elements : ")
print(myList)

# Adding elements to the list using Iterator
for i in range(1, 4):
  myList.append(i)
print("\nList after adding the element 1 to 3 : ")
print(myList)

# printing the number of elements
length = len(myList)
print(f'\nTotal number of elements in the list : {length}')
