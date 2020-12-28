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
