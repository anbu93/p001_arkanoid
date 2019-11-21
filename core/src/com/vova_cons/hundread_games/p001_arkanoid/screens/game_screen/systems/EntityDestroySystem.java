package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Entity;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anbu on 21.11.19.
 **/
public class EntityDestroySystem extends GameSystem {
    private List<Entity> destroyEntities = new LinkedList<Entity>();

    public EntityDestroySystem(World world) {
        super(world);
    }

    @Override
    public void updateSpecific(float delta) {
        destroyBricks();
        destroyBalls();
    }

    private void destroyBricks() {
        destroyEntities.clear();
        for(Entity brick : world.bricks){
            if (brick.isRemoved) {
                destroyEntities.add(brick);
                world.ui.addScore();
            }
        }
        for(Entity brick : destroyEntities) {
            world.bricks.remove(brick);
        }
    }

    private void destroyBalls() {
        destroyEntities.clear();
        for(Entity ball : world.balls){
            if (ball.isRemoved) {
                destroyEntities.add(ball);
            }
        }
        for(Entity ball : destroyEntities) {
            world.balls.remove(ball);
        }
    }
}
