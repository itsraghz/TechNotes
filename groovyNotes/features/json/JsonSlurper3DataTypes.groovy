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
