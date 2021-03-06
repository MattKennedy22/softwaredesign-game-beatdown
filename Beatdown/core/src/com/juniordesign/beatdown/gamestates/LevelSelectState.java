package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.juniordesign.beatdown.entities.*;
import com.juniordesign.beatdown.managers.GameStateManager;

public class LevelSelectState extends GameState {

    private SelectBar select;
    private LvlSelect background;

    int x =24;

    public LevelSelectState(GameStateManager gsm){
        super(gsm);
    }

    public void init(){

        background = new LvlSelect();
        background.setPosition(0,0);

        select = new SelectBar();
        select.setPosition(24,-6);

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
        select.draw(batch);
        batch.end();
    }

    public void handleInput(){
        if((Gdx.input.isKeyJustPressed(Input.Keys.D)) || (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))){
            if(x > 170){
                select.setPosition(x,-6);
            }
            else {
                x=x+86;
                select.setPosition(x,-6);
            }

        }
        if((Gdx.input.isKeyJustPressed(Input.Keys.A)) || (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))){
            if(x < 86){
                select.setPosition(x,-6);
            }
            else {
                x = x - 86;
                select.setPosition(x,-6);
            }
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            gsm.setGameState(GameStateManager.MENU);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            if(x == 24)
            {
                gsm.setLevel(1);
                gsm.setGameState(GameStateManager.SIDESCROLL);
            }
            else if (x == 110)
            {
                //City Stage
                gsm.setLevel(2);
                gsm.setGameState(GameStateManager.SIDESCROLL);
            }
            else if (x==196)
            {
                //hard play
                gsm.setLevel(3);
                gsm.setGameState(GameStateManager.SIDESCROLL);
            }
        }
    }

    public void dispose(){
        background.dispose();
        select.dispose();
    }

}
