package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Logic;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Entity;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.RickoshetDirection;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anbu on 19.11.19.
 **/
public class BallsSystem extends GameSystem {
    private List<Entity> destroyEntities = new LinkedList<Entity>();

    public BallsSystem(World world) {
        super(world);
    }

    @Override
    public void update(float delta) {
        for(Entity ball : world.balls) {
            updateBall(ball);
        }
    }

    private void updateBall(Entity ball) {
        checkBricksCollision(ball);
        checkBoardAndWallsCollision(ball);
    }

    private void checkBricksCollision(Entity ball) {
        destroyEntities.clear();
        for(Entity brick : world.bricks) {
            if (Logic.isCollision(ball.body, brick.body)) {
                destroyEntities.add(brick);
                RickoshetDirection direction = detectRickoshetDirection(ball, brick);
                applyRickoshet(ball, direction);
            }
        }
        for(Entity brick : destroyEntities) {
            world.bricks.remove(brick);
        }
    }

    private RickoshetDirection detectRickoshetDirection(Entity ball, Entity brick) {
        float dx = (ball.body.x + ball.body.w/2f) - (brick.body.x + brick.body.w/2f);
        float dy = (ball.body.y + ball.body.h/2f) - (brick.body.y + brick.body.h/2f);

        return null;
    }

    private void checkBoardAndWallsCollision(Entity ball) {
        for(Entity wall : world.walls) {
            checkBoardAndWall(ball, wall);
        }
        checkBoardAndWall(ball, world.board);
    }

    private void checkBoardAndWall(Entity ball, Entity wall) {
        if (Logic.isCollision(ball.body, wall.body)) {
            applyRickoshet(ball, wall.rickoshetDirection);
        }
    }

    private void applyRickoshet(Entity ball, RickoshetDirection direction) {
        switch (direction) {
            case Up:
            case Down:
                ball.movement.y = -ball.movement.y;
                break;
            case Left:
            case Right:
                ball.movement.y = -ball.movement.y;
                break;
        }
    }
}
