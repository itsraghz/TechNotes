
println "-----------------------------------------"
println "         Printing File Contents"
println "-----------------------------------------"

new File('employees.txt').eachLine { line ->
    println line
}

/* Line Numbers */

println ""
println "-----------------------------------------"
println "Printing File Contents with Line Numbers"
println "-----------------------------------------"
println ""

new File('employees.txt').eachLine { line, nb ->
    println "Line $nb: $line"
}

/* Parent / Base Directory, with a line number */

println ""
println "-----------------------------------------"
println "Printing File Contents with Base/Parent Directory + Line Numbers"
println "-----------------------------------------"
println ""

def baseDir = '.' // current directory
new File(baseDir, 'employees.txt').eachLine { line, nb ->
    println "Line $nb: $line"
}

/* File Operations */

println ""
println "-----------------------------------------"
println "           File Operations"
println "-----------------------------------------"
println ""

def fileContentsList = []
new File('employees.txt').eachLine { line ->
    fileContentsList << line
}

println "fileContentsList : " + fileContentsList
println "fileContentsList.size() : " + fileContentsList.size()
println "Sorted List -> " + fileContentsList.sort()

def customNames = { list ->
    list.each {
      //println "... " + it + " || size : " + it.length()
      if(it.length()<=5) {
        println it
      }
    }
}

println ""
println ".... Calling a closure on a list to print the names only if it is less than 5 characters...."
customNames(fileContentsList)

/* Transformations */

println ""
println "----------------------------------------------"
println " File contents - get as a list - via collect()"
println "-----------------------------------------------"
println ""

//baseDir already declared
def listCollected = new File(baseDir, 'employees.txt').collect {it}

printList = { list ->
  println "list : " + list
  println "list size : " + list.size()
  println "list class : " + list.class
}

printList(listCollected)


println ""
println "----------------------------------------------"
println " File contents - get as a Array - via 'as'"
println "-----------------------------------------------"
println ""


printArray = { array ->
  println "array : " + array
  println "array size : " + array.size()
  println "array class : " + array.class
}

def arrayAs = new File(baseDir, 'employees.txt') as String[]
printArray(arrayAs)


/* ---------------------------------- */
// Best way to deal with File Input in Groovy

new File(baseDir,'employees.txt').withInputStream { stream ->
    // do something ...
}
