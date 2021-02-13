package com.mygdx.pong.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.Pong;

public class PauseState extends State{

    private Texture playBtn;
    private BitmapFont font;
    private float fontsize;

    private static PauseState INSTANCE = null;

    public PauseState(){
        super(gsm.getINSTANCE());
        playBtn = new Texture("playbtn.PNG");

        fontsize = 1f;
        font = new BitmapFont();
        font.getData().setScale(fontsize);
    }

    public static PauseState getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PauseState();
        }
        return INSTANCE;
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr) {
        sb.begin();
        sb.draw(playBtn, (Pong.WIDTH/2) - (playBtn.getWidth()/2), Pong.HEIGHT/2 - playBtn.getHeight()/2);
        font.draw(sb, "Click to start next set", 175, Pong.HEIGHT-200);
        sb.end();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            dispose();
            gsm.pop();
        }
    }

    @Override
    public void dispose() {
        playBtn.dispose();
    }
}
