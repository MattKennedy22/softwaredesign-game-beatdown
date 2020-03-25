package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class DeweySideScroll extends Dewey{
    //private Rectangle frontHitbox;
    //private Rectangle normalHitbox;
    /*private Sprite sprite;
    private Texture texture;
    private TextureRegion idleTexture,attackTexture;
    private int health;
    private float runSpeed;
    private float animationTimeEnd;
    private float animationTime;
    private enum State {JUMPING,DUCKING,ATTACKING,IDLE,GETTINGHIT}
    private State currentState;*/

    // Constructor
    public DeweySideScroll() {
        /*texture = new Texture("GuitarDewey.png");
        idleTexture = new TextureRegion(texture,0,0,32,32);
        attackTexture = new TextureRegion(texture,96,0,32,32);

        sprite = new Sprite(idleTexture, 0, 0, 32, 32);
        normalHitbox = new Rectangle(0,0, 16, 16);
        frontHitbox = new Rectangle(0, 0, 32, 32);
        this.setPosition(0,0);

        runSpeed = 175.73799999f; //pixels per second
        health = 5;
        currentState = State.IDLE;
        animationTimeEnd = 64f / runSpeed;
        animationTime = 0;*/
        super();

    }

    protected void init(){
        texture = new Texture("GuitarDewey.png");
        idleTexture = new TextureRegion(texture,0,0,32,32);
        attackTexture = new TextureRegion(texture,96,0,32,32);

        sprite = new Sprite(idleTexture, 0, 0, 32, 32);
        this.setPosition(0,0);
    }

    /*public float getPositionX(){
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

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        frontHitbox.setPosition(x+32, y);
        normalHitbox.setPosition(x+8,y+8);
    }


    public void moveRight() {
        if(sprite.getX() != 128) {
            sprite.translateX(32);
        }
    }

    public void moveLeft() {
        if(sprite.getX() != 0) {
            sprite.translateX(-32);
        }
    }*/

    public void run(float deltatime) {
        // Move player 192 pixels per second
        sprite.translateX(runSpeed*deltatime);
        frontHitbox.setPosition(sprite.getX()+32f,sprite.getY());
        normalHitbox.setPosition(sprite.getX(),sprite.getY()+8f);
    }

    public void attack(ArrayList<Enemy> enemies) {
        if(currentState == State.IDLE){
            currentState = State.ATTACKING;
            for(int i = 0; i < enemies.size(); i++){
                Enemy enemy = enemies.get(i);
                if(enemy.getSprite().getBoundingRectangle().overlaps(frontHitbox)){
                    enemy.dispose();
                    enemies.remove(i);
                }
            }
        }
    }

    /*public void jump() {
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
            //PLACEHOLDER
            //this.setPosition(sprite.getX(), 16);
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
            sprite.setRegion(attackTexture);
            if (animationTime >= animationTimeEnd){
                currentState = State.IDLE;
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
            animationTime = 0;
            health--;
            currentState = State.GETTINGHIT;
        }
    }
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void dispose() {
        texture.dispose();
    }*/

}
