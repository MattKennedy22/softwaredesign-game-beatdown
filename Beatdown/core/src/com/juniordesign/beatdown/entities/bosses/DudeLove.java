package com.juniordesign.beatdown.entities.bosses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.juniordesign.beatdown.entities.Projectile;

import java.util.ArrayList;
import java.util.Random;

public class DudeLove extends Boss {

    private TextureRegion FullHealthAttack, HalfHealthIdle, HalfHealthAttack, LowHealthIdle, LowHealthAttack, DeadDudeLove;

    public DudeLove (){
        super("FinalStageBossSheet.png");
        this.init();
    }

    protected void init(){
        FullHealthAttack = new TextureRegion(texture, 96, 0, 96, 96); //Determine X's
        HalfHealthIdle = new TextureRegion(texture, 192, 0, 96, 96);
        HalfHealthAttack = new TextureRegion(texture, 288, 0, 96, 96);
        LowHealthIdle = new TextureRegion(texture, 384, 0, 96, 96);
        LowHealthAttack = new TextureRegion(texture, 480, 0, 96, 96);
        DeadDudeLove = new TextureRegion(texture, 576, 0, 96, 96);

        projectilesTexture = new Texture("StageObstacleSheet.png");

        projectiles = new ArrayList<>();

        health = 60;
        animationEnd = 7.5f;
        animationTime = 0;
    }


    public void doActions(float deltatime){
        if(currentState == State.IDLE){
            animationTime += deltatime;
            if(health > 45) {
                sprite.setRegion(initialTexture);
            }
            else if (health > 30) {
                sprite.setRegion(HalfHealthIdle);
            }
            else{
                sprite.setRegion(LowHealthIdle);
            }
            if(animationTime >= animationEnd){
                currentState = State.ATTACKING;
                animationTime = 0;
            }
        }

        else if(currentState == State.ATTACKING){
            if (health > 45) {
                sprite.setRegion(FullHealthAttack);
                this.firstAttack(deltatime);
            } else if (health > 30) {
                sprite.setRegion(HalfHealthAttack);
                this.secondAttack(deltatime);
            }
            else {
                sprite.setRegion(LowHealthAttack);
                this.finalAttack(deltatime);
            }

            animationTime += deltatime;

            if(animationTime >= animationEnd){
                currentState = State.IDLE;
                animationTime = 0;

            }
        }
        else if (currentState == State.DEAD){
            sprite.setRegion(DeadDudeLove);
            animationTime += deltatime;
            if(animationTime >= animationEnd){
                this.dead = true;
            }
        }

    }

    public void firstAttack(float deltatime){
        if(animationTime == 0) {
            //check if these coordinates are right
            TextureRegion letterP = new TextureRegion(projectilesTexture, 0, 0, 16, 16);
            TextureRegion letterE = new TextureRegion(projectilesTexture, 16, 0, 16, 16);
            TextureRegion letterA = new TextureRegion(projectilesTexture, 32, 0, 16, 16);
            TextureRegion letterC = new TextureRegion(projectilesTexture, 48, 0, 16, 16);
            TextureRegion letterEe = new TextureRegion(projectilesTexture, 64, 0, 16, 16);
            for (int i = 0; i < 5; i++) {
                Projectile letter_P = new Projectile(letterP, 16, 16);
                Projectile letter_E = new Projectile(letterE, 16, 16);
                Projectile letter_A = new Projectile(letterA, 16, 16);
                Projectile letter_C = new Projectile(letterC, 16, 16);
                Projectile letter_Ee = new Projectile(letterEe, 16, 16);
                if(i == 0){
                    letter_P.setPosition(300 + (i * 200), 48); //or 32
                    projectiles.add(letter_P);
                }
                else if(i == 1){
                    letter_E.setPosition(300 + (i * 200), 48); //or 32
                    projectiles.add(letter_E);
                }
                else if(i == 2){
                    letter_A.setPosition(300 + (i * 200), 48); //or 32
                    projectiles.add(letter_A);
                }
                else if(i == 3){
                    letter_C.setPosition(300 + (i * 200), 48); //or 32
                    projectiles.add(letter_C);
                }
                else if(i == 4){
                    letter_Ee.setPosition(300 + (i * 200), 48); //or 32
                    projectiles.add(letter_Ee);
                }

            }
        }
        else {
            for(Projectile projectile : projectiles){
                projectile.translateX(-(deltatime*300)); // MAKE THIS THE SAME AS RUNSPEED //from 190,210
            }
        }
    }

