package com.mygdx.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
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

    private Vector2 calculateReturnDirection(Padel padel, Ball ball){
//        if (ball.getPos().x < padel.getPos().x || ball.getPos().x > (padel.getPos().y + padel.getTexture().getHeight())) {
//            return new Vector2(0, 0);
//        }
        float velX;
        float velY;
        float padelPosYCenter = padel.getPos().y + padel.getTexture().getHeight() / 2;
        float ballPosYCenter = ball.getPos().y + ball.getTexture().getHeight()/2;

        float diff = ballPosYCenter - padelPosYCenter;
        float returnAngle = (float) (Math.PI/4 * (2.0/padel.getTexture().getHeight()) * diff);

        if (padel.isLeftPadle()){
            velX = (float) (Ball.BALL_SPEED * Math.cos(returnAngle));
        } else {
            velX = (float) -(Ball.BALL_SPEED * Math.cos(returnAngle));
        }

        velY = (float) (Ball.BALL_SPEED * Math.sin(returnAngle));
        System.out.println(String.format("returnAngle: %.1f \t velX: %.1f \t velY: %.1f", returnAngle, velX, velY));

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
