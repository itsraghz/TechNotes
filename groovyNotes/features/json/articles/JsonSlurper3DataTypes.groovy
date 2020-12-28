/**
 *  Script Name  : JsonSlurper3DataTypes.groovy
 *
 *  Purpose      : To demonstrate JsonSlurper class and its methods to parse the contents from a text (literal)
 *                 and work with the JSON object for inspecting the data type of each of the attributes
 *
 *  Environment  : Tested with -> Groovy Version: 2.4.3 JVM: 1.7.0_80 Vendor: Oracle Corporation OS: Windows 7
 *
 *  URL to refer : http://docs.groovy-lang.org/latest/html/gapi/groovy/json/JsonSlurper.html
 * 
 *  Author       : Raghavan alias Saravanan Muthu (Java Code Geeks)
 *  Date         : 12 Mar 2016
 */
 
package com.javacodegeeks.example.groovy.json;

import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
def jsonObject = jsonSlurper.parseText '''
    {
        "name"        : "Raghavan",
        "age"         : 23,
        "temp"        : 98.4,
        "salary"      : 40000.25
    }
'''

println "JSON Object :  " + jsonObject
println "JSON Object class : " + jsonObject.getClass()
println ""
println "Individual Attributes and Data types "
println "======================================"
println "Datatype of name :  " + jsonObject.name.class
println "Datatype of age : " + jsonObject.age.class
println "Datatype of temp : " + jsonObject.temp.class
println "Datatype of salary : " + jsonObject.salary.class