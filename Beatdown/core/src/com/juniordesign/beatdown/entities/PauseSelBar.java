package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class PauseSelBar {

    private Sprite BlackSelectBarSprite;

    private Texture BlackSelectBar;

    // Constructor
    public PauseSelBar() {
        BlackSelectBar = new Texture("BlackSelectBar.png");
        BlackSelectBarSprite = new Sprite(BlackSelectBar,0,0,127,4);
        this.setPosition(0,0);
    }

    public void setPosition(float x, float y) {
        BlackSelectBarSprite.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        BlackSelectBarSprite.draw(batch);
    }

    public void dispose() {
        BlackSelectBar.dispose();
    }

}