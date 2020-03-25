package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DeweyBossFight extends Dewey{

    public DeweyBossFight(){
        super();
    }
    protected void init(){
        texture = new Texture("GuitarDewey.png");
        idleTexture = new TextureRegion(texture,0,0,32,32);
        attackTexture = new TextureRegion(texture,96,0,32,32);

        sprite = new Sprite(idleTexture, 0, 0, 32, 32);
        this.setPosition(0,0);
    }

    public void moveRight() {
        if(sprite.getX() != 128) {
            sprite.translateX(32);
        }
    }

    public void moveLeft() {
        if(sprite.getX() != 0) {
            sprite.translateX(-32);
        }
    }
}
