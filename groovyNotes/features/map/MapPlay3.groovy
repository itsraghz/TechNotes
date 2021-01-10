def printMapProperties(map) {
    println "Map contains : " + map
    printMapKeys(map)   
    printMapValues(map)
}

def printMapKeys(map) {
    println ""
    println "//// Keys ////"
    def keySet = map.keySet()
    println "Keys of the map are : " +  keySet
    println "Keys are of type : " + keySet.class //class java.util.LinkedHashMap$LinkedKeySet
    
    println "**********"
    keySet.each { 
        if(it.equals("PAN")) {
            //print "**"
           it = "**"
        }
        println it + " of type " + it.class 
   }
}

def printMapValues(map) {
    println ""
    println "//// Values ////"
    def values = map.values()
    println "Values of the map are : " +  values
    println "Values are of type : " + values.class //class java.util.LinkedHashMap$LinkedValues
    
    println "**********"
    values.each { 
        //print it
        if(it.equals("PAN")) {
           //print "**"
           it = "**"
        }
        print it
        println "| Type : " + it.getClass()
    }
}

def printMapKeyValues(map) {
    println "printMapKeyValues() - map contains : " + map
    map.keySet().each {
        if(it.equals("PAN")){
            def maskedData = maskDigits(map.get(it))
            println it + " --> " + maskedData
        } else {
            // map.it will try to fetch the value of key named 'it'. The dot notation is very specific
            // map.get(it) will try to get the value of the key supplied by the variable 'it' which is a closure iteration here
            // map.get() is safer
            println it + " --> [" + map.it + "] | " + map.get(it)
        }
    }
}

def studentMap = [Name : 'Shyam', Age : 35, Country : 'AU']
//println studentMap
//println studentMap.getClass()

def scoreMap = [Subjec1: 80, Subject2: 78, Subject3: 90]
//println scoreMap

def studentScoreMap = studentMap + scoreMap
//println studentScoreMap
printMapProperties(studentScoreMap)

def studentBackMap = studentScoreMap - scoreMap
println studentBackMap

def scoreRevisedMap = [:]

/* FAQ: Typical error people tend to do, do the operation but forget to assign to a variable back*/
scoreMap - [Subject3: 90]
println scoreMap

studentRevisedMap = scoreMap - [Subject3: 90]
println studentRevisedMap