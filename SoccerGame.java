package soccergame;

// Stuart Anderson, 30056472, 08/08/2022
// AT1 - Portfolio (OOP2)
// Activity 2
// Soccer Game

public class SoccerGame {
    
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        Game game = new Game();

        
        scheduler.schedule();
        game.displayGameResults();
    }
    
}
