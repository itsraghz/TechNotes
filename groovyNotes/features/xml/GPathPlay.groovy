/* GPathPlay.groovy */

/*
 Once you obtain the equivalent object of XML in Groovy (GPathResult), 
 there are two types of notations to get attributes of an XML element, as follows.

    direct notation with @nameoftheattribute
    map notation using ['@nameoftheattribute']

*/

final String books = '''
    <response version-api="2.0">
        <value>
            <books>
                <book available="20" id="1">
                    <title>Don Quixote</title>
                    <author id="1">Miguel de Cervantes</author>
                </book>
                <book available="14" id="2">
                    <title>Catcher in the Rye</title>
                   <author id="2">JD Salinger</author>
               </book>
               <book available="13" id="3">
                   <title>Alice in Wonderland</title>
                   <author id="3">Lewis Carroll</author>
               </book>
               <book available="5" id="4">
                   <title>Don Quixote</title>
                   <author id="4">Miguel de Cervantes</author>
               </book>
           </books>
       </value>
    </response>
'''

def response = new XmlSlurper().parseText(books)
def authorResult = response.value.books.book[0].author

assert authorResult.text() == 'Miguel de Cervantes'

def printXMLElementProperties(xmlElement, elementName) {
    println "============================="
    println "Properties of the XML Element"
    println "============================="
    println elementName + " : " + xmlElement
    println elementName + ".text() : " + xmlElement.text()
    println elementName + ".type : " + xmlElement.type
    println elementName + ".class : " + xmlElement.class
    println elementName + ".getClass() : " + xmlElement.getClass() 
    println "------------------------------------"
}

printXMLElementProperties(response, "response")
printXMLElementProperties(authorResult, "authorResult")

response = new XmlSlurper().parseText(books)

println response.value.books.size()

def book = response.value.books.book[0] 
def bookAuthorId1 = book.@id 
def bookAuthorId2 = book['@id'] 

assert bookAuthorId1 == '1' 
assert bookAuthorId1.toInteger() == 1 
