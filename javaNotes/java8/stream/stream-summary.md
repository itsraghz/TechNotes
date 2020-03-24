# Streams

## Quick Bytes - Summary
	
   * A functional programming concept introduced in Java 8
   * `java.util.stream` is the base package
   * `*Stream*` is the Interface (in `java.util.stream` package - `Stream<E>`) that extends to the `BaseStream<T, Stream<T>>` interface
   * Two different types of streams offerred in Java
	- Serial Stream - default to utilize a single core - by invoking a `.stream()` method on a collection defined in `java.util.Collection` interface
	- Parallel Stream - to make use of the multicore, by invoking a `.parallelStream()` method on a collection defined in `java.util.Collection` interface
