// def customers = new XmlSlurper().parse(new File('customers.xml'))

/* To make it working in GroovyConsole, but works pretty well in Groovy Command as well */

/* Reason being, generally GroovyConsole when invoked does not have the relative path/classpath set, until we programatically defined, unlike
the Groovy Command which mostly has the current directory set in the CLASSPATH environment variable */

def customers = new XmlSlurper().parse(new File('C://raghs//prfsnl//groovyPgms//tasteOfGroovy//taste-02//customers.xml'))

for (customer in customers.corporate.customer) {
  println "${customer.@name} works for ${customer.@company}"
}