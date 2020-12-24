// def - dynamic typing, alias of Object
def dynamic = 1
println dynamic
dynamic = "A String"
println dynamic

int typed = 2
println typed
//typed = "A String value stored in Int" // throws ClassCastException

//org.codehaus.groovy.runtime.typehandling.GroovyCastException:
//  Cannot cast object 'A String value stored in Int' with class 'java.lang.String' to class 'int'
