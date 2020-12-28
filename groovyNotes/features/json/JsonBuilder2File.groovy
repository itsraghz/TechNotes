/**
 *  Script Name  : JsonBuilder2File.groovy
 *
 *  Purpose      : To demonstrate the JsonBuilder class and its methods to generate the JSON object at runtime
 *                 and also to write the JSON data into an Output file. This example also reads back the content
 *                 from the same file and displays the output for confirmation.
 *
 *  Environment  : Tested with -> Groovy Version: 2.4.3 JVM: 1.7.0_80 Vendor: Oracle Corporation OS: Windows 7
 *
 *  URL to refer : http://docs.groovy-lang.org/latest/html/gapi/groovy/json/JsonBuilder.html
 * 
 *  Author       : Raghavan alias Saravanan Muthu (Java Code Geeks)
 *  Date         : 12 Mar 2016
 */
 
package com.javacodegeeks.example.groovy.json;

import groovy.json.JsonBuilder
import groovy.json.JsonOutput

def jsonBuilder = new JsonBuilder()

jsonBuilder.config
{
    env : "Prod"
    database {
        host "example.com"
        port 3306
        type "MySQL"
        user 'dbUser'
        pass 'dbPass'
        driver 'com.mysql.jdbc.Driver'
    }
    threadPool 10
    useBridge 'Y'
}

println "JSONBuilder Object : " + jsonBuilder
println ""
println "JSON Pretty Printed Config "
println "=========================="
println JsonOutput.prettyPrint(jsonBuilder.toString())
println ""

String outputFile = 'config.json'
def fileWriter = new FileWriter(outputFile)
jsonBuilder.writeTo(fileWriter)
fileWriter.flush() /* to push the data from  buffer to file */
println "Config details are written into the file '${outputFile}'"

println ""
def fileContents = new File(outputFile).text
println "File contents : " + fileContents
println ""
println "File Contents PrettyPrint"
println "========================="
println JsonOutput.prettyPrint(fileContents)