package com.vanshaj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(new File("src/test.txt"));
        Team t1 = new Team(true);
        Team t2 = new Team(false);
        enterTeam(t1,t2);
        Innings i1 = new Innings(t1);
        Innings i2 = new Innings(t2);
        Match m = new Match(t1,t2,i1,i2,1);
        ScoreKeeper sk = new ScoreKeeper(m);
        sk.startMatch(sc);
    }

    private static void enterTeam(Team t1, Team t2){
        System.out.println("Enter First Team");
        enterTeam(t1);
        System.out.println("Enter Second Team");
        enterTeam(t2);
    }

    private static void enterTeam(Team t) {
        int i=11;
        while(i!=0){
            t.addPlayer(enterPlayer());
            i--;
        }
    }
    private static Player enterPlayer() {
        String playerType = sc.nextLine();
        String name= sc.nextLine();
        return new Player(PlayerType.valueOf(playerType),name);
    }
}
