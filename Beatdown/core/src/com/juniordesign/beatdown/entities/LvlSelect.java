package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class LvlSelect {

    private Sprite backgroundSprite;

    private Texture background;

    // Constructor
    public LvlSelect() {
        background = new Texture("LEVELSELECT.png");
        backgroundSprite = new Sprite(background, 0, 0, 256, 144); //1200 x 1008
        this.setPosition(0, 0);
    }

    public void setPosition(float x, float y) {
        backgroundSprite.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        backgroundSprite.draw(batch);
    }

    public void dispose() {
        background.dispose();
    }

}