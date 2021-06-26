"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Circle_1 = require("./Circle");
var Rectangle_1 = require("./Rectangle");
var myCircle = new Circle_1.Circle(10, 15, 5);
var myRectangle = new Rectangle_1.Rectangle(10, 15, 20, 15);
//declare an empty array 
var theShapes = [];
theShapes.push(myCircle);
theShapes.push(myRectangle);
// won't work due to the type mismatch
/*
theShapes.push("Hello, will this work?"); // Argument of type 'string' is not assignable to parameter of type 'Shape'.ts(2345)
theShapes.push(9); // Argument of type 'number' is not assignable to parameter of type 'Shape'.ts(2345)
*/
for (var _i = 0, theShapes_1 = theShapes; _i < theShapes_1.length; _i++) {
    var tempShape = theShapes_1[_i];
    console.log(tempShape.getInfo());
    //console.log(tempShape);
    console.log(tempShape.calculateArea());
    console.log();
}
