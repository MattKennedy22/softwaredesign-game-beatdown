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
          boss = new Devil();
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
            player.attack(boss);
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

