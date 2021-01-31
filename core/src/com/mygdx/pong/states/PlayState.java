package com.mygdx.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.pong.Player.Player;
import com.mygdx.pong.Score.Score;
import com.mygdx.pong.Score.ScoreBoard;

public class PlayState extends State {

    private Player player1;
    private Player player2;
    private ScoreBoard scoreBoard;

    private int targetScore;
    private int level;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        player1 = new Player();
        player2 = new Player();
        scoreBoard = new ScoreBoard(player1, player2);

        level = 1;
        //targetScore = Get from config

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        scoreBoard.drawScore(sb);
        spriteManager.drawSprites(sb); //TODO: Implement spritemanager

        sb.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }

    private void updateScore(int player) {

    }

    private void increaseLevel(){
        level+=1;
    }

}
