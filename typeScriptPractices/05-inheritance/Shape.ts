export class Shape {

    private _X: number;
    private _Y: number;

    constructor(X: number, Y: number) {
        console.log("constructor() called on Shape class");
        this._X = X;
        this._Y = Y;
    }

    public get X(): number { 
        console.log("getX() called on Shape class");
        return this._X;
    }

    public set X(value: number) {
        console.log("setX() called on Shape class");
        this._X = value;
    }

    public get Y(): number { 
        console.log("getY() called on Shape class");
        return this._Y;
    }

    public set Y(value: number) {
        console.log("setY() called on Shape class");
        this._Y = value;
    }

    getInfo(): string {
        console.log("getInfo() called on Shape class");
        return `x=${this._X}, y=${this._Y}`;
    }
}