import { Shape } from './Shape';

export class Rectangle extends Shape {

    calculateArea(): number {
        //throw new Error('Method not implemented.');
        return this._width * this._length;
    }

    constructor(X: number, Y: number, 
        private _width: number, private _length: number) {        
        super(X, Y);
        console.log("constructor() called on Rectangle class");
    }

    public get width(): number {
        return this._width;
    }
    public set width(value: number) {
        this._width = value;
    }
    
    public get length(): number {
        return this._length;
    }
    public set length(value: number) {
        this._length = value;
    }

    getInfo(): string {
        console.log("getInfo() called on Rectangle class");
        return super.getInfo() + `, width=${this._width}, height=${this._length}`;
    }

}