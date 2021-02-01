package com.mygdx.pong.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;

public class Ball {
    private Vector2 pos;
    private Texture ballTexture;

    public Ball() {
        ballTexture = new Texture("ball11.png");
        pos = new Vector2(Pong.WIDTH/2 - ballTexture.getWidth()/2, Pong.HEIGHT/2 - ballTexture.getHeight()/2);
    }

    public void update(float dt) {

    }

    public void dispose() {
        ballTexture.dispose();
    }

    public Vector2 getPos() {
        return pos;
    }

    public Texture getTexture() {
        return ballTexture;
    }
}
