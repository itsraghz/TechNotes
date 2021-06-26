class User {

    private firstName: string;
    private lastName: string;

    constructor(firstNameParam: string, lastNameParam: string) {
        this.firstName = firstNameParam;
        this.lastName = lastNameParam;
    }

    public getFirstName(): string {
        return this.firstName;
    }

    public getLastName(): string {
        return this.lastName;
    }
}

let user1 = new User("Sabarish", "Mahalingam");

/* user1.firstName = "Sindhuja";
user1.lastName = "V"; */

/* console.log(user1.firstName);
console.log(user1.lastName); */

console.log(user1.getFirstName());
console.log(user1.getLastName());
