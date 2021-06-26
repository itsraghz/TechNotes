var Person = /** @class */ (function () {
    function Person(firstNameParam, lastNameParam) {
        this.firstName = firstNameParam;
        this.lastName = lastNameParam;
    }
    return Person;
}());
var person1 = new Person("Kannan", 'Muthu');
console.log(person1.firstName);
console.log(person1.lastName);
