package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.juniordesign.beatdown.entities.DeweyBossFight;
import com.juniordesign.beatdown.entities.bosses.Boss;
import com.juniordesign.beatdown.entities.DeweySideScroll;
import com.juniordesign.beatdown.entities.bosses.Smore;
import com.juniordesign.beatdown.levels.Level;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.collisions.BossFightCollisions;
import com.juniordesign.beatdown.managers.maps.BossFightMap;

public class BossFightState extends GameState {

    private DeweyBossFight player;
    private Boss boss;
    private Level level;

    public BossFightState(GameStateManager gsm){
        super(gsm);
    }


    public void init(){
        level = gsm.getLevel();
        player = new DeweyBossFight();
        player.setPosition(64,32);
        boss = new Smore();
        mapManager = new BossFightMap(level.getLevelMap());
        collisionManager = new BossFightCollisions(boss, player);

        camera.setToOrtho(false, 256, 144);
        camera.update();
    }
    public void update(float deltatime){
        //CHANGE THIS
        camera.update();
        handleInput();
        player.checkActions(deltatime);
        boss.doActions(deltatime);

        //Check collisions
        collisionManager.checkCollisions(deltatime, null);
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

