package com.juniordesign.beatdown.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.juniordesign.beatdown.entities.Dewey;

import java.awt.*;

//MAKE THIS COLLISIONMANAGER FOR SIDESCROLL EXTEND ABSTRACT
public class CollisionManager {
    private MapLayer collideLayer;
    private Dewey player;
    private float timeSinceCollision;

    public CollisionManager(MapLayer collideLayer, Dewey player){
        this.collideLayer = collideLayer;
        this.player = player;
        timeSinceCollision = 0;
    }

    public void checkCollisions(float deltatime){
        MapObjects objects = collideLayer.getObjects();
        boolean isColliding = false;
        for(RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)){
            Rectangle rectangle = rectangleObject.getRectangle();

            if(rectangle.overlaps(player.getFrontHitbox())){
                //COLLISION
                isColliding = true;
                if(timeSinceCollision == 0f) {
                    player.gotHit();
                }
                else{
                    //MAYBE CANCEL THE COLLISION
                }
                timeSinceCollision += deltatime;
            }
        }
        if(!isColliding){
            timeSinceCollision = 0;
        }
    }

}
