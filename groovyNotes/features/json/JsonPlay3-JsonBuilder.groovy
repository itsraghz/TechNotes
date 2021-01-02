//JsonPlay3 - JsonBuilder

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

JsonBuilder jsonBuilderObj = new JsonBuilder()

println jsonBuilderObj
println jsonBuilderObj.class
println jsonBuilderObj.properties

/*jsonBuilderObj.getMetaClass().getMetaMethods().each {
    println it.name
}*/

jsonBuilderObj.student {
    name 'Raghavan'
    age 40
    subject  'Java', 'Groovy'
}

println jsonBuilderObj
println jsonBuilderObj.class
println jsonBuilderObj.properties
println "-----------------"
println jsonBuilderObj.toString()
println "-----------------"
println jsonBuilderObj.toPrettyString()

/*println jsonBuilderObj.name
println jsonBuilderObj.student.getName()*/

JsonSlurper jsonSlurperObj = new JsonSlurper()
def jsonObj = jsonSlurperObj.parseText(jsonBuilderObj.toString())
println jsonSlurperObj
println jsonObj


