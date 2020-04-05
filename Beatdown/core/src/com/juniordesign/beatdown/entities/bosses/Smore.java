package com.juniordesign.beatdown.entities.bosses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.juniordesign.beatdown.entities.Projectile;

import java.util.ArrayList;
import java.util.Random;

public class Smore extends Boss {

    private TextureRegion yellowIdleTexture, redIdleTexture, greenAttackTexture, yellowAttackTexture, redAttackTexture, deadTexture;

    public Smore(){
        super("Smore-Sheet.png");
        this.init();
    }

    protected void init(){
        yellowIdleTexture = new TextureRegion(texture, 96, 0, 96, 96); //x at what point in the sheet
        redIdleTexture = new TextureRegion(texture, 192, 0, 96, 96);
        greenAttackTexture = new TextureRegion(texture, 288, 0, 96, 96);
        yellowAttackTexture = new TextureRegion(texture, 384, 0, 96, 96);
        redAttackTexture = new TextureRegion(texture, 480, 0, 96, 96);
        deadTexture = new TextureRegion(texture, 576, 0, 96, 96);

        projectilesTexture = new Texture("smore projectiles.png");

        projectiles = new ArrayList<>();

        health = 60*2;
        animationEnd = 7.5f;
        animationTime = 0;
    }


    public void doActions(float deltatime){
        if(currentState == State.IDLE){
            animationTime += deltatime;
            if(health > 40*2) {
                sprite.setRegion(initialTexture);
            }
            else if (health > 20*2) {
                sprite.setRegion(yellowIdleTexture);
            }
            else{
                sprite.setRegion(redIdleTexture);
            }
            if(animationTime >= animationEnd){
                currentState = State.ATTACKING;
                animationTime = 0;
            }
        }

        else if(currentState == State.ATTACKING){
            if (health > 40*2) {
                sprite.setRegion(greenAttackTexture);
                this.firstAttack(deltatime);
            } else if (health > 20*2) {
                sprite.setRegion(yellowAttackTexture);
                this.secondAttack(deltatime);
            }
            else {
                sprite.setRegion(redAttackTexture);
                this.finalAttack(deltatime);
            }

            animationTime += deltatime;

            if(animationTime >= animationEnd){
                currentState = State.IDLE;
                animationTime = 0;

            }
        }
        else if (currentState == State.DEAD){
            sprite.setRegion(deadTexture);
            animationTime += deltatime;
            if(animationTime >= animationEnd){
                this.dead = true;
            }
        }

    }

    public void firstAttack(float deltatime){
        if(animationTime == 0) {
            TextureRegion record = new TextureRegion(projectilesTexture, 64, 0, 32, 32);
            for (int i = 0; i < 8; i++) {
                Projectile projec = new Projectile(record, 20, 20);
                projec.setPosition(300 + (i * 200), 32);
                projectiles.add(projec);
            }
        }
        else {
            for(Projectile projectile : projectiles){
                projectile.translateX(-(deltatime*300));
            }
        }
    }

    public void secondAttack(float deltatime){
        if(animationTime == 0) {
            TextureRegion record = new TextureRegion(projectilesTexture, 96, 0, 32, 32);
            for (int i = 0; i < 8; i++) {
                Projectile projec = new Projectile(record,20,20);
                projec.setPosition(400 + (i * 200), 48);
                projectiles.add(projec);
            }
        }
        else {
            for(Projectile projectile : projectiles){
                projectile.translateX(-(deltatime*300));
            }
        }
    }

    public void finalAttack(float deltatime){
        if(animationTime == 0) {
            TextureRegion bassGuitar = new TextureRegion(projectilesTexture, 0,0,32,32);
            TextureRegion bassFish = new TextureRegion(projectilesTexture,32,0,32,32);
            for (int i = 0; i < 9; i++) {
                int randItem = new Random().nextInt(2);
                int randLocation = new Random().nextInt(5);
                if(randItem == 0){
                    Projectile guitar = new Projectile(bassGuitar,32,32);
                    guitar.setPosition(randLocation*32,176 + (i*128));
                    projectiles.add(guitar);
                }
                else{
                    Projectile fish = new Projectile(bassFish,32,32);
                    fish.setPosition(randLocation*32,176 + (i*128));
                    projectiles.add(fish);
                }

            }
        }
        //After all projectiles are spawned
        else{
            for(Projectile projectile : projectiles){
                projectile.translateY(-(deltatime*240));
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
