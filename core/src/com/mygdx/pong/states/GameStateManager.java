package com.mygdx.pong.states;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;

    /*Initialize gms with state stack*/
    public GameStateManager() { states = new Stack<State>(); }

    public void push(State state) { states.push(state); }

    public void pop() { states.pop(); }

    public void set(State state) {
        states.pop();
        states.push(state);
    }

    public void update(float dt) { states.peek().update(dt); }

    public void render(SpriteBatch sb) { states.peek().render(sb); }

    public State currentState() { return states.peek(); }

}
