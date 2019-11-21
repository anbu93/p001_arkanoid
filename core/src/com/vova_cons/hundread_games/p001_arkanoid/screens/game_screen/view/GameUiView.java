package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.vova_cons.hundread_games.p001_arkanoid.screens.BaseScreen;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.Balance;
import com.vova_cons.hundread_games.p001_arkanoid.services.fonts_service.FontsService;
import com.vova_cons.hundread_games.p001_arkanoid.utils.ViewUtils;

/**
 * Created by anbu on 21.11.19.
 **/
public class GameUiView extends Group {
    private Label resultLabel;
    private Label scoreLabel;
    private int score = 0;

    public GameUiView() {
        resultLabel = ViewUtils.createLabel("result", FontsService.Size.Big, Color.WHITE);
        resultLabel.setAlignment(Align.center);
        resultLabel.setPosition(BaseScreen.WIDTH/2f, BaseScreen.HEIGHT/2f, Align.center);
        this.addActor(resultLabel);
        resultLabel.setVisible(false);
        Label scoreCaptionLabel = ViewUtils.createLabel("Score: ", FontsService.Size.Normal, Color.WHITE);
        scoreCaptionLabel.setPosition(0, BaseScreen.HEIGHT, Align.topLeft);
        this.addActor(scoreCaptionLabel);
        scoreLabel = ViewUtils.createLabel("0", FontsService.Size.Normal, Color.WHITE);
        scoreLabel.setPosition(scoreCaptionLabel.getX(Align.right), scoreCaptionLabel.getY(), Align.bottomLeft);
        scoreLabel.setAlignment(Align.left);
        this.addActor(scoreLabel);
    }

    public void addScore() {
        score += Balance.BRICK_DESTROY_SCORE;
        scoreLabel.setText(""+score);
    }

    public int getScore() {
        return score;
    }

    public void win() {
        resultLabel.setVisible(true);
        resultLabel.setText("You win!");
    }

    public void lose() {
        resultLabel.setVisible(true);
        resultLabel.setText("Game over!");
    }
}
