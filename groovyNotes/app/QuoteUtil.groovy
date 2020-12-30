/**
QuoteUtil
---------
    Part I
    ------
1. Create the quote and associate with one or more categories/labels/tags
2. Read the quotes for a given tag/label/category, and facilitate retrieval 
    of either all or a subset of quotes on a particular category/tag/label

    Part II
    -------
3. Update a quote in the collection and/or persist optionally
4. Delete a quote (from the collection, and/or persist)
**/

def baseDir = '.'
def fileName = 'Quotes.md'

def quotesList = []
/*new File(baseDir, fileName).eachLine { line ->
    quotesList << line
}

println quotesList.size()*/

def directListFromFile = new File(baseDir, fileName).collect { it}
println directListFromFile.class
println directListFromFile.size()
println directListFromFile
println directListFromFile[0] // NOT permitted in Java. Hey, we love Groovy! :) 