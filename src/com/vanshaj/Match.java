package com.vanshaj;

public class Match {
    private Team team1;
    private Team team2;
    private Innings inn1;
    private Innings inn2;
    private int currentInn;

    public Match(Team team1, Team team2, Innings inn1, Innings inn2, int currentInn) {
        this.team1 = team1;
        this.team2 = team2;
        this.inn1 = inn1;
        this.inn2 = inn2;
        this.currentInn = currentInn;
    }

    void addBall(int runScored, boolean isWicket, BallType ballType, boolean strikeChange, int extras){
        if(currentInn==1){
            inn1.addBall(runScored, isWicket, ballType, strikeChange, extras);
        }else{
            inn2.addBall(runScored, isWicket, ballType, strikeChange, extras);
        }
    }
    void printScore(){
        if(currentInn==1){
            inn1.printScore();
        }else{
            inn2.printScore();
        }
    }
}
