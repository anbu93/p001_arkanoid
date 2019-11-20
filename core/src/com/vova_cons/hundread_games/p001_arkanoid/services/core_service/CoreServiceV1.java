package com.vova_cons.hundread_games.p001_arkanoid.services.core_service;

import com.vova_cons.hundread_games.p001_arkanoid.ArkanoidGame;
import com.vova_cons.hundread_games.p001_arkanoid.screens.ScreenType;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.GameScreen;
import com.vova_cons.hundread_games.p001_arkanoid.screens.loading_screen.LoadingScreen;
import com.vova_cons.hundread_games.p001_arkanoid.screens.menu_screen.MenuScreen;
import com.vova_cons.hundread_games.p001_arkanoid.services.ServiceLocator;
import com.vova_cons.hundread_games.p001_arkanoid.services.assets_service.AssetsService;
import com.vova_cons.hundread_games.p001_arkanoid.services.assets_service.AssetsServiceV1;
import com.vova_cons.hundread_games.p001_arkanoid.services.fonts_service.FontsService;
import com.vova_cons.hundread_games.p001_arkanoid.services.fonts_service.FontsServiceV1;
import com.vova_cons.hundread_games.p001_arkanoid.services.screens_service.ScreensService;
import com.vova_cons.hundread_games.p001_arkanoid.services.screens_service.ScreensServiceV1;

/**
 * Created by anbu on 19.11.19.
 **/
public class CoreServiceV1 implements CoreService {
    private final ArkanoidGame game;

    public CoreServiceV1(ArkanoidGame arkanoidGame) {
        this.game = arkanoidGame;
    }

    @Override
    public void registerCoreServices() {
        ServiceLocator.register(ScreensService.class, new ScreensServiceV1(game));
        ServiceLocator.register(AssetsService.class, new AssetsServiceV1());
        ServiceLocator.register(FontsService.class, new FontsServiceV1());
    }

    @Override
    public void registerGameServices() {

    }

    @Override
    public void registerScreens() {
        ScreensService screensService = ServiceLocator.getService(ScreensService.class);
        screensService.registerScreen(new LoadingScreen());
        screensService.registerScreen(new MenuScreen());
        screensService.registerScreen(new GameScreen());
    }

    @Override
    public void startGame() {
        ScreensService screensService = ServiceLocator.getService(ScreensService.class);
        screensService.setScreen(ScreenType.LoadingScreen);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void pauseGame() {

    }

    @Override
    public void resumeGame() {

    }
}
