def baseDir = '.'

/* Directly supply the baseDir value as well in the parameter */
new File(baseDir,'haiku.txt').withWriter('utf-8') { writer ->
    writer.writeLine 'Into the ancient pond'
    writer.writeLine 'A frog jumps'
    writer.writeLine 'Water’s sound!'
}

/* Best way to write into a File in Groovy */
// benefit: It automatically closes the stream/resource.
new File(baseDir,'data.bin').withOutputStream { stream ->
    // do something ...
}

/* write a list into a file */
def vowelsList = ['a', 'e', 'i', 'o', 'u']
new File('.', 'vowelsList.txt').withWriter('UTF-8') { writer ->
  writer.writeLine "Today Date : " + new java.util.Date()
  writer.writeLine "vowelsList : " + vowelsList
  writer.writeLine "vowelsList size : " + vowelsList.size()

  writer.writeLine "-------------------------"
  vowelsList.each {
    writer.writeLine it
  }
  writer.writeLine "-------------------------"
}
