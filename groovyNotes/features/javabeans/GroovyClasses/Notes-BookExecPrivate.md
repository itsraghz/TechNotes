```
C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ cat BookTestPrivate.groovy
class BookPrivateField
{
  private String title
}


C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ cat BookExecPrivate.groovy

def book = new BookPrivateField()
println book
println book.title
println book.getTitle()


C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ groovy BookExecPrivate.groovy
BookPrivateField@59a67c3a
null
Caught: groovy.lang.MissingMethodException: No signature of method: BookPrivateField.getTitle() is applicable for argument types: () values: []
Possible solutions: getAt(java.lang.String), getClass()
groovy.lang.MissingMethodException: No signature of method: BookPrivateField.getTitle() is applicable for argument types: () values: []
Possible solutions: getAt(java.lang.String), getClass()
        at BookExecPrivate.run(BookExecPrivate.groovy:5)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)

C:\raghs\prfsnl\groovyPgms\features\javabeans\GroovyClasses
λ
```
