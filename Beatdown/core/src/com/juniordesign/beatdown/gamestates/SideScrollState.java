package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.managers.collisions.CollisionManager;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.collisions.SideScrollCollisions;
import com.juniordesign.beatdown.managers.maps.SideScrollMap;

public class SideScrollState extends GameState {

    private Dewey player;

    public SideScrollState (GameStateManager gsm, String mapName){
        super(gsm,mapName);
    }

    public void init(String mapName){
        player = new Dewey();
        player.setPosition(64,32);
        mapManager = new SideScrollMap(mapName);
        collisionManager = new SideScrollCollisions(mapManager.getCollideLayer(), player);
    }
    public void update(float deltatime){
        //CHANGE THIS (NOT GOOD)
        player.run(deltatime);
        // Move camera 192 pixels per second
        camera.translate(192*deltatime,0);
        camera.update();

        //TEST COLLISIONS
        collisionManager.checkCollisions(deltatime);
        if(player.getHealth() <= 0){
            gsm.setGameState(GameStateManager.BOSSFIGHT);
        }
        handleInput();
    }
    public void draw(){
        mapManager.render(camera);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        //mapManager.renderObstacles();
        player.draw(batch);
        batch.end();
    }
    public void handleInput(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            player.attack();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            player.jump();
        }
    }
    public void dispose(){
        player.dispose();
        mapManager.dispose();
        //tiledMap.dispose();
    }
}
