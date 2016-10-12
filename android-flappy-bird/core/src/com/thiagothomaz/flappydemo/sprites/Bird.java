package com.thiagothomaz.flappydemo.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.thiagothomaz.flappydemo.FlapplyDemo;

/**
 * Created by thiago on 12/10/16.
 */
public class Bird {

    private static int GRAVITY = -15;

    private Vector3 position;
    private Vector3 velocity;

    private Texture bird;

    public Bird(int x, int y) {
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        bird = new Texture("bird.png");

    }

    public void update(float dt){
        if (position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(dt);
        position.add(0, velocity.y, 0);
        if (position.y < 0) {
            position.y = 0;
        }

        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public void jump(){
        if (position.y < ((FlapplyDemo.HEIGHT/2) - bird.getHeight()) ) {
            velocity.y = 250;
        }

    }


}
