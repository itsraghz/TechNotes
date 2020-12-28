/**
 *  Script Name  : JsonSlurper1Basic.groovy
 *
 *  Purpose      : To demonstrate JsonSlurper class and its methods to parse the JSON equivalent text and retrieve a JSON object
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
def inputText = '{"name" : "Groovy", "year": 2005}'

def jsonObject = jsonSlurper.parseText(inputText)
println "JSONObject generated out of JsonSlurper : " + jsonObject

println "jsonObject is of type : " +  jsonObject.getClass()
println "jsonObject is a Map ? " + (jsonObject instanceof Map)
assert jsonObject instanceof Map

println ""
println "Individual Attributes"
println "====================="
println "Object.name -> [" + jsonObject.name + "]"
println "Object.year -> [" + jsonObject.year + "]"