def str = 'Groovy'
println str

println str.properties

/*str = ''
println str.blank
println str.empty
println str.class
println str.bytes

str = 'ABCDabcd'
println str.blank
println str.empty
println str.bytes

assert str.blank == false*/

//str.properties.each { println it }
//str.class

//println str.getMetaClass().getMethods()
println str.class
str.getMetaClass().getMethods().each {
 if(it.name.equalsIgnoreCase('hashcode')) 
    println it
}

println "===="

str.getMetaClass().getMetaMethods().each {  
 if(it.name.equalsIgnoreCase('getAt')) 
    println it
 } 

println "===="

