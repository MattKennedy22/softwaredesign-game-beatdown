package com.juniordesign.beatdown.entities.bosses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.juniordesign.beatdown.entities.Projectile;

import java.util.ArrayList;

public class Smore extends Boss {

    private TextureRegion yellowIdleTexture, redIdleTexture, greenAttackTexture, yellowAttackTexture, redAttackTexture, deadTexture;
    private Texture projectilesTexture;

    public Smore(){
        super("Smore-Sheet.png");
        this.init();
    }

    private void init(){
        yellowIdleTexture = new TextureRegion(texture, 96, 0, 96, 96);
        redIdleTexture = new TextureRegion(texture, 192, 0, 96, 96);
        greenAttackTexture = new TextureRegion(texture, 288, 0, 96, 96);
        yellowAttackTexture = new TextureRegion(texture, 384, 0, 96, 96);
        redAttackTexture = new TextureRegion(texture, 480, 0, 96, 96);
        deadTexture = new TextureRegion(texture, 576, 0, 96, 96);

        projectilesTexture = new Texture("smore projectiles.png");

        projectiles = new ArrayList<>();

        health = 60;
        animationEnd = 7.5f;
        animationTime = 0;
    }


    public void doActions(float deltatime){
        if(currentState == State.IDLE){
            animationTime += deltatime;
            if(animationTime >= animationEnd){
                sprite.setRegion(greenAttackTexture);
                currentState = State.ATTACKING;
                animationTime = 0;
            }
        }

        if(currentState == State.ATTACKING){
            if (health > 40) {
                this.firstAttack(deltatime);
            }

            animationTime += deltatime;

            if(animationTime >= animationEnd){
                sprite.setRegion(initialTexture);
                currentState = State.IDLE;
                animationTime = 0;
            }
        }

    }

    public void firstAttack(float deltatime){
        if(animationTime == 0) {
            TextureRegion record = new TextureRegion(projectilesTexture, 64, 0, 32, 32);
            for (int i = 0; i < 5; i++) {
                Projectile projec = new Projectile(record);
                projec.setPosition(300 + (i * 200), 32);
                projectiles.add(projec);
            }
        }
        else {
            for(Projectile projectile : projectiles){
                projectile.translateX(-(deltatime*190)); // MAKE THIS THE SAME AS RUNSPEED
            }
        }

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
