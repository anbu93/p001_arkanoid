package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Balance;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Logic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anbu on 19.11.19.
 **/
public class World {
    public float width;
    public float height;
    public Entity board = new Entity(EntityType.Board);
    public List<Entity> balls = new LinkedList<Entity>();
    public List<Entity> bricks = new LinkedList<Entity>();

    public World(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void initBoard(float x, float y, float w, float h) {
        board.body.x = x;
        board.body.y = y;
        board.body.w = w;
        board.body.h = h;
        board.movement = new Movement();
        board.rickoshetDirection = RickoshetDirection.Up;
    }

    public void addBall(float x, float y, float angle) {
        Entity ball = new Entity(EntityType.Ball);
        ball.body.x = x;
        ball.body.y = y;
        ball.body.w = Balance.BALL_SIZE;
        ball.body.h = Balance.BALL_SIZE;
        ball.movement = new Movement();
        Logic.setAngle(ball.movement, angle);
        balls.add(ball);
    }

    public void addbrick(float x, float y) {
        Entity brick = new Entity(EntityType.Brick);
        brick.body.x = x;
        brick.body.y = y;
        brick.body.w = Balance.BRICK_WIDTH;
        brick.body.h = Balance.BRICK_HEIGHT;
        bricks.add(brick);
    }
}
