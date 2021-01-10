def list1 = [1,2]
def list2 = [3,4]
def list = [list1, list2]
println list
println list.flatten()


def PAN = "AB12CD34XY"
println "Actual PAN is : " +PAN
def maskedPAN = maskDigits(PAN)
println "Masked PAN is : " + maskedPAN

def maskDigits(data) 
{
 def maskedData = []
 data.eachWithIndex() { it, index -> 
     if(index % 2 == 0) {
         it = "*"
     }
     println index + " : " + it 
     //newList = [it]
     //maskedData << newList    
     maskedData << it
 }
 /*println maskedData
 println maskedData.flatten()
 println maskedData.join("")*/
 maskedData
}

def maskDigits(data, maskingType) 
{
 println("maskDigits(data,maskingType) - ENTER")
 println("maskingType :: " + maskingType)
 def maskedData = []
 data.eachWithIndex() { it, index -> 
     def divisor = 3
     if(maskingType.equalsIgnoreCase("Even")) {
         divisor = 2
     }
     if(index % divisor == 0) {
         it = "*"
     }
     println index + " : " + it 
     //newList = [it]
     //maskedData << newList    
     maskedData << it
 }
 /*println maskedData
 println maskedData.flatten()
 println maskedData.join("")*/
 maskedData
}

maskDigits(PAN, "Odd")
