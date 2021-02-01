package com.mygdx.pong.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;

import java.util.Random;

public class Ball {
    public static float BALL_SPEED = 150;

    private Vector2 pos;
    private Vector2 vel;
    private Texture ballTexture;
    private Rectangle bounds;
    private Random rand;

    public Ball() {
        ballTexture = new Texture("ball11.png");
        pos = new Vector2(Pong.WIDTH/2 - ballTexture.getWidth()/2, Pong.HEIGHT/2 - ballTexture.getHeight()/2);
        bounds = new Rectangle(pos.x, pos.y, ballTexture.getWidth(), ballTexture.getHeight());

        rand = new Random(2);
        if (rand.nextInt() > 0) {
            vel = new Vector2(BALL_SPEED, 0);
        } else {
            vel = new Vector2(-BALL_SPEED, 0);
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void update(float dt) {
        if (pos.y < 0) {
            vel.y = -vel.y;
        }
        if (pos.y > Pong.HEIGHT-ballTexture.getHeight()) {
            vel.y = -vel.y;
        }

        vel.scl(dt);
        pos.add(vel.x, vel.y);
        vel.scl(1/dt);
        bounds.setPosition(pos.x, pos.y);
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

    public void setVel(Vector2 vel) {
        this.vel = vel;
    }
}
