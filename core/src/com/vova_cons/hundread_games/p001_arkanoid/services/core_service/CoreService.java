package com.vova_cons.hundread_games.p001_arkanoid.services.core_service;

import com.vova_cons.hundread_games.p001_arkanoid.services.Service;

/**
 * Created by anbu on 27.10.19.
 **/
public interface CoreService extends Service {
    //region initialization
    void registerCoreServices();
    void registerGameServices();
    void registerScreens();
    void startGame();
    //endregion
    //region runtime
    void update(float delta);
    void pauseGame();
    void resumeGame();
    //endregion
}
