package com.labouardy.mariobros;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.labouardy.mariobros.screens.PlayScreen;

public class Home extends Game {

    public static final int V_HEIGHT=208;
    public static final int V_WIDTH=400;

	@Override
	public void create () {
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
