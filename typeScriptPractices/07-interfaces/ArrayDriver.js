"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var CricektCoach_1 = require("./CricektCoach");
var GolfCoach_1 = require("./GolfCoach");
var myCricketCoach = new CricektCoach_1.CricketCoach();
var myGolfCoach = new GolfCoach_1.GolfCoach();
//create an array and let it be initially empty 
var theCoaches = [];
theCoaches.push(myCricketCoach);
theCoaches.push(myGolfCoach);
for (var _i = 0, theCoaches_1 = theCoaches; _i < theCoaches_1.length; _i++) {
    var tempCoach = theCoaches_1[_i];
    console.log(tempCoach.getDailyWorkout());
}
