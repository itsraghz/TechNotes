def myMap = [a:1, b:2, c:3]
def other = [b:2, c:3, a:1]
assert myMap == other
assert !myMap.isEmpty()
assert myMap.size() == 3
assert myMap.containsKey('a')
assert myMap.containsValue(1)
assert myMap.entrySet() instanceof Collection
assert myMap.any {entry -> entry.value > 2 }
assert myMap.every {entry -> entry.key < 'd'}
assert myMap.keySet() == ['a','b','c'] as Set
assert myMap.values().toList() == [1, 2, 3]