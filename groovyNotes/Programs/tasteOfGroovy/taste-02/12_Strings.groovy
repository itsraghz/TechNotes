// Playing with strings in Groovy
/* Case sensitive like Java */

String singleQuotedStr = 'Groovy'
String doubleQuotedStr = "Groovy"
println singleQuotedStr 
println doubleQuotedStr

println 'Single Quoted Str :  ' + singleQuotedStr
println 'Single Quoted Str inside a statement : ${singleQuotedStr}'

println "Single Quoted Str inside a statement via String Interpolation : ${singleQuotedStr}"


def nick = 'Raghs'
def profession = 'Groovy Teacher'
assert "$nick is a ${profession}" == 'Raghs is a Groovy Teacher'

println "String Length : "  + nick.length()
assert (nick.length()==5)


