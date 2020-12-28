# JavaBeans - V2

## BookBean class

```
public class BookBean
{
    private String title;

    public BookBean()
    {
    	this.title="Default Title";
    	System.out.println("BookBean instantiated");
    }

    @Override
    public String toString()
    {
    	return "[Book] hashcode=" + this.hashCode() + ", title="+this.title;
    }
}
```

It is an improved version of the `BookBean` class from the `v1` where we added the following.

 * We (*explicitly) added a `default constructor`, one without any parameters.
 * We added a *SOP* (`System.out.println`) message to understand by when the object is instantiated. \
   Ideally, it will be instantiated when the `new` operator is being used along with the class.
 * We provide a default value to the `title`, which otherwise may be initialized to `null` in Java.
 * We overloaded the `toString()` method with the suitable *annotation* `@Override` to have a meaningful description \
   when we print the object of this `BookBean` class in the logs or terminal.

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

This is the same as that of `V1` to have/get the difference in the output.

## Terminal Output

```
C:\raghs\prfsnl\groovyPgms\features\javabeans\versions\v1
λ compileAndRun.bat

ls -ltrh
total 16K
-rwxrwxrwx  1 raghs 0   76 2020-12-28 13:36 compileAndRun.bat
-rw-rw-rw-  1 raghs 0  316 2020-12-28 13:37 BookBean.java
-rw-rw-rw-  1 raghs 0 2.3K 2020-12-28 20:04 REAME.md
-rw-rw-rw-  1 raghs 0  185 2020-12-28 20:05 BookBeanTest.java

rm -rf *.class
rm: cannot lstat `*.class': Invalid argument

javac *.java

ls -ltrh
total 24K
-rwxrwxrwx  1 raghs 0   76 2020-12-28 13:36 compileAndRun.bat
-rw-rw-rw-  1 raghs 0  316 2020-12-28 13:37 BookBean.java
-rw-rw-rw-  1 raghs 0 2.3K 2020-12-28 20:04 REAME.md
-rw-rw-rw-  1 raghs 0  185 2020-12-28 20:05 BookBeanTest.java
-rw-rw-rw-  1 raghs 0 1.1K 2020-12-28 20:05 BookBean.class
-rw-rw-rw-  1 raghs 0  904 2020-12-28 20:05 BookBeanTest.class

java BookBeanTest
BookBean instantiated
Bean object is :  [Book] hashcode=980546781, title=Default Title

C:\raghs\prfsnl\groovyPgms\features\javabeans\versions\v2
λ
```

### Terminal Output - Observations

  1. The default Constructor was available in the class definition by the developer, meaning \
    the default constructor was explicitly provided by the Developer and hence the Java Compiler \
    does not add it by default.
  2. The rest of the output is same as `V1` except we get an additional line of output as a debug message \
    when we instantiate the object of `BookBean` class, and the meaningful description of the `bean` instance \
    when printed in the output.

> This overridden toString method will NOT have the hashCode value, until you add it manually
> via this.hashCode().
