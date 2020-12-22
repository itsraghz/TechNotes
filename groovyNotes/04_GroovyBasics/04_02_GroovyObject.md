
# GroovyObject

Similar to the `java.lang.Object` class which is a super class of all the other classes in the Java/JDK world,
we have an *Interface* named [*GroovyObject*](http://docs.groovy-lang.org/latest/html/api/groovy/lang/GroovyObject.html) defined in the `groovy.lang` package, and this will be implemented by all the Groovy objects in the GDK space.

> It is very helpful when we have to deal with the Groovy objects when inside the Java world, ie., while calling Groovy from within a Java program.


## java.lang.Object Vs groovy.lang.GroovyObject

| Object | Package | Type | Purpose |
| ------ | ------- | ---- | ------- |
| Java Object | `java.lang` | Class | Super class for all Java objects, without being explicitly `extend`ed |
| GroovyObject | `groovy.lang` | Interface | Super class object being implicitly implemented by all the Objects in the Groovy ecosystem |
