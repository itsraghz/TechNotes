def myMap = [a:1, b:2, c:3]

// Retrieves existing elements
assert myMap['a'] == 1
assert myMap.a == 1
assert myMap.get('a') == 1
assert myMap.get('a',0) == 1

// Attempting to retreive the missing elements
assert myMap['d'] == null
assert myMap.d == null
assert myMap.get('d') == null

// Default values
assert myMap.get('d',0) == 0
assert myMap.d == 0

// single putAt
myMap['d'] = 1
assert myMap.d == 1
myMap.d = 2
assert myMap.d == 2