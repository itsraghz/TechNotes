myList = ['a','b','c','d','e','f']
assert myList[0..2] == ['a','b','c']
assert myList[0,2,4] == ['a','c','e']
myList[0..2] = ['x','y','z']
assert myList == ['x','y','z','d','e','f']
myList[3..5] = []
assert myList == ['x','y','z']
myList[1..1] = [0, 1, 2]
assert myList == ['x', 0, 1, 2, 'z']