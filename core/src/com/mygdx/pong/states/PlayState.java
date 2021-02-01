package com.mygdx.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.pong.Level.Level;
import com.mygdx.pong.Level.Timer;
import com.mygdx.pong.Player.Player;
import com.mygdx.pong.Pong;
import com.mygdx.pong.Score.Score;
import com.mygdx.pong.Score.ScoreBoard;
import com.mygdx.pong.sprites.Ball;
import com.mygdx.pong.sprites.Midwall;
import com.mygdx.pong.sprites.Padel;
import com.mygdx.pong.sprites.Sidewall;

public class PlayState extends State {

    public static final float wallDistanceFactor = 0.1f;
    public static final float sideWallThickness = 0.01f * Pong.HEIGHT;
    public static final float infoHeight = 0.95f;

    private Padel leftPadel;
    private Padel rightPadel;
    private Ball ball;
    private Sidewall topWall;
    private Sidewall botWall;
    private Midwall midWall;

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
        topWall = new Sidewall(true);
        botWall = new Sidewall(false);
        midWall = new Midwall();

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
    public void render(SpriteBatch sb, ShapeRenderer sr) {
        sb.begin();

        scoreBoard.drawScore(sb);
        timer.drawTimer(sb);
        level.drawLevel(sb);

        sb.draw(leftPadel.getTexture(), leftPadel.getPos().x, leftPadel.getPos().y);
        sb.draw(rightPadel.getTexture(), rightPadel.getPos().x, rightPadel.getPos().y);
        sb.draw(ball.getTexture(), ball.getPos().x, ball.getPos().y);

        sb.end();

        topWall.drawWall(sr);
        botWall.drawWall(sr);
        midWall.drawWall(sr);

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
