package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.juniordesign.beatdown.entities.*;
import com.juniordesign.beatdown.entities.bosses.Boss;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.maps.MapManager;

import java.util.ArrayList;

public class PauseState extends GameState {

    private PauseSelBar select;
    private Pause pause;
    private GameState currentState;


    int y = 77; //for select bar movements Value TBD

   public PauseState(GameStateManager gsm){
       super(gsm);
       this.currentState = currentState;
    }

    public void init(){

        pause = new Pause();
        pause.setPosition(0,0);

        select = new PauseSelBar();
        select.setPosition(68,77);


        camera.setToOrtho(false, 256, 144);
        camera.update();

    }
    public void update(float deltatime){
        handleInput();
    }
    public void draw(){

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        pause.draw(batch);
        select.draw(batch);
        batch.end();

    }
    public void handleInput(){
        if((Gdx.input.isKeyJustPressed(Input.Keys.W)) || (Gdx.input.isKeyJustPressed(Input.Keys.UP))){
            if(y == 77){
                select.setPosition(68,y);
            }
            else {
                y=y+33;
                select.setPosition(68,y);
            }

        }
        if((Gdx.input.isKeyJustPressed(Input.Keys.S)) || (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))){
            if(y == 11){
                select.setPosition(68,y);
            }
            else {
                y = y - 33;
                select.setPosition(68,y);
            }
        }
        // JUST TEST TO SWITCH STATES
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            if(y == 77)
            {

            }
            else if (y == 44)
            {
                gsm.setGameState(GameStateManager.SIDESCROLL);
            }
            else if (y==11)
            {
                gsm.setGameState(GameStateManager.MENU); //good
            }
        }
    }
    public void dispose(){
        pause.dispose();
        select.dispose();
    }
}
