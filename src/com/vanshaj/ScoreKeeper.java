package com.vanshaj;

import java.util.Scanner;

public class ScoreKeeper {
    private Match m;

    public ScoreKeeper(Match m) {
        this.m = m;
    }
    void startMatch(Scanner sc){
        int cmd;
        while(true){
            cmd = sc.nextInt();
            if(cmd == 1){
                enterBall(sc);
            }else if(cmd==2){
                printScore();
            }else{
                break;
            }
        }
    }
    void enterBall(Scanner sc){
        int runs = sc.nextInt();
        boolean isWicket = sc.nextBoolean();
        sc.nextLine();
        String bt = sc.nextLine();
        boolean strikeChange = sc.nextBoolean();
        int extras = sc.nextInt();
        addBall(runs,isWicket,BallType.valueOf(bt),strikeChange, extras);
        System.out.println("RUNS -> " +runs+", IsWicket -> "+isWicket+", Ball type -> "+BallType.valueOf(bt)+", Strike changed ->"+strikeChange+", extras -> "+extras);
    }

    void addBall(int runScored, boolean isWicket, BallType ballType, boolean strikeChange, int extras){
        m.addBall(runScored, isWicket, ballType,strikeChange, extras);
    }
    void printScore(){
        m.printScore();
    }
    //print summary
}
