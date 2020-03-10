package com.juniordesign.beatdown.gamestates;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.juniordesign.beatdown.BeatdownGame;
import com.juniordesign.beatdown.managers.CollisionManager;
import com.juniordesign.beatdown.managers.GameStateManager;
import com.juniordesign.beatdown.managers.MapManager;

public abstract class GameState {

    protected GameStateManager gsm;
    protected BeatdownGame game;

    protected SpriteBatch batch;
    protected OrthographicCamera camera;

    //protected TiledMap tiledMap;
    //protected TiledMapRenderer tiledMapRenderer;
    protected MapManager mapManager;
    protected CollisionManager collisionManager;

    protected GameState(GameStateManager gsm){
        this.gsm = gsm;
        game = gsm.getGame();
        batch = game.getBatch();
        camera = game.getCamera();
        //tiledMap = new TmxMapLoader().load(map);
        //tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        init();
    }

    public abstract void init();
    public abstract void update(float deltatime);
    public abstract void draw();
    public abstract void handleInput();
    public abstract void dispose();
}
