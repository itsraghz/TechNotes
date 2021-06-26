var User = /** @class */ (function () {
    function User(firstNameParam, lastNameParam) {
        this.firstName = firstNameParam;
        this.lastName = lastNameParam;
    }
    User.prototype.getFirstName = function () {
        return this.firstName;
    };
    User.prototype.getLastName = function () {
        return this.lastName;
    };
    return User;
}());
var user1 = new User("Sabarish", "Mahalingam");
/* user1.firstName = "Sindhuja";
user1.lastName = "V"; */
/* console.log(user1.firstName);
console.log(user1.lastName); */
console.log(user1.getFirstName());
console.log(user1.getLastName());
