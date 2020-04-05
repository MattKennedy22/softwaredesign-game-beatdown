package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.juniordesign.beatdown.entities.*;
import com.juniordesign.beatdown.entities.bosses.Boss;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.maps.MapManager;

import java.util.ArrayList;

public class PauseState extends GameState {

    private PauseSelBar select;
    private Pause pause;

    private int positionY;

   public PauseState(GameStateManager gsm){
       super(gsm);
   }

   public void init(){
        positionY = 77;
        pause = new Pause();
        pause.setPosition(0,0);

        select = new PauseSelBar();
        select.setPosition(68,77);

   }

   public void update(float deltatime){
        handleInput();
   }

   public void draw(){

        batch.setProjectionMatrix(hudCamera.combined);

        batch.begin();
        pause.draw(batch);
        select.draw(batch);
        batch.end();

   }

   public void handleInput(){
        if((Gdx.input.isKeyJustPressed(Input.Keys.W)) || (Gdx.input.isKeyJustPressed(Input.Keys.UP))){
            if(positionY != 77){
                positionY = positionY + 33;
            }
            select.setPosition(68,positionY);
        }
        if((Gdx.input.isKeyJustPressed(Input.Keys.S)) || (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))){
            if(positionY != 11){
                positionY = positionY - 33;
            }
            select.setPosition(68,positionY);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            if(positionY == 77)
            {
                gsm.unpause();
            }
            else if (positionY == 44)
            {
                gsm.setGameState(GameStateManager.SIDESCROLL);
            }
            else if (positionY==11)
            {
                gsm.setGameState(GameStateManager.MENU);
            }
        }
   }

   public void dispose(){
        pause.dispose();
        select.dispose();
   }
}
