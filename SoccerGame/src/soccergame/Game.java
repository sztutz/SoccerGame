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
    private static int gameCount = 0;
    private int gameID;
    private static ArrayList<Game> games = new ArrayList<>();
    final private Random random = new Random();
    
    public void setGames() {
        games.add(this);
    }
    public Game() {
        
    }
    public Game(int temperature, Team homeTeam, Team awayTeam) {
        this.temperature = temperature;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        gameCount++;
        gameID = gameCount;
        homeTeamScore = random.nextInt((int) (temperature / 6.5 + 3));
        awayTeamScore = random.nextInt((int) (temperature / 6.5 + 3));
        
        // Updating team stats
        if (homeTeamScore > awayTeamScore) {
            homeTeam.setWinTotal();
            awayTeam.setLossTotal();
        }
        else if (awayTeamScore > homeTeamScore) {
            awayTeam.setWinTotal();
            homeTeam.setLossTotal();
        }
        else {
            homeTeam.setTieTotal();
            awayTeam.setTieTotal();
        }
        homeTeam.setGoalsScoredTotal(homeTeamScore);
        homeTeam.setGoalsAllowedTotal(awayTeamScore);
        awayTeam.setGoalsScoredTotal(awayTeamScore);
        awayTeam.setGoalsAllowedTotal(homeTeamScore);
    }
    
    public void gameStats() {
        games.forEach((game) -> System.out.println(game + "\n"));
        int hottestTemperature = 0;
        double averageTemperature = 0;
        for (Game game : games) {
            averageTemperature += game.temperature;
            if (game.temperature > hottestTemperature) {
                hottestTemperature = game.temperature;
            }
        }
        averageTemperature = averageTemperature / gameCount;
        System.out.println("Hottest Temperature: " + hottestTemperature + "\n"
                + "Average Temperature: " + averageTemperature);
    }  
    @Override
    public String toString(){
        return "Game #" + gameID + "\nTemperature: " + temperature + "\nAway Team: "
                + awayTeam.getTeamName() + " " + awayTeamScore + "\nHome Team: " + homeTeam.getTeamName()
                + " " + homeTeamScore;
    }
}