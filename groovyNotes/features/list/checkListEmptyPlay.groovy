/**
 * A Groovy script to check whether a List is empty or not
 * using two different methods - one is builtin and other is
 * custom.
 */
def checkListEmptyBuiltIn(list) {
    println "checkListEmptyBuiltIn >>>>"
    println "list.isEmpty() -> " + (list.isEmpty() ? "Yes" : "No")
    println " "
}
def checkListEmptyCustom(list) {
    println "checkListEmptyCustom() >>>> "
    println "list : " + list
    println "list size : " + list.size()

    if (list!=null && list.size()>0){
     println "list is NOT empty"
    }
    else {
     println "list is empty"
    }
    println " "
}
def list1 = []
def list2 = ['a','e','i','o','u']

assert list1!=null
assert list1.size() ==0

checkListEmptyBuiltIn(list1)
checkListEmptyCustom(list1)

checkListEmptyBuiltIn(list2)
checkListEmptyCustom(list2)

/* Output
   =======
    checkListEmptyBuiltIn >>>>
    list.isEmpty() -> Yes
     
    checkListEmptyCustom() >>>> 
    list : []
    list size : 0
    list is empty
     
    checkListEmptyBuiltIn >>>>
    list.isEmpty() -> No
     
    checkListEmptyCustom() >>>> 
    list : [a, e, i, o, u]
    list size : 5
    list is NOT empty

*/
