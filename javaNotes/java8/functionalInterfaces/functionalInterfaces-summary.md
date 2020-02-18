# Functional Interfaces

## Definition
   - An interface that contains at most one abstract function (SAM - Single Abstract Method)
   - Represents abstract concepts such as functions, actions and predicates
   - An interface can have other methods like default method, static etc., (introduced in Java 8) which do NOT count as an abstract method
   - Javadoc Link : https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html

## Package
   - A new package defined in Java 8 - _java.util.function_.

## Popular Functional Interfaces
   - Predicate --> Takes one argument, returns a Boolean (test() method with a condition)
   - Consumer --> Accepts a single argument with no return value
   - Function --> Accepts one argument and produces a result
   - Supplier --> Represents a supplier of results (unlike functions, they do not accept arguments)
   - UnaryOperator --> Takes a single operator and returns a value
   - BinaryOperator --> Takes two arguments and returns a value



