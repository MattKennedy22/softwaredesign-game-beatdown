package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.managers.GameStateManager;

public class BossFightState extends GameState {

    private Dewey player;
    public BossFightState(GameStateManager gsm){
        super(gsm);
    }

    public void init(){
        player = new Dewey();
        player.setPosition(64,32);
    }
    public void update(float deltatime){
        //CHANGE THIS
        handleInput();
    }
    public void draw(){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.draw(batch);
        batch.end();
    }
    public void handleInput(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            player.moveRight();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            player.moveLeft();
        }
        // JUST TEST TO SWITCH STATES
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            gsm.setGameState(GameStateManager.SIDESCROLL);
        }
    }
    public void dispose(){

    }
}
