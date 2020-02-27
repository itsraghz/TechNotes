# Supplier  - Functional Interface

## Definition
	
  * Represets a supplier of results. 	 
  * There is no requiement that a new or distinct result be returned each time the supplier is invoked. 
  * Links 
       - https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
       - https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
  * This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference. 
  * The functional method is *`get()`*

## Syntax
```
  @FunctionalInterface
  public interface Supplier<T>
```

## Methods

  * *functional* - `get()` - returns T --> _applies this function without any arguments_

## Sample Code

```
    Supplier<String> s = () -> ("Java 8 is really fun, when it is SUPPLIED well!");

    // get is the 'functional' method of Supplier Interface (SAM Method)
    // The return type is void(). It does not take any arguments as well.
    System.out.println(s.get());
```

## Sample Output

```
   C:\rags\TechNotes\javaNotes\java8\functionalInterfaces\samplePrograms>java Java8SupplierExample
   Java 8 is really fun, when it is SUPPLIED well!
```

