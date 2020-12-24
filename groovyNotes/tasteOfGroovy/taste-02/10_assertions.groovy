assert(true)
assert 1 == 1
def x = 1
assert x == 1
def y = 1; assert y == 1

println "---------------------"
println "Interesting and helpful stacktrace when an assertion fails"

def a = 5
def b = 9
assert b == a + a