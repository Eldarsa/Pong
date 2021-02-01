package com.mygdx.pong.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;
import com.mygdx.pong.states.PlayState;

import java.util.Random;

public class Ball {
    public static final float ORIGINAL_BALL_SPEED = 250;
    public static float CHANGING_BALL_SPEED = 250;

    private Vector2 pos;
    private Vector2 vel;
    private Texture ballTexture;
    private Rectangle bounds;
    private Random rand;

    private float topBound;
    private float botBound;

    public Ball(PlayState ps) {
        ballTexture = new Texture("ball11.png");
        pos = new Vector2(Pong.WIDTH/2 - ballTexture.getWidth()/2, Pong.HEIGHT/2 - ballTexture.getHeight()/2);
        bounds = new Rectangle(pos.x, pos.y, ballTexture.getWidth(), ballTexture.getHeight());

        rand = new Random(2);
        if (rand.nextInt() > 0) {
            vel = new Vector2(CHANGING_BALL_SPEED, 0);
        } else {
            vel = new Vector2(-CHANGING_BALL_SPEED, 0);
        }

        topBound = ps.topWall.getPos().y - ballTexture.getHeight();
        botBound = ps.botWall.getPos().y + ps.botWall.getWallHeight();

    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void update(float dt) {

        if (pos.y < botBound || pos.y > topBound) {
            vel.y = -vel.y;   // Bounce of top and bottom wall
        }

        vel.scl(dt);
        pos.add(vel.x, vel.y);
        vel.scl(1/dt);
        bounds.setPosition(pos.x, pos.y);
    }

    public boolean gameOver(){
        return (pos.x < 0 || pos.x > Pong.WIDTH-ballTexture.getWidth());
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
