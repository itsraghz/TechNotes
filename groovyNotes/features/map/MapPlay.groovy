// Groovy Maps

def emptyStudentMap = [:]
println emptyStudentMap // [:]
 
def studentMap = [name: "John", surname: "Doe", age: 17]
println studentMap // [name:John, surname:Doe, age:17]

println studentMap.properties
println studentMap.getClass()

def student = [:] // Initialize empty map

/* 5 Different ways you can add an element (key,value pair) to a map */
/* 6th way is given below - via get() method with a default value */
student.put('name', 'John') // java notation
/* Following are the only Groovy specific */
student['surname'] = 'Doe' // You can state key in square brackets
student << [age: 17] // This is something output redirection in unix commands. key-value pair put inside map object
student.class = "11C" // Dot notation is also available
student.'school' = "Groovy School" // Same as previous
 
println student // [name:John, surname:Doe, age:17, class:11C, school:Groovy School]

/* Only Exception to Map Operations is via remove() where it goes only with a Key */
student.remove('age') // Remove by key
println student // [name:John, surname:Doe, class:11C, school:Groovy School]

/* Minus operator overloaded, and it takes a key,value pair */
student = student - [school: 'Groovy School'] // This is something like arithmetic operation 
println student // [name:John, surname:Doe, class:11C]

/* Get Default Values */
import groovy.transform.ToString
@ToString class Teacher { String name }

def student2 = [name: 'John', surname: 'Doe', age: 17, class: '11C', school: 'Groovy School']
println "Attempt to access a non-exisitng key in a map - teacher : " + student2.get('teacher') // produces null

/* Safe way to get a default value if the key does not exist in the Map */
// map.get(key, defaultValue)
/* Note: This actually adds a key,value pair (element) into the Map */
def result = student2.get('teacher', new Teacher(name: "Betty"))

println "Attempt to access a non-exisitng key in a map - teacher with a default value : " + result 
println "Map after adding a default value : " + student2

println "Attempt to access a NOW exisitng key in a map - teacher : " + student2.get('teacher')

def result2 = student2.get('teacher2', 'Raghavan')
println "Attempt to access a non-exisitng key in a map - teacher2 with a default value : " + result2
println "Map after adding a default value : " + student2

/* Map Union */
def studentProp1 = [name: 'John', surname: 'Doe']
def studentProp2 = [age: 17, class: '11C']
def studentProp3 = [school: 'Groovy School']
def studentUnion = studentProp1 + studentProp2 + studentProp3
 
println "Union Map : " + studentUnion // [name:John, surname:Doe, age:17, class:11C, school:Groovy School]
 
/* Map Intersect */
/* Takes the common key,value pair in both the sets */
 def student11 = [name: 'John', surname: 'Doe', age: 17]
 def student12 = [surname: 'Bunny', age: 17]
def sameProperties = student11.intersect(student12) // [age: 17]
 
println "Intersected Map Properties : " + sameProperties // [age:17]

/* Print the keys */
println "Keys of the Map are : " + student.keySet() // [name, surname, age]
def keys = student.keySet()
println "keys type : " + keys.class
println "keys properties : " + keys.properties
//println "keys properties MetaClass : " + keys.properties.getMetaClass().getMethods().each { println it }

/* Print the Values */
def studentValues = student.values() // [John, Doe, 17]
println studentValues // [John, Doe, 17]



