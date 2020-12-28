myList = ['a', 'b', 'c']
assert myList.isCase('a')

assert 'b' in myList

def candidate = 'c'
switch(candidate){
case myList : assert true; break
default : assert false
}
println(['x','a','z'].grep(myList))
def greppedElement = ['x','a','z'].grep(myList)
println greppedElement
assert ['x','a','z'].grep(myList) == ['a']

myList = []
println myList
if (myList) assert false

// Lists can be iterated with a 'for' loop
def expr = ''
for (i in [1,'*',5]){
    expr += i
}

assert expr == '1*5'