def today = new Date()

println today
println today.class

def weekdays = [ 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
println weekdays
println weekdays.size()
println weekdays.class

def getNewLine() {
    System.getProperty("line.separator")
}


def getNewLineWithDebug() {
    def newLine = System.getProperty("line.separator")
    println "newLine is : " + newLine 
    println "newLine length : " + newLine.length()
    newLine
}

def baseDir='.'
def fileName='test-output-file.txt'
new File(baseDir, fileName).withWriter {
    //it.writeLine "Test\r\n" // WRONG. Platform specific.

    //it.writeLine "Test" + System.getProperty("line.separator") // Safe. Platform Independent
    it.writeLine 'Test' + getNewLineWithDebug()
}