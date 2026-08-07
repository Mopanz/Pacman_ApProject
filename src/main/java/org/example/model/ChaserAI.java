package org.example.model;

import java.util.ArrayList;
import java.util.Random;

public class ChaserAI implements GhostAI{

    private final Random random = new Random();
    private int count = 0;

    @Override
    public Direction getNextMove(Maze maze, Ghost ghost, Pacman pacman) {

        Direction[] exiteDirection = {Direction.UP, Direction.UP, Direction.UP, Direction.UP, Direction.RIGHT};
        if (count < exiteDirection.length){
            return exiteDirection[count++];
        }


        Direction nearDirection = getPacmanNearDirection(ghost, pacman);
        if (nearDirection != null){
            if (!isWallInThere(maze, ghost, pacman, nearDirection)){
                return nearDirection;
            }
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

    private Direction getPacmanNearDirection(Ghost ghost, Pacman pacman){

        for (Direction direction : Direction.values()){

            if (direction != getOppositeDirection(ghost.getDirection())){

                switch (direction){
                    case UP -> {
                        if (0 < ghost.getRow() - pacman.getRow() && ghost.getRow() - pacman.getRow() < 4 && ghost.getColumn() == pacman.getColumn()){
                            return Direction.UP;
                    }
                    }
                    case DOWN -> {
                        if (0 < pacman.getRow() - ghost.getRow() && pacman.getRow() - ghost.getRow() < 4 && ghost.getColumn() == pacman.getColumn()){
                            return Direction.DOWN;
                        }
                    }
                    case RIGHT -> {
                        if (0 < pacman.getColumn() - ghost.getColumn() && pacman.getColumn() - ghost.getColumn() < 4 && ghost.getRow() == pacman.getRow()){
                            return Direction.RIGHT;
                        }
                    }
                    case LEFT -> {
                        if (0 < ghost.getColumn() - pacman.getColumn() && ghost.getColumn() - pacman.getColumn() < 4 && ghost.getRow() == pacman.getRow()){
                            return Direction.LEFT;
                        }
                    }
                }

            }

        }

        return null;

    }

    private boolean isWallInThere(Maze maze, Ghost ghost, Pacman pacman, Direction direction){

        switch (direction){
            case UP -> {
                for (int i = pacman.getRow() + 1; i < ghost.getRow(); i++){
                    if (maze.isWall(i, ghost.getColumn())){
                        return true;
                    }
                }
                return false;
            }
            case DOWN -> {
                for (int i = ghost.getRow() + 1; i < pacman.getRow(); i++){
                    if (maze.isWall(i, ghost.getColumn())){
                        return true;
                    }
                }
                return false;
            }
            case RIGHT -> {
                for (int i = ghost.getColumn() + 1; i < pacman.getColumn(); i++){
                    if (maze.isWall(ghost.getRow(), i)){
                        return true;
                    }
                }
                return false;
            }
            case LEFT -> {
                for (int i = pacman.getColumn() + 1; i < ghost.getColumn(); i++){
                    if (maze.isWall(ghost.getRow(), i)){
                        return true;
                    }
                }
                return false;
            }
        }

        return false;

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
