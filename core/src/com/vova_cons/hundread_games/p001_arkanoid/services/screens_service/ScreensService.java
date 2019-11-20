package com.vova_cons.hundread_games.p001_arkanoid.services.screens_service;

import com.vova_cons.hundread_games.p001_arkanoid.screens.BaseScreen;
import com.vova_cons.hundread_games.p001_arkanoid.screens.ScreenType;
import com.vova_cons.hundread_games.p001_arkanoid.services.Service;

/**
 * Created by anbu on 27.10.19.
 **/
public interface ScreensService extends Service {
    void registerScreen(BaseScreen screen);
    BaseScreen getScreen(ScreenType screenType);
    void setScreen(ScreenType nextScreen);
}
