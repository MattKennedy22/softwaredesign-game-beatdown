package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Dewey {
    private Rectangle frontHitbox;
    private Rectangle normalHitbox;
    private Sprite sprite;
    private Texture texture;
    private int health;

    // Constructor
    public Dewey() {
        texture = new Texture("GuitarDewey.png");
        sprite = new Sprite(texture, 0, 0, 32, 32);
        normalHitbox = new Rectangle(0,0, 16, 16);
        frontHitbox = new Rectangle(0, 0, 32, 32);
        this.setPosition(0,0);

        health = 5;

    }

    public Rectangle getFrontHitbox(){
        return frontHitbox;
    }

    public Rectangle getNormalHitbox(){
        return normalHitbox;
    }

    public int getHealth() {
        return health;
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        frontHitbox.setPosition(x+32, y);
    }


    public void moveRight() {
        sprite.translateX(32);
    }

    public void moveLeft() {
        sprite.translateX(-32);
    }

    public void run(float deltatime) {
        // Move player 192 pixels per second
        sprite.translateX(192*deltatime);
        frontHitbox.setPosition(sprite.getX()+32f,sprite.getY());
        normalHitbox.setPosition(sprite.getX()+8f,sprite.getY()+8f);
    }

    public void attack() {

    }

    public void jump() {

    }

    public void gotHit(){
        health--;
    }
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void dispose() {
        texture.dispose();
    }

}
