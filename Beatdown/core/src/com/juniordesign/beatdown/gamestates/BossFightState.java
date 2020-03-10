package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.MapManager;

public class BossFightState extends GameState {

    private Dewey player;

    public BossFightState(GameStateManager gsm, String mapName){
        super(gsm);
        mapManager = new MapManager(mapName);
    }

    public void init(){
        player = new Dewey();
        player.setPosition(64,32);
        camera.setToOrtho(false, 256, 144);
        camera.update();
    }
    public void update(float deltatime){
        //CHANGE THIS
        camera.update();
        handleInput();
    }
    public void draw(){
        //tiledMapRenderer.setView(camera);
        //tiledMapRenderer.render();
        mapManager.render(camera);

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
        player.dispose();
        mapManager.dispose();
        //tiledMap.dispose();
    }
}
