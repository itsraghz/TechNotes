import groovy.json.JsonOutput
 
class Person
{
    String name
    int age
     
    String toString()
    {
        "[Person] name : ${name}, age : ${age}"
    }
}
def person = new Person(name:'Raghavan',age:34)
println "Person Object : " + person
println "Person Object in JSON : " + JsonOutput.toJson(person)
println "JSON Pretty Print"
println "-----------------"
// prettyPrint requires a String and NOT an Object
println JsonOutput.prettyPrint(JsonOutput.toJson(person))
println ""
 
/* Let us work with a list of Person instances */
def json = JsonOutput.toJson([new Person(name : "Vignesh", age : 50),
            new Person(name : "Murugan", age: 45)])
println "JSON Object List : " + json
println "JSON Pretty Print "
println "------------------"
println JsonOutput.prettyPrint(json)