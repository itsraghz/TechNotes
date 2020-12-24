[Home](../) | [05_GroovyUsages](./)

# Groovy Usage - Intellij IDEA

  You can create a new Grovy Project by selecting the built in Groovy Plugin. You need to select the Groovy version installed in your machine.

  From Groovy 2.5+ onwards, it comes with an extra jaxb libraries which need to be manually inserted, otherwise you get an error like below when running a Groovy Script.

  ```
  Information:Groovyc: While compiling groovy-hello-world:java.lang.NoClassDefFoundError: Unable to load class org.apache.groovy.jaxb.extensions.JaxbExtensions due to missing dependency javax/xml/bind/JAXBContext
	at org.codehaus.groovy.vmplugin.v5.Java5.configureClassNode(Java5.java:408)
	at org.codehaus.groovy.ast.ClassNode.lazyClassInit(ClassNode.java:280)
	at org.codehaus.groovy.ast.ClassNode.getMethods(ClassNode.java:400)
	at org.codehaus.groovy.macro.transform.MacroMethodsCache.scanExtClasses(MacroMethodsCache.java:88)
	at org.codehaus.groovy.macro.transform.MacroMethodsCache.access$000(MacroMethodsCache.java:45)
	at org.codehaus.groovy.macro.transform.MacroMethodsCache$2.onModule(MacroMethodsCache.java:69)
	at org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.scanExtensionModuleFromProperties(ExtensionModuleScanner.java:87)
	at org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.scanExtensionModuleFromMetaInf(ExtensionModuleScanner.java:81)
	at org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.scanClasspathModulesFrom(ExtensionModuleScanner.java:63)
	at org.codehaus.groovy.runtime.m12n.ExtensionModuleScanner.scanClasspathModules(ExtensionModuleScanner.java:54)
                      ...............
  ```

## How to Run/Execute - Ultimate Edition

 Press `Shift+F10` in Windows OS to run the Groovy Script. You can also alternatively click on the Green Arrow button to execute it.

## How to Run/Execute - Community Edition

 Intellij IDEA Community edition does not have a direct way to run a script. We need to *Add a Configuration for a runtime* to execute a Groovy Script, which is very similar to set up a configuration for a Java class execution.

> Remember to add the *extra-jaxb-jars* to the classpath otherwise you would get an error.

## Useful link

* https://www.logicbig.com/tutorials/misc/groovy/intellij.html
