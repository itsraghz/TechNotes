/**
 *  Script Name  : JsonBuilder1Basic.groovy
 *
 *  Purpose      : To demonstrate the JsonBuilder class and its methods to generate the JSON object at runtime
 *                 in a very easy and simple manner - by adding the JSON attributes and values, without actually
 *                 instantiating an instance of a dedicated class for the same. This script also demonstrates
 *                 the easy way to work with each of the attribute and its semantics from the generated JSON object.
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
import groovy.json.JsonSlurper

/* Part 1 - Create a JSON content on the fly using JsonBuilder */

def builder = new JsonBuilder()
builder.book {
    title 'Head First Java'
    publisher 'Orielly'
    author 'Kathy Sierra', 'Bert Bates'
    year '2005'
    currency 'USD'
    price 44.95
    format 'pdf', 'print'
}

println builder
println ""
println builder.toPrettyString()

/* Part 2 - Parse the Json Content into a JSON Object via JsonSlurper for further usage */

def jsonSlurper = new JsonSlurper()
def jsonBookObj = jsonSlurper.parseText(builder.toString())

println "JsonBook Object : " 
println jsonBookObj
println "JsonBook Object type : " + jsonBookObj.getClass()
println "JsonBook Object size : " + jsonBookObj.size()
println ""

def book = jsonBookObj.book
println "Book Instance : " 
println jsonBookObj.book
println "Book Instance Type : " + book.getClass()
println "Book Instance size : " + jsonBookObj.book.size()
println ""
println "Individual Attributes"
println "----------------------"
println "Title : " +  jsonBookObj.book.title + " || Type : " + book.title.getClass()
println "Author : " + book.author + " || Type : " + book.author.getClass() + " || Size : " + book.author.size
println "Price : " + book.price + " || Type : " + book.price.getClass()
println "Currency : " + book.currency +  " || Type : " + book.currency.getClass()
println "Format : " + book.format +  " || Type : " + book.format.getClass() + " || Size : " + book.format.size