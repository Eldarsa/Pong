package com.mygdx.pong.Score;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.pong.Player.Player;
import com.mygdx.pong.Pong;

public class ScoreBoard {

    private Vector3 pos1;
    private Vector3 pos2;
    private Player p1;
    private Player p2;

    private float fontsize;
    private BitmapFont font;

    public ScoreBoard(Player player1, Player player2) {
        p1 = player1;
        p2 = player2;

        //TODO: Implement x/y-factor
        //TODO: get fontsize and set fontsize
        font = new BitmapFont();

        pos1 = new Vector3(Pong.WIDTH*xFac, Pong.HEIGHT*yFac, 0);
        pos2 = new Vector3(Pong.WIDTH*(1-xFac), Pong.HEIGHT*(1-yFac), 0);
    }

    public void drawScore(SpriteBatch sb) {
        font.draw(sb, p1.score.toString(), pos1.x, pos1.y);
        font.draw(sb, p2.score.toString(), pos2.x, pos2.y);
    }


}
