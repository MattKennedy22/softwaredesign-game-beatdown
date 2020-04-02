package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.juniordesign.beatdown.entities.*;
import com.juniordesign.beatdown.managers.GameStateManager;

public class GameOverState extends GameState {

    private GameOverScreen background;

    public GameOverState(GameStateManager gsm){
        super(gsm);
    }

    public void init(){

        background = new GameOverScreen();
        background.setPosition(0,0);


        camera.setToOrtho(false, 256, 144);
        camera.update();

    }
    public void update(float deltatime){
        handleInput();
    }
    public void draw(){

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background.draw(batch);
        batch.end();

    }
    public void handleInput() {

        // JUST TEST TO SWITCH STATES
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            gsm.setGameState(GameStateManager.MENU);
        }
    }

    public void dispose(){
        background.dispose();
    }
}
