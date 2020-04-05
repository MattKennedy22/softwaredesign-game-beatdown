package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.juniordesign.beatdown.entities.*;
import com.juniordesign.beatdown.managers.GameStateManager;

public class HelpMenuState extends GameState {

    private SelectBar select;
    private Help controls;

    public HelpMenuState(GameStateManager gsm){
        super(gsm);
    }

    public void init(){

        controls = new Help();
        controls.setPosition(0,0);

        select = new SelectBar();
        select.setPosition(110,-6);

        camera.setToOrtho(false, 256, 144);
        camera.update();

    }
    public void update(float deltatime){
        handleInput();
    }

    public void draw(){

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        controls.draw(batch);
        select.draw(batch);
        batch.end();

    }
    public void handleInput(){

        if((Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) || (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) || (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))){
            gsm.setGameState(GameStateManager.MENU);
        }
    }
    public void dispose(){
        controls.dispose();
        select.dispose();
    }


}
