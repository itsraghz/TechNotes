// Scope of Variables

/* No mention of data type, treats the variable in a global scope and binding */
x = 1
println x
println x==1
println this.binding.getVariable("x")==1

/* the def keyword does not keep the variable in the global scope/binding */
def y=2
println y==2
println y

try {
    this.binding.getVariable("y")
} catch (groovy.lang.MissingPropertyException e) {
    println ("Exception occurred")
}

println this.binding.properties

/*
def method1() {
   var1 = "var1 declared inside method1()"
   defVar1 = "defVar1 declared inside method1()"
   println var1
   println defVar1
   
   println x
   
   if(this.binding.getVariable("y"))
      println y
   else
       println "there is no variable called y bound in the global scope"
}

method1()*/

