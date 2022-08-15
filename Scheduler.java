package soccergame;

import java.util.Scanner;
import java.util.Random;

// Stuart Anderson, 30056472, 08/08/2022
// AT1 - Portfolio (OOP2)
// Activity 2
// Soccer Game

public class Scheduler {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private int temperature;
    private int consecutiveFreeze = 0;
    private int randomInt;

    private Team team0 = new Team("Wolverines");
    private Team team1 = new Team("Snakes");
    private Team team2 = new Team("Dragons");
    private Team team3 = new Team("Badgers");
    private Team[] teams = {team0, team1, team2, team3};
    private Team[] shuffledTeams;
    
    private Team[] shuffleArray(Team[] array){
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            
            Team temp = array[j];
            array[j] = array [i];
            array[i] = temp; 
        }    
        return array;
    }
                
    public void schedule() {
        while(consecutiveFreeze < 3) {
            System.out.print("What is today's temperature? ");
            while(!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid input. Temperature must be an integer");
                System.out.print("What is today's temperature? ");
            }
            temperature = scanner.nextInt();
            if (temperature < 1) {
                System.out.println("Too cold to play");
                consecutiveFreeze++;
            }
            else {
                consecutiveFreeze = 0;
                shuffledTeams = shuffleArray(teams);
                new Game(temperature, shuffledTeams[0], shuffledTeams[1]);
                new Game(temperature, shuffledTeams[2], shuffledTeams[3]);
            }
        }
        System.out.println("Winter is here and the soccer season is over");
    }
}
