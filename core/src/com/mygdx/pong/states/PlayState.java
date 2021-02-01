package com.mygdx.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.pong.Level.Level;
import com.mygdx.pong.Level.Timer;
import com.mygdx.pong.Pong;
import com.mygdx.pong.Score.ScoreBoard;
import com.mygdx.pong.sprites.Ball;
import com.mygdx.pong.sprites.Midwall;
import com.mygdx.pong.sprites.Padel;
import com.mygdx.pong.sprites.Sidewall;

public class PlayState extends State {
    private static final int MAX_TIME = 6;

    public static final float wallDistanceFactor = 0.1f;
    public static final float sideWallThickness = 0.01f * Pong.HEIGHT;
    public static final float infoHeight = 0.95f;

    private Padel leftPadel;
    private Padel rightPadel;
    private Ball ball;
    public Sidewall topWall;
    public Sidewall botWall;
    private Midwall midWall;

    private ScoreBoard scoreBoard;
    private Timer timer;
    private int targetScore;
    private Level level;
    private boolean recentlyIncrementedLevel;

    protected PlayState(GameStateManager gsm) {
        super(gsm);

        targetScore = 5;
        timer = new Timer(MAX_TIME);
        level = new Level(timer, 1);

        topWall = new Sidewall(true);
        botWall = new Sidewall(false);
        midWall = new Midwall();

        ball = new Ball(this);
        leftPadel = new Padel(true,  this);
        rightPadel = new Padel(false, this);

        scoreBoard = new ScoreBoard(leftPadel, rightPadel);
        recentlyIncrementedLevel = true;
    }

    private Vector2 calculateReturnDirection(Padel padel, Ball ball){
        float velX;
        float velY;
        float padelPosYCenter = padel.getPos().y + padel.getTexture().getHeight() / 2;
        float ballPosYCenter = ball.getPos().y + ball.getTexture().getHeight()/2;

        float diff = ballPosYCenter - padelPosYCenter;
        float returnAngle = (float) (Math.PI/4 * (2.0/padel.getTexture().getHeight()) * diff);

        if (padel.isLeftPadle()){
            velX = (float) (Ball.CHANGING_BALL_SPEED * Math.cos(returnAngle));
        } else {
            velX = (float) -(Ball.CHANGING_BALL_SPEED * Math.cos(returnAngle));
        }

        velY = (float) (Ball.CHANGING_BALL_SPEED * Math.sin(returnAngle));

        return new Vector2(velX, velY);
    }

    private void detectCollision(Padel padel, Ball ball){
        if (padel.getBounds().overlaps(ball.getBounds())) {
            ball.setVel(calculateReturnDirection(padel, ball));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

        detectCollision(leftPadel, ball);
        detectCollision(rightPadel, ball);

        leftPadel.update(dt);
        rightPadel.update(dt);
        ball.update(dt);

        if ((timer.getElapsedSeconds() % timer.getMaxTime() == 0) && !recentlyIncrementedLevel){
            level.incrementLevel();
            recentlyIncrementedLevel = true;
        }
        if ((timer.getElapsedSeconds() + (timer.getMaxTime()/2)) % timer.getMaxTime() == 0) {
            recentlyIncrementedLevel = false;
        }

        if (ball.setOver()) {
            if (ball.getPos().x < Pong.WIDTH/2) {
                rightPadel.incrementScore(1);
            }
            else if (ball.getPos().x > Pong.WIDTH/2) {
                leftPadel.incrementScore(1);
            }

            ball.reset();
            rightPadel.resetPos();
            leftPadel.resetPos();

            gsm.push(new PauseState(gsm));
        }

        if (rightPadel.getScore() >= targetScore || leftPadel.getScore() >= targetScore) {
            gsm.set(new EndState(gsm));
            dispose();
        }
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
