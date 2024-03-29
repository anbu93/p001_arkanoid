package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Balance;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Logic;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Entity;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.RickoshetDirection;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;

/**
 * Created by anbu on 19.11.19.
 **/
public class BallsSystem extends GameSystem {
    private int boardActionCount = 0;

    public BallsSystem(World world) {
        super(world);
    }

    @Override
    public void updateSpecific(float delta) {
        for(Entity ball : world.balls) {
            updateBall(ball);
        }
    }

    private void updateBall(Entity ball) {
        checkBricksCollision(ball);
        checkBoardCollision(ball);
        checkWallsCollisions(ball);
    }

    private void checkBricksCollision(Entity ball) {
        for(Entity brick : world.bricks) {
            if (Logic.isCollision(ball.body, brick.body)) {
                brick.isRemoved = true;
                RickoshetDirection direction = detectRickoshetDirection(ball, brick);
                applyRickoshet(ball, direction);
            }
        }
    }

    private RickoshetDirection detectRickoshetDirection(Entity ball, Entity brick) {
        float dx = (ball.body.x + ball.body.w/2f) - (brick.body.x + brick.body.w/2f);
        float dy = (ball.body.y + ball.body.h/2f) - (brick.body.y + brick.body.h/2f);
        if (dy > Balance.BALL_SIZE/2f) {
            return RickoshetDirection.Up;
        }
        if (dy < -Balance.BALL_SIZE/2f) {
            return RickoshetDirection.Down;
        }
        if (dx > Balance.BALL_SIZE/2f) {
            return RickoshetDirection.Right;
        }
        if (dx < -Balance.BALL_SIZE/2f) {
            return RickoshetDirection.Left;
        }
        return RickoshetDirection.Down;
    }

    private void checkBoardCollision(Entity ball) {
        if (Logic.isCollision(ball.body, world.board.body)) {
            applyRickoshet(ball, RickoshetDirection.Up);
            float deltaX = world.board.body.x + world.board.body.w/2f - (ball.body.x + ball.body.w/2f);
            float angleForce = (deltaX / (world.board.body.w/2f));
            float angleDelta = angleForce * Balance.BOARD_ANGLE_MODIFICATOR;
            float ballAngle = Logic.getAngle(ball);
            float resultAngle = ballAngle + angleDelta;
            if (resultAngle < -Balance.MAX_BALL_ANGLE) {
                resultAngle = -Balance.MAX_BALL_ANGLE;
            }
            if (resultAngle > Balance.MAX_BALL_ANGLE) {
                resultAngle = Balance.MAX_BALL_ANGLE;
            }
            Logic.setAngle(ball, resultAngle);
            boardActionCount++;
            System.out.println("Board action: " + boardActionCount);
        }
    }

    private void checkWallsCollisions(Entity ball) {
        if (ball.body.x < 0) {
            applyRickoshet(ball, RickoshetDirection.Right);
        }
        if (ball.body.x + ball.body.w > world.width) {
            applyRickoshet(ball, RickoshetDirection.Left);
        }
        if (ball.body.y + ball.body.h > world.height) {
            applyRickoshet(ball, RickoshetDirection.Down);
        }
        if (ball.body.y + ball.body.h < 0) {
            ball.isRemoved = true;
        }
    }

    private void applyRickoshet(Entity ball, RickoshetDirection direction) {
        switch (direction) {
            case Up:
                if (ball.movement.y < 0) {
                    ball.movement.y = -ball.movement.y;
                }
                break;
            case Down:
                if (ball.movement.y > 0) {
                    ball.movement.y = -ball.movement.y;
                }
                break;
            case Left:
                if (ball.movement.x > 0) {
                    ball.movement.x = -ball.movement.x;
                }
                break;
            case Right:
                if (ball.movement.x < 0) {
                    ball.movement.x = -ball.movement.x;
                }
                break;
        }
    }
}
