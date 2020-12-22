
println("Way #1 : Current classpath is (absoluteFile) : " + new File(".").absoluteFile)
println("Way #2 : Current classpath is (absolutePath) : " + new File(".").absolutePath)

println "--------------"
println "All the URLs/entries in the current CLASSPATH : " + getClass().classLoader.URLs

// Use the groovy script's classLoader to add the jar file at runtime.
//this.class.classLoader.rootLoader.addURL(new URL("C://raghs//prfsnl//groovyPgms"));
this.class.classLoader.addURL(new URL("file://C://raghs//prfsnl//groovyPgms//tasteOfGroovy//taste-02//customers.xml"));

println "==============================="

def printClassPath(classLoader) {
  println "$classLoader"
  classLoader.getURLs().each {url->
     println "- ${url.toString()}"
  }
  if (classLoader.parent) {
     printClassPath(classLoader.parent)
  }
}

printClassPath this.class.classLoader