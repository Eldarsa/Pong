package com.mygdx.pong.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Stack;

public class GameStateManager {

    private static GameStateManager INSTANCE = null;

    private Stack<State> states;


    public static GameStateManager getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new GameStateManager();
        }
        return INSTANCE;
    }

    private GameStateManager() { states = new Stack<State>(); }

    public GameStateManager getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new GameStateManager();
        }
        return INSTANCE;
    };

    public void push(State state) { states.push(state); }

    public void pop() { states.pop(); }

    public void set(State state) {
        states.pop();
        states.push(state);
    }

    public void update(float dt) { states.peek().update(dt); }

    public void render(SpriteBatch sb, ShapeRenderer sr) { states.peek().render(sb, sr); }

    public State currentState() { return states.peek(); }

}
