package com.mygdx.pong.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.pong.sprites.Ball;
import com.mygdx.pong.sprites.Padel;

public class PlayState extends State {
    private Padel leftPadel;
    private Padel rightPadel;
    private Ball ball;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
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

}
