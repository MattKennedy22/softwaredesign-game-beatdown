package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.juniordesign.beatdown.BeatdownGame;
import com.juniordesign.beatdown.managers.collisions.CollisionManager;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.maps.MapManager;

public abstract class GameState {

    protected GameStateManager gsm;
    protected BeatdownGame game;

    protected SpriteBatch batch;
    protected OrthographicCamera camera;

    //protected TiledMap tiledMap;
    //protected TiledMapRenderer tiledMapRenderer;
    protected MapManager mapManager;
    protected CollisionManager collisionManager;

    protected GameState(GameStateManager gsm, String mapName){
        this.gsm = gsm;
        game = gsm.getGame();
        batch = game.getBatch();
        camera = game.getCamera();

        init(mapName);
    }

    public abstract void init(String mapName);
    public abstract void update(float deltatime);
    public abstract void draw();
    public abstract void handleInput();
    public abstract void dispose();
}
