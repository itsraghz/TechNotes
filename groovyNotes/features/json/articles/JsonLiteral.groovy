/**
 *  Script Name  : JsonLiteral.groovy
 *
 *  Purpose      : To demonstrate the power of Groovy language to create the JSON data from a String literal
 *
 *  Environment  : Tested with -> Groovy Version: 2.4.3 JVM: 1.7.0_80 Vendor: Oracle Corporation OS: Windows 7
 *
 *  URL to refer : http://docs.groovy-lang.org/latest/html/gapi/groovy/json/JsonOutput.html
 * 
 *  Author       : Raghavan alias Saravanan Muthu (Java Code Geeks)
 *  Date         : 12 Mar 2016
 */

package com.javacodegeeks.example.groovy.json;

import groovy.json.JsonOutput;

def jsonLiteral = ["name": "Raghavan", "id" : 1]

println "JSON Literal as String : " + jsonLiteral
println "JSON Literal as JSON   : " + JsonOutput.toJson(jsonLiteral)
println "JSON Literal as JSON formatted : "
println JsonOutput.prettyPrint(JsonOutput.toJson(jsonLiteral))