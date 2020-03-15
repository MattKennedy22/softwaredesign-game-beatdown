package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.entities.Enemy;
import com.juniordesign.beatdown.managers.collisions.CollisionManager;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.collisions.SideScrollCollisions;
import com.juniordesign.beatdown.managers.maps.SideScrollMap;

import java.util.ArrayList;

public class SideScrollState extends GameState {

    private Dewey player;
    private ArrayList<Enemy> enemies;
    private Music music;


    public SideScrollState (GameStateManager gsm, String mapName){
        super(gsm,mapName);
    }

    public void init(String mapName){

        music = Gdx.audio.newMusic(Gdx.files.internal("cityMusic.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();

        player = new Dewey();
        player.setPosition(64,32);
        enemies = new ArrayList<Enemy>();
        mapManager = new SideScrollMap(mapName);
        mapManager.spawnEnemies(enemies);
        collisionManager = new SideScrollCollisions(mapManager.getCollideLayer(), player);
    }
    public void update(float deltatime){
        //CHANGE THIS (NOT GOOD)
        player.run(deltatime);
        // Move camera 192 pixels per second
        camera.translate(player.getRunSpeed()*deltatime,0);
        camera.update();

        //TEST COLLISIONS
        collisionManager.checkCollisions(deltatime);
        if(player.getHealth() <= 0){
            gsm.setGameState(GameStateManager.BOSSFIGHT);
        }
        handleInput();
        player.checkActions(deltatime);
    }
    public void draw(){
        mapManager.render(camera);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(Enemy enemy : enemies){
            enemy.draw(batch);
        }
        player.draw(batch);
        batch.end();
    }
    public void handleInput(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            player.attack(enemies);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            if(player.getAnimationTime() == 0){
                player.jump();
            }
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.S)){
            player.duck();
        }
    }
    public void dispose(){
        player.dispose();
        mapManager.dispose();
        for(Enemy enemy : enemies){
            enemy.dispose();
        }
        music.dispose();
    }
}
