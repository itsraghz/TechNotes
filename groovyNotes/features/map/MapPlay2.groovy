// Map - Key , Value Pair 
// Not a collection (Neither in Java NOR in Groovy)

// Key:Value - Notation 
// JSON is based on Map

// [] Vs [:]
// [] - empty list
// [:] = empty map

// Map is an Unordered collection of key,value pairs - generally. (java.util.Map) 
// Map is an Interface, HashMap is the implementation class of a Map (java.util.HashMap)
// LinkedHashMap - is an ordered collection of key,value pairs (java.util.LinkedHashMap)
// Java - follows HashMap as a default collection type
// Groovy - follows LinkedHashMap - for maintaining the Order

// You don't need to import the classes in Groovy, as it gives you the classes in java.util. package by default
// In Java, you need to as only java.lang package classes are imported by default.

// Map - Keys will be of KeySet (java.util.KeySet)
// Set is an Interface (java.util.Set) - No duplicates
// Set is a Collection in Java.
// HashSet - is an implementation class of the Set Interface, unordered collection of values with no duplicates (java.util.HashSet)
// LinkedHashSet - is an ordered collection of values with no duplicates (java.util.LinkedKeySet)
// Groovy adapts LinkedHashSet for the keys for a Map 

//  Duplicate keys are not allowed. Even if you have a Duplicate key, Map takes the latest value
// The Programmer will get only the finite set of keys with the duplicates eliminated, never ever with the actual snapshot of the values 
// from which the Map was constructed. 

def myMap = [:]
def myList = []

def printObject(it) {
    println "==================================================="
    println "    Printing an Object and its properties          "
    println "==================================================="
    println "Object contains : " + it

    if(it instanceof LinkedHashMap) {
       println "The object is a Map"
       println "Map is of type : " + it.getClass() //class java.util.LinkedHashMap
    } else {
        println "Object is of type : " + it.class
    }
    
    println "Object Properties : " + it.properties
    println "Object Properties Each : " + it.properties.each { println it }
    println "Object Values Each : " + it.each { println it }
    
    println "==================================================="
}

def printMapProperties(map) {
    println "Map contains : " + map
    printMapKeys(map)   
    printMapValues(map)
}

def printMapKeys(map) {
    println ""
    println "//// Keys ////"
    def keySet = map.keySet()
    println "Keys of the map are : " +  keySet
    println "Keys are of type : " + keySet.class //class java.util.LinkedHashMap$LinkedKeySet
    
    println "**********"
    keySet.each { 
        if(it.equals("PAN")) {
            //print "**"
           it = "**"
        }
        println it + " of type " + it.class 
   }
}

def printMapValues(map) {
    println ""
    println "//// Values ////"
    def values = map.values()
    println "Values of the map are : " +  values
    println "Values are of type : " + values.class //class java.util.LinkedHashMap$LinkedValues
    
    println "**********"
    values.each { 
        //print it
        if(it.equals("PAN")) {
           //print "**"
           it = "**"
        }
        print it
        println "| Type : " + it.getClass()
    }
}

def printMapKeyValues(map) {
    println "printMapKeyValues() - map contains : " + map
    map.keySet().each {
        if(it.equals("PAN")){
            def maskedData = maskDigits(map.get(it))
            println it + " --> " + maskedData
        } else {
            // map.it will try to fetch the value of key named 'it'. The dot notation is very specific
            // map.get(it) will try to get the value of the key supplied by the variable 'it' which is a closure iteration here
            // map.get() is safer
            println it + " --> [" + map.it + "] | " + map.get(it)
        }
    }
}

/* A method to mask every alternate digit with 'X' */
def maskDigits(data) {
    println "%%%%%%%%%%%%%%"
    def maskedData = []
    data.eachWithIndex { it, index -> 
        if(index%2==0) {
            it = "*"
        }
        maskedData<<it
        println index + ": " + it
    }
    println "[**] Masked Data : " + maskedData + ", flattened : " +  maskedData.join("")
    println "%%%%%%%%%%%%%%"   
    return maskedData.join("") 
}

/*printObject(myList)
println ""
printObject(myMap)

myList=['Raghavan',40]
printObject(myList)*/

// Fill the values into Map
def PersonMap = [Name : 'Raghavan', Age : 40, PAN : 'ABC123XY6', name : 'smallCase']
def PersonMapTest = [Name : 'Raghavan', Age : 40, PAN : 'ABC123XY6', 123 : 123, 1: 'One', '1': 'One']
//printObject(PersonMap)

/* Manipulate a Map */
println "Name being accessed via the dot notation : " +PersonMap.Name
println "Name being accessed via the dot notation (case sensitive) : " +PersonMap.name
println "Name being accessed via the get() Method : " +PersonMap.get('Name')
println "Name being accessed via the Array Style : " +PersonMap['Name']

//println PersonMap[Name] // throws an error because there is  no property called Name as it is a literal String
def Name = 'Name'
println "Name being accessed via a variable for Key : " + PersonMap[Name]

PersonMap['Name']


/* Duplicates are not allowed. Even if you have a Duplicate key, Map takes the latest value */
def PersonMapWithDuplicateKey = [Name : 'Raghavan', Age : 40, Name: 'Shyam']
//printObject(PersonMapWithDuplicateKey) //[Name:Shyam, Age:40]

def StrictMap = new LinkedHashMap<String, String>()
def LinkedHashMap<String, String> StrictMapStyle2 = [:]
StrictMap = [Name : 'Raghavan', Age : 40, PAN : 'ABC123XY6', 123 : 123, 1: 'One', '1': 'One']

//printMapProperties(PersonMap)
//printMapProperties(PersonMapWithDuplicateKey)
//printMapProperties(PersonMapTest)
//printMapProperties(StrictMap)
//printMapProperties(StrictMapStyle2)
println ""



import groovy.transform.ToString
@ToString
class Person 
{
    String firstName, lastName, PAN
    int age
}

@ToString
class Employee 
{
    String firstName, lastName, PAN
    int employeeId, age
}

def person1 = new Person(firstName: 'Raghavan', lastName: 'Muthu', age: 40)
//println "Person instance person1 is : "+ person1
def personTypeMap = new LinkedHashMap<String, Person>()
personTypeMap = ['person1': person1]
//printMapProperties(personTypeMap)

println ""
println ""
println ""

def emp1 = new Employee(employeeId: 1001, firstName: 'Raghavan', lastName: 'Muthu', age: 40)
//println "Employee instance person1 is : "+ emp1
def employeeTypeMap = new LinkedHashMap<Integer, Employee>()
employeeTypeMap = [1001: emp1]
//printMapProperties(employeeTypeMap)


printMapKeyValues(PersonMap)