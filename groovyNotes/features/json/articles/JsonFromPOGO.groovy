/**
 *  Script Name  : JsonFromPOGO.groovy
 *
 *  Purpose      : To demonstrate the power of Groovy language to create the JSON data from a POGO (Plain Old Groovy Object)
 *
 *  Environment  : Tested with -> Groovy Version: 2.4.3 JVM: 1.7.0_80 Vendor: Oracle Corporation OS: Windows 7
 *
 *  URL to refer : http://docs.groovy-lang.org/latest/html/gapi/groovy/json/JsonOutput.html
 * 
 *  Author       : Raghavan alias Saravanan Muthu (Java Code Geeks)
 *  Date         : 12 Mar 2016
 */

package com.javacodegeeks.example.groovy.json;

import groovy.json.JsonOutput

class Person
{
    String name
    int age
    
    String toString()
    {
        "[Person] name : ${name}, age : ${age}"
    }
}
def person = new Person(name:'Raghavan',age:34)
println "Person Object : " + person
println "Person Object in JSON : " + JsonOutput.toJson(person)
println "JSON Pretty Print"
println "-----------------"
/* prettyPrint requires a String and NOT an Object */
println JsonOutput.prettyPrint(JsonOutput.toJson(person))
println ""

/* Let us work with a list of Person instances */
def json = JsonOutput.toJson([new Person(name : "Vignesh", age : 50),
            new Person(name : "Murugan", age: 45)])
println "JSON Object List : " + json
println "JSON Pretty Print "
println "------------------"
println JsonOutput.prettyPrint(json)