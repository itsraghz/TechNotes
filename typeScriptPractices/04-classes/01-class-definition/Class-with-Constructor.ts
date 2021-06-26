class Person {
    firstName: string;
    lastName: string;   
    
    constructor(firstNameParam: string, lastNameParam: string) {
        this.firstName = firstNameParam;
        this.lastName = lastNameParam;
    }
    
}

let person1 = new Person("Kannan", 'Muthu');

console.log(person1.firstName);
console.log(person1.lastName);