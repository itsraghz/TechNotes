import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def jsonFile 
def fileName = 'person.json'

jsonFile = new File(fileName)
String jsonFileContents = jsonFile.text
jsonFileContents = jsonFile.getText('UTF-8')

println jsonFile.properties
println jsonFileContents.class
println jsonFileContents

/*
println "------------------------"

jsonFile.getMetaClass().getMetaMethods().each {
    if(it.name.contains('text') || it.name.contains('Text')) {
        println it
    }
}
*/

println JsonOutput.toJson(jsonFileContents)
//println JsonOutput.prettyPrint(jsonFileContents)
//println JsonOutput.prettyPrint(JsonOutput.toJson(jsonFileContents))

//TODO #Raghavan Why the below line throws an error when it is all nested?

// ERROR : 'org.apache.groovy.json.internal.LazyMap' to class 'groovy.json.JsonSlurper' 
// due to: org.codehaus.groovy.runtime.metaclass.MissingPropertyExceptionNoStack: 
//  No such property: student for class: groovy.json.JsonSlurper

/*def jsonSlurperObj = new JsonSlurper().parseText(jsonFileContents)
println jsonSlurperObj*/

def jsonSlurperObj = new JsonSlurper()
def jsonObj= jsonSlurperObj.parseText(jsonFileContents)
println jsonSlurperObj
println jsonObj

println jsonObj.class
println jsonObj.properties
println "---------------------------------"
println jsonObj.name
println jsonObj.age
println jsonObj.subject
println jsonObj.subject.class
println "subject is a list ? " + (jsonObj.subject instanceof List)
println "---------------------------------"
println jsonObj.properties.each {
    println it.class + "| " + it
}
println "---------------------------------"

/*println jsonObj.getMetaClass().getMethods().each { println it.name}*/