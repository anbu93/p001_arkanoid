package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.badlogic.gdx.math.Vector2;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Balance;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Logic;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Entity;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;

/**
 * Created by anbu on 21.11.19.
 **/
public class CollisionSolveSystem extends GameSystem {
    private Vector2 direction = new Vector2();

    public CollisionSolveSystem(World world) {
        super(world);
    }

    @Override
    public void updateSpecific(float delta) {
        for(Entity ball : world.balls) {
            updateBall(ball, delta);
        }
    }

    private void updateBall(Entity ball, float delta) {
        checkBricksCollision(ball, delta);
        checkBoardCollision(ball, delta);
    }

    private void checkBricksCollision(Entity ball, float delta) {
        for(Entity brick : world.bricks) {
            if (Logic.isCollision(ball.body, brick.body)) {
                applySolveForce(ball, brick, delta);
                return;
            }
        }
    }

    private void checkBoardCollision(Entity ball, float delta) {
        if (Logic.isCollision(ball.body, world.board.body)) {
            applySolveForce(ball, world.board, delta);
        }
    }

    private void applySolveForce(Entity ball, Entity entity, float delta) {
        direction.x = ball.movement.x;
        direction.y = ball.movement.y;
        direction = direction.setLength(Balance.BALL_SPEED * delta);
        ball.body.x = ball.body.x + direction.x;
        ball.body.y = ball.body.y + direction.y;
        //TODO change logic to vectors
//        float dx = ball.body.centerX() - entity.body.centerX();
//        float dy = ball.body.centerY() - entity.body.centerY();
//        float cX = (ball.body.w/2f + entity.body.w/2f) - Math.abs(dx);
//        float cY = (ball.body.h/2f + entity.body.h/2f) - Math.abs(dy);
//        float dirX = dx > 0 ? 1f : 0f;
//        float dirY = dy > 0 ? 1f : 0f;
//        System.out.println("beforeX=" + ball.body.x);
//        System.out.println("beforeY=" + ball.body.y);
//        System.out.println("dx=" + dx);
//        System.out.println("dy=" + dx);
//        System.out.println("cX=" + cX);
//        System.out.println("cY=" + cY);
//        System.out.println("cY=" + cY);
//        if (Math.abs(cY) > Math.abs(cX)) {
//            ball.body.y += dy * dirY;
//        } else {
//            ball.body.x += dx * dirX;
//        }
//        System.out.println("afterX=" + ball.body.x);
//        System.out.println("afterY=" + ball.body.y);
    }
}
