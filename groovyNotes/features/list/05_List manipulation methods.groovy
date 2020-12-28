assert [1,[2,3]].flatten() == [1,2,3]
assert [1,2,3].intersect([4,3,1])== [3,1]

def disjointList = [1,2,3].disjoint([4,5,6])
println disjointList
assert [1,2,3].disjoint([4,5,6])
list = [1,2,3]
println "before popping : " + list
popped = list.pop()
println "popped element : " + popped
println "after popping : " + list
assert popped == 1
assert list == [2,3]
assert [1,2].reverse() == [2,1]
assert [3,1,2].sort() == [1,2,3]
def list = [ [1,0], [0,1,2] ]
println "composite list : " + list
list = list.sort { a,b -> a[0] <=> b[0] }
println "after sorting a composite list : " + list
//assert list == [ [0,1,2], [0, 1] ]

list = list.sort { item -> item.size() }
println "after sorting a composite list based on size of each element : " + list
assert list == [ [1,0], [0,1,2] ]
list = ['a','b','c']
list.remove(2) // remove by index
assert list == ['a','b']
list.remove('b') // remove by value
assert list == ['a']
list = ['a','b','b','c']
list.removeAll(['b','c'])
assert list == ['a']

//Transforming the list elements
def doubled = [1,2,3].collect{ item ->
  item*2
}

println doubled
assert doubled == [2,4,6]

// Finding every element matching the closure
def odd = [1,2,3].findAll{ item ->
   item % 2 == 1
}
println odd
assert odd == [1,3]