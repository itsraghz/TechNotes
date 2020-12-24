[Home](../) | [02_GroovyFeatures](../02_GroovyFeatures)

# Groovy Features

Features of Groovy

* Superset of Java (Super version)
* Groovy classes and scripts are usually stored in .groovy files
* Scripts contain Groovy statements without any class declaration.
* Scripts can also contain method definitions outside of class definitions.
* It can be compiled and fully integrated with traditional Java application.
* Language level support for maps, lists, regular expressions
* List, map, range, regular expression literals
* Multimethod and metaprogramming
* Supports closures, dynamic typing, metaobject protocol, duck typing
* Support for static and dynamic typing & operator overloading
* Literal declaration for lists (arrays), maps, ranges, and regular expressions
* Groovy Beans similar to Java Beans, GString and GPath
* Closures and currying
* Support for *DSL* (Domain Specific Language), and offers the custom DSLs to be written via `Gradle` (A Groovy based Build tool similar to the Java based Maven) and `Spock`.

## Dynamic Programming, Dynamic typing

An ability to change the data type of a variable at runtime, to offer the flexibility to have more than value.

## Meta programming

In Groovy, we can also change the behavior of objects and classes at runtime, with the feature called Metaprogramming.

## Static Vs Dynamic typing

| Language | Type | Explanation |
| -------- | ---- | ----------- |
| Java  | Static Typing | Resolves the type of variables during the compile time (early) |
| Groovy  | Dynamic Typing | Resolves the type of variables during the runtime (late) |

Groovy supports *optional-typing* (static or dynamic)

## Strong Vs Weakly typed languages

| Language | Type | Explanation |
| -------- | ---- | ----------- |
| Java, Groovy  | Strongly typed | You can't coerce to a wrong type. The language guarantees the type-conformance |
| C  | Weakly typed | You can modify the types inadvertently and the compiler has no way to find that out |

## Seamless Integration with Java

* An additional *jar* at runtime.
* Syntactically aligned with Java
* Seamlessly a Java program can call a Groovy Program and vice versa
