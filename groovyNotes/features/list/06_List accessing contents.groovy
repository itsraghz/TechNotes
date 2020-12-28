def list = [1, 2, 3]

// Querying
assert list.first() == 1
assert list.head() == 1
println list.head()
println list

def vowelsList = ['a', 'e', 'i', 'o', 'u']
println vowelsList
println vowelsList.head()
println vowelsList.tail() // all elements but the head/first

assert list.tail() == [2, 3]
assert list.last() == 3
assert list.count(2) == 1

def numList = [1, 1, 2, 1]
assert numList.count(1) == 3
assert numList.count(3) == 0

assert list.max() == 3
assert list.min() == 1

println list.max()
println list.min()
println vowelsList.max()
println vowelsList.min()

def even = list.find { item ->
 item % 2 == 0
}
assert even == 2

//list << 7
assert list.every { item -> item < 5 }
assert list.any { item -> item < 2 }

// Iterating

def store = ''
list.each { item ->
   store += item
}
assert store == '123'

store = ''
list.reverseEach { item ->
   store += item
}
assert store == '321'

store = ''
list.eachWithIndex { item, index ->
    store += "$index:$item "
}
assert store == '0:1 1:2 2:3 '

def vowelsWithIndex = ""
vowelsList.eachWithIndex { item, index ->
    vowelsWithIndex += "$index:$item "
}
println ""
println vowelsWithIndex

// -----------------------------------------
//             Accumulating
// -----------------------------------------
assert list.join('-') == '1-2-3'

// Inject Method
/* You don’t need to introduce that extra variable to the outer scope of your accumulation, 
and your closure has no side effects on that scope. 
Other languages often call this kind of method fold or reduce */
result = list.inject(0) { clinks, guests ->
  clinks + guests
}
assert result == 0 + 1 + 2 + 3
assert list.sum() == 6

factorial = list.inject(1) { fac, item ->
    fac * item
}
assert factorial == 1 * 1 * 2 * 3
println factorial