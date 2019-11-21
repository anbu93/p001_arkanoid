package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.systems;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.WorldState;

/**
 * Created by anbu on 21.11.19.
 **/
public class GameRuleSystem extends GameSystem {
    public GameRuleSystem(World world) {
        super(world);
    }

    @Override
    public void updateSpecific(float delta) {
        checkWin();
        checkLose();
    }

    private void checkWin() {
        if (world.bricks.isEmpty()) {
            System.out.println("Win game!");
            world.state = WorldState.Win;
            world.ui.win();
        }
    }

    private void checkLose() {
        if (world.balls.isEmpty()) {
            System.out.println("Lose game");
            world.state = WorldState.Lose;
            world.ui.lose();
        }
    }
}
