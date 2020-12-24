// Declaring a Class

class Book {
    private String title
    
    Book (String theTitle) {
        println "Book is instantiated"
        title = theTitle
    }
    
    String getTitle(){
        println "getTitle() is invoked on a Book instance"
        return title
    }
}

Book gina = new Book('Groovy in Action')
//Book ginaNew = new Book('Groovy in Action')

println gina.title
println gina.getTitle()
println gina

assert gina.getTitle() == 'Groovy in Action'
println "String title in reverse : " + getTitleBackwards(gina)
assert getTitleBackwards(gina) == 'noitcA ni yvoorG'

String getTitleBackwards(book) {
    String title = book.getTitle()
    return title.reverse()
}

/* Does not work, need to import */
/*
@Override
String toString() {
   println "[Book] title="+title
}*/

import groovy.transform.ToString

@ToString
class Book2 {
    private String title
    Book2 (String theTitle) {
        title = theTitle
    }
    String getTitle(){
        return title
    }
}

Book2 gina2 = new Book2('Groovy 2 in Action')

println gina
println gina2