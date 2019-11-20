package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;

/**
 * Created by anbu on 19.11.19.
 **/
public abstract class GameSystem {
    protected World world;

    public GameSystem(World world) {
        this.world = world;
    }

    public abstract void update(float delta);
}
