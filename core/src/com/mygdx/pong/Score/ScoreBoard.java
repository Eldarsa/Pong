package com.mygdx.pong.Score;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.pong.Player.Player;
import com.mygdx.pong.Pong;
import com.mygdx.pong.sprites.Padel;

public class ScoreBoard {

    private Vector3 pos1;
    private Vector3 pos2;
    private Padel p1;
    private Padel p2;

    private BitmapFont font;
    private float fontsize;

    private float xFac;
    private float yFac;

    public ScoreBoard(Padel padel1, Padel padel2) {
        p1 = padel1;
        p2 = padel2;

        xFac = 0.2f;
        yFac = 0.5f;

        font = new BitmapFont();
        fontsize = 1f;
        font.getData().setScale(fontsize);

        pos1 = new Vector3(Pong.WIDTH*xFac, Pong.HEIGHT*yFac, 0);
        pos2 = new Vector3(Pong.WIDTH*(1-xFac), Pong.HEIGHT*yFac, 0);
    }

    public void drawScore(SpriteBatch sb) {
        font.draw(sb, String.valueOf(p1.getScore()), pos1.x, pos1.y);
        font.draw(sb, String.valueOf(p2.getScore()), pos2.x, pos2.y);
    }


}
