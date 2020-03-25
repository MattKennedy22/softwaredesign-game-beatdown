package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Projectile {
    private Sprite sprite;
    private Texture texture;

    public Projectile(String image){
        this.texture = new Texture(image);
        this.sprite = new Sprite(texture);
    }
}
