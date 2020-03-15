package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.juniordesign.beatdown.entities.Boss;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.maps.SideScrollMap;

public class BossFightState extends GameState {

    private Dewey player;
    private Boss boss;
    public BossFightState(GameStateManager gsm, String mapName){
        super(gsm,mapName);
    }


    public void init(String mapName){
        player = new Dewey();
        player.setPosition(64,32);
        boss = new Boss();
        boss.setPosition(160, 32);
        mapManager = new SideScrollMap(mapName);
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
        boss.draw(batch);
        batch.end();
    }
    public void handleInput(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            player.moveRight();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            player.moveLeft();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            player.jump();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            player.duck();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            //attack in dewey class
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            gsm.setGameState(GameStateManager.SIDESCROLL);
        }
    }
    public void dispose(){
        player.dispose();
        boss.dispose();
        mapManager.dispose();
        //tiledMap.dispose();
    }
}