    public void secondAttack(float deltatime){
        if(animationTime == 0) {
            TextureRegion letterP = new TextureRegion(projectilesTexture, 0, 0, 16, 16);
            TextureRegion letterE = new TextureRegion(projectilesTexture, 16, 0, 16, 16);
            TextureRegion letterA = new TextureRegion(projectilesTexture, 32, 0, 16, 16);
            TextureRegion letterC = new TextureRegion(projectilesTexture, 48, 0, 16, 16);
            TextureRegion letterEe = new TextureRegion(projectilesTexture, 64, 0, 16, 16);
            for (int i = 0; i < 5; i++) {
                Projectile letter_P = new Projectile(letterP, 16, 16);
                Projectile letter_E = new Projectile(letterE, 16, 16);
                Projectile letter_A = new Projectile(letterA, 16, 16);
                Projectile letter_C = new Projectile(letterC, 16, 16);
                Projectile letter_Ee = new Projectile(letterEe, 16, 16);
                if(i == 0){
                    letter_P.setPosition(300 + (i * 200), 32); //or 32
                    projectiles.add(letter_P);
                }
                else if(i == 1){
                    letter_E.setPosition(300 + (i * 200), 32); //or 32
                    projectiles.add(letter_E);
                }
                else if(i == 2){
                    letter_A.setPosition(300 + (i * 200), 32); //or 32
                    projectiles.add(letter_A);
                }
                else if(i == 3){
                    letter_C.setPosition(300 + (i * 200), 32); //or 32
                    projectiles.add(letter_C);
                }
                else if(i == 4){
                    letter_Ee.setPosition(300 + (i * 200), 32); //or 32
                    projectiles.add(letter_Ee);
                }

            }
        }
        else {
            for(Projectile projectile : projectiles){
                projectile.translateX(-(deltatime*300)); // MAKE THIS THE SAME AS RUNSPEED
            }
        }
    }

    public void finalAttack(float deltatime){
        if(animationTime == 0) {
            TextureRegion Saxophone = new TextureRegion(projectilesTexture, 80,0,32,32);
            TextureRegion Piano = new TextureRegion(projectilesTexture,112,0,16,16);
            TextureRegion Harp = new TextureRegion(projectilesTexture,128,0,32,32);
            TextureRegion PeaceSymbol = new TextureRegion(projectilesTexture,160,0,16,16);

            for (int i = 0; i < 10; i++) {
                int randItem = new Random().nextInt(4);
                if(randItem == 0){
                    Projectile Sax = new Projectile(Saxophone,32,32);
                    Sax.setPosition(300 + (i * 200), 32); //or 32
                    projectiles.add(Sax);
                }
                else if (randItem == 1){
                    Projectile Keyboard = new Projectile(Piano,16,16);
                    Keyboard.setPosition(300 + (i * 200), 48); //or 32
                    projectiles.add(Keyboard);
                }
                else if(randItem == 2){
                    Projectile DudesHarp = new Projectile(Harp,32,32);
                    DudesHarp.setPosition(300 + (i * 200), 32); //or 32
                    projectiles.add(DudesHarp);
                }
                else if (randItem == 3){
                    Projectile Pce = new Projectile(PeaceSymbol,16,16);
                    Pce.setPosition(300 + (i * 200), 48); //or 32
                    projectiles.add(Pce);
                }

            }
        }
        //After all projectiles are spawned
        else{
            for(Projectile projectile : projectiles){
                projectile.translateX(-(deltatime*300));
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
