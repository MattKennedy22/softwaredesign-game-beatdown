package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.juniordesign.beatdown.entities.DeweySideScroll;
import com.juniordesign.beatdown.entities.Enemy;
import com.juniordesign.beatdown.levels.Level;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.collisions.SideScrollCollisions;
import com.juniordesign.beatdown.managers.maps.SideScrollMap;

import java.util.ArrayList;

public class SideScrollState extends GameState {

    private DeweySideScroll player;
    private ArrayList<Enemy> enemies;
    private Music music;
    private double startTime = System.currentTimeMillis();
    private Level level;


    public SideScrollState (GameStateManager gsm){
        super(gsm);
    }

    public void init(){
        level = gsm.getLevel();
        music = Gdx.audio.newMusic(Gdx.files.internal(level.getLevelMusic()));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();


        player = new DeweySideScroll();
        player.setPosition(64,32);
        enemies = new ArrayList<Enemy>();
        mapManager = new SideScrollMap(level.getLevelMap());
        mapManager.spawnEnemies(enemies, level.getLevelEnemies());
        collisionManager = new SideScrollCollisions(mapManager.getCollideLayer(), player);
    }
    public void update(float deltatime){
        //CHANGE THIS (NOT GOOD)
        player.run(deltatime);
        // Move camera with player if player position is not past end of level
        if(player.getPositionX() < 15744) {
            camera.translate(player.getRunSpeed() * deltatime, 0);
        }
        // Once player reaches this x coordinate go to boss fight
        else if (player.getPositionX() > 16000){
            gsm.setGameState(GameStateManager.BOSSFIGHT);
        }
        camera.update();

        //TEST COLLISIONS
        collisionManager.checkCollisions(deltatime, enemies);
        if(player.getHealth() <= 0){
            gsm.setGameState(GameStateManager.MENU);
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

            //if(((0 <= ((System.currentTimeMillis() - startTime) % 731.7)) && (150 >= ((System.currentTimeMillis() - startTime)%731.7))) || ((581.7 <= ((System.currentTimeMillis() - startTime) % 731.7)) && (731.7 >= ((System.currentTimeMillis() - startTime)%731.7))))
            //{
                player.attack(enemies);
            //}
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            //if(((0 <= ((System.currentTimeMillis() - startTime) % 731.7)) && (150 >= ((System.currentTimeMillis() - startTime)%731.7))) || ((581.7 <= ((System.currentTimeMillis() - startTime) % 731.7)) && (731.7 >= ((System.currentTimeMillis() - startTime)%731.7))))
            //{
                if(player.getAnimationTime() == 0) {
                    player.jump();
                }
            //}
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.S)){
            //if(((0 <= ((System.currentTimeMillis() - startTime) % 731.7)) && (150 >= ((System.currentTimeMillis() - startTime)%731.7))) || ((581.7 <= ((System.currentTimeMillis() - startTime) % 731.7)) && (731.7 >= ((System.currentTimeMillis() - startTime)%731.7))))
            //{
                player.duck();
            //}
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
