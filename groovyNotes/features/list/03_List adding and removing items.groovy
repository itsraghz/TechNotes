myList = []
myList += 'a' // plus(Object) 
assert myList == ['a']
myList += ['b','c'] //plus(Collection)
assert myList == ['a','b','c']

myList = []
myList << 'a' << 'b'  //left shift is append
println myList
assert myList == ['a','b']

myList2 = ['a', 'b', 'b', 'a', 'b']
println myList2
println myList2 - ['b']

myList3 = [['a', 'b'], 'b', 'a', 'b']
println myList3
println myList3 - ['b']

println "-----------------------"
exerciseList = [1, 2, null, 3, null, 4, null, 5, 'null']
println exerciseList
println "-----------------------"
exerciseList.each { 
    if(it!=null) {
        println "[" + it.class + "] | " + it 
    } else {
        println "a null value encountered..."
    }
}
println "-----------------------"
println exerciseList - null
println exerciseList - 'null'

assert myList - ['b'] == ['a'] //minus(Collection)

// Groovy Spread Operator - *
oddList = [1,3,5]
oddDuplicateList = oddList * 2
println oddList
println oddDuplicateList
println oddList.size()
println oddDuplicateList.size()

oddSquareList = oddList.each { println it * it }
println oddSquareList

assert myList * 2 == ['a','b','a','b'] // multiply