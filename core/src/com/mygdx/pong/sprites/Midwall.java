package com.mygdx.pong.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;
import com.mygdx.pong.states.PlayState;

public class Midwall extends Wall {

    private Vector2 pos;
    private Rectangle border;
    private float wallWidth;
    private float wallHeight;

    public Midwall() {

        wallWidth = Pong.WIDTH * 0.01f;
        wallHeight = Pong.HEIGHT - Pong.HEIGHT* PlayState.wallDistanceFactor * 2.0f;
        pos = new Vector2(Pong.WIDTH * 0.5f - wallWidth * 0.5f,
                Pong.HEIGHT * PlayState.wallDistanceFactor);

        border = new Rectangle(pos.x, pos.y, wallWidth, wallHeight);
    }

    @Override
    public Rectangle getRectangle() {
        return border;
    }

    @Override
    public void drawWall(ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1, 1, 1, 1);
        sr.rect(pos.x, pos.y, wallWidth, wallHeight);
        sr.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
