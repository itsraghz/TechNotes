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
