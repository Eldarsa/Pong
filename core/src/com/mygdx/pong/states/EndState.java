package com.mygdx.pong.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;

public class EndState extends State{

    private Texture playBtn;
    private BitmapFont font;
    private float fontsize;
    private Vector2 fontPos;


    public EndState(GameStateManager gsm){
        super(gsm);
        playBtn = new Texture("playbtn.PNG");

        font = new BitmapFont();
        fontsize = 4f;
        font.getData().setScale(fontsize);
        font.setColor(Color.RED);
        fontPos = new Vector2(50, Pong.HEIGHT-50);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr) {

    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        font.draw(sb, "GAME OVER!\n  Play Again?", fontPos.x, fontPos.y);
        sb.draw(playBtn, (Pong.WIDTH/2) - (playBtn.getWidth()/2), Pong.HEIGHT/2 - playBtn.getHeight()/2);
        sb.end();
    }

    @Override
    public void dispose() {
        playBtn.dispose();
        font.dispose();
    }

}
