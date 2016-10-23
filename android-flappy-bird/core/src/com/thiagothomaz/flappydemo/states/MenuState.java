package com.thiagothomaz.flappydemo.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thiagothomaz.flappydemo.FlapplyDemo;
import com.thiagothomaz.flappydemo.scenes.Hud;

/**
 * Created by thiago on 12/10/16.
 */
public class MenuState extends State {

    private Texture background;
    private Texture playBtn;
    private Hud hud;

    public MenuState(GameStateManager gsm, Hud hud) {
        super(gsm);
        this.hud = hud;
        cam.setToOrtho(false,FlapplyDemo.WIDTH/2, FlapplyDemo.HEIGHT/2);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(this.gsm, this.hud));
        }
    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();;
        sb.draw(background, 0,0);
        sb.draw(playBtn, cam.position.x - playBtn.getWidth()/2, cam.position.y);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Menu state disposed.");
    }
}
