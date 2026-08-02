package org.example.model;

public interface GhostAI {
    Direction getNextMove(Maze maze, Ghost ghost, Pacman pacman);
}
