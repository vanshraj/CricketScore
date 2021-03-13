package com.vanshaj;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    private List<Over> overs;
    private Over currentOver;
    private Player onStrike;
    private Player offStrike;
    private int currentRun;
    private int wicketsFallen;
    private Team team;
    private boolean strikeToggle;

    public Innings(Team team) {
        this.overs = new ArrayList<>();
        this.currentOver = new Over();
        this.team = team;
        this.onStrike = this.team.getNextPlayer();
        this.offStrike = this.team.getNextPlayer();
        this.currentRun = 0;
        this.wicketsFallen = 0;
        this.strikeToggle = false;
    }

    //adding a ball
    void addBall(int runScored, boolean isWicket, BallType ballType, boolean strikeChange, int extras) {
        currentRun+=runScored;
        currentRun+=extras;
        if(isWicket){
            wicketsFallen++;
        }

        if(strikeToggle){
            offStrike.addRuns(runScored);
        }else{
            onStrike.addRuns(runScored);
        }

        changeStrike(isWicket, checkOverChange(ballType), runScored);
    }
    //printing score
    void printScore(){
        System.out.println("============= PRINT SCORE ==========");
        if(strikeToggle){
            System.out.println(offStrike.getName()+"-> "+offStrike.getScore());
            System.out.println(onStrike.getName()+"-> "+onStrike.getScore());
        } else {
            System.out.println(onStrike.getName() + "-> " + onStrike.getScore());
            System.out.println(offStrike.getName() + "-> " + offStrike.getScore());
        }
        System.out.println("Score -> "+currentRun);
        System.out.println("Wickets ->" +wicketsFallen);
        System.out.println("Overs ->" +overs.size()+"."+currentOver.getNumBalls());
        System.out.println("============= =========== ==========");
    }

    void changeStrike(boolean isWicket, boolean overChange, int runs){
        if(isWicket){
            if(strikeToggle){
                offStrike = team.getNextPlayer();
            }else{
                onStrike = team.getNextPlayer();
            }
        }
        boolean strikeChange;
        if(overChange){
            strikeChange = (runs&1)==0;//even runs change strike
        } else {
            strikeChange = (runs&1)==1;//odd runs change strike
        }

        if(strikeChange) {
            strikeToggle=!strikeToggle;
        }
    }

    boolean checkOverChange(BallType bType){
        currentOver.addBall(bType);
        if(currentOver.getNumBalls()==6){
            currentOver = new Over();
            overs.add(currentOver);
            return true;
        }
        return false;
    }
}
