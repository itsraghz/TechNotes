import groovy.json.JsonOutput

def jsonLiteral = ["name": "Raghavan", "id": 1]
println jsonLiteral
println JsonOutput.toJson(jsonLiteral)

def jsonOutput = JsonOutput.toJson(jsonLiteral)
println JsonOutput.prettyPrint(jsonOutput)

println "--------------------------"
def jsonObj = new JsonOutput()
println jsonObj
println jsonObj.properties
//jsonObj.getMetaClass().getMethods().each { println it.name + " --> " + it}

println jsonObj.toJson(3)

/* From Map */
println jsonObj.toJson([1:'One', 2: 'Two', 3: 'Three'])
println JsonOutput.prettyPrint(jsonObj.toJson([1:'One', 2: 'Two', 3: 'Three']))

class Employee
{
    String firstName, lastName
    
    String toString()
    {
         "[Employee] firstName : " + firstName + ", lastName : " + lastName
    }
}

def emp1 = new Employee()
println emp1
def emp2 = new Employee(firstName: 'Raghavan', lastName: 'Muthu')
println emp2
def emp3 = new Employee('firstName': 'Shyam', lastName: 'Vishwanathan')
println emp3
//groovy.lang.GroovyRuntimeException: Could not find matching constructor for: Employee(String, String) 
/*def emp4 = new Employee('Java', 'Groovy')
println emp4*/

def printJson(obj) { 
    //println JsonOutput.toJson(obj)
    
    /* Error: groovy.lang.MissingMethodException: 
           No signature of method: static groovy.json.JsonOutput.prettyPrint() is applicable for argument types: 
           (Employee) values: [[Employee] firstName : Raghavan, lastName : Muthu]
    */
    //println JsonOutput.prettyPrint(obj)
    
    def jsonObj = JsonOutput.toJson(obj)
    println JsonOutput.prettyPrint(jsonObj)
}

printJson(emp2)

def jsonList = [emp1, emp2, emp3]
println jsonList
def jsonParsedObjList = JsonOutput.toJson(jsonList)
println jsonParsedObjList
println "--------------------------"
println JsonOutput.prettyPrint(jsonParsedObjList)

println "==================== "

// ========================================================
//                      JsonSlurper 
// ========================================================

// you can import a class in the mid way of a Groovy Script :) unlike Java.
import groovy.json.JsonSlurper

JsonSlurper jsonSlurper = new JsonSlurper();

// parseText --> public java.lang.Object groovy.json.JsonSlurper.parseText(java.lang.String)
jsonSlurper.getMetaClass().getMethods().each { 
    if(it.name.contains('parseText'))
        println it.name + " --> " + it
}

println ""
println ""
println ""

// ===================================================
//                    JsonBuilder
// ==================================================
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
 
// Part 1 - Create a JSON content on the fly using JsonBuilder 
 
def builder = new JsonBuilder()
builder.book {
    title 'Head First Java'
    publisher 'Orielly'
    author 'Kathy Sierra', 'Bert Bates'
    year '2005'
    currency 'USD'
    price 44.95
    format 'pdf', 'print'
}
 
println builder
println ""
println builder.toPrettyString()

/* Part 2 - Parse the Json Content into a JSON Object via JsonSlurper for further usage */
 
def jsonSlurper2 = new JsonSlurper()
def jsonBookObj = jsonSlurper2.parseText(builder.toString())
 
println "JsonBook Object : "
println jsonBookObj
println "JsonBook Object type : " + jsonBookObj.getClass()
println "JsonBook Object size : " + jsonBookObj.size()
println ""
 
def book = jsonBookObj.book
println "Book Instance : "
println jsonBookObj.book
println "Book Instance Type : " + book.getClass()
println "Book Instance size : " + jsonBookObj.book.size()
println ""
println "Individual Attributes"
println "----------------------"
println "Title : " +  jsonBookObj.book.title + " || Type : " + book.title.getClass()
println "Author : " + book.author + " || Type : " + book.author.getClass() + " || Size : " + book.author.size
println "Price : " + book.price + " || Type : " + book.price.getClass()
println "Currency : " + book.currency +  " || Type : " + book.currency.getClass()
println "Format : " + book.format +  " || Type : " + book.format.getClass() + " || Size : " + book.format.size