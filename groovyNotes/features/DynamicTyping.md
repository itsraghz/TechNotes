# Dynamic typing

## Groovy Shell

Groovy Shell treats the variables defined with the keyword `def` as a short living entity.
The variable lives only during the statement when it is declared and then it ceases to exist
immediately after completing the execution of the statement.

### Example in Groovy Shell

```
λ groovysh
Groovy Shell (3.0.7, JVM: 14.0.2)
Type ':help' or ':h' for help.
-------------------------------------------------------------------------------
groovy:000> x = 'Groovy'
===> Groovy
groovy:000> println x
Groovy
===> null
groovy:000> def x = 'Java'
===> Java
groovy:000> println x
Groovy
===> null
groovy:000>
```

```
groovy:000> def y =  'Java'
===> Java
groovy:000> println y
Unknown property: y
groovy:000>
```

If you observe the snippet above, we define two variables both have the name `x` but with different types.
One without any type, and other one with the `def` type.

At first, a variable 'x' is declared and initialized with a value 'Groovy' and it is printed on the console.
Later the same variable 'x' is declared with a `def` type (for dynamic) and initialized a value 'Java'.

When we attempt to print the value 'x' now, the Groovy Shell prints the value 'Groovy' - as that of the variable which
was declared without any type - which is what Groovy Shell binds to the context/scope of the shell/session.

> The Groovy Shell treats the `def` typed variable only for a very short period, only till the declaration statement execution.

## GroovyConsole GUI

In GroovyConsole GUI, Groovy behaves differently. The variable with the `def` type declaration if any, is retained in the
context/session until it is overridden with a different value, which is quite opposite to the Groovy Shell.

### GroovyConsole Example

#### Script

```
// def - dynamic typing, alias of Object
dynamic = "A String"
println dynamic
def dynamic = 1
println dynamic

println "Taking a break....."
println dynamic

dynamic = 'Groovy'
println dynamic
```

#### Output

```
A String
1
Taking a break.....
1
Groovy
```
