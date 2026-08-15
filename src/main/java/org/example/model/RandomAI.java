package org.example.model;

import java.util.ArrayList;
import java.util.Random;

public class RandomAI implements GhostAI{

    private final Random random = new Random();
    private int count = 0;

    @Override
    public Direction getNextDirection(Maze maze, Ghost ghost, Pacman pacman) {

        Direction[] exiteDirection = {Direction.UP, Direction.UP, Direction.UP, Direction.UP, Direction.RIGHT};
        if (count < exiteDirection.length){
            return exiteDirection[count++];
        }

        if (ghost.canMove(maze, ghost.getDirection()) && random.nextDouble() < 0.7){
            return ghost.getDirection();
        }

        ArrayList<Direction> validDirections = new ArrayList<>();

        for (Direction direction : Direction.values()){

            if (ghost.canMove(maze , direction) && direction != getOppositeDirection(ghost.getDirection())){
                validDirections.add(direction);
            }

        }
        return validDirections.get(random.nextInt(validDirections.size()));
    }

    private Direction getOppositeDirection(Direction direction){

        switch (direction){
            case UP -> {
                return Direction.DOWN;
            }
            case DOWN -> {
                return Direction.UP;
            }
            case RIGHT -> {
                return Direction.LEFT;
            }
            case LEFT -> {
                return Direction.RIGHT;
            }
        }

        return null;

    }

}
