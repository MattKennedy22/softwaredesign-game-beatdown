package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Dewey {
    Rectangle bottom, left, right, top;
    private Sprite sprite;
    private Texture texture;

    // Constructor
    public Dewey() {
        texture = new Texture("GuitarDewey.png");
        sprite = new Sprite(texture, 0, 0, 32, 32);
        this.setPosition(0,0);

    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    public void moveRight() {
        sprite.translateX(32);
    }

    public void moveLeft() {
        sprite.translateX(-32);
    }

    public void run() {
        sprite.translateX(4);
    }

    public void attack() {

    }
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void dispose() {
        texture.dispose();
    }

}
