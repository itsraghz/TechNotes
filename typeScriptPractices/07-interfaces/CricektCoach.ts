import { Coach } from "./Coach";

export class CricketCoach implements Coach {

    getDailyWorkout(): string {
        //throw new Error('Method not implemented.');
        return "Practice your spin bowling techniques";
    }
    
}