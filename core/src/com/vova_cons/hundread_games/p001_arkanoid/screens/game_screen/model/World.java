package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anbu on 19.11.19.
 **/
public class World {
    public Entity board = new Entity(EntityType.Board);
    public List<Entity> walls = new LinkedList<Entity>();
    public List<Entity> balls = new LinkedList<Entity>();
    public List<Entity> bricks = new LinkedList<Entity>();

    public void initBoard(float x, float y, float w, float h) {
        board.body.x = x;
        board.body.y = y;
        board.body.w = w;
        board.body.h = h;
        board.movement = new Movement();
        board.rickoshetDirection = RickoshetDirection.Up;
    }

    public void addWall(float x, float y, float w, float h, RickoshetDirection direction) {
        Entity wall = new Entity(EntityType.Wall);
        wall.body.x = x;
        wall.body.y = y;
        wall.body.w = w;
        wall.body.h = h;
        wall.rickoshetDirection = direction;
        walls.add(wall);
    }
}
