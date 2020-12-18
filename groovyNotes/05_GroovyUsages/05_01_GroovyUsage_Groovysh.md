[Home](../) | [05_GroovyUsages](./)

# Groovy Usage - Groovy Shell (groovysh)

Open a Terminal / Command Prompt and type `groovysh` to invoke the *Groovy Shell* which is a *REPL* tool.

> REPL stands for Read, Evaluate, Print and Loop - that facilitates a quick way of programming these common 4 tasks without really creating
a structure for the sake of ceremony.

> Remember: You should have set the *Groovy Executable* in the `PATH` environment variable prior, to invoke the `groovysh` on the terminal. Refer to the [01_GroovyInstall](../03_GroovyInstall.md) for more details on the same.

```
C:\raghs\prfsnl\groovyPgms\basics                                                         
λ groovysh                                                                                
Groovy Shell (3.0.7, JVM: 14.0.2)                                                         
Type ':help' or ':h' for help.                                                            
-------------------------------------------------------------------------------           
groovy:000> print 'Hello, Groovy'                                                         
Hello, Groovy===> null                                                                    
groovy:000> println 'Hello, Groovy - newline';                                            
Hello, Groovy - newline                                                                   
===> null                                                                                 
groovy:000> 2.class                                                                       
===> class java.lang.Integer                                                              
groovy:000> "Groovy".class                                                                
===> class java.lang.String                                                               
groovy:000> println 'press Ctrl+C to quit this groovysh interactive terminal'             
press Ctrl+C to quit this groovysh interactive terminal                                   
===> null                                                                                 
groovy:000> Terminate batch job (Y/N)? y                                                  

C:\raghs\prfsnl\groovyPgms\basics                                                         
λ                                                                                         
```

## Observations


## Groovysh help

Type `:help` on the `groovysh` prompt, it will display the list of available commands you can issue.

```
groovy:000> :help

For information about Groovy, visit:
    http://groovy-lang.org

Available commands:
  :help      (:h ) Display this help message
  ?          (:? ) Alias to: :help
  :exit      (:x ) Exit the shell
  :quit      (:q ) Alias to: :exit
  import     (:i ) Import a class into the namespace
  :display   (:d ) Display the current buffer
  :clear     (:c ) Clear the buffer and reset the prompt counter
  :show      (:S ) Show variables, classes or imports
  :inspect   (:n ) Inspect a variable or the last result with the GUI object browser
  :purge     (:p ) Purge variables, classes, imports or preferences
  :edit      (:e ) Edit the current buffer
  :load      (:l ) Load a file or URL into the buffer
  .          (:. ) Alias to: :load
  :save      (:s ) Save the current buffer to a file
  :record    (:r ) Record the current session to a file
  :history   (:H ) Display, manage and recall edit-line history
  :alias     (:a ) Create an alias
  :set       (:= ) Set (or list) preferences
  :grab      (:g ) Add a dependency to the shell environment
  :register  (:rc) Register a new command with the shell
  :doc       (:D ) Open a browser window displaying the doc for the argument

For help on a specific command type:
    :help command

groovy:000>
```
## Groovysh display

```
groovy:000> :display
Buffer is empty
groovy:000>
```

## FAQs

### Why the variable defined with `def` (typed variables) is not working in `groovysh` but works on `groovy`?

A variable declared with def or a data type is not stored in the session and will be lost as soon as the command is issued.

```
groovy:000> Integer s3 = 3
===> 3
groovy:000> s3
Unknown property: s3
groovy:000>
```

The below example demonstrates that even if you type the variable s2, it shows the variable in the `groovysh` session (which is not a typed variable)

```
groovy:000> s2 = "Java"
===> Java
groovy:000> Integer s2 = 3
===> 3
groovy:000> s2
===> Java
```

## Summary / Conclusion
