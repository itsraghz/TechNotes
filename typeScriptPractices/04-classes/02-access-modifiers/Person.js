var Person = /** @class */ (function () {
    function Person(firstName, lastName) {
        console.log("constructor() invoked for Person class");
        this._firstName = firstName;
        this._lastName = lastName;
    }
    Object.defineProperty(Person.prototype, "firstName", {
        get: function () {
            console.log("get firstName() invoked");
            return this._firstName;
        },
        set: function (value) {
            console.log("set firstName() invoked");
            this._firstName = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "lastName", {
        get: function () {
            console.log("get lastName() invoked");
            return this._lastName;
        },
        set: function (value) {
            console.log("set lastName() invoked");
            this._lastName = value;
        },
        enumerable: false,
        configurable: true
    });
    return Person;
}());
var raghs = new Person("Raghavan", "Muthu");
console.log(raghs.firstName);
console.log(raghs.lastName);
raghs.firstName = "Raghavan alias Saravanan";
console.log(raghs.firstName);
