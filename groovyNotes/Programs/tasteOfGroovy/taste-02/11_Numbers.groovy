// Numbers are Objects in Groovy

def x = 1
def y = 2
assert x + y == 3
assert x.plus(y) == 3
assert x instanceof Integer


println x.class
println x.getClass()
println y.class
println x.class == y.class
assert x.class == y.class