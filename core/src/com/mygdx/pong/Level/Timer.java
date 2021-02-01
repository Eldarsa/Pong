package com.mygdx.pong.Level;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;
import com.mygdx.pong.states.PlayState;

public class Timer {

    private long startTime;
    private Vector2 pos;
    private float yFac;
    private int maxTime;

    private BitmapFont font;
    private float fontsize;

    public Timer(int maxTime) {

        startTime = System.currentTimeMillis();
        this.maxTime = maxTime;

        pos = new Vector2(Pong.WIDTH*0.4925f, Pong.HEIGHT* PlayState.infoHeight);

        font = new BitmapFont();
        fontsize = 1f;
        font.getData().setScale(fontsize);

    }

    //Returns the accurate display second amount
    public long getSecondDisplay() {
        long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
        return elapsedSeconds % maxTime;
    }

    //Returns the accurate second pass
    public long getElapsedSeconds() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    public void drawTimer(SpriteBatch sb) {
        font.draw(sb, String.valueOf(getSecondDisplay()), pos.x, pos.y);
    }

    public void reset(){
        startTime = System.currentTimeMillis();
    }

}
