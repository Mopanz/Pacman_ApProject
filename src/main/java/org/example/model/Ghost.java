package org.example.model;

public class Ghost extends Character{

    private GhostColor color;
    private GhostAI ai;

    public Ghost(int row, int column, GhostColor color){
        super(row, column, Direction.UP);
        this.color = color;
        switch (color){
            case RED -> this.ai = new BFSAI();
            case BLUE -> this.ai = new RandomAI();
            case ORANGE -> this.ai = new ChaserAI();
        }
    }

    public void update(Maze maze, Pacman pacman){
        this.setDirection(ai.getNextDirection(maze, this, pacman));
    }

    public GhostColor getColor() {
        return color;
    }

    public void setColor(GhostColor color) {
        this.color = color;
    }

    public GhostAI getAi() {
        return ai;
    }

    public void setAi(GhostAI ai) {
        this.ai = ai;
    }
}
