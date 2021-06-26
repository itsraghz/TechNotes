import { Shape } from './Shape';

export class Circle extends Shape {

    constructor(X: number, Y: number, private _radius: number) {        
        super(X, Y);
        console.log("constructor() called on Circle class");
    }

    public set radius(value: number) {
        console.log("setRadius() called on Circle class");
        this._radius = value;
    }

    public get radius(): number {
        console.log("getRadius() called on Circle class");
        return this._radius;
    }

    getInfo(): string {
        console.log("getInfo() called on Circle class");
        return super.getInfo() + `, radius: ${this._radius}`;
    }

}