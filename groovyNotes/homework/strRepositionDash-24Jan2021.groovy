def str='930-200' // output : 93-0200
println str.properties

str.getMetaClass().getMethods().each { if(it.name.contains("format")) println it }

int indexOfDash = str.indexOf("-")
println indexOfDash

assert null == "New York, NY".find(/\d{5}/)
assert null == str.find(/\d{5}/)
println str.find(/-/)

def val = str.find(~/(\d{3})-?(\d{3})/)
println val

str.find(/(\d{3})-?(\d{3})/) {
    match -> println "Match is : ${match}"
    //match[1].substr(0, 1) + "=" + match[2]
}

//str = 'Raghavan alias Saravanan Muthu'
str='930-200' // output : 93-0200
println str.split()//[930-200]
println str.split(){0} //[[], [9, 3, 0, -, 2, 0, 0]]
println str.split(){0}[1] //[9, 3, 0, -, 2, 0, 0]
println str.split(){0}[1].subList(0,2) //[9, 3]
println str.split(){0}[1].minus('-').plus(2,'-').join("")

/*
def list = [9,3,0,'-',2,0,0]
println list
list = list - '-'
list = list.plus(2, '-')
println list
println list.flatten()
println list.join("")*/

/*def newList = list
newList[2]=['-']
println newList
*/