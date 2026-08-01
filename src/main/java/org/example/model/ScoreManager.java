package org.example.model;

public class ScoreManager {

    private int score = 0;

    public void addPelletScore(){
        score = score + 10;
    }

    public void addMovePenalty(){
        score = score - 1;
    }

    public int getScore() {
        return score;
    }
}
