def baseDir = '.'
def fileName = 'Quotes.md'

def quotesList = []
new File(baseDir, fileName).eachLine { line ->
    quotesList << line
}

println quotesList.size()