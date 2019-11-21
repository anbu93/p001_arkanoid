package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.badlogic.gdx.math.Vector2;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Balance;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Entity;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;

/**
 * Created by anbu on 19.11.19.
 **/
public class MoveSystem extends GameSystem {
    private Vector2 direction = new Vector2();

    public MoveSystem(World world) {
        super(world);
    }

    @Override
    public void update(float delta) {
        for(Entity balls : world.balls) {
            applyMovements(balls, delta, Balance.BALL_SPEED);
        }
        applyMovements(world.board, delta, Balance.BOARD_SPPED);
        checkBoard(world.board);
    }

    private void applyMovements(Entity entity, float delta, float speed) {
        direction.x = entity.movement.x;
        direction.y = entity.movement.y;
        direction = direction.setLength(speed * delta);
        entity.body.x = entity.body.x + direction.x;
        entity.body.y = entity.body.y + direction.y;
    }

    private void checkBoard(Entity board) {
        if (board.body.x < 0) {
            board.body.x = 0;
        }
        if (board.body.x + board.body.w > world.width) {
            board.body.x = world.width - board.body.w;
        }
    }
}
