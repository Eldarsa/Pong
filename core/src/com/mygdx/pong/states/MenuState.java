package com.mygdx.pong.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.Pong;

public class MenuState extends State{

    private Texture playBtn;
    private static MenuState INSTANCE = null;

    public MenuState(){
        super(gsm.getINSTANCE());
        playBtn = new Texture("playbtn.PNG");
    }

    public static MenuState getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new MenuState();
        }
        return INSTANCE;
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(PlayState.getINSTANCE());
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr) {
        sb.begin();
        sb.draw(playBtn, (Pong.WIDTH/2) - (playBtn.getWidth()/2), Pong.HEIGHT/2 - playBtn.getHeight()/2);
        sb.end();
    }

    @Override
    public void dispose() {
        playBtn.dispose();
    }

}
