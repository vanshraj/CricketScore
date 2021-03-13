package com.vanshaj;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private int numOfValidBalls;
    private List<Ball> ball;

    public Over() {
        this.numOfValidBalls = 0;
        this.ball = new ArrayList<>();
    }

    void addBall(BallType bType){
        if(bType == BallType.NORMAL){
            numOfValidBalls++;
        }
        Ball b = new Ball(bType);
        ball.add(b);
    }
    int getNumBalls(){
        return numOfValidBalls;
    }

}
