package com.thiagothomaz.flappydemo.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thiagothomaz.flappydemo.FlapplyDemo;
import com.thiagothomaz.flappydemo.sprites.Bird;
import com.thiagothomaz.flappydemo.sprites.Tube;

/**
 * Created by thiago on 12/10/16.
 */
public class PlayState extends State {

    private Bird bird;
    private Texture bg;
    private Tube tube;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 300);
        cam.setToOrtho(false,FlapplyDemo.WIDTH/2, FlapplyDemo.HEIGHT/2);
        bg = new Texture("bg.png");
        tube = new Tube(100);

    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    protected void update(float dt) {
        handleInput();
        bird.update(dt);

    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2), 0);
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        sb.draw(tube.getBottomTube(), tube.getPotBotTube().x, tube.getPotBotTube().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
