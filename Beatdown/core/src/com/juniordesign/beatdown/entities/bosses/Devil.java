package com.juniordesign.beatdown.entities.bosses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.juniordesign.beatdown.entities.Projectile;

import java.util.ArrayList;

public class Devil extends Boss {

    public Devil(){
        super("Devil.png");
        this.init();
    }

    @Override
    public void doActions(float deltatime) {

    }

    @Override
    protected void init(){
        projectilesTexture = new Texture("devilProjectiles.png");

        projectiles = new ArrayList<>();

        health = 66666666;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
        for(Projectile projectile : projectiles){
            projectile.draw(batch);
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
        projectilesTexture.dispose();

    }


}
