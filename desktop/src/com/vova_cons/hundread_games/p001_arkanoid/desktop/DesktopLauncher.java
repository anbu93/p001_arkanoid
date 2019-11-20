package com.vova_cons.hundread_games.p001_arkanoid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.vova_cons.hundread_games.p001_arkanoid.ArkanoidGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		config.resizable = false;
		config.samples = 8;
		config.title = "Arkanoid";
		new LwjglApplication(new ArkanoidGame(), config);
	}
}
