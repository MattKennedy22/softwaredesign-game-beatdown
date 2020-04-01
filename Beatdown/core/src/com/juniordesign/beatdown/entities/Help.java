package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Help {
    Rectangle bottom, left, right, top;

    private Sprite HelpSprite;

    private Texture help;

    // Constructor
    public Help() {

        help = new Texture("BgdHELP.png");
        HelpSprite = new Sprite(help, 0, 0, 256, 144);
        this.setPosition(0, 0);
    }

    public void setPosition(float x, float y) {

        HelpSprite.setPosition(x, y);

    }

    public void draw(SpriteBatch batch) {

        HelpSprite.draw(batch);

    }

    public void dispose() {

        help.dispose();

    }

}