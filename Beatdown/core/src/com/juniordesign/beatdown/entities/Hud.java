package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hud {
    private Dewey player;
    private BitmapFont healthFont,pauseFont,surviveFont;
    private String currentHealth;
    private int difficulty;

    public Hud(Dewey player){
        this.player = player;
        difficulty = 0;
        healthFont = new BitmapFont();
        pauseFont = new BitmapFont();
        healthFont.getData().setScale(0.4f);
        pauseFont.getData().setScale(0.4f);
        currentHealth = String.valueOf(player.getHealth());
    }

    public Hud(Dewey player, int difficulty){
        this.player = player;
        this.difficulty = difficulty;
        surviveFont = new BitmapFont();
        healthFont = new BitmapFont();
        pauseFont = new BitmapFont();
        surviveFont.getData().setScale(0.6f);
        healthFont.getData().setScale(0.4f);
        pauseFont.getData().setScale(0.4f);
        currentHealth = String.valueOf(player.getHealth());
    }

    public void render(SpriteBatch batch){
        currentHealth = String.valueOf(player.getHealth());
        healthFont.draw(batch, "Health: " + currentHealth, 15, 130);
        pauseFont.draw(batch, "Press ESC to pause", 200,130);
        if(difficulty == 3){
            surviveFont.draw(batch,"SURVIVE THE SONG",84,130);
        }
    }

    public void dispose(){
        healthFont.dispose();
    }
}
