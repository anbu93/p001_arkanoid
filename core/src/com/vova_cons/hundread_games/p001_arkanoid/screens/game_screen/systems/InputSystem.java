package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.vova_cons.hundread_games.p001_arkanoid.screens.ScreenType;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.WorldState;
import com.vova_cons.hundread_games.p001_arkanoid.services.ServiceLocator;
import com.vova_cons.hundread_games.p001_arkanoid.services.screens_service.ScreensService;

/**
 * Created by anbu on 19.11.19.
 **/
public class InputSystem extends GameSystem {

    public InputSystem(World world) {
        super(world, null);
    }

    @Override
    public void updateSpecific(float delta) {
        if (world.state == WorldState.GameProcess) {
            processGameInputs();
        }
        processUiInputs();
    }

    private void processGameInputs() {
        int dir = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            dir = dir - 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            dir = dir + 1;
        }
        world.board.movement.x = dir;
    }

    private void processUiInputs() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            ScreensService screensService = ServiceLocator.getService(ScreensService.class);
            screensService.setScreen(ScreenType.MenuScreen);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            switch(world.state) {
                case GameProcess:
                    world.state = WorldState.Pause;
                    world.ui.pause();
                    break;
                case Pause:
                    world.state = WorldState.GameProcess;
                    world.ui.resume();
                    break;

            }
        }
    }
}
