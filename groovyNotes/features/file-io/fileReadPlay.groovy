// Reading a file 
new File('fruits.txt').eachLine {
  println it
}

println "================"

new File('.', 'fruits.txt').eachLine {
  println it
}

println "================"

new File('input-files', 'check-fruits.txt').eachLine {
    println it
}

println "================"

new File('input-files\\check-fruits.txt').eachLine {
    println "...." + it
}

println "================"

def baseDir = 'input-files'
new File(baseDir, 'check-fruits.txt').eachLine {
    if(it.trim().length()>0)
        println "[*} " + it + " | " + it.length() + " | " + it.trim().length()
}

println "================"

def fileContentsList = []
new File(baseDir, 'check-fruits.txt').eachLine { it, index -> 
    println "Line # [ " + index + "] " + it + " | " + it.length() + " | " + it.trim().length()
    fileContentsList << it 
    if(it.trim().length()>0) {
        println ".... [*] " + it + " | " + it.length() + " | " + it.trim().length()
       // fileContentsList << it 
    }
}

println fileContentsList.size()
println fileContentsList

fileContentsList.each { line -> 
    /* Dont take this for granted. Ask the business whether the whitespaces carry any meaning and should you preserve it! */
    def trimmedLine = line.trim()
    if(trimmedLine.length()>0) {
        println trimmedLine
    }
}


def directListFromFile = new File(baseDir, 'check-fruits.txt').collect { it}
println directListFromFile.class
println directListFromFile.size()
println directListFromFile
println directListFromFile[0] // NOT permitted in Java. Hey, we love Groovy! :) 

def directArrayFromFile = new File(baseDir, 'check-fruits.txt') as String[]
println directArrayFromFile.class
println directArrayFromFile.size()
println directArrayFromFile
println directArrayFromFile[0]

println "--------------------------------"
println "     withInputStream demo "
println "---------------------------------"
baseDir='.'
new File(baseDir,'fruits.txt').withInputStream { stream ->
    // do something ...
    println "stream.class [ " + stream.class + "], stream : [ " + stream.getText().class + "]"
    println "stream properties -> " + stream.getMetaClass().getMetaMethods().each { 
        print it.name
        if(it.name.contains('getText')) {
            println "....... " + it
        } else {
            println ""
        }
    }
}
