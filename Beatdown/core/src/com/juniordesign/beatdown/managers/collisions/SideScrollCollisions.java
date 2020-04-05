package com.juniordesign.beatdown.managers.collisions;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.juniordesign.beatdown.entities.DeweySideScroll;
import com.juniordesign.beatdown.entities.Enemy;

import java.util.ArrayList;

public class SideScrollCollisions implements CollisionManager{

    private MapObjects collisions;
    private DeweySideScroll player;
    private float timeSinceCollision;

    public SideScrollCollisions(MapLayer collideLayer, DeweySideScroll player){
        collisions = collideLayer.getObjects();
        this.player = player;
        timeSinceCollision = 0;
    }

    public void checkCollisions(float deltatime, ArrayList<Enemy> enemies){

        for(RectangleMapObject rectangleObject : collisions.getByType(RectangleMapObject.class)){
            Rectangle rectangle = rectangleObject.getRectangle();

            if(rectangle.overlaps(player.getNormalHitbox())){
                player.gotHit();
            }
        }
        for(Enemy enemy : enemies){
            if(enemy.getSprite().getBoundingRectangle().overlaps(player.getNormalHitbox())){
                player.gotHit();
            }
        }
    }
}
