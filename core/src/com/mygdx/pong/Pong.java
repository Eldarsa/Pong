package com.mygdx.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.pong.states.GameStateManager;
import com.mygdx.pong.states.MenuState;

public class Pong extends ApplicationAdapter {

	public static final	int WIDTH = 480;
	public static final int HEIGHT = 700;
	public static final String TITLE = "Pong";

	private GameStateManager gsm;
	private SpriteBatch sb;

	
	@Override
	public void create () {
		sb = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0,0,0,1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();

		//TODO: Draw state

		sb.end();
	}
	
	@Override
	public void dispose () {
		sb.dispose();

		//TODO: dispose all elements
	}
}
