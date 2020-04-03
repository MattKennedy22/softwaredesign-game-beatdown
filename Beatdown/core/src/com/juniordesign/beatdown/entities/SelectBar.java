package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class SelectBar {

    private Sprite selectBarSprite;
    private Texture selectBar;

    // Constructor
    public SelectBar() {
        selectBar = new Texture("underline.png");
        selectBarSprite = new Sprite(selectBar, 0, 0, 36, 36);
        this.setPosition(0, 0);
    }

    public void setPosition(float x, float y) {
        selectBarSprite.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        selectBarSprite.draw(batch);
    }

    public void dispose() {
        selectBar.dispose();
    }

}