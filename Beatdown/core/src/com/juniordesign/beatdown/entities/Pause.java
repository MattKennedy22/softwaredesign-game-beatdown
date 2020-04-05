package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Pause {

    private Sprite PauseSprite;

    private Texture PauseTexture;

    // Constructor
    public Pause() {

        PauseTexture = new Texture("PauseMenu.png");
        PauseSprite = new Sprite(PauseTexture, 0, 0, 256, 144); //1200 x 1008
        this.setPosition(0, 0);

    }

    public void setPosition(float x, float y) {

        PauseSprite.setPosition(x, y);

    }

    public void draw(SpriteBatch batch) {

        PauseSprite.draw(batch);

    }

    public void dispose() {

        PauseTexture.dispose();

    }

}