package com.thiagothomaz.flappydemo.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.thiagothomaz.flappydemo.FlapplyDemo;

/**
 * Created by thiago on 10/23/16.
 */

public class Hud {

    private Viewport viewport;
    private Stage stage;

    private Integer level;
    private Integer score;

    Label levelLabel;
    Label scoreLabel;


    public Hud(SpriteBatch sb) {
        this.level = 1;
        this.score = 0;

        viewport = new FitViewport(FlapplyDemo.WIDTH, FlapplyDemo.HEIGHT, new OrthographicCamera());
        this.stage = new Stage(viewport,sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        this.scoreLabel = new Label(String.format("%06d", this.score), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));

        this.levelLabel = new Label(String.format("%01d", this.level), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));

        table.add(this.levelLabel).padTop(10);
        table.row();
        table.add(this.scoreLabel).expandX();

        this.stage.addActor(table);

    }

    public Stage getStage() {
        return stage;
    }

    public void addScore(int value){
        this.score += value;
        this.scoreLabel.setText(String.format("%06d", this.score));
    }

    public void resetScore(){
        this.score = 0;
        this.scoreLabel.setText(String.format("%06d", this.score));
    }

    public void dispose() {
        this.stage.dispose();
    }

}
