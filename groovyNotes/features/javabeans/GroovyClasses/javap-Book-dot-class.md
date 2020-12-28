# Decompiled class  - BookTest.groovy -> Book.class

`BookTest.groovy` -> `Book.class`

As the class does not have any access specifier specified for the field 'title',
Groovy Compiler produces the `getter` and `setter`.


```
Compiled from "BookTest.groovy"
public class Book implements groovy.lang.GroovyObject {
  public static transient boolean __$stMC;

  public Book();
    Code:
       0: invokestatic  #22                 // Method $getCallSiteArray:()[Lorg/codehaus/groovy/runtime/callsite/CallSite;
       3: astore_1
       4: aload_0
       5: invokespecial #24                 // Method java/lang/Object."<init>":()V
       8: aload_0
       9: invokevirtual #28                 // Method $getStaticMetaClass:()Lgroovy/lang/MetaClass;
      12: astore_2
      13: aload_2
      14: aload_0
      15: swap
      16: putfield      #30                 // Field metaClass:Lgroovy/lang/MetaClass;
      19: aload_2
      20: pop
      21: return

  protected groovy.lang.MetaClass $getStaticMetaClass();
    Code:
       0: aload_0
       1: invokevirtual #36                 // Method java/lang/Object.getClass:()Ljava/lang/Class;
       4: ldc           #2                  // class Book
       6: if_acmpeq     14
       9: aload_0
      10: invokestatic  #42                 // Method org/codehaus/groovy/runtime/ScriptBytecodeAdapter.initMetaClass:(Ljava/lang/Object;)Lgroovy/lang/MetaClass;
      13: areturn
      14: getstatic     #44                 // Field $staticClassInfo:Lorg/codehaus/groovy/reflection/ClassInfo;
      17: astore_1
      18: aload_1
      19: ifnonnull     34
      22: aload_0
      23: invokevirtual #36                 // Method java/lang/Object.getClass:()Ljava/lang/Class;
      26: invokestatic  #50                 // Method org/codehaus/groovy/reflection/ClassInfo.getClassInfo:(Ljava/lang/Class;)Lorg/codehaus/groovy/reflection/ClassInfo;
      29: dup
      30: astore_1
      31: putstatic     #44                 // Field $staticClassInfo:Lorg/codehaus/groovy/reflection/ClassInfo;
      34: aload_1
      35: invokevirtual #53                 // Method org/codehaus/groovy/reflection/ClassInfo.getMetaClass:()Lgroovy/lang/MetaClass;
      38: areturn

  public groovy.lang.MetaClass getMetaClass();
    Code:
       0: aload_0
       1: getfield      #30                 // Field metaClass:Lgroovy/lang/MetaClass;
       4: dup
       5: ifnull        9
       8: areturn
       9: pop
      10: aload_0
      11: dup
      12: invokevirtual #28                 // Method $getStaticMetaClass:()Lgroovy/lang/MetaClass;
      15: putfield      #30                 // Field metaClass:Lgroovy/lang/MetaClass;
      18: aload_0
      19: getfield      #30                 // Field metaClass:Lgroovy/lang/MetaClass;
      22: areturn

  public void setMetaClass(groovy.lang.MetaClass);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #30                 // Field metaClass:Lgroovy/lang/MetaClass;
       5: return

  public java.lang.String getTitle();
    Code:
       0: aload_0
       1: getfield      #63                 // Field title:Ljava/lang/String;
       4: areturn

  public void setTitle(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #63                 // Field title:Ljava/lang/String;
       5: return
}
```
