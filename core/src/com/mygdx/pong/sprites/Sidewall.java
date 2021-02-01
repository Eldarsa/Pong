package com.mygdx.pong.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Pong;
import com.mygdx.pong.states.PlayState;

public class Sidewall extends Wall {

    private Vector2 pos;
    private Rectangle border;
    private float wallWidth;
    private float wallHeight;

    public Sidewall(boolean top) {

        wallWidth = Pong.WIDTH;
        wallHeight = PlayState.sideWallThickness;
        if(top){
            pos = new Vector2(0,
                    Pong.HEIGHT - Pong.HEIGHT * PlayState.wallDistanceFactor - wallHeight);

        } else if(!top){
            pos = new Vector2(0, Pong.HEIGHT * PlayState.wallDistanceFactor);
        }

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
