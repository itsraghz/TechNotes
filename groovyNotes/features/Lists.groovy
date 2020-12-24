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