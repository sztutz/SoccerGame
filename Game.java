package soccergame;

import java.util.ArrayList;
import java.util.Random;

// Stuart Anderson, 30056472, 08/08/2022
// AT1 - Portfolio (OOP2)
// Activity 2
// Soccer Game

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private int temperature;
    private static int uniqueIdentifier = 1;
    private int gameID;
    private static ArrayList<Game> games = new ArrayList<>();
    final private Random random = new Random();
    
    public Game() {
        
    }
    
    public Game(int temperature, Team homeTeam, Team awayTeam) {
        this.temperature = temperature;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        gameID = uniqueIdentifier;
        uniqueIdentifier++;
        homeTeamScore = random.nextInt((int) (temperature / 6.5 + 3));
        awayTeamScore = random.nextInt((int) (temperature / 6.5 + 3));
        games.add(this);
    }
    
    public void displayGameResults() {
        games.forEach((game) -> System.out.println(game + "\n"));
    }
    
    @Override
    public String toString(){
        return "Game #" + gameID + "\nTemperature: " + temperature + "\nAway Team: "
                + awayTeam.getTeamName() + " " + awayTeamScore + "\nHome Team: " + homeTeam.getTeamName()
                + " " + homeTeamScore;
    }
}
