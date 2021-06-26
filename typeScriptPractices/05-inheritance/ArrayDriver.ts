import { Shape } from './Shape';
import { Circle } from './Circle';
import { Rectangle } from './Rectangle';

let myShape = new Shape(10,15);
let myCircle = new Circle(10, 15, 5);
let myRectangle = new Rectangle(10, 15, 20, 15);

//declare an empty array 
let theShapes: Shape[] = [];

theShapes.push(myShape);
theShapes.push(myCircle);
theShapes.push(myRectangle);

// won't work due to the type mismatch
/*
theShapes.push("Hello, will this work?"); // Argument of type 'string' is not assignable to parameter of type 'Shape'.ts(2345)
theShapes.push(9); // Argument of type 'number' is not assignable to parameter of type 'Shape'.ts(2345)
*/

for(let tempShape of theShapes) {
    console.log(tempShape.getInfo());
    //console.log(tempShape);
}