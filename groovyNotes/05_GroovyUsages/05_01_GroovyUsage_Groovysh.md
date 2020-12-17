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


## Summary / Conclusion
