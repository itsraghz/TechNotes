# Disassembled Employee class (latest)

## Command to disassemble the generated/compiled .class file

`javap -c Employee.class`

## Output of the Disassembled .class file
```
Compiled from "Employee.java"
public class Employee {
  public java.lang.String getName();
    Code:
       0: aload_0
       1: getfield      #1                  // Field name:Ljava/lang/String;
       4: areturn

  public int getAge();
    Code:
       0: aload_0
       1: getfield      #7                  // Field age:I
       4: ireturn

  public char getGender();
    Code:
       0: aload_0
       1: getfield      #11                 // Field gender:C
       4: ireturn

  public void setName(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #1                  // Field name:Ljava/lang/String;
       5: return

  public void setAge(int);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #7                  // Field age:I
       5: return

  public void setGender(char);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #11                 // Field gender:C
       5: return

  public Employee(java.lang.String, int, char);
    Code:
       0: aload_0
       1: invokespecial #15                 // Method java/lang/Object."<init>":()V
       4: aload_0
       5: aload_1
       6: putfield      #1                  // Field name:Ljava/lang/String;
       9: aload_0
      10: iload_2
      11: putfield      #7                  // Field age:I
      14: aload_0
      15: iload_3
      16: putfield      #11                 // Field gender:C
      19: return

  public java.lang.String toString();
    Code:
       0: aload_0
       1: invokevirtual #21                 // Method getName:()Ljava/lang/String;
       4: aload_0
       5: invokevirtual #25                 // Method getAge:()I
       8: aload_0
       9: invokevirtual #29                 // Method getGender:()C
      12: invokedynamic #33,  0             // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;IC)Ljava/lang/String;
      17: areturn
}
```
