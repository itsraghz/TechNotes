# JavaBeans - V1

## BookBean class

```
public class BookBean
{
    private String title;
}
```

It is the simplest class you can ever have with the following.

 * The class declaration with a name of class being *Book*
 * A private member variable called *title* - which is a very minimal property of a book.

> This Java class is a starting point to demonstrate a `Java Bean` with just a property
> minus the accessor/mutator (getter/setter) methods, to help the developers appreciate
> the benefit of using Groovy where we get the Getter/Setters by default :)

## BookBeanTest class

```
public class BookBeanTest
{
    public static void main(String... args)
    {
    	BookBean bean = new BookBean();
    	System.out.println("Bean object is :  " + bean);
    }
}
```

This is the simplest Java class with a `main()` method to test the `BookBean` class.

## Terminal Output

```
C:\raghs\prfsnl\groovyPgms\features\javabeans\versions\v1
λ compileAndRun.bat

ls -ltrh
total 24K
-rw-rw-rw-  1 raghs 0   58 2020-12-28 13:19 BookBean.java
-rw-rw-rw-  1 raghs 0  185 2020-12-28 16:31 BookBeanTest.java
-rw-rw-rw-  1 raghs 0  227 2020-12-28 19:45 BookBean.class
-rw-rw-rw-  1 raghs 0  904 2020-12-28 19:45 BookBeanTest.class
-rwxrwxrwx  1 raghs 0  194 2020-12-28 19:45 compileAndRun.bat
-rw-rw-rw-  1 raghs 0 1.1K 2020-12-28 19:46 REAME.md

rm -rf *.class

javac *.java

ls -ltrh
total 24K
-rw-rw-rw-  1 raghs 0   58 2020-12-28 13:19 BookBean.java
-rw-rw-rw-  1 raghs 0  185 2020-12-28 16:31 BookBeanTest.java
-rwxrwxrwx  1 raghs 0  194 2020-12-28 19:45 compileAndRun.bat
-rw-rw-rw-  1 raghs 0 1.1K 2020-12-28 19:46 REAME.md
-rw-rw-rw-  1 raghs 0  227 2020-12-28 19:47 BookBean.class
-rw-rw-rw-  1 raghs 0  904 2020-12-28 19:47 BookBeanTest.class

java BookBeanTest
Bean object is :  BookBean@3a71f4dd

C:\raghs\prfsnl\groovyPgms\features\javabeans\versions\v1
λ
```

### Terminal Output - Observations

  1. The timestamp of the .class files are latest - after we delete and recompile
  2. The default constructor was not provided by the Developer. But still we are able to
      invoke it in the Test class as `BookBean bean = new BookBean();`.\
      The reason being it will be provided by the Java Compiler, as long
      as it does not have any explicit constructors (NEITHER the `default` constructor NOR the `overloaded` constructors)
  2. The output is very simple as we just print out the object we just created, which
      just prints the `Hashcode` of the object in the Console.  

> The Hashcode is just an unique number in the underlying JVM which is usually
> represented in the Hex Code representation in the pattern `className@HexCode`
