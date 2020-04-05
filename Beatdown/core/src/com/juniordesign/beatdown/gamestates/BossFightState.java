package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.TimeUtils;
import com.juniordesign.beatdown.entities.DeweyBossFight;
import com.juniordesign.beatdown.entities.Hud;
import com.juniordesign.beatdown.entities.bosses.Boss;
import com.juniordesign.beatdown.entities.DeweySideScroll;
import com.juniordesign.beatdown.entities.bosses.Devil;
import com.juniordesign.beatdown.entities.bosses.DudeLove;
import com.juniordesign.beatdown.entities.bosses.Smore;
import com.juniordesign.beatdown.levels.Level;
import com.juniordesign.beatdown.levels.LevelOne;
import com.juniordesign.beatdown.levels.LevelTwo;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.collisions.BossFightCollisions;
import com.juniordesign.beatdown.managers.maps.BossFightMap;

import java.sql.Time;

public class BossFightState extends GameState {

    private DeweyBossFight player; //here the player restarts with his max health
    private Boss boss;
    private Level level;
    private double msPerBeat;

    private double time;

    public BossFightState(GameStateManager gsm){
        super(gsm);
    }


    public void init() {
        level = gsm.getLevel();
        music = Gdx.audio.newMusic(Gdx.files.internal(level.getBossMusic()));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();

        player = new DeweyBossFight();
        if(gsm.getPlayerHealthCheat()){
            player.setHealth(666);
        }
        player.setPosition(64, 32);

        msPerBeat = level.getLevelMSpB();
        time = level.getBossStartTime();

        if (level.getDifficulty() == 1) {
            boss = new DudeLove();
        }

        else if (level.getDifficulty() == 2) {
            boss = new Smore();
        }
        else if (level.getDifficulty() == 3){
            boss = new Devil();
        }

        gameHUD = new Hud(player,level.getDifficulty());
        player.setRunSpeed(level.getRunSpeed());
        player.setPosition(64,32);
        mapManager = new BossFightMap(level.getLevelMap());
        collisionManager = new BossFightCollisions(boss, player);

        camera.setToOrtho(false, 256, 144);
        camera.update();
    }


    public void update(float deltatime){

        time += (deltatime*1000);

        camera.update();
        player.checkActions(deltatime);
        boss.doActions(deltatime);

        //Check collisions
        collisionManager.checkCollisions(deltatime, null);

        if(player.getHealth() <= 0){
            gsm.setGameState(GameStateManager.GAMEOVERMENU);
        }

        if(boss.getHealth() <= 0){
            boss.died();
        }

        if(boss.getDead()){
            gsm.setGameState(GameStateManager.LEVELSELECT);
        }

        handleInput();
    }

    public void draw(){
        mapManager.render(camera,hudCamera);

        //Render Player and Boss
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.draw(batch);
        boss.draw(batch);
        batch.end();

        //Render HUD
        batch.setProjectionMatrix(hudCamera.combined);
        batch.begin();
        gameHUD.render(batch);
        batch.end();
    }
    public void handleInput(){

        if ((Gdx.input.isKeyJustPressed(Input.Keys.D)) || (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))) {
            player.moveRight();
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.A)) || (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))) {
            player.moveLeft();
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.W)) || (Gdx.input.isKeyJustPressed(Input.Keys.UP))) {
            player.jump();
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.S)) || (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))) {
            player.duck();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if ((0 <= (time % msPerBeat) && (150 >= (time % msPerBeat))) || (((msPerBeat - 150) <= (time % msPerBeat)) && (msPerBeat >= (time % msPerBeat)))) {
                player.attack(boss);
            }
            else {
                player.gotHit();
            }
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            music.pause();
            gsm.pause();
        }

    }
    public void dispose(){
        player.dispose();
        boss.dispose();
        mapManager.dispose();
        music.dispose();
        gameHUD.dispose();
    }
}


