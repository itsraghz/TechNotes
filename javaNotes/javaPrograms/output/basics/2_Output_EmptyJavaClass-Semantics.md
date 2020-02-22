# Output - Empty Java Class Semantics

## Command
`javap -c <compiledClass>`

## Output

`
C:\rags\TechNotes\javaNotes\javaPrograms\basics (master)
λ javap -c EmptyJavaClass.class
Compiled from "EmptyJavaClass.java"
public class EmptyJavaClass {
  public EmptyJavaClass();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return
}
`

