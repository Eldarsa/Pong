package com.mygdx.pong.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;

import java.util.Random;

public class Ball {
    public float SPEED;

    private Vector2 pos;
    private Vector2 vel;
    private Texture ballTexture;
    private Random rand;

    public Ball() {
        rand = new Random();
        ballTexture = new Texture("ball11.png");
        pos = new Vector2(Pong.WIDTH/2 - ballTexture.getWidth()/2, Pong.HEIGHT/2 - ballTexture.getHeight()/2);
        vel = new Vector2(SPEED,0);

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
