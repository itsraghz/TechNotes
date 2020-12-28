def myMap = [a:1, b:2, c:3]

// Iterate over entries
def store = ''
myMap.each { entry ->
  store += entry.key
  store += entry.value
}
assert store == 'a1b2c3'

// Iterate over keys and values
store = ''
myMap.each { key, value ->
  store += key
  store += value
}
assert store == 'a1b2c3'

// Iterating over just keys
store = ''
for (key in myMap.keySet()) {
  store += key
}
assert store == 'abc'

// Iterating over just values
store = ''
for (value in myMap.values()) {
   store += value
}
assert store == '123'
