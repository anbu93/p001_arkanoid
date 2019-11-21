package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen;

import com.badlogic.gdx.math.Vector2;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Body;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Movement;

/**
 * Created by anbu on 19.11.19.
 **/
public class Logic {
    public static boolean isCollision(Body a, Body b) {
        float dx = Math.abs(a.x - b.x);
        float dy = Math.abs(a.y - b.y);
        return (a.w/2f + b.w/2f) > dx && (a.h/2f + b.h/2f) > dy;
    }

    public static void setAngle(Movement movement, float angle) {
        Vector2 vec = new Vector2(1f, 0).setAngle(angle+90f);
        movement.x = vec.x;
        movement.y = vec.y;
    }
}
