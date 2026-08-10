package org.example.model;

import org.example.util.AudioManager;

public class Ghost extends Character{

    private GhostColor color;
    private GhostState state;
    private GhostAI ai;

    public Ghost(int row, int column, GhostColor color){
        super(row, column, Direction.UP);
        this.state = GhostState.CHASE;
        this.color = color;
        switch (color){
            //case RED -> this.ai = new BFSAI();
            case BLUE -> this.ai = new BFSAI();
            //case ORANGE -> this.ai = new AStarAI();
        }
    }

    public void update(Maze maze, Pacman pacman){
        this.setDirection(ai.getNextMove(maze, this, pacman));
    }

    public GhostColor getColor() {
        return color;
    }

    public void setColor(GhostColor color) {
        this.color = color;
    }

    public GhostState getState() {
        return state;
    }

    public void setState(GhostState state) {
        this.state = state;
    }

    public GhostAI getAi() {
        return ai;
    }

    public void setAi(GhostAI ai) {
        this.ai = ai;
    }
}
