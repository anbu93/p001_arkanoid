package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen;

import com.vova_cons.hundread_games.p001_arkanoid.screens.BaseScreen;
import com.vova_cons.hundread_games.p001_arkanoid.screens.ScreenType;
import com.vova_cons.hundread_games.p001_arkanoid.screens.UI;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.RickoshetDirection;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems.GameSystem;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems.InputSystem;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems.MoveSystem;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.view.Renderer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anbu on 19.11.19.
 **/
public class GameScreen extends BaseScreen {
    private World world;
    private List<GameSystem> systems = new LinkedList<GameSystem>();
    private Renderer renderer;

    @Override
    public ScreenType getScreenType() {
        return ScreenType.GameScreen;
    }

    @Override
    public void start() {
        createWorld();
        systems.add(new InputSystem(world));
        systems.add(new MoveSystem(world));
        renderer = new Renderer(world);
        this.addActor(renderer);
    }

    @Override
    public void update(float delta) {
        for(GameSystem system : systems) {
            system.update(delta);
        }
    }

    private void createWorld() {
        world = new World();
        world.initBoard(WIDTH/2f - world.board.body.w/2f, 0, Balance.BOARD_WIDTH, Balance.BOARD_HEIGHT);
        world.addWall(-100, 0, 100, UI.SCENE_WIDE_WIDTH, RickoshetDirection.Right);
        world.addWall(UI.SCENE_WIDE_WIDTH-100, 0, 100, UI.SCENE_HEIGHT, RickoshetDirection.Left);
        world.addWall(0, UI.SCENE_HEIGHT, UI.SCENE_WIDE_WIDTH, 100, RickoshetDirection.Down);
    }
}
