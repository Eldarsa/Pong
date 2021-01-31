package com.mygdx.pong.Score;

public class Score {

    private int playerScore;

    public Score() {
        setZero();
    }

    public void setZero() {
        playerScore = 0;
    }

    public void addScore(int points) {
        playerScore+=points;
    }

    public int getScore(){
        return playerScore;
    }

}
