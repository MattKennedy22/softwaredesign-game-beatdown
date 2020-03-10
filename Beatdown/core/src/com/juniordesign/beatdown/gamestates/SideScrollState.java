package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.managers.CollisionManager;
import com.juniordesign.beatdown.managers.GameStateManager;

public class SideScrollState extends GameState {

    private Dewey player;

    public SideScrollState (GameStateManager gsm, String mapName){
        super(gsm, mapName);
    }

    public void init(){
        player = new Dewey();
        player.setPosition(64,32);
        collisionManager = new CollisionManager(mapManager.getCollideLayer(), player);
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
    }
    public void dispose(){
        player.dispose();
        mapManager.dispose();
        //tiledMap.dispose();
    }
}
