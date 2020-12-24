/* Reading from a file is super easy in Groovy */

new File('fruits.txt').eachLine { line -> 
	println line
}



