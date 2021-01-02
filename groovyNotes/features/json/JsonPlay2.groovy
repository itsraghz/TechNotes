// JSON - Javascript Object Notation

// format to specify the data\
// a data carrier (like XML) 
// MIME Type - 'application/json', similar to plain/text

// data specified in a key,value pair { key: value} and more than one will be comma separated
// a key and value will be separated by a semicolon (':')
// example: A person having name as Raghavan, age as 40
// will be represented in JSON as { Name : "Raghavan", age : 40}

// JSON can be printed neatly for the better human readability, with the indentations preserved
/*
  {
      name : 'Raghavan',
      age : 40
  }
*/

// data types - int, String, boolean (true/false), Object, Array
// Object - is a composite entity specified in a pair of curly braces - '{'  and '}'
// Array is a data structure used to contain a set of (homogeneous - not necessarily) values 
//   specified within a pair of square brackets - '[' and ']' . Example : [a','e','i',''o','u']

// JSON with composite elements
// A person named Raghavan of age 40 works teaches multiple subjects - Groovy, Java, JSON
// can be represented as 
//  
/*
  {
      name : 'Raghavan',
      age : 40,
      subject: ['Java', 'Groovy', 'JSON']
  }
  */
  
  
// Outer most - Object (JSON Object)
// A JSON Object can have either of these - an Object, Array, int, string, boolean etc., or in combination of these (nested)
// nesting can be of any level.

/* ------------------------------------------ */
/*                 JSON Operations            */
/* ------------------------------------------ */
def teacherJson = [ 'Name' : 'Raghavan', age : 40, 'subject': ['Java', 'Groovy']]
println teacherJson
println teacherJson.class

/* ------------------------------------------ */
/*                 Groovy JSON               */
/* ------------------------------------------ */
/*
 Groovy has a special package called groovy.json for all the classes related to JSON
1. JsonOutput - an Utility class to output the JSON data in several formats
2. JsonSlurper - to read/parse a JSON object from a String literal
3. JsonBuilder - to create a JSON object on the fly from within a Groovy Class/script
*/

import groovy.json.JsonOutput;

// Son (Mischevious, Disobedient) <-> Mother (Friendly, flexible) <-> Father (Very Strict)
// Developer <--> Groovy <--> Java 

// similar to flatten() method of a list, it offers a convenient methods to transform 
// the data into a JSON structutre in the output (only in the output, and NOT the actual data)
def teacherJsonObj = JsonOutput.toJson(teacherJson) 
println JsonOutput.toJson(teacherJson)
println teacherJsonObj
println teacherJsonObj.class // still a String

println JsonOutput.prettyPrint(JsonOutput.toJson(teacherJson))

JsonOutput jsonOutputObj = new JsonOutput()
println jsonOutputObj.properties

/*println jsonOutputObj.getMetaClass().getMethods().each { 
    if(it.name.contains("pretty"))
        println it.name
}*/


// -----------------------------------
// JsonSlurper - to read a JSON Literal and give a JSON Object
// --------------------------------------
import groovy.json.JsonSlurper

def teacherJsonTxt = '{"Name" : "Raghavan", "age" : 40, "subject": ["Java", "Groovy"]}'
jsonObjFromSlurper = new JsonSlurper().parseText(teacherJsonTxt)
println jsonObjFromSlurper
println jsonObjFromSlurper.getClass()

println jsonObjFromSlurper.getProperties()

def printJSONElementDetails(jsonObj, jsonElement) {
    println jsonObj[jsonElement]
    println jsonObj.jsonElement
    //TODO: #Raghavan why it prints  org.codehaus.groovy.runtime.NullObject rather than the actual type? 
    println jsonObj.jsonElement.getClass()
    println "is instanceof ArrayList ? " + (jsonObj.jsonElement.getClass()==java.util.ArrayList)
    
}

printJSONElementDetails(jsonObjFromSlurper, 'Name')
printJSONElementDetails(jsonObjFromSlurper, 'age')
printJSONElementDetails(jsonObjFromSlurper, 'subject')

println jsonObjFromSlurper.subject.getClass()

if(jsonObjFromSlurper.subject.getClass()==java.util.ArrayList)
{
    println "... (==) Hey, it is a List.."
}
else 
{
    println "... (==) Hmm, it is NOT a list... "
}

if(jsonObjFromSlurper.subject instanceof List) //instanceof ArrayList, instanceof java.util.ArrayList
{
    println "... (instanceof) Hey, it is a List.."
    
    def listFromObj = jsonObjFromSlurper.subject
    
    listFromObj.each {
        println " ...... list Element : " + it + " | class :  " +  it.class + ", length : " + it.length()
    }
}
else 
{
    println "... (instanceof) Hmm, it is NOT a list... "
}

println "  %% COMPLETED %% "
