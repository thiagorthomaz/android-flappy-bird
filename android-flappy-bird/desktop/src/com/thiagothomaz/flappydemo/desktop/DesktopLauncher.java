package com.thiagothomaz.flappydemo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.thiagothomaz.flappydemo.FlapplyDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlapplyDemo.WIDTH;
		config.height = FlapplyDemo.HEIGHT;
		config.title = FlapplyDemo.TITLE;
		new LwjglApplication(new FlapplyDemo(), config);
	}
}
