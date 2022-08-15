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

    final private Team team0 = new Team("Wolverines");
    final private Team team1 = new Team("Snakes");
    final private Team team2 = new Team("Dragons");
    final private Team team3 = new Team("Badgers");
    final private Team[] teams = {team0, team1, team2, team3};
    //private Team[] shuffledTeams = teams;
    
    // Shuffles the array of Teams using the Fisher-Yates Algorithm
    private void shuffleTeams() {
        for (int i = teams.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Team temp = teams[j];
            teams[j] = teams[i];
            teams[i] = temp; 
        }    
    }
    
    // Schedules a game
    private void scheduleGame(Team team1, Team team2) {
        Game game = new Game(temperature, team1, team2);
        game.setGames();
    }
              
    // Collects the necessary information to schedule the soccer season
    public void schedule() {
        while(consecutiveFreeze < 3) {
            System.out.print("What is today's temperature in Celcius? ");
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
                shuffleTeams();
                scheduleGame(teams[0], teams[1]);
                scheduleGame(teams[2], teams[3]);
            }
        }
        System.out.println("Winter is here and the soccer season is over\n\n"
                + "--------------RESULTS--------------\n");
        for (Team team : teams) {
            System.out.println(team);
        }
    }
}