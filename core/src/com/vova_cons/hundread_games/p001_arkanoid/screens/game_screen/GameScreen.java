package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen;

import com.vova_cons.hundread_games.p001_arkanoid.screens.BaseScreen;
import com.vova_cons.hundread_games.p001_arkanoid.screens.ScreenType;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems.BallsSystem;
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
        systems.add(new BallsSystem(world));
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
        world = new World(WIDTH, HEIGHT);
        world.initBoard(WIDTH/2f - world.board.body.w/2f, 0, Balance.BOARD_WIDTH, Balance.BOARD_HEIGHT);
        world.addBall(WIDTH/2f - Balance.BALL_SIZE, Balance.BOARD_HEIGHT + Balance.BALL_SIZE, 30f);
        float space = Balance.BRICKS_SPACE;
        float startX = world.width / 2f - (4.5f*space + 5*Balance.BRICK_WIDTH);
        float startY = world.height - 200 - (2*space + 3*Balance.BRICK_HEIGHT);
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 10; x++) {
                world.addbrick(startX + x*(Balance.BRICK_WIDTH + space), startY + y*(Balance.BRICK_HEIGHT + space));
            }
        }
    }
}
