package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;

/**
 * Created by anbu on 19.11.19.
 **/
public class InputSystem extends GameSystem {

    public InputSystem(World world) {
        super(world);
    }

    @Override
    public void update(float delta) {
        int dir = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            dir = dir - 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            dir = dir + 1;
        }
        world.board.movement.x = dir;
    }
}
