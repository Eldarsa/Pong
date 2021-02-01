package com.mygdx.pong.Level;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;

public class Level {

    private int currentLevel;
    private Vector2 pos;
    private Timer timer;

    private BitmapFont font;
    private float fontsize;

    public Level(Timer timer, int initLevel) {
        currentLevel = initLevel;
        this.timer = timer;
        this.timer.reset();

        // Draw parameters
        pos = new Vector2(Pong.WIDTH*0.1f, Pong.HEIGHT*0.8f);
        font = new BitmapFont();
        fontsize = 1f;
        font.getData().setScale(fontsize);
    }

    public void incrementLevel(float incBallSpeed) {
        currentLevel+=1;
        timer.reset();
    }

    public void drawLevel(SpriteBatch sb) {
        font.draw(sb, "Level " + String.valueOf(currentLevel), pos.x, pos.y);
    }

}
