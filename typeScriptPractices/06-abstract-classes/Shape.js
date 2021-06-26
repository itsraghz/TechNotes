"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Shape = void 0;
var Shape = /** @class */ (function () {
    function Shape(X, Y) {
        console.log("constructor() called on Shape class");
        this._X = X;
        this._Y = Y;
    }
    Object.defineProperty(Shape.prototype, "X", {
        get: function () {
            console.log("getX() called on Shape class");
            return this._X;
        },
        set: function (value) {
            console.log("setX() called on Shape class");
            this._X = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Shape.prototype, "Y", {
        get: function () {
            console.log("getY() called on Shape class");
            return this._Y;
        },
        set: function (value) {
            console.log("setY() called on Shape class");
            this._Y = value;
        },
        enumerable: false,
        configurable: true
    });
    Shape.prototype.getInfo = function () {
        console.log("getInfo() called on Shape class");
        return "x=" + this._X + ", y=" + this._Y;
    };
    return Shape;
}());
exports.Shape = Shape;
