package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public abstract class Dewey {
    protected Rectangle frontHitbox;
    protected Rectangle normalHitbox;
    protected Sprite sprite;
    protected Texture texture;
    protected TextureRegion idleTexture,attackTexture;
    protected int health;
    protected float runSpeed;
    protected float animationTimeEnd;
    protected float animationTime;
    protected enum State {JUMPING,DUCKING,ATTACKING,IDLE,GETTINGHIT}
    protected State currentState;


    // Constructor
    public Dewey() {
        /*texture = new Texture("GuitarDewey.png");
        idleTexture = new TextureRegion(texture,0,0,32,32);
        attackTexture = new TextureRegion(texture,96,0,32,32);

        sprite = new Sprite(idleTexture, 0, 0, 32, 32);*/
        normalHitbox = new Rectangle(0,0, 16, 16);
        frontHitbox = new Rectangle(0, 0, 32, 32);
        //this.setPosition(0,0);

        currentState = State.IDLE;
        runSpeed = 1f; //pixels per second
        health = 100;

        animationTimeEnd = 64f / runSpeed;
        animationTime = 0;

        this.init();

    }

    abstract protected void init();

    public float getPositionX(){
        return sprite.getX();
    }

    public Rectangle getFrontHitbox(){
        return frontHitbox;
    }

    public Rectangle getNormalHitbox(){
        return normalHitbox;
    }

    public float getRunSpeed(){
        return runSpeed;
    }

    public int getHealth() {
        return health;
    }

    public float getAnimationTime(){
        return animationTime;
    }

    public void setRunSpeed(float speed){
        runSpeed = speed;
        animationTimeEnd = 64f / runSpeed;
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        frontHitbox.setPosition(x+32, y);
        normalHitbox.setPosition(x+8,y+8);
    }

    public void jump() {
        //do jump animation
        if(currentState == State.IDLE){
            currentState = State.JUMPING;
        }

    }

    public void duck(){
        //do duck animation
        if(currentState == State.IDLE){
            currentState = State.DUCKING;
        }
    }

    public void checkActions(float deltatime){
        if(currentState == State.JUMPING) {
            animationTime += deltatime;
            this.setPosition(sprite.getX(), 64);
            sprite.rotate(45);

            if (animationTime >= animationTimeEnd) {
                this.setPosition(sprite.getX(), 32);
                float rotation = sprite.getRotation();
                sprite.rotate(360f - rotation);
                currentState = State.IDLE;
                animationTime = 0;
            }
        }

        else if (currentState == State.DUCKING){
            animationTime += deltatime;
            sprite.setScale(1,0.5f);
            this.setPosition(sprite.getX(), 24);
            if(animationTime >= animationTimeEnd){
                currentState = State.IDLE;
                this.setPosition(sprite.getX(), 32);
                sprite.setScale(1,1);
                animationTime = 0;
            }
        }
        else if (currentState == State.ATTACKING){
            animationTime += deltatime;
            if (animationTime >= animationTimeEnd){
                currentState = State.IDLE;
                sprite.setSize(32,32);
                sprite.setRegion(idleTexture);
                animationTime = 0;
            }
        }
        else if (currentState == State.GETTINGHIT){
            animationTime += deltatime;
            float rotation = sprite.getRotation();
            sprite.rotate(360f - rotation);
            sprite.setScale(1,1);
            this.setPosition(sprite.getX(), 32);
            sprite.setRegion(idleTexture);
            sprite.setSize(32,32);
            sprite.setColor(Color.RED);
            if(animationTime >= animationTimeEnd){
                currentState = State.IDLE;
                sprite.setColor(Color.WHITE);
                animationTime = 0;
            }
        }
    }

    public void gotHit(){
        if(currentState != State.GETTINGHIT) {
            animationTime = 16f/runSpeed; // Fast recovery time
            health--;
            currentState = State.GETTINGHIT;
        }
    }
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void dispose() {
        texture.dispose();
    }
}
