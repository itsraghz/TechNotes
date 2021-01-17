/* 
## XML Parsing in Groovy

    Official Documentation: 
    -----------------------
    https://docs.groovy-lang.org/latest/html/documentation/#_processing_xml

    XML Parsing comes very easy and handy in Groovy 
    by means of the following two classes in the groovy.xml package.

    XMLSlurper
    XMLParser

    Both the classes support the XML parsing and has a rich set of API methods.
    
    Similiarities
    =============
    Both are based on SAX so they both are low memory footprint
    Both can update/transform the XML

    Differences : https://stackoverflow.com/questions/7558019/groovy-xmlslurper-vs-xmlparser
    
    XmlSlurper evaluates the structure lazily. So if you update the xml you’ll have to evaluate the whole tree again.
    XmlSlurper returns GPathResult instances when parsing XML
    XmlParser returns Node objects when parsing XML

    Parser creates a DOM equivalent structure in memory, whereas Slurper uses GPath and 
    evaluates on demand everytime, without relying on the in memory equivalent data.    
    
    Practical Use Cases
    ===================
    If you want to transform an existing document to another then XmlSlurper will be the choice
    If you want to update and read at the same time then XmlParser is the choice.
    If you just have to read a few nodes XmlSlurper should be your choice, since it will not have to create a complete structure in memory"    

    Summary
    ========
    - XML Parser Is Faster Then XML Slurper.
    - XML Slurper Consumes Lesser Memory Than XML Parser.
    - XML Parser Can Parse And Update The XML Simultaneously.
    - For XML Slurper You Need To MarkupBuild The XML's After Each Update You Make.
    - When You Want To use Path Expressions XML Slurper Would Be Better Than Parser.
    - For Reading Almost All Nodes XML Parser Would Be Fine

## GPath Expression 

    It is similar to XPath expressions and you can use it not only with XML but also with POJO classes.
    
    Example
    =======
    a.b.c ? for XML, yields all the <c> elements inside <b> inside <a>
    a.b.c ? all POJOs, yields the <c> properties for all the <b> properties of <a> (sort of like a.getB().getC() in JavaBeans)


For XML, you can also specify attributes, e.g.:
    a["@href"] ? the href attribute of all the a elements
    a.'@href' ? an alternative way of expressing this
    a.@href ? an alternative way of expressing this when using XmlSlurper

*/


/*
 ## XMLSlurper - From a Literal Text    
*/

def text = '''
    <list>
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
'''

def list = new XmlSlurper().parseText(text) 

println list
println list.getClass() // groovy.util.slurpersupport.NodeChild
//assert list instanceof groovy.xml.slurpersupport.GPathResult 
assert list.technology.name == 'Groovy' //Traversing the tree in a GPath style

/* -------------------------------------------- */

/*
 ## XmlParser - From a Literal Text    
*/

def text2 = '''
    <list>
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
'''

def list2 = new XmlParser().parseText(text2) 
println list2
println list2.getClass() // groovy.util.Node
assert list2 instanceof groovy.util.Node 
assert list2.technology.name.text() == 'Groovy'

/* -------------------------------------------- */

/*def xmlSource = new File('employees.xml')
def employees = new XmlSlurper().parse(xmlSource)

println employees.class  // null

def employeesParsedText = new XmlSlurper().parseText(xmlSource.stripLines())
assert employeesParsedText instanceof groovy.xml.slurpersupport.GPathResult
println employees.properties // null
//println employees

println employees.each {  
    println it
    println "--------------------"
}
*/