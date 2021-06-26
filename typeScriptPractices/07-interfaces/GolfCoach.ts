import { Coach } from "./Coach";

export class GolfCoach implements Coach {

    getDailyWorkout(): string {
        //throw new Error('Method not implemented.');
        return "Hit 100 balls at the golf range";
    }
    
}