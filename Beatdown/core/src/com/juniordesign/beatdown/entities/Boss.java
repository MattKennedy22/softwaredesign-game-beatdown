package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Boss {
    private Rectangle frontHitbox;
    private Sprite DJboss;
    private Texture texture;
    private int health;

    // Constructor
    public Boss() {
        texture = new Texture("Marshmello.png");
        DJboss = new Sprite(texture, 0, 0, 96, 96);
        frontHitbox = new Rectangle(0, 0, 96, 96);
        this.setPosition(0,0);

        health = 25;

    }

    public Rectangle getFrontHitbox(){
        return frontHitbox;
    }

    public int getHealth() {
        return health;
    }

    public void setPosition(float x, float y) {
        DJboss.setPosition(x, y);
        frontHitbox.setPosition(x, y); //??
    }

    public void attack() {

    }

    public void gotHit(){
        health--;
    }
    public void draw(SpriteBatch batch) {
        DJboss.draw(batch);
    }

    public void dispose() {
        texture.dispose();
    }

}
