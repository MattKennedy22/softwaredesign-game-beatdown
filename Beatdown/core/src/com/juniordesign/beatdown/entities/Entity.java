package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {

    protected Sprite sprite;
    protected Texture texture;

    public Entity(String image, int width, int height){
        texture = new Texture(image);
        sprite = new Sprite(texture,0,0,width,height);
        this.setPosition(0,0);
    }

    public void setPosition(float x, float y) {

        sprite.setPosition(x, y);

    }

    public void draw(SpriteBatch batch) {

        sprite.draw(batch);

    }

    public void dispose() {

        texture.dispose();

    }

}
