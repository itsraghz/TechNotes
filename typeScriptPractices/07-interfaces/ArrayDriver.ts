import { Coach } from "./Coach";
import { CricketCoach } from "./CricektCoach";
import { GolfCoach } from "./GolfCoach";

let myCricketCoach = new CricketCoach();
let myGolfCoach = new GolfCoach();

//create an array and let it be initially empty 
let theCoaches: Coach[] = [];

// add the coaches to the array
theCoaches.push(myCricketCoach);
theCoaches.push(myGolfCoach);

for(let tempCoach of theCoaches) {
    console.log(tempCoach.getDailyWorkout());
}
