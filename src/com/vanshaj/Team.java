package com.vanshaj;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private boolean playingFirst;
    private List<Player> players;
    private int currentPlayer;

    public Team(boolean playingFirst) {
        this.playingFirst = playingFirst;
        this.players = new ArrayList<>();
        this.currentPlayer = -1;
    }

    boolean addPlayer(Player p){
        if(players.size()==11){
            return false;
        }else{
            players.add(p);
            return true;
        }
    }

    Player getNextPlayer(){
        if(currentPlayer==players.size()-1){
            return null;
        }else{
            return players.get(++currentPlayer);
        }
    }

}
