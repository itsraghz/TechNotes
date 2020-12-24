// Scope of Variables

/* No mention of data type, treats the variable in a global scope and binding */
x = 1
println x
println x==1
println this.binding.getVariable("x")==1

/* the def keyword does not keep the variable in the global scope/binding */
def y=2
println y==2

try {
    this.binding.getVariable("y")
} catch (groovy.lang.MissingPropertyException e) {
    println ("Exception occurred")
}
