package org.example.model;

public class Ghost extends Character{

    private GhostColor color;
    private GhostState state;
    private GhostAI ai;

    public Ghost(int row, int column, GhostColor color){
        super(row, column, Direction.UP);
        this.state = GhostState.CHASE;
        this.color = color;
        switch (color){
            case RED -> this.ai = new BFSAI();
            case BLUE -> this.ai = new DFSAI();
            case ORANGE -> this.ai = new AStarAI();
        }
    }

    public void update(Maze maze, Pacman pacman){
        Direction nextDirection = ai.getNextMove(maze, this, pacman);

        if (canMove(maze, nextDirection)){
            this.setDirection(nextDirection);
        }
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
