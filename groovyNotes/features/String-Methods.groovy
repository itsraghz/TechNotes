String greeting = 'Hello Groovy!'
assert greeting.startsWith('Hello')
assert greeting.getAt(0) == 'H'
assert greeting[0] == 'H'
println greeting.indexOf('Groovy')
assert greeting.indexOf('Groovy') >= 0
assert greeting.contains('Groovy')
assert greeting[6..11] == 'Groovy'
println greeting
assert 'Hi' + greeting - 'Hello' == 'Hi Groovy!'
assert greeting.count('o') == 3
assert 'x'.padLeft(3) == '  x'
assert 'x'.padRight(3,'_') == 'x__'
assert 'x'.center(3) == ' x '
assert 'x' * 3 == 'xxx'

names = ['Ram', 'Ravi', 'Raghu', 'Raghav']
names.each { println "|" + it.padRight(8) + "|"}
names.each { println "|" + it.center(8) + "|"}


"s".getMetaClass().getMethods().each { println it.name}
"s".getMetaClass().getMetaMethods().each { println it.name}

"s".getMetaClass().getMetaMethods().each { 
    if (it.name.contains("pad")) {
         println it 
    }
}

println "====="
