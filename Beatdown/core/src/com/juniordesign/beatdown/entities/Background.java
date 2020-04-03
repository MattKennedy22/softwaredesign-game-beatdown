package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

    private Sprite backgroundSprite;

    private Texture background;

    // Constructor
    public Background() {

        background = new Texture("Background.png");
        backgroundSprite = new Sprite(background, 0, 0, 256, 144);
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