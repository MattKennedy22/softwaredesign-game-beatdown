package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.managers.GameStateManager;

public class SideScrollState extends GameState {

    private Dewey player;
    public SideScrollState (GameStateManager gsm){
        super(gsm);
    }

    public void init(){
        player = new Dewey();
        player.setPosition(64,32);
    }
    public void update(float deltatime){
        //CHANGE THIS (NOT GOOD)
        player.run();
        camera.translate(4,0);
        camera.update();
        handleInput();
    }
    public void draw(){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.draw(batch);
        batch.end();
    }
    public void handleInput(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            player.attack();
        }
    }
    public void dispose(){
        player.dispose();
    }
}
