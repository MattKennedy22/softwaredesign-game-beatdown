package com.juniordesign.beatdown.managers.maps;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.juniordesign.beatdown.entities.Enemy;

import java.util.ArrayList;

public class BossFightMap extends MapManager {

    public BossFightMap(String mapName){
        super(mapName);
    }

    public MapLayer getCollideLayer(){
        return collideLayer;
    }

    @Override
    public void spawnEnemies(ArrayList<Enemy> enemies, ArrayList<String> enemyFileNames) {
        //DO NOTHING
    }
}
