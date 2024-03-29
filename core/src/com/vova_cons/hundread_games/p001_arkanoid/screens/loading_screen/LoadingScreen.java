package com.vova_cons.hundread_games.p001_arkanoid.screens.loading_screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.vova_cons.hundread_games.p001_arkanoid.screens.BaseScreen;
import com.vova_cons.hundread_games.p001_arkanoid.screens.ScreenType;
import com.vova_cons.hundread_games.p001_arkanoid.services.ServiceLocator;
import com.vova_cons.hundread_games.p001_arkanoid.services.assets_service.AssetsService;
import com.vova_cons.hundread_games.p001_arkanoid.services.fonts_service.FontsService;
import com.vova_cons.hundread_games.p001_arkanoid.services.screens_service.ScreensService;
import com.vova_cons.hundread_games.p001_arkanoid.utils.ViewUtils;

/**
 * Created by anbu on 19.11.19.
 **/
public class LoadingScreen extends BaseScreen {
    private AssetsService assetsService;

    @Override
    public ScreenType getScreenType() {
        return ScreenType.LoadingScreen;
    }

    @Override
    public void start() {
        assetsService = ServiceLocator.getService(AssetsService.class);
        assetsService.loadTextures();
        Label label = ViewUtils.createLabel("Идет загрузка...", FontsService.Size.Big, Color.WHITE);
        label.setPosition(WIDTH/2f, HEIGHT/2f, Align.center);
        this.addActor(label);
    }

    @Override
    public void update(float delta) {
        assetsService.update(delta);
        if (assetsService.isFinishLoading()) {
            ScreensService screensService = ServiceLocator.getService(ScreensService.class);
            screensService.setScreen(ScreenType.MenuScreen);
        }
    }
}
