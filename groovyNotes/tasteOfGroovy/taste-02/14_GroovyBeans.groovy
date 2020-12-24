// Groovy Beans

 // Java Bean - you should mandatorily have the getter, setter methods

class BookBean {
  String title
}

def groovyBook = new BookBean()
groovyBook.setTitle('Groovy in Action')
assert groovyBook.getTitle() == 'Groovy in Action'
println groovyBook.title
println groovyBook.getTitle()

groovyBook.title = 'Groovy conquers the world'
assert groovyBook.title == 'Groovy conquers the world'

println groovyBook
println groovyBook.title
println groovyBook.getTitle()