package com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Body;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.Entity;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.EntityType;
import com.vova_cons.hundread_games.p001_arkanoid.screens.game_screen.model.World;
import com.vova_cons.hundread_games.p001_arkanoid.services.ServiceLocator;
import com.vova_cons.hundread_games.p001_arkanoid.services.assets_service.AssetsService;

/**
 * Created by anbu on 19.11.19.
 **/
public class Renderer extends Group {
    private World world;
    private Texture textureBall;
    private Texture textureBrick;
    private Texture textureBoard;

    public Renderer(World world) {
        this.world = world;
        AssetsService assetsService = ServiceLocator.getService(AssetsService.class);
        textureBall = assetsService.getTexture("textures/ball.png");
        textureBoard = assetsService.getTexture("textures/board.png");
        textureBrick = assetsService.getTexture("textures/brick.png");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawBg(batch);
        drawBricks(batch);
        drawBalls(batch);
        drawBoard(batch);
        batch.flush();
    }

    private void drawBg(Batch batch) {
        //draw bg here
    }

    private void drawBricks(Batch batch) {
        for(Entity entity : world.bricks) {
            if(entity.type == EntityType.Brick) {
                drawTexture(batch, entity.body, textureBrick);
            }
        }
    }

    private void drawBalls(Batch batch) {
        for(Entity entity : world.balls) {
            if(entity.type == EntityType.Ball) {
                drawTexture(batch, entity.body, textureBall);
            }
        }
    }

    private void drawBoard(Batch batch) {
        drawTexture(batch, world.board.body, textureBoard);
    }

    private void drawTexture(Batch batch, Body body, Texture texture) {
        batch.draw(texture, body.x, body.y, body.w, body.h);
    }
}
