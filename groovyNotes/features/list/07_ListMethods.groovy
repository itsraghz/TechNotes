def list = [1,1,2,3,5]
println list
println list.class

// print the 1st element , using the access operator, starts from index 0
println list[0]

// print the last element using an easy syntax - with -1 as an index
println "Last element of the list : " + list[-1]

/* ---------------------------- */
/* Condition - Groovy Truth     */
/* ---------------------------- */
//## Finding Elements using 'in' operator
if(4 in list)
    println "Number 4 is in the list"
else 
    println "Number 4 is NOT in the list"

/* ---------------------------- */
/* Transformation and Filtering */
/* ---------------------------- */

list.each {
  println it
}


def even = list.findAll { it % 2 == 0 }
println even 

def squaredList = list.collect { it * it }
println squaredList

def upper = ["Hello", "World"].collect { it.toUpperCase() }
println upper

def upper2 = ["Hello", "World"]*.toUpperCase()
println "Special case - UPPER : " + upper2