# `gitignore rm -r cached .` command demo - *Interesting exercise*

See the way the command works. Read it till the end to see the traction.
It is not a straight forward journey and it demanded a back and forth push/pull exercise to keep the
repository intact by ONLY removing the already tracked/pushed .class files. 

## command line output

```
C:\rags\TechNotes (master)
¿ git rm -r --cached .
rm '.gitignore'
rm 'LICENSE'
rm 'README.md'
rm 'ToDo.md'
rm 'gitHubDotComPractices/gitHubMarkdownPractice.md'
rm 'gitNotes/gitCommands-summary.md'
rm 'gitNotes/gitErrors.md'
rm 'gitNotes/gitFAQ.md'
rm 'gitNotes/output/1_git-remote-set-url-output.md'
rm 'gitNotes/output/2_git-push-after-remote-set-url-output.md'
rm 'gitNotes/output/3_gitignore_demo-output.md'
rm 'javaNotes/java8/functionalInterfaces/consumer.md'
rm 'javaNotes/java8/functionalInterfaces/function.md'
rm 'javaNotes/java8/functionalInterfaces/functionalInterfaces-summary.md'
rm 'javaNotes/java8/functionalInterfaces/predicate.md'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample.class'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample.java'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample2.class'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample2.java'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8FunctionExample.class'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8FunctionExample.java'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateExample.class'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateExample.java'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample$1.class'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample.class'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample.java'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/output/1_Output-Java8PredicateExample.txt'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/output/2_Output-Java8PredicateNonLambdaExample.txt'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/output/3_Output_Java8ConsumerExample.txt'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/output/4_Output_JavaConsumerExample2.txt'
rm 'javaNotes/java8/functionalInterfaces/samplePrograms/output/5_Output_Java8FunctionExample.md'
rm 'javaNotes/java8/lambdas/lambda-summary.md'
rm 'javaNotes/javaPrograms/basics/ChainedTernaryOperatorDemo.class'
rm 'javaNotes/javaPrograms/basics/ChainedTernaryOperatorDemo.java'
rm 'javaNotes/javaPrograms/basics/CommandLineArgsPrint.class'
rm 'javaNotes/javaPrograms/basics/CommandLineArgsPrint.java'
rm 'javaNotes/javaPrograms/basics/EmptyJavaClass.class'
rm 'javaNotes/javaPrograms/basics/EmptyJavaClass.java'
rm 'javaNotes/javaPrograms/basics/JavaDataTypesIntOctalPrefix.class'
rm 'javaNotes/javaPrograms/basics/JavaDataTypesIntOctalPrefix.java'
rm 'javaNotes/javaPrograms/basics/JavaPgmWithIfAndElseIf.class'
rm 'javaNotes/javaPrograms/basics/JavaPgmWithIfAndElseIf.java'
rm 'javaNotes/javaPrograms/basics/enum/JavaEnumDemo.java'
rm 'javaNotes/javaPrograms/output/basics/1_Output_CommandLineArgsPrint.md'
rm 'javaNotes/javaPrograms/output/basics/2_Output_EmptyJavaClass-Semantics.md'
rm 'javaNotes/javaPrograms/output/basics/3_Output_JavaPgmWithIfAndElseIf.md'
rm 'javaNotes/javaPrograms/output/basics/4_Output_ChainedTernaryOperator.md'
rm 'javaNotes/javaPrograms/output/basics/5_Output_JavaDataTypesIntOctalPrefix.md'
rm 'javaNotes/javaPrograms/output/basics/enum/1_Output_JavaEnumDemo.md'
rm 'springNotes/IDE-Stuff/1_How-to-increase-eclipse-treeview-font-size.txt'
rm 'springNotes/Spring-Errors/Spring-Errors-Resolutions.txt'
rm 'springNotes/Spring-QuickBytes/Spring-Aspect-Proxies.md'
rm 'springNotes/Spring-QuickBytes/Spring-Beans-Notes.md'
rm 'springNotes/Spring-QuickBytes/Spring-Component-Scan.md'
rm 'springNotes/Spring-QuickBytes/Spring-LifeCycle-Methods.md'
rm 'springNotes/Spring-QuickBytes/Spring-Notes-Summary.md'
rm 'vimNotes/vimEditorCommands.md'

C:\rags\TechNotes (master)
¿ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        deleted:    .gitignore
        deleted:    LICENSE
        deleted:    README.md
        deleted:    ToDo.md
        deleted:    gitHubDotComPractices/gitHubMarkdownPractice.md
        deleted:    gitNotes/gitCommands-summary.md
        deleted:    gitNotes/gitErrors.md
        deleted:    gitNotes/gitFAQ.md
        deleted:    gitNotes/output/1_git-remote-set-url-output.md
        deleted:    gitNotes/output/2_git-push-after-remote-set-url-output.md
        deleted:    gitNotes/output/3_gitignore_demo-output.md
        deleted:    javaNotes/java8/functionalInterfaces/consumer.md
        deleted:    javaNotes/java8/functionalInterfaces/function.md
        deleted:    javaNotes/java8/functionalInterfaces/functionalInterfaces-summary.md
        deleted:    javaNotes/java8/functionalInterfaces/predicate.md
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample.java
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample2.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample2.java
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8FunctionExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8FunctionExample.java
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateExample.java
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample$1.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample.java
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/output/1_Output-Java8PredicateExample.txt
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/output/2_Output-Java8PredicateNonLambdaExample.txt
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/output/3_Output_Java8ConsumerExample.txt
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/output/4_Output_JavaConsumerExample2.txt
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/output/5_Output_Java8FunctionExample.md
        deleted:    javaNotes/java8/lambdas/lambda-summary.md
        deleted:    javaNotes/javaPrograms/basics/ChainedTernaryOperatorDemo.class
        deleted:    javaNotes/javaPrograms/basics/ChainedTernaryOperatorDemo.java
        deleted:    javaNotes/javaPrograms/basics/CommandLineArgsPrint.class
        deleted:    javaNotes/javaPrograms/basics/CommandLineArgsPrint.java
        deleted:    javaNotes/javaPrograms/basics/EmptyJavaClass.class
        deleted:    javaNotes/javaPrograms/basics/EmptyJavaClass.java
        deleted:    javaNotes/javaPrograms/basics/JavaDataTypesIntOctalPrefix.class
        deleted:    javaNotes/javaPrograms/basics/JavaDataTypesIntOctalPrefix.java
        deleted:    javaNotes/javaPrograms/basics/JavaPgmWithIfAndElseIf.class
        deleted:    javaNotes/javaPrograms/basics/JavaPgmWithIfAndElseIf.java
        deleted:    javaNotes/javaPrograms/basics/enum/JavaEnumDemo.java
        deleted:    javaNotes/javaPrograms/output/basics/1_Output_CommandLineArgsPrint.md
        deleted:    javaNotes/javaPrograms/output/basics/2_Output_EmptyJavaClass-Semantics.md
        deleted:    javaNotes/javaPrograms/output/basics/3_Output_JavaPgmWithIfAndElseIf.md
        deleted:    javaNotes/javaPrograms/output/basics/4_Output_ChainedTernaryOperator.md
        deleted:    javaNotes/javaPrograms/output/basics/5_Output_JavaDataTypesIntOctalPrefix.md
        deleted:    javaNotes/javaPrograms/output/basics/enum/1_Output_JavaEnumDemo.md
        deleted:    springNotes/IDE-Stuff/1_How-to-increase-eclipse-treeview-font-size.txt
        deleted:    springNotes/Spring-Errors/Spring-Errors-Resolutions.txt
        deleted:    springNotes/Spring-QuickBytes/Spring-Aspect-Proxies.md
        deleted:    springNotes/Spring-QuickBytes/Spring-Beans-Notes.md
        deleted:    springNotes/Spring-QuickBytes/Spring-Component-Scan.md
        deleted:    springNotes/Spring-QuickBytes/Spring-LifeCycle-Methods.md
        deleted:    springNotes/Spring-QuickBytes/Spring-Notes-Summary.md
        deleted:    vimNotes/vimEditorCommands.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)

        .gitignore
        LICENSE
        README.md
        ToDo.md
        gitHubDotComPractices/
        gitNotes/
        javaNotes/
        springNotes/
        vimNotes/


C:\rags\TechNotes (master)
¿ git add **/*
warning: LF will be replaced by CRLF in gitHubDotComPractices/gitHubMarkdownPractice.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in gitNotes/gitCommands-summary.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in gitNotes/gitErrors.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in gitNotes/gitFAQ.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in gitNotes/output/1_git-remote-set-url-output.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in gitNotes/output/2_git-push-after-remote-set-url-output.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in gitNotes/output/3_gitignore_demo-output.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/consumer.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/function.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/functionalInterfaces-summary.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/predicate.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample2.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/samplePrograms/Java8FunctionExample.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateExample.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/samplePrograms/output/3_Output_Java8ConsumerExample.txt.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/samplePrograms/output/4_Output_JavaConsumerExample2.txt.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/functionalInterfaces/samplePrograms/output/5_Output_Java8FunctionExample.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/java8/lambdas/lambda-summary.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/basics/ChainedTernaryOperatorDemo.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/basics/CommandLineArgsPrint.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/basics/EmptyJavaClass.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/basics/JavaDataTypesIntOctalPrefix.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/basics/JavaPgmWithIfAndElseIf.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/basics/enum/JavaEnumDemo.java.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/output/basics/1_Output_CommandLineArgsPrint.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/output/basics/2_Output_EmptyJavaClass-Semantics.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/output/basics/3_Output_JavaPgmWithIfAndElseIf.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/output/basics/4_Output_ChainedTernaryOperator.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/output/basics/5_Output_JavaDataTypesIntOctalPrefix.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/output/basics/enum/1_Output_JavaEnumDemo.md.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in vimNotes/vimEditorCommands.md.
The file will have its original line endings in your working directory.

C:\rags\TechNotes (master)
¿ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        deleted:    .gitignore
        deleted:    LICENSE
        deleted:    README.md
        deleted:    ToDo.md
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample2.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8FunctionExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample$1.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample.class
        deleted:    javaNotes/javaPrograms/basics/ChainedTernaryOperatorDemo.class
        deleted:    javaNotes/javaPrograms/basics/CommandLineArgsPrint.class
        deleted:    javaNotes/javaPrograms/basics/EmptyJavaClass.class
        deleted:    javaNotes/javaPrograms/basics/JavaDataTypesIntOctalPrefix.class
        deleted:    javaNotes/javaPrograms/basics/JavaPgmWithIfAndElseIf.class

Untracked files:
  (use "git add <file>..." to include in what will be committed)

        .gitignore
        LICENSE
        README.md
        ToDo.md


C:\rags\TechNotes (master)
¿ git add .gitignore LICENSE README.md ToDo.md
warning: LF will be replaced by CRLF in .gitignore.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in ToDo.md.
The file will have its original line endings in your working directory.

C:\rags\TechNotes (master)
¿ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8ConsumerExample2.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8FunctionExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateExample.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample$1.class
        deleted:    javaNotes/java8/functionalInterfaces/samplePrograms/Java8PredicateNonLambdaExample.class
        deleted:    javaNotes/javaPrograms/basics/ChainedTernaryOperatorDemo.class
        deleted:    javaNotes/javaPrograms/basics/CommandLineArgsPrint.class
        deleted:    javaNotes/javaPrograms/basics/EmptyJavaClass.class
        deleted:    javaNotes/javaPrograms/basics/JavaDataTypesIntOctalPrefix.class
        deleted:    javaNotes/javaPrograms/basics/JavaPgmWithIfAndElseIf.class


C:\rags\TechNotes (master)
¿
```
