package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen;

import com.badlogic.gdx.math.Vector2;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Body;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Entity;

/**
 * Created by anbu on 19.11.19.
 **/
public class Logic {
    public static boolean isCollision(Body a, Body b) {
        float dx = Math.abs(a.centerX() - b.centerX());
        float dy = Math.abs(a.centerY() - b.centerY());
        return (a.w/2f + b.w/2f) >= dx && (a.h/2f + b.h/2f) >= dy;
    }

    public static void setAngle(Entity entity, float angle) {
        entity.movement = new Vector2(1f, 0).setAngle(angle+90f);
    }

    public static float getAngle(Entity entity) {
        return entity.movement.angle() - 90f;
    }
}
