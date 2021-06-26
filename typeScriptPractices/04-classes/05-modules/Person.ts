export class Person {

    constructor(private _firstName: string, private _lastName: string) {
        console.log("constructor() invoked for Person class");
        console.log("... The Internal assignment of properties are automatically done by Typescript");
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