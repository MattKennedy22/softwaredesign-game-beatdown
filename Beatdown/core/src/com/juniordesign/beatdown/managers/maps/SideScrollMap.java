package com.juniordesign.beatdown.managers.maps;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.juniordesign.beatdown.entities.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class SideScrollMap extends MapManager {

    public SideScrollMap(String mapName){
        super(mapName);
    }

    public MapLayer getCollideLayer(){
        return collideLayer;
    }

    public MapLayer getSpawnLayer(){
        return spawnLayer;
    }

    public void spawnEnemies(ArrayList<Enemy> enemies, ArrayList<String> enemyFileNames){
        MapObjects objects = spawnLayer.getObjects();
        for(RectangleMapObject spawnPoint : objects.getByType(RectangleMapObject.class)) {
            Rectangle rectangle = spawnPoint.getRectangle();
            int rand = new Random().nextInt(enemyFileNames.size());
            //rand = rand % enemyFileNames.size();//MIGHT NOT NEED THIS
            Enemy enemy = new Enemy(enemyFileNames.get(rand));
            enemy.setPosition(rectangle.getX() + rectangle.getWidth()/2, rectangle.getY() + rectangle.getHeight()/2);
            enemies.add(enemy);
        }
    }

}
