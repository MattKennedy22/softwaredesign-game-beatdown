package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.juniordesign.beatdown.entities.*;
import com.juniordesign.beatdown.managers.GameStateManager;

public class MenuState extends GameState {

    private SelectBar select;
    private Background background;

    private int positionX;

    public MenuState(GameStateManager gsm){
        super(gsm);
    }

    public void init(){

        background = new Background();
        background.setPosition(0,0);

        select = new SelectBar();
        select.setPosition(24,-6);

        camera.setToOrtho(false, 256, 144);
        camera.update();

        positionX = 24;

    }
    public void update(float deltatime){
        handleInput();
    }
    public void draw(){
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        background.draw(batch);
        select.draw(batch);
        batch.end();



    }
    public void handleInput(){
        if((Gdx.input.isKeyJustPressed(Input.Keys.D)) || (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))){
            if(positionX <= 170){
                positionX = positionX + 86;
            }
            select.setPosition(positionX,-6);
        }
        if((Gdx.input.isKeyJustPressed(Input.Keys.A)) || (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))){
            if(positionX >= 86){
                positionX = positionX - 86;
            }
            select.setPosition(positionX,-6);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            if(positionX == 24)
            {
                gsm.setGameState(GameStateManager.LEVELSELECT);
            }
            else if (positionX == 110)
            {
                gsm.setGameState(GameStateManager.HELPMENU);
            }
            else if (positionX == 196)
            {
                Gdx.app.exit();
            }
        }
    }

    public void dispose(){
        background.dispose();
        select.dispose();
    }


}
