class Person {

    private _firstName: string;
    private _lastName: string;

    constructor(firstName: string, lastName: string) {
        console.log("constructor() invoked for Person class");
        this._firstName = firstName;
        this._lastName = lastName;
    }

    public get firstName(): string {
        console.log("get firstName() invoked");
        return this._firstName;
    }

    public set firstName(value: string) {
        console.log("set firstName() invoked");
        this._firstName = value;
    }

    public get lastName(): string {
        console.log("get lastName() invoked");
        return this._lastName;
    }

    public set lastName(value: string) {
        console.log("set lastName() invoked");
        this._lastName = value;
    }   
}

let raghs = new Person("Raghavan", "Muthu");

console.log(raghs.firstName);
console.log(raghs.lastName);

raghs.firstName="Raghavan alias Saravanan";
console.log(raghs.firstName);

