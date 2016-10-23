package com.thiagothomaz.flappydemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thiagothomaz.flappydemo.scenes.Hud;
import com.thiagothomaz.flappydemo.states.GameStateManager;
import com.thiagothomaz.flappydemo.states.MenuState;

public class FlapplyDemo extends ApplicationAdapter {

	public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public static final String TITLE = "Flappy bird";

    private GameStateManager gsm;
    private  SpriteBatch batch;

	Texture img;

	private Music music;


	private Hud hud;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
        gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();

        hud = new Hud(batch);

		img = new Texture("badlogic.jpg");
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm, hud));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
        this.batch.setProjectionMatrix(this.hud.getStage().getCamera().combined);
        this.hud.getStage().draw();

	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		img.dispose();
		music.dispose();
	}
}
