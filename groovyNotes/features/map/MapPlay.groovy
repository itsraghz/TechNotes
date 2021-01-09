// Groovy Maps

def emptyStudentMap = [:]
println emptyStudentMap // [:]
 
def studentMap = [name: "John", surname: "Doe", age: 17]
println studentMap // [name:John, surname:Doe, age:17]

println studentMap.properties

def student = [:] // Initialize empty map
student.put('name', 'John') // java notation
student['surname'] = 'Doe' // You can state key in square brackets
student << [age: 17] // This is something output redirection in unix commands. key-value pair put inside map object
student.class = "11C" // Dot notation is also available
student.'school' = "Groovy School" // Same as previous
 
println student // [name:John, surname:Doe, age:17, class:11C, school:Groovy School]

student.remove('age') // Remove by key
println student // [name:John, surname:Doe, class:11C, school:Groovy School]

student = student - [school: 'Groovy School'] // This is something like arithmetic operation 
println student // [name:John, surname:Doe, class:11C]

/* Get Default Values */
import groovy.transform.ToString
@ToString class Teacher { String name }

def student2 = [name: 'John', surname: 'Doe', age: 17, class: '11C', school: 'Groovy School']
def result = student2.get('teacher', new Teacher(name: "Betty"))
println result 

/* Map Union */
def studentProp1 = [name: 'John', surname: 'Doe']
def studentProp2 = [age: 17, class: '11C']
def studentProp3 = [school: 'Groovy School']
def studentUnion = studentProp1 + studentProp2 + studentProp3
 
println "Union Map : " + studentUnion // [name:John, surname:Doe, age:17, class:11C, school:Groovy School]
 
/* Map Intersect */
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





