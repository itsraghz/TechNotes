// Lists in Groovy are the same as lists in Java, except that the syntax is easier and there
// are some additional methods available. Create a list in Groovy by including values
// between square brackets:

def teams = ['Red Sox', 'Yankees']
assert teams.class == java.util.ArrayList

// Groovy has operator overloading. The Groovy JDK shows that the plus, minus, and
// left-shift operators have been defined to work with lists:
teams << 'Orioles'
assert teams == ['Red Sox', 'Yankees', 'Orioles']
teams << ['Rays', 'Blue Jays']
assert teams ==
['Red Sox', 'Yankees', 'Orioles', ['Rays', 'Blue Jays']]
assert teams.flatten() ==
['Red Sox', 'Yankees', 'Orioles', 'Rays', 'Blue Jays']
assert teams + 'Angels' - 'Orioles' ==
['Red Sox', 'Yankees', ['Rays', 'Blue Jays'], 'Angels']

//Accessing elements of a list can be done with array-like syntax. Again, this is done by
//overriding a method—in this case, the getAt method:
assert teams[0] == 'Red Sox'
assert teams[1] == 'Yankees'
assert teams[-1] == ['Rays','Blue Jays']
println teams
// -1 is to get the element at last index

// Using a Range
def cities = ['New York', 'Boston', 'Cleveland','Seattle']
assert ['Boston', 'Cleveland'] == cities[1..2]
println teams[-1]

printProperties(cities)
println "Is cities empty? " + cities.empty
assert cities.empty == false

// Spread dot operator - apply a function to each element in a collection
println cities
println "Spread dot Operator -> " + cities*.size()

//The collect method takes a closure as an argument and applies it to each element of
// the collection, returning a list with the results. This is similar to the spread-dot operator, but can do more general operations
def abbrev = cities.collect { city -> city[0..2].toLowerCase() }
println "Abbreviation : " + abbrev
assert abbrev == ['new', 'bos', 'cle', 'sea']

// Groovy Collections are Searchable - via find() and findAll() methods
// The find method takes a closure and returns the first element that satisfies the closure:
assert 'New Hampshire' ==
['New Hampshire','New Jersey','New York'].find { it =~ /New/ }

def result = ['New Hampshire','New Jersey','New York'].find { it =~ /New/ }
println result

println cities
// The findAll method returns all the elements that satisfy the closure.
def withE = cities.findAll { city -> city =~ /e/ }
println withE
assert withE == ['New York', 'Cleveland', 'Seattle']
 
def withX = cities.findAll { city -> city =~ /X/ }
println withX
assert withX == []

/* Any and Every */
println "Cities list has : " + cities
println "Spread dot Operator -> " + cities*.size()
// Groovy also supplies the methods any and every, which also take closures:
assert cities.any { it.size() < 7 } // States that there’s at least one city whose name is less than 7 characters.
println "At least one city whose name is < 7 characters ? " + cities.any { it.size() < 7 } 
assert cities.every { it.size() < 10 } // Says that all of the city names are 10 characters or less.
println  "Whethere all the city names are of < 10 characters ? " + cities.every { it.size() < 10 }


/* Join Method */
// The join method concatenates all the elements of the list into a single string,
// using the supplied separator
println " "
println "========================================"
println " .....   JOIN Method of a List .....     "
println "=========================================="
println "cities.join(',') returns -> " + cities.join(',')
assert cities.join(',') == "New York,Boston,Cleveland,Seattle"

/* Plus, Minus methods */
println " "
println "========================================================"
println " .....   Plus, Minus Methods of a String List .....     "
println "========================================================"
def fruitsList1 = ['Apple', 'Orange', 'Banana', 'Jackfruit']
def fruitsList2 = ['Strawberry', 'Pomegranate', 'Banana', 'Chickoo']
def fruitsList3 = ['Strawberry', 'Pomegranate', 'Chickoo']
println "fruitsList1 has : " + fruitsList1
println "fruitsList2 has : " + fruitsList2
println "fruitsList3 has : " + fruitsList3
println "fruitsList1.plus(fruitsList2) -> " + fruitsList1.plus(fruitsList2)
println "fruitsList1.minus(fruitsList2) -> " + fruitsList1.minus(fruitsList2)
println "fruitsList1.minus(fruitsList3) -> " + fruitsList1.minus(fruitsList3)
println ""
println "fruitsList1+fruitsList2 -> " + fruitsList1+fruitsList2
println "fruitsList1-fruitsList2 -> " + fruitsList1-fruitsList2

println " "
println "========================================================"
println " .....   Plus, Minus Methods of a Numeric List .....     "
println "========================================================"
def numList1 = [5, 1, 2, 4]
def numList2 = [3, 6, 9, 2]
def numList3 = [3, 6, 9]
println "numList1 has : " + numList1
println "numList2 has : " + numList2
println "numList3 has : " + numList3
println "numList1.plus(numList2) -> " + numList1.plus(numList2)
println "numList1.minus(numList2) -> " + numList1.minus(numList2)
println "numList1.minus(numList3) -> " + numList1.minus(numList3)
println ""
println "numList1+numList2 -> " + numList1+numList2
println "numList1-numList2 -> " + numList1-numList2

def printProperties(cities) {
    println "==========================="
    println "Properties of a List "
    println "============================"
    println "List is of type : " + cities.class
    println cities.properties
}

def printMethods(cities) {
    println "==========================="
    println "Methods of a List "
    println "=========================="
    println cities.getMetaClass().getMethods().each { println it.name}
}    
 
def printMetaMethods(cities) {
    println "==========================="
    println "Meta Methods of a List "
    println "=========================="
    println cities.getMetaClass().getMetaMethods().each { println it}
}

def printMetaMethods(cities, toFilter) {
    println "==========================="
    println "Meta Methods of a List - custom selection "
    println "=========================="
    println cities.getMetaClass().getMetaMethods().each { it -> 
        if(it.name.contains(toFilter)) {
            println it
        }
    }
}

numericListSorted = [1..10]
numericListUnSorted = [6,2,4,0,1,9,7,5,8,3]
numericList = numericListUnSorted
playWithNumericList(numericList)

def playWithNumericList(numericList) {
    println "________________________________"
    println "[INPUT] List : " + numericList
    println "________________________________"
    println "List is of type : " + numericList.class
    println "Size of the list : " + numericList.size()
    println "Sorted List : " + numericList.sort()
    println "Min number in the list : " + numericList.min()
    println "Max number in the list : " + numericList.max()
    println "First number in the list : " + numericList.first()    
    println "Last number in the list : " + numericList.last()   
   
    //printMetaMethods(numericList, "sum") 
    println "Sum of the items in the list : " + numericList.sum()
    println "Average of the items in the list : " + numericList.average()
    println "________________________________"
}

def playWithStringList(cities) {
    println cities
    // Groovy adds methods like pop, intersect, and reverse to collections
    println cities.pop() // removes the element on top of stack -> 'New York'
    println cities // prints the remaining / active elements
    println cities.reverse() // prints the items in reverse order (last to first)
    
    def cities2 = ['Cleveland', 'Washington', 'New Jersey']
    println cities2
    println cities.intersect(cities2) // prints the common elements in both the Collection -> Cleveland
    def cities3 = ['Agra', 'Delhi', 'Mumbai', 'Chennai']
    println cities3
    println cities.intersect(cities3) // []
}