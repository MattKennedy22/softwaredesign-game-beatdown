package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hud {
    private Dewey player;
    private BitmapFont font;
    private String currentHealth;

    public Hud(Dewey player){
        this.player = player;
        font = new BitmapFont();
        font.getData().setScale(0.4f);
        currentHealth = String.valueOf(player.getHealth());
    }

    public void render(SpriteBatch batch){
        currentHealth = String.valueOf(player.getHealth());
        font.draw(batch, "Health: " + currentHealth, 15, 130);
    }

    public void dispose(){
        font.dispose();
    }
}
