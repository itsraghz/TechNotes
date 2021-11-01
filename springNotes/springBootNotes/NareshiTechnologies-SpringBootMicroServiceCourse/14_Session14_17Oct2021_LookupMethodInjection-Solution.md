# SpringBoot MicroServices - Session by Mr Raghu, Naresh IT

Session 14 \
17 Oct 2021 Sun \
8 AM IST - 09 AM IST

# Agenda

* Lookup Method Injection (LMI) - Spring Scope - Solution

## Answer to Spring Singleton Vs Java Singleton

> Ref: https://www.javadevjournal.com/spring/spring-singleton-vs-singleton-pattern/

Spring Singleton is very different from Singleton pattern. Spring guarantees to create only one bean instance for given bean id definition per container. Singleton pattern ensures that one and only one instance is created per ClassLoader.

    * Singleton pattern ensures one instance of a particular class of per class loader.
    * Spring Singleton is  “per container per bean”.

## Solution to the Parent-Child Singleton Vs Prototype - Lookup Method Injection

New Maven Project : *Spring5CoreLookupMethodAnno*
