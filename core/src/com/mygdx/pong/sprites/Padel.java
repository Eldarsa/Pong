package com.mygdx.pong.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;

public class Padel {
    public static final int DIST_FROM_WALL = 20;

    private Vector2 pos;
    private Texture padelTexture;

    public Padel(boolean leftPaddle) {
        padelTexture = new Texture("padel100.png");
        pos.y = Pong.HEIGHT/2 - padelTexture.getHeight()/2;

        if (leftPaddle) {
            pos.x = DIST_FROM_WALL;
        }
        else {
            pos.x = Pong.WIDTH - DIST_FROM_WALL;
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
