package com.juniordesign.beatdown.managers.maps;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

//PROB MAKE THIS AN ABSTRACT AND DIFF CLASSES
public abstract class MapManager {

    private TiledMap tiledMap;
    protected OrthogonalTiledMapRenderer tiledMapRenderer;
    protected MapLayer collideLayer;
    protected TiledMapTileLayer obstacleLayer;
    protected int[] decorationLayersIndices;


    public MapManager(String mapName){
        tiledMap = new TmxMapLoader().load(mapName);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        MapLayers mapLayers = tiledMap.getLayers();
        obstacleLayer = (TiledMapTileLayer) mapLayers.get("Obstacles");
        collideLayer = mapLayers.get("ObstacleObjects");

        decorationLayersIndices = new int[] {
                mapLayers.getIndex("Background"),
                mapLayers.getIndex("Floor")
        };
    }

    public void render(OrthographicCamera camera){
        tiledMapRenderer.setView(camera);
        // First render background then floor
        tiledMapRenderer.render(decorationLayersIndices);

        // Render obstacle layer of map
        tiledMapRenderer.getBatch().begin();
        tiledMapRenderer.renderTileLayer(obstacleLayer);
        tiledMapRenderer.getBatch().end();
    }

    abstract public MapLayer getCollideLayer();

    public void dispose(){
        tiledMap.dispose();
    }
}
