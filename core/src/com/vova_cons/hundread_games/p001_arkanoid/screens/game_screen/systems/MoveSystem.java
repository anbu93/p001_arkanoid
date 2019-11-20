package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Entity;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;

/**
 * Created by anbu on 19.11.19.
 **/
public class MoveSystem extends GameSystem {
    public MoveSystem(World world) {
        super(world);
    }

    @Override
    public void update(float delta) {
        for(Entity balls : world.balls) {
            applyMovements(balls);
        }
        applyMovements(world.board);
    }

    private void applyMovements(Entity entity) {
        entity.body.x = entity.body.x + entity.movement.x;
        entity.body.y = entity.body.y + entity.movement.y;
    }
}
