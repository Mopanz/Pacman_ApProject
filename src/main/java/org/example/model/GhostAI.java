package org.example.model;

public interface GhostAI {
    Direction getNextDirection(Maze maze, Ghost ghost, Pacman pacman);
}
