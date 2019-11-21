package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.WorldState;

/**
 * Created by anbu on 19.11.19.
 **/
public abstract class GameSystem {
    protected World world;
    private WorldState workingState = WorldState.GameProcess;

    public GameSystem(World world) {
        this.world = world;
    }

    public GameSystem(World world, WorldState workingState) {
        this.world = world;
        this.workingState = workingState;
    }

    public void update(float delta) {
        if (workingState == world.state) {
            updateSpecific(delta);
        }
    }

    public abstract void updateSpecific(float delta);
}
