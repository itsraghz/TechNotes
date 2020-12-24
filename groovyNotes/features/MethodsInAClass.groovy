// Define Methods in a Class

class Calculator 
{
    def add(x, y) {
        x + y //Return statement is optional in Groovy
    }
    
    def subtract(x,y) {
        x - y
    }
}

result1 = new Calculator().add(13,4)
println result1
println new Calculator().subtract(13, 4)
println new Calculator().add("Malaya", "lam")
println new Calculator().subtract("Malayalam", "lam")
