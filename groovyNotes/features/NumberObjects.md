# Numbers as objects

In Groovy, even a number is treated as an Object, not just as a number. It has got several methods to be invoked directly on each number object.

 A quick glance on the number methods

 * times
 * upto
 * downto
 * plus
 * minus
 * toString
 * toBigInteger
 * each
 * collect

## Methods

```
print 0.class
assert 0.class == java.lang.Integer
```

### Properties

```
println 0.properties
println 0.getProperties()
```

#### Execution in Groovy Shell

```
groovy:000> 0.properties
===> [class:class java.lang.Integer]
groovy:000> println 0.properties
[class:class java.lang.Integer]
===> null
groovy:000> println 0.getProperties()
[class:class java.lang.Integer]
===> null
groovy:000>
```
