package com.juniordesign.beatdown.entities.bosses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.juniordesign.beatdown.entities.Projectile;

import java.util.ArrayList;

public abstract class Boss {
    protected Rectangle hitbox;
    protected Sprite sprite;
    protected TextureRegion initialTexture;
    protected Texture texture;
    protected int health;
    protected enum State{IDLE,ATTACKING,DEAD};
    protected State currentState;
    protected float animationTime;
    protected float animationEnd;
    protected ArrayList<Projectile> projectiles;
    protected Texture projectilesTexture;
    protected boolean dead;

    // Constructor
    public Boss(String image) {
        texture = new Texture(image);
        initialTexture = new TextureRegion(texture,0, 0, 96, 96);
        sprite = new Sprite(initialTexture, 0, 0, 96, 96);
        hitbox = new Rectangle(0, 0, 96, 96);
        this.setPosition(160,32);

        currentState = State.IDLE;
        dead = false;

    }


    public abstract void doActions(float deltatime);

    protected abstract void init();

    public boolean getDead() {
        return dead;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getHealth() {
        return health;
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        hitbox.setPosition(x, y);
    }


    public void gotHit(){
        health--;
    }

    public void died(){
        if(currentState != State.DEAD) {
            currentState = State.DEAD;
            animationTime = 0;
            projectilesTexture.dispose();
            projectiles.clear();
        }
    }

    abstract public void draw(SpriteBatch batch);

    abstract public void dispose();

}
