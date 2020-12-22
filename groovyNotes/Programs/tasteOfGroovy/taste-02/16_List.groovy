//def Apple = 'Apple'
def fruits = ['Apple', 'Banana' ,'JackFruit']
println fruits
//method - size()
println fruits.size()
// like property - size
// Groovy's syntactic Sugar - omit the paranthesis if a method does not take any parameter
println fruits.size

for(fruit in fruits) {
  println "Item : " + fruit
  println "Item size : " + fruit.size()
}

def classes = [String, List, File]
for (clazz in classes) {
   println clazz.package.name
}