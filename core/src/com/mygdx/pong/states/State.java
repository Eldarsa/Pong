package com.mygdx.pong.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    protected static GameStateManager gsm;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void update(float dt);

    public abstract void render(SpriteBatch sb, ShapeRenderer sr);

    public abstract void handleInput();

    public abstract void dispose();
}
