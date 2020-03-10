package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.juniordesign.beatdown.entities.*;
import com.juniordesign.beatdown.managers.GameStateManager;

public class MenuState extends GameState {

    private SelectBar select;
    private Background background;
    private Help controls;

    int x =24;

    public MenuState(GameStateManager gsm){ //constructor
        super(gsm);
    }

    public void init(){

        background = new Background();
        background.setPosition(0,0);

        select = new SelectBar();
        select.setPosition(24,-6);

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
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            if(x > 170){
                select.setPosition(x,-6);
            }
            else {
                x=x+86;
                select.setPosition(x,-6);
            }

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            if(x < 86){
                select.setPosition(x,-6);
            }
            else {
                x = x - 86;
                select.setPosition(x,-6);
            }
        }
        // JUST TEST TO SWITCH STATES
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            if(x == 24)
            {
                gsm.setGameState(GameStateManager.BOSSFIGHT); //starts level select but if we select 2 for this then we can jump
                                    // right into side scroller for first iteration demo
            }
            else if (x == 110)
            {
                //show Controls.png
                //if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                //close the Controls.png image
                //}

            }
            else if (x==196)
            {
                Gdx.app.exit();
            }
        }
    }
    public void dispose(){

    }


}