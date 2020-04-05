package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class DeweySideScroll extends Dewey{

    // Constructor
    public DeweySideScroll() {
        super();
    }

    protected void init(){
        texture = new Texture("GuitarDewey.png");
        idleTexture = new TextureRegion(texture,0,0,32,32);
        attackTexture = new TextureRegion(texture,96,0,32,32);

        sprite = new Sprite(idleTexture, 0, 0, 32, 32);
        this.setPosition(0,0);
    }

    public void run(float deltatime) {
        // Move player at certain pixels per second
        sprite.translateX(runSpeed*deltatime);
        frontHitbox.setPosition(sprite.getX()+32f,sprite.getY());
        normalHitbox.setPosition(sprite.getX(),sprite.getY()+8f);
    }

    public void attack(ArrayList<Enemy> enemies) {
        if(currentState == State.IDLE){
            sprite.setRegion(attackTexture);
            currentState = State.ATTACKING;
            for(int i = 0; i < enemies.size(); i++){
                Enemy enemy = enemies.get(i);
                if(enemy.getSprite().getBoundingRectangle().overlaps(frontHitbox)){
                    enemy.dispose();
                    enemies.remove(i);
                }
            }
        }
    }
}
