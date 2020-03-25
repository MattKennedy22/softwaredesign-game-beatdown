package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Projectile {
    private Sprite sprite;

    public Projectile(TextureRegion textureRegion){
        this.sprite = new Sprite(textureRegion);
    }

    public Sprite getSprite(){
        return sprite;
    }
    public void setPosition(float x, float y){
        sprite.setPosition(x,y);
    }

    public void translateX(float x){
        sprite.translateX(x);
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

}
