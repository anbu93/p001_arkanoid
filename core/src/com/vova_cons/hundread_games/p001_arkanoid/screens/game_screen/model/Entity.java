package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by anbu on 19.11.19.
 **/
public class Entity {
    public EntityType type = null;
    public Body body = new Body();
    public Vector2 movement = null;
    public RickoshetDirection rickoshetDirection = null;

    public Entity() {}

    public Entity(EntityType type) {
        this.type = type;
    }
}
