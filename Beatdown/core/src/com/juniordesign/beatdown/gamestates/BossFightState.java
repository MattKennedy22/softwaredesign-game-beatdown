package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
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

public class BossFightState extends GameState {

    private DeweyBossFight player;
    private Boss boss;
    private Music music;
    private Level level;
    double BPMS;

    private double startTime = System.currentTimeMillis();

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
        player.setPosition(64, 32);

        if (level.getDifficulty() == 1) {
            boss = new DudeLove();
        }

        else if (level.getDifficulty() == 2) {
            boss = new Smore();
        }
        else if (level.getDifficulty() == 3){
          boss = new DudeLove(); //PLACE HOLDER
        }

        if(level.getBPMS() == 1262.9) {
            BPMS = 1262.9;
            //startTime = System.currentTimeMillis() + 631.45;

        }
        else if(level.getBPMS() == 444.4) {
            BPMS = 444.4;
           // startTime = System.currentTimeMillis();

        }

        else if(level.getBPMS() == 300.3) {
            BPMS = 300.3;
           // startTime = System.currentTimeMillis();
        }

        gameHUD = new Hud(player);
        player.setRunSpeed(level.getRunSpeed());
        player.setPosition(64,32);
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

        if(player.getHealth() <= 0){
            gsm.setGameState(GameStateManager.MENU);
        }

        if(boss.getHealth() <= 0){
            boss.died();
        }

        if(boss.getDead()){
            gsm.setGameState(GameStateManager.LEVELSELECT);
        }
    }
    public void draw(){
        //tiledMapRenderer.setView(camera);
        //tiledMapRenderer.render();
        mapManager.render(camera,hudCamera);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.draw(batch);
        boss.draw(batch);
        batch.end();
    }
    public void handleInput(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){

            gsm.setGameState(GameStateManager.PAUSEMENU);
        }
        if(level.getDifficulty() == 2 || level.getDifficulty() == 3) {
            if ((Gdx.input.isKeyJustPressed(Input.Keys.D)) || (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))) {
                //if (((0 <= ((System.currentTimeMillis() - startTime) % BPMS)) && (100 >= ((System.currentTimeMillis() - startTime) % BPMS))) || (((BPMS - 100) <= ((System.currentTimeMillis() - startTime) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - startTime) % BPMS)))) {
                    player.moveRight();
                //}
            }
            if ((Gdx.input.isKeyJustPressed(Input.Keys.A)) || (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))) {
                //if (((0 <= ((System.currentTimeMillis() - startTime) % BPMS)) && (100 >= ((System.currentTimeMillis() - startTime) % BPMS))) || (((BPMS - 100) <= ((System.currentTimeMillis() - startTime) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - startTime) % BPMS)))) {
                    player.moveLeft();
                //}
            }
            if ((Gdx.input.isKeyJustPressed(Input.Keys.W)) || (Gdx.input.isKeyJustPressed(Input.Keys.UP))) {
                //if (((0 <= ((System.currentTimeMillis() - startTime) % BPMS)) && (100 >= ((System.currentTimeMillis() - startTime) % BPMS))) || (((BPMS - 100) <= ((System.currentTimeMillis() - startTime) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - startTime) % BPMS)))) {
                    player.jump();
                //}
            }
            if ((Gdx.input.isKeyJustPressed(Input.Keys.S)) || (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))) {
                //if (((0 <= ((System.currentTimeMillis() - startTime) % BPMS)) && (100 >= ((System.currentTimeMillis() - startTime) % BPMS))) || (((BPMS - 100) <= ((System.currentTimeMillis() - startTime) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - startTime) % BPMS)))) {
                    player.duck();
                //}
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                if (((0 <= ((System.currentTimeMillis() - startTime) % BPMS)) && (200 >= ((System.currentTimeMillis() - startTime) % BPMS))) || (((BPMS - 200) <= ((System.currentTimeMillis() - startTime) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - startTime) % BPMS)))) {
                    player.attack(boss);
                }
                else
                {
                    player.gotHit();
                }
            }
        }
        else {
            if ((Gdx.input.isKeyJustPressed(Input.Keys.D)) || (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))) {
                //if (((0 <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (100 >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS))) || (((BPMS - 100) <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)))) {
                    player.moveRight();
                //}
            }
            if ((Gdx.input.isKeyJustPressed(Input.Keys.A)) || (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))) {
                //if (((0 <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (100 >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS))) || (((BPMS - 100) <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)))) {
                    player.moveLeft();
                //}
            }
            if ((Gdx.input.isKeyJustPressed(Input.Keys.W)) || (Gdx.input.isKeyJustPressed(Input.Keys.UP))) {
                //if (((0 <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (100 >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS))) || (((BPMS - 100) <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)))) {
                    player.jump();
                //}
            }
            if ((Gdx.input.isKeyJustPressed(Input.Keys.S)) || (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))) {
                //if (((0 <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (100 >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS))) || (((BPMS - 100) <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)))) {
                    player.duck();
                //}
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                if (((0 <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (200 >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS))) || (((BPMS - 200) <= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)) && (BPMS >= ((System.currentTimeMillis() - (startTime + 631.45)) % BPMS)))) {
                    player.attack(boss);
                }
                else{
                    player.gotHit();
                }
            }
        }


    }
    public void dispose(){
        player.dispose();
        boss.dispose();
        mapManager.dispose();
        music.dispose();
        gameHUD.dispose();
        //tiledMap.dispose();
    }
}

