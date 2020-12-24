/* Reading from a file is super easy in Groovy */

/* Flavor2 - to pass the directory as a variable */

baseDir = '.'
fruitsList = []

new File(baseDir, 'fruits.txt').eachLine { line ->
    fruitsList << line
    println line
}

println fruitsList.size 

fruitsList.sort()
println fruitsList



