# Consumer  - Functional Interface

## Definition

	- Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
	- Javadoc Link : https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
	- Declared with the newly introduced Annotation @FunctionalInterface

## Available Methods

	- accept(T t) - functional method to test this interface (SAM method)
	- andThen(Consumer<? super T) after) - default method that returns a composed Consumer that performs, in sequence, this operation followed by the after operation.

## Example Program

```
import java.util.function.Consumer;

 Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
       // accept is the functional method, does not return anything (void)
 consumerStr.accept("Java 8 is Really Awesome!");
```

## Output

```
$ java Java8ConsumerExample
java 8 is really awesome!`
````

## Note
	Check the `samplePrograms` and the `samplePrograms\output` directories for the complete workable example Java Program and the output.
