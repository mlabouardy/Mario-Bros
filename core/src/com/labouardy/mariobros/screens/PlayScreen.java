package com.labouardy.mariobros.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.labouardy.mariobros.Home;
import com.labouardy.mariobros.factory.BatchFactory;
import com.labouardy.mariobros.scenes.Hud;

/**
 * Created by mlabouardy on 14/01/16.
 */
public class PlayScreen implements Screen {
    private Game game;
    private Hud hud;
    private OrthographicCamera camera;
    private Viewport viewport;
    private TmxMapLoader mapLoader;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

    public PlayScreen(Game game) {
        this.game=game;
        this.camera=new OrthographicCamera();
        this.viewport=new FitViewport(Home.V_WIDTH, Home.V_HEIGHT, camera);
        this.hud=new Hud();

        mapLoader=new TmxMapLoader();
        tiledMap=mapLoader.load("level1.tmx");
        orthogonalTiledMapRenderer=new OrthogonalTiledMapRenderer(tiledMap);
        camera.position.set(viewport.getWorldWidth()/2, viewport.getWorldHeight()/2, 0);
    }

    public void handleInput(float dt){
        if(Gdx.input.isTouched()){
            camera.position.x+=100*dt;
        }
    }

    public void update(float dt){
        handleInput(dt);
        camera.update();
        orthogonalTiledMapRenderer.setView(camera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        orthogonalTiledMapRenderer.render();
        SpriteBatch batch= BatchFactory.getInstance();
        batch.setProjectionMatrix(hud.getCamera().combined);
        hud.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
