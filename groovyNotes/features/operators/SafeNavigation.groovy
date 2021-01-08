import groovy.transform.ToString 

@ToString 
class Address
{
    String streetName
    String city
    String state
    String country
}

@ToString 
class Contact
{
    Address address
    String phoneNo
    String emailAddress
}

@ToString 
class Person
{
    String firstName, lastName
    int age
    Contact contact 
}

Address address = null // = new Address('streetName' : 'Murugan Street', 'city' : 'Chennai', )
Contact contact
Person person = new Person(firstName: 'Raghavan', lastName : 'Muthu', age : 40) 
println "Person : " + person

// Traditional Java way gives you a NPE
/*
    Caught: java.lang.NullPointerException: Cannot get property 'address' on null object
    java.lang.NullPointerException: Cannot get property 'address' on null object
        at SafeNavigation.run(SafeNavigation.groovy:33)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
*/
//println "Street: " + person.contact.address.street

/* Safe way : Use Groovys Safe Navigation Operator '?.' */
/* Output: 
   --------
   Person : Person(Raghavan, Muthu, 40, null)
   Street: null
*/
println "Street: " + person?.contact?.address?.street
