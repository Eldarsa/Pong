package com.mygdx.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.pong.Player.Player;
import com.mygdx.pong.Score.Score;
import com.mygdx.pong.Score.ScoreBoard;
import com.mygdx.pong.sprites.Ball;
import com.mygdx.pong.sprites.Padel;

public class PlayState extends State {
    private Padel leftPadel;
    private Padel rightPadel;
    private Ball ball;

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

        leftPadel = new Padel(true);
        rightPadel = new Padel(false);
        ball = new Ball();
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        scoreBoard.drawScore(sb);
        spriteManager.drawSprites(sb); //TODO: Implement spritemanager

        sb.draw(leftPadel.getTexture(), leftPadel.getPos().x, leftPadel.getPos().y);
        sb.draw(rightPadel.getTexture(), rightPadel.getPos().x, rightPadel.getPos().y);
        sb.draw(ball.getTexture(), ball.getPos().x, ball.getPos().y);

        sb.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {
        leftPadel.dispose();
        rightPadel.dispose();
        ball.dispose();
    }

    private void updateScore(int player) {

    }

    private void increaseLevel(){
        level+=1;
    }

}
