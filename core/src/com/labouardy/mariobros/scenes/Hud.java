package com.labouardy.mariobros.scenes;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.labouardy.mariobros.Home;
import com.labouardy.mariobros.factory.BatchFactory;

/**
 * Created by mlabouardy on 14/01/16.
 */
public class Hud {
    private Stage stage;
    private Viewport viewport;
    private Label marioLabel;
    private Label scoreLabel;
    private Label worldLabel;
    private Label healthLabel;
    private Label timeLabel;
    private Label countLabel;

    private String mario;
    private int score;
    private String world;
    private String health;
    private String time;
    private int count;

    public Hud(){

        viewport=new FitViewport(Home.V_WIDTH, Home.V_HEIGHT, new OrthographicCamera());
        stage=new Stage(viewport, BatchFactory.getInstance());

        mario="MARIO";
        score=0;
        world="WORLD";
        health="1-1";
        time="TIME";
        count=300;

        marioLabel=new Label(mario,new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel=new Label(String.format("%06d",score),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel=new Label(world,new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        healthLabel=new Label(health,new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel=new Label(time,new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        countLabel=new Label(String.valueOf(count),new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        Table table=new Table();
        table.top();
        table.setFillParent(true);

        table.add(marioLabel).expandX().pad(5);
        table.add(worldLabel).expandX().pad(5);
        table.add(timeLabel).expandX().pad(5);
        table.row();
        table.add(scoreLabel).expandX().pad(10);
        table.add(healthLabel).expandX().pad(10);
        table.add(countLabel).expandX().pad(10);

        stage.addActor(table);

    }

    public Camera getCamera(){
        return stage.getCamera();
    }

    public void draw(){
        stage.draw();
    }
}
