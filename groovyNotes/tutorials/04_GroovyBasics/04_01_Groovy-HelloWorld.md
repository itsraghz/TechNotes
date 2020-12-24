[Home](../) | [04_GroovyBasics](../04_GroovyBasics)

# Sample Groovy Script

```
println 'Hello, World'
```

It is equivalent to the following in Java.

```
public class Sample
{
  public static void main(String... args)
  {
    System.out.println("Hello, World");
  }
}
```

## Observations

* It reduces the verbosity to a great extent
* It does not really need the ceremonies
   * No need of a class declaration for the simple statements like `println`, they can be just invoked without any orchestration
   * No need of a `main()` method for the invocation point, unlike the typical Java program that necessitates it
   * The `System.out` is implicitly taken for the `print` or `println` methods, making it even more easy for the programmers :)
* Last but not the least, the *semicolons are optional* in Groovy :) :P

## Execution

```
C:\raghs\prfsnl\groovyPgms\basics
λ ls -ltrh
total 8.0K
-rw-rw-rw-  1 raghs 0 179 2020-12-17 11:27 Example.groovy
-rw-rw-rw-  1 raghs 0  24 2020-12-17 23:29 HelloWorld.groovy

C:\raghs\prfsnl\groovyPgms\basics
λ cat HelloWorld.groovy
println 'Hello, World'

C:\raghs\prfsnl\groovyPgms\basics
λ groovy HelloWorld.groovy
Hello, World

C:\raghs\prfsnl\groovyPgms\basics
λ
```

## Summary / Conclusion

 The Groovy Programming Language has reduced a 7 line Java program to be of a single line Groovy Script :)

 > Remember, the *Observations* section above was just to give a taste of the language. There are few nuances and subtleties associated with the concepts shared above, which we will see in detail later at an appropriate topic.
