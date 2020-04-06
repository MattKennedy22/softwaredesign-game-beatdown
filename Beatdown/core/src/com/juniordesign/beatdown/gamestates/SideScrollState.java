package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.juniordesign.beatdown.entities.DeweySideScroll;
import com.juniordesign.beatdown.entities.Enemy;
import com.juniordesign.beatdown.entities.Hud;
import com.juniordesign.beatdown.levels.Level;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.collisions.SideScrollCollisions;
import com.juniordesign.beatdown.managers.maps.SideScrollMap;

import java.util.ArrayList;

public class SideScrollState extends GameState {

    private DeweySideScroll player;
    private ArrayList<Enemy> enemies;
    private Level level;
    private int endOfLevel;
    private int cameraEndOfLevel;


    public SideScrollState (GameStateManager gsm){
        super(gsm);
    }

    public void init(){
        level = gsm.getLevel();
        endOfLevel = level.getEndOfLevel();
        cameraEndOfLevel = endOfLevel - 256;
        music = Gdx.audio.newMusic(Gdx.files.internal(level.getLevelMusic()));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();


        player = new DeweySideScroll();
        if(gsm.getPlayerHealthCheat()){
            player.setHealth(666);
        }
        gameHUD = new Hud(player);
        player.setRunSpeed(level.getRunSpeed());
        player.setPosition(level.getStartPosition(),32);
        enemies = new ArrayList<Enemy>();
        mapManager = new SideScrollMap(level.getLevelMap());
        mapManager.spawnEnemies(enemies, level.getLevelEnemies());
        collisionManager = new SideScrollCollisions(mapManager.getCollideLayer(), player);

        camera.setToOrtho(false, 256, 144);
        camera.update();
    }

    public void update(float deltatime){

        player.run(deltatime);
        // Move camera with player if player position is not past end of level
        if(player.getPositionX() < cameraEndOfLevel) {
            camera.translate(player.getRunSpeed() * deltatime, 0);
        }
        // Once player reaches this x coordinate go to boss fight
        else if (player.getPositionX() > endOfLevel){
            gsm.setGameState(GameStateManager.BOSSFIGHT);
        }
        camera.update();

        //TEST COLLISIONS
        collisionManager.checkCollisions(deltatime, enemies);
        if(player.getHealth() <= 0){
            gsm.setGameState(GameStateManager.GAMEOVERMENU);
        }
        handleInput();
        player.checkActions(deltatime);


    }

    public void draw(){

        mapManager.render(camera,hudCamera);
        // Print HUD
        batch.setProjectionMatrix(hudCamera.combined);
        batch.begin();
        gameHUD.render(batch);
        batch.end();

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
        if((Gdx.input.isKeyJustPressed(Input.Keys.W)) || (Gdx.input.isKeyJustPressed(Input.Keys.UP))){
            if(player.getAnimationTime() == 0) {
                player.jump();
            }
        }
        if((Gdx.input.isKeyJustPressed(Input.Keys.S)) || (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))){
            player.duck();
        }

        else if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            music.pause();
            gsm.pause();
        }
        
    }

    public void dispose(){
        player.dispose();
        mapManager.dispose();
        for(Enemy enemy : enemies){
            enemy.dispose();
        }
        music.dispose();
        gameHUD.dispose();
    }
}
