package com.thiagothomaz.flappydemo.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thiagothomaz.flappydemo.FlapplyDemo;

/**
 * Created by thiago on 12/10/16.
 */
public class MenuState extends State {

    private Texture background;
    private Texture playBtn;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    protected void update(float dt) {

    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.begin();;
        sb.draw(background, 0,0, FlapplyDemo.WIDTH, FlapplyDemo.HEIGHT);
        sb.draw(playBtn,(FlapplyDemo.WIDTH/ 2) - (playBtn.getWidth()/2) ,(FlapplyDemo.HEIGHT/2) - (playBtn.getHeight()/2));
        sb.end();

    }
}
