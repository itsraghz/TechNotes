# Supplier  - Functional Interface

## Definition
	
  * Represets a funtion that accepts one argument and produces one result. 
  * Function Interface takes two parameters <A,B> where A is the input parameter type and B is the output/return value. 
  * Links 
       - https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
       - https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
  * This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference. 
  * The functional method is *`apply(Object)`*

## Syntax
```
  @FunctionalInterface
  public interface Function<T,R>
```

## Methods

  * andThen(Function<? super R, ? extends V> after)
  * *functional* - `apply(T t)` - returns R --> _applies this function to the given argument._
  * *default* - compose(Function<? super V, ? extends T> before)
  * *static* - identity() 

## Sample Code

```
  Function<Integer, String> converter = (num) -> Integer.toString(num);

  // apply is the 'functional' interface of Function Interface (SAM Method)
  System.out.println("Length of 26 is : " + converter.apply(26).length());
```

## Sample Output

```
  C:\rags\TechNotes\javaNotes\java8\functionalInterfaces\samplePrograms (master)
  ¿ java Java8FunctionExample
	Length of 26 is : 2
```

