/* Homework - 27Dec2020

1. FlattenedList - print it with the padding for a neat output
2. Take a customList - and stuff with random elements with null in between
   Write a closure to print only the not null elements/values.
*/

/*
exerciseList = [1, null, 3, null, 5]
exerciseList.size()
println exerciseList
exerciseList.each { if(it!=null) println it}
exerciseRange = 1..5
exerciseCustomList = [1, 2, 3, exerciseList, null, null, exerciseRange, 6, 7]
exerciseCustomList.each { if(it!=null) println it}
*/

def printNotNullListValuesWay1(list) {
    println "Way1 - printing non-null elements of a list using a closure and if statement"
    list.each {
        if(it != null) {
            println it
        }
    }
}

def printNotNullListValuesWay2(list) {
    println "Way2 - printing non-null elements of a list using the minus Operator"
    println list - null
}

def printNotNullListValuesWithClass(list) {
    println "-----------------------"
    list.each { 
        if(it!=null) {
            println "[" + it.class + "] | " + it 
        } else {
            println "a null value encountered..."
        }
    }
    println "-----------------------"
}

def printNotNullListValuesNestedWithClass(list) {
    println "-----------------------"
    list.each { 
        if(it!=null) {
            println "[" + it.class + "] | " + it 
            if(it.class == java.util.ArrayList) {
                println "..... It is an ArrayList ..... "
                it.each {                    
                    if(it != null) { 
                        println "............... [" + it.class + "] | " + it
                        //println "............... " + it
                    }
                }
            } else if (it.class == groovy.lang.IntRange) {
                println " ########## It is a Range ######## "
                println " ########## " + it.toListString()
            }
        } else {
            println "a null value encountered..."
        }
    }
    println "-----------------------"
}

/*
// 1st scenario - when there are only null elements/values
exerciseList = [1, 2, null, 4, 5, null]
println exerciseList

printNotNullListValuesWay1(exerciseList)
printNotNullListValuesWay2(exerciseList)

println exerciseList

println "-----------------------------"

//2nd scenario - when there is a null literal (within single quote)
exerciseList2 = [1, 2, null, 4, 5, null, 7, 'null']
println exerciseList2
printNotNullListValuesWay1(exerciseList2)
printNotNullListValuesWay2(exerciseList2)

println ""
printNotNullListValuesWithClass(exerciseList2)

*/

vowelsList = ['a', 'e', 'i', 'o','u']
oddList= [1, 3, 5,7, 9]
myRange = 3..7
exerciseCompositeList  = [vowelsList, exerciseList, 6, 7, null, oddList, myRange, null]

println exerciseCompositeList
/*printNotNullListValuesWithClass(exerciseCompositeList)
printNotNullListValuesWay1(exerciseCompositeList)
printNotNullListValuesWay2(exerciseCompositeList)*/
println "******************************"
printNotNullListValuesNestedWithClass(exerciseCompositeList)