package com.juniordesign.beatdown.managers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

//PROB MAKE THIS AN ABSTRACT AND DIFF CLASSES
public class MapManager {

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private TiledMapTileLayer obstacleLayer;
    private int[] decorationLayersIndices;

    public MapManager(String mapName){
        tiledMap = new TmxMapLoader().load(mapName);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        MapLayers mapLayers = tiledMap.getLayers();
        obstacleLayer = (TiledMapTileLayer) mapLayers.get("Obstacles");

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


    public void dispose(){
        tiledMap.dispose();
    }
}
