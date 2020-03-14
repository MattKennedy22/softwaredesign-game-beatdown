package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy {
    private Sprite sprite;
    private Texture texture;

    public Enemy(){
        texture = new Texture("2notcello.png");
        sprite = new Sprite(texture);

    }

    public Sprite getSprite(){
        return sprite;
    }

    public void setPosition(float x, float y){
        sprite.setPosition(x,y);
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    public void dispose(){
        texture.dispose();
    }

}
