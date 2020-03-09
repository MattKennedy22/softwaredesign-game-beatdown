package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.juniordesign.beatdown.BeatdownGame;
import com.juniordesign.beatdown.managers.GameStateManager;

public abstract class GameState {

    protected GameStateManager gsm;
    protected BeatdownGame game;

    protected SpriteBatch batch;
    protected OrthographicCamera camera;

    protected GameState(GameStateManager gsm){
        this.gsm = gsm;
        game = gsm.getGame();
        batch = game.getBatch();
        camera = game.getCamera();
        init();
    }

    public abstract void init();
    public abstract void update(float deltatime);
    public abstract void draw();
    public abstract void handleInput();
    public abstract void dispose();
}
