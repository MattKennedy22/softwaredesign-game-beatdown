package com.juniordesign.beatdown.managers.collisions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.entities.Enemy;

import java.awt.*;
import java.util.ArrayList;


public interface CollisionManager {

    void checkCollisions(float deltatime, ArrayList<Enemy> enemies);

}
