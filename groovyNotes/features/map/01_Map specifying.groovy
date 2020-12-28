def myMap = [a:1, b:2, c:3]
assert myMap instanceof LinkedHashMap
assert myMap.size() == 3
assert myMap['a'] == 1
def emptyMap = [:]
assert emptyMap.size() == 0
def explicitMap = new TreeMap()
explicitMap.putAll(myMap)
assert explicitMap['a'] == 1
def composed = [x:'y', *:myMap] // Spread Operator
assert composed == [x:'y', a:1, b:2, c:3]

// the quotes around the key is optional
assert ['a':1] == [a:1]


// using a local variable as a key
// Use '(varName)' to get the value at runtime
def x = 'a'
assert ['x':1] == [x:1]
assert ['a':1] == [(x):1] // indirection


