nameList = ['Raghavan', 'Shyam', 'Kannan', 'Arun', 'Gopi']
ageList = [10, 20, 30, 40, 50]
subjectList = ['Java', 'Groovy', 'C', 'XML', 'C++']

import groovy.json.JsonBuilder

JsonBuilder jsonBuilderStd1 = new JsonBuilder()

jsonBuilderStd1.student  {
	name nameList[0]
	age ageList[0]
	subject subjectList[0], subjectList[2]
	
}

println jsonBuilderStd1.toString()
println jsonBuilderStd1.toPrettyString()

JsonBuilder jsonBuilderStd2 = new JsonBuilder()

jsonBuilderStd2.student  {
	name nameList[1]
	age ageList[1]
	subject subjectList[1], subjectList[3]
	
}

println jsonBuilderStd2.toString()
println jsonBuilderStd2.toPrettyString()

nameList.eachWithIndex { it, index -> 
    println index +  " : " + it
}

jsonStudList = []

def constructJson() {
    JsonBuilder jsonBuilderStd
    
    nameList.eachWithIndex { it, index -> 
        jsonBuilderStd = new JsonBuilder()
        jsonBuilderStd.student {
            name nameList[index]
            age ageList[index]
            subject subjectList[index], subjectList[index+1], subjectList[index+2]
        }
        //println jsonBuilderStd
        jsonStudList << jsonBuilderStd
    }
}

constructJson()

println jsonStudList
println jsonStudList.eachWithIndex { it, index -> 
    println "StudentList[" + index + "] has : " + it
    println "------------------------------------------"
}

println ""

JsonBuilder jsonBuilderObj = new JsonBuilder()

// TODO #Raghavan Nested JSON Builder does not work on dynamically
jsonBuilderObj.students {
    student {
        name nameList[0]
        age ageList[0]
        subject subjectList[0], subjectList[1]
    },
    student {
        name nameList[1]
        age ageList[1]
        subject subjectList[1], subjectList[2]
    }
}

println ""
println "=================================================="
println ""
println jsonBuilderObj.toPrettyString()
