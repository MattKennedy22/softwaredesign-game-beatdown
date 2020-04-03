package com.juniordesign.beatdown.entities.bosses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.juniordesign.beatdown.entities.Projectile;

import java.util.ArrayList;
import java.util.Random;

public class Devil extends Boss {

    private TextureRegion lavaWall, fireBall;
    private TextureRegion deadTexture;

    public Devil(){
        super("Devil-Sheet.png");
        this.init();
    }


    @Override
    protected void init(){
        projectilesTexture = new Texture("devilProjectiles.png");
        lavaWall = new TextureRegion(projectilesTexture,0,0,32,32);
        fireBall = new TextureRegion(projectilesTexture,32,0,32,32);

        deadTexture = new TextureRegion(texture,96,0,96,96);

        projectiles = new ArrayList<>();

        health = 66666666;
        animationEnd = 220f;
        animationTime = 0f;
    }

    @Override
    public void doActions(float deltatime) {
        //Unique attacks at different points in the song
        if(0 <= animationTime && animationTime < 21 || (144 <= animationTime && animationTime < 163)){
            wallAttack(deltatime);
            animationTime += deltatime;
            if (animationTime >= 21 && animationTime < 144){
                animationTime = 21;
            }
        }
        else if ((21 <= animationTime && animationTime < 144) || (163 <= animationTime && animationTime < 199)){
            crazyAttack(deltatime);
            animationTime += deltatime;
            if(animationTime >= 199){
                animationTime = 199;
            }
        }
        else if ((199 <= animationTime && animationTime < 218)){
            finalAttack(deltatime);
            animationTime += deltatime;
        }
        else if ((animationTime >= 218)){
            sprite.setRegion(deadTexture);
            if(animationTime > 220) {
                this.dead = true;
            }
            animationTime += deltatime;
        }

    }

    public void wallAttack(float deltatime){
        if(animationTime == 0){
            //Create projectiles
            for(int i = 0; i < 153; i++){
                if(i < 11 || (i >= 131 && i < 142)){
                    Projectile wall = new Projectile(lavaWall,32,32);
                    wall.setPosition(32,256 + (i*32));
                    projectiles.add(wall);
                }
                else if ((i >= 22 && i < 33) || (i >= 119 && i < 131)){
                    Projectile wall = new Projectile(lavaWall,32,32);
                    wall.setPosition(96,256 + (i*32));
                    projectiles.add(wall);
                }
                else if ((i >= 44 && i < 55) || (i >= 95 && i < 107)){
                    Projectile wall = new Projectile(lavaWall,32,32);
                    wall.setPosition(64,256 + (i*32));
                    projectiles.add(wall);
                }
                else if ((i >= 66 && i < 77) || (i >= 107 && i < 119) || (i >= 142)){
                    Projectile wall = new Projectile(lavaWall,32,32);
                    Projectile wall2 = new Projectile(lavaWall,32,32);
                    wall.setPosition(0,256 + (i*32));
                    wall2.setPosition(128,256 + (i*32));
                    projectiles.add(wall);
                    projectiles.add(wall2);
                }
                else if (i >= 77 && i < 88){
                    Projectile wall = new Projectile(lavaWall,32,32);
                    Projectile wall2 = new Projectile(lavaWall,32,32);
                    Projectile wall3 = new Projectile(lavaWall,32,32);
                    Projectile wall4 = new Projectile(lavaWall,32,32);
                    wall.setPosition(0,256 + (i*32));
                    wall2.setPosition(128,256 + (i*32));
                    wall3.setPosition(32,256 + (i*32));
                    wall4.setPosition(96,256 + (i*32));
                    projectiles.add(wall);
                    projectiles.add(wall2);
                    projectiles.add(wall3);
                    projectiles.add(wall4);
                }
            }
        }
        //After all projectiles are created
        else{
            for(Projectile projectile : projectiles){
                //Only move the lava wall projectiles
                if(projectile.getSprite().getWidth() == 32f)
                projectile.translateY(-(133.290083f * deltatime)); //Move at half the runspeed
            }
        }

    }

    public void crazyAttack(float deltatime){
        //First create all projectiles
        if(animationTime == 21){
            for(int i = 0; i < 593; i++){
                int randHeight = new Random().nextInt(2);

                if(i < 64){
                    Projectile ball = new Projectile(fireBall,16,24);
                    ball.setPosition(246 + (i*188.35f),32 + (randHeight*22));
                    projectiles.add(ball);
                }
                else if ((i > 75 && i < 203) || i > 207) {
                    Projectile ball = new Projectile(fireBall,16,24);
                    ball.setPosition(272 + (i * 160), 32 + (randHeight * 22));
                    projectiles.add(ball);
                }
            }
        }
        //Move Projectiles
        else{
            for(Projectile projectile : projectiles){
                //Only move the fireballs
                if(projectile.getSprite().getWidth() == 16f) {
                    projectile.translateX(-(266.580166f * deltatime)); //Move at the runspeed
                }
            }
        }

    }


    public void finalAttack(float deltatime){
        //Create fireballs to fall from the sky
        if(animationTime == 199){
            for(int i = 0; i < 38; i++){
                int randColumn = new Random().nextInt(5);
                Projectile ball = new Projectile(fireBall,32,32);
                ball.getSprite().rotate90(false);
                ball.setPosition(32*randColumn, 256 + (128*i));
                projectiles.add(ball);
            }
        }
        //Make the fireballs fall
        else{
            for(Projectile projectile : projectiles){
                projectile.translateY(-(266.580166f * deltatime));
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
        for(int i = 0; i < projectiles.size(); i++){
            Projectile projectile = projectiles.get(i);
            if(projectile.getX() < -64 || projectile.getY() < -64){
                projectiles.remove(i);
            }
            else {
                projectile.draw(batch);
            }
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
        projectilesTexture.dispose();

    }


}
