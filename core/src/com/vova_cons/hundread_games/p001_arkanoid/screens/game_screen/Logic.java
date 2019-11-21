package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen;

import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Body;

/**
 * Created by anbu on 19.11.19.
 **/
public class Logic {
    public static boolean isCollision(Body a, Body b) {
        float dx = Math.abs(a.x - b.x);
        float dy = Math.abs(a.y - b.y);
        return (a.w/2f + b.w/2f) > dx && (a.h/2f + b.h/2f) > dy;
    }
}
