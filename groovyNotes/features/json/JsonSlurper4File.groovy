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
