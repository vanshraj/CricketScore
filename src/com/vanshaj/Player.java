package com.vanshaj;

public class Player {
    private PlayerType type;
    private int score;
    private int wickets;
    private String name;

    public Player(PlayerType type, String name) {
        this.type = type;
        this.score = 0;
        this.wickets = 0;
        this.name = name;
    }

    void addRuns(int runs){
        score+=runs;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
