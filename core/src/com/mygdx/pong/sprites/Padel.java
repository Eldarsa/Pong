package com.mygdx.pong.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;
import com.mygdx.pong.Score.Score;

public class Padel {
    public static final int DIST_FROM_WALL = 20;
    private static final int PADEL_SPEED = 4;

    private Score score;
    private Vector2 pos;
    private Texture padelTexture;
    private boolean leftPadle;
    private Rectangle bounds;

    public Padel(boolean leftPadle) {
        score = new Score();
        this.leftPadle = leftPadle;

        padelTexture = new Texture("padel100.png");
        pos = new Vector2(0, 0);
        pos.y = ((float) Pong.HEIGHT / (float) 2) - ((float) padelTexture.getHeight() / (float) 2);
        bounds = new Rectangle(pos.x, pos.y, padelTexture.getWidth(), padelTexture.getHeight());

        if (leftPadle) {
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

    public Rectangle getBounds() {
        return bounds;
    }

    public void update(float dt) {
        handleInput();
        bounds.setPosition(pos.x, pos.y);
    }

    public void handleInput() {
        if (leftPadle) {
            if (Gdx.input.isKeyPressed(Input.Keys.W) && (pos.y + padelTexture.getHeight() < Pong.HEIGHT)) {
                pos.y += PADEL_SPEED;
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.S) && (pos.y > 0)) {
                pos.y -= PADEL_SPEED;
            }
        }
        else if (!leftPadle) {
            if (Gdx.input.isKeyPressed(Input.Keys.UP) && (pos.y + padelTexture.getHeight() < Pong.HEIGHT)) {
                pos.y += PADEL_SPEED;
            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && (pos.y > 0)) {
                pos.y -= PADEL_SPEED;
            }
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

    public boolean isLeftPadle() {
        return leftPadle;
    }
}
