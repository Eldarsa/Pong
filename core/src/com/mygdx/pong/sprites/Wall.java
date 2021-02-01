package com.mygdx.pong.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Wall {

    private Vector2 pos;
    private Rectangle border;
    private int wallWidth;
    private int wallHeight;

    public Wall() {

    }

    public Rectangle getRectangle() {
        return border;
    }

    public void drawWall(ShapeRenderer sr) {

    }

    public void dispose() {

    }

}
