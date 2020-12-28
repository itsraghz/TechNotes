/**
 *  Script Name  : JsonSlurper4File.groovy
 *
 *  Purpose      : To demonstrate JsonSlurper class and its methods along with File Reading capacity of Groovy
 *                 to read the contents from an input file (hard coded) and get an equivalent JSON object at runtime 
 *                 to work with the JSON object and its attributes
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
import groovy.json.JsonOutput

String inputFile = 'employee.json'
String fileContents = new File(inputFile).getText('UTF-8')

def jsonSlurper = new JsonSlurper()
def jsonObject = jsonSlurper.parseText(fileContents)

println "JSONObject : " + jsonObject
println ""
println "JSONObject type : " + jsonObject.getClass()
println " "
println "JSONObject pretty printed"
println "========================="
println JsonOutput.prettyPrint(fileContents)
println ""
println "Individual Attributes"
println "---------------------"
println "JSONObject employee firstName : " + jsonObject.employee.firstName
println "JSONObject employee age : " + jsonObject.employee.age
println "JSONObject employee project name : " + jsonObject.employee.project.name