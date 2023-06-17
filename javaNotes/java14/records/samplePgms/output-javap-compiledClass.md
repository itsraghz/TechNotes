# Disassembled .class file 

```sh
➜  records git:(master) ✗ javac Person.java 
➜  records git:(master) ✗ ls
Person.class Person.java
➜  records git:(master) ✗
```


```java
➜  records git:(master) ✗ javap -c Person.class
Compiled from "Person.java"
public final class Person extends java.lang.Record {
  public Person(java.lang.String, int);
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Record."<init>":()V
       4: aload_0
       5: aload_1
       6: putfield      #7                  // Field name:Ljava/lang/String;
       9: aload_0
      10: iload_2
      11: putfield      #13                 // Field age:I
      14: return

  public final java.lang.String toString();
    Code:
       0: aload_0
       1: invokedynamic #17,  0             // InvokeDynamic #0:toString:(LPerson;)Ljava/lang/String;
       6: areturn

  public final int hashCode();
    Code:
       0: aload_0
       1: invokedynamic #21,  0             // InvokeDynamic #0:hashCode:(LPerson;)I
       6: ireturn

  public final boolean equals(java.lang.Object);
    Code:
       0: aload_0
       1: aload_1
       2: invokedynamic #25,  0             // InvokeDynamic #0:equals:(LPerson;Ljava/lang/Object;)Z
       7: ireturn

  public java.lang.String name();
    Code:
       0: aload_0
       1: getfield      #7                  // Field name:Ljava/lang/String;
       4: areturn

  public int age();
    Code:
       0: aload_0
       1: getfield      #13                 // Field age:I
       4: ireturn
}
```
