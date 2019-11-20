package com.vova_cons.hundread_games.p001_arkanoid.screens.menu_screen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.vova_cons.hundread_games.p001_arkanoid.screens.BaseScreen;
import com.vova_cons.hundread_games.p001_arkanoid.screens.ScreenType;
import com.vova_cons.hundread_games.p001_arkanoid.services.ServiceLocator;
import com.vova_cons.hundread_games.p001_arkanoid.services.assets_service.AssetsService;
import com.vova_cons.hundread_games.p001_arkanoid.services.screens_service.ScreensService;

/**
 * Created by anbu on 19.11.19.
 **/
public class MenuScreen extends BaseScreen {
    @Override
    public ScreenType getScreenType() {
        return ScreenType.MenuScreen;
    }

    @Override
    public void start() {
        AssetsService assetsService = ServiceLocator.getService(AssetsService.class);
        Image image = new Image(assetsService.getTexture("badlogic.jpg"));
        image.setPosition(WIDTH/2f, HEIGHT/2f, Align.center);
        this.addActor(image);
        image.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ScreensService screensService = ServiceLocator.getService(ScreensService.class);
                screensService.setScreen(ScreenType.GameScreen);
            }
        });
    }

    @Override
    public void update(float delta) {}
}
