/**
 *  Script Name  : JsonSlurper2List.groovy
 *
 *  Purpose      : To demonstrate JsonSlurper class and its methods to parse the contents from a JSON equivalent
 *                 List of values and work with the parsed JSON object at runtime for inspecting each attribute
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
def jsonObject = jsonSlurper.parseText('{ "vowels" : ["a", "e", "i", "o", "u"] }')

println "Json Object : " + jsonObject
println "Json Object Type : " + jsonObject.getClass()
println ""

println "Json Object - vowels : " + jsonObject.vowels
println "Json Object - vowels Type : " + jsonObject.vowels.getClass()
println "Json Object - vowels is a List ? " + (jsonObject.vowels instanceof List)
def listSize = jsonObject.vowels.size
println "Json Object - vowels Size : " + listSize
println "Json Object - vowels = first element : " + jsonObject.vowels.get(0)
println "Json Object - vowels = last  element : " + jsonObject.vowels.get(listSize-1)