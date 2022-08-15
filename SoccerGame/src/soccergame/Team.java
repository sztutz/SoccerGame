package soccergame;

// Stuart Anderson, 30056472, 08/08/2022
// AT1 - Portfolio (OOP2)
// Activity 2
// Soccer Game

public class Team {
    public String teamName;
    private int winTotal = 0;
    private int lossTotal = 0;
    private int tieTotal = 0;
    private int goalsScoredTotal = 0;
    private int goalsAllowedTotal = 0;
    
    public Team(String teamName) {
        this.teamName = teamName;
    }
    
    public void setWinTotal() {
        winTotal++;
    }
    
    public void setLossTotal() {
        lossTotal++;
    }
    
    public void setTieTotal() {
        tieTotal++;
    }
    
    public void setGoalsScoredTotal(int score) {
        goalsScoredTotal += score;
    }
    
    public void setGoalsAllowedTotal(int score) {
        goalsAllowedTotal += score;
    }
    
    public String getTeamName() {
        return teamName;
    }
    @Override
    public String toString(){
        return "Team: " + teamName + "\n"
                + "Wins: " + winTotal + "   Losses: " + lossTotal + "   Ties: " + tieTotal + "\n"
                + "Goals Scored: " + goalsScoredTotal + "   Goals Allowed: " + goalsAllowedTotal + "\n";
    }
}