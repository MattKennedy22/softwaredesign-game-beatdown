package com.juniordesign.beatdown.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.juniordesign.beatdown.BeatdownGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = BeatdownGame.title;
		config.width = BeatdownGame.v_width * BeatdownGame.scale;
		config.height= BeatdownGame.v_height * BeatdownGame.scale;

		new LwjglApplication(new BeatdownGame(), config);
	}
}
