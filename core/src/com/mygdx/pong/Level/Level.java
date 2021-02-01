package com.mygdx.pong.Level;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;
import com.mygdx.pong.sprites.Ball;
import com.mygdx.pong.states.PlayState;

public class Level {
    public static final int BALL_SPEED_INCREMENT = 100;

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
        pos = new Vector2(Pong.WIDTH*0.1f, Pong.HEIGHT * PlayState.infoHeight);
        font = new BitmapFont();
        fontsize = 1f;
        font.getData().setScale(fontsize);
    }

    public void incrementLevel() {
        currentLevel+=1;
        timer.reset();
        Ball.CHANGING_BALL_SPEED += BALL_SPEED_INCREMENT;
    }

    public void reset(){
        currentLevel = 1;
    }

    public void drawLevel(SpriteBatch sb) {
        font.draw(sb, "Level " + String.valueOf(currentLevel), pos.x, pos.y);
    }

// TODO: Add incrementlevel functionality that increases the ball speed etc..

}
