package com.mygdx.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.pong.Level.Level;
import com.mygdx.pong.Level.Timer;
import com.mygdx.pong.Player.Player;
import com.mygdx.pong.Score.Score;
import com.mygdx.pong.Score.ScoreBoard;
import com.mygdx.pong.sprites.Ball;
import com.mygdx.pong.sprites.Padel;

public class PlayState extends State {
    private Padel leftPadel;
    private Padel rightPadel;
    private Ball ball;

    private ScoreBoard scoreBoard;
    private Timer timer;
    private int targetScore;
    private Level level;

    protected PlayState(GameStateManager gsm) {
        super(gsm);

        targetScore = 5;
        timer = new Timer(21);
        level = new Level(timer, 1);

        leftPadel = new Padel(true);
        rightPadel = new Padel(false);
        ball = new Ball();

        scoreBoard = new ScoreBoard(leftPadel, rightPadel);
    }

    @Override
    public void update(float dt) {
        handleInput();
        leftPadel.update(dt);
        rightPadel.update(dt);
        ball.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        scoreBoard.drawScore(sb);
        timer.drawTimer(sb);
        level.drawLevel(sb);

        sb.draw(leftPadel.getTexture(), leftPadel.getPos().x, leftPadel.getPos().y);
        sb.draw(rightPadel.getTexture(), rightPadel.getPos().x, rightPadel.getPos().y);
        sb.draw(ball.getTexture(), ball.getPos().x, ball.getPos().y);

        sb.end();
    }

    @Override
    public void handleInput() {
        leftPadel.handleInput();
        rightPadel.handleInput();
    }

    @Override
    public void dispose() {
        leftPadel.dispose();
        rightPadel.dispose();
        ball.dispose();
    }

    private void updateScore(int player) {

    }

}
