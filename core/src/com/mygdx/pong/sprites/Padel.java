package com.mygdx.pong.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;
import com.mygdx.pong.Score.Score;

public class Padel {
    public static final int DIST_FROM_WALL = 20;
    private static final int PADEL_SPEED = 10;

    private Score score;
    private Vector2 pos;
    private Texture padelTexture;
//    private int score;

    public Padel(boolean leftPaddle) {
        score = new Score();

        padelTexture = new Texture("padel100.png");
        pos = new Vector2(0, 0);
        pos.y = ((float) Pong.HEIGHT / (float) 2) - ((float) padelTexture.getHeight() / (float) 2);

        if (leftPaddle) {
            pos.x = DIST_FROM_WALL;
        }
        else {
            pos.x = Pong.WIDTH - DIST_FROM_WALL;
        }
    }

    public int getScore() {
        return score.getScore();
    }

    public void setScore(int points) {
        this.score.addScore(points);
    }

    public void update(float dt) {
        handleInput();
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pos.y += PADEL_SPEED;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pos.y -= PADEL_SPEED;
        }
    }

    public void dispose() {
        padelTexture.dispose();
    }

    public Vector2 getPos() {
        return pos;
    }

    public Texture getTexture() {
        return padelTexture;
    }
}
