"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Person_1 = require("./Person");
var raghs = new Person_1.Person("Raghavan", "Muthu");
console.log(raghs.firstName);
console.log(raghs.lastName);
raghs.firstName = "Raghavan alias Saravanan";
console.log(raghs.firstName);
