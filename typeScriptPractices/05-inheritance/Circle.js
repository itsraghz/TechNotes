"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.Circle = void 0;
var Shape_1 = require("./Shape");
var Circle = /** @class */ (function (_super) {
    __extends(Circle, _super);
    function Circle(X, Y, _radius) {
        var _this = _super.call(this, X, Y) || this;
        _this._radius = _radius;
        console.log("constructor() called on Circle class");
        return _this;
    }
    Object.defineProperty(Circle.prototype, "radius", {
        get: function () {
            console.log("getRadius() called on Circle class");
            return this._radius;
        },
        set: function (value) {
            console.log("setRadius() called on Circle class");
            this._radius = value;
        },
        enumerable: false,
        configurable: true
    });
    Circle.prototype.getInfo = function () {
        console.log("getInfo() called on Circle class");
        return _super.prototype.getInfo.call(this) + (", radius: " + this._radius);
    };
    return Circle;
}(Shape_1.Shape));
exports.Circle = Circle;
