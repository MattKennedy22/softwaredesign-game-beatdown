package com.juniordesign.beatdown.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.juniordesign.beatdown.entities.bosses.Boss;

public class DeweyBossFight extends Dewey{

    public DeweyBossFight(){
        super();
    }
    protected void init(){
        texture = new Texture("deweysmore-Sheet.png");
        idleTexture = new TextureRegion(texture,0,0,32,32);
        attackTexture = new TextureRegion(texture,256,0,256,32);

        sprite = new Sprite(idleTexture);
        this.setPosition(0,0);
    }

    public void moveRight() {
        if(sprite.getX() != 128) {
            this.setPosition(sprite.getX()+32, sprite.getY());
        }
    }

    public void moveLeft() {
        if(sprite.getX() != 0) {
            this.setPosition(sprite.getX()-32, sprite.getY());
        }
    }

    public void attack(Boss boss){
        if(currentState == State.IDLE){
            sprite.setSize(256,32);
            sprite.setRegion(attackTexture);
            currentState = State.ATTACKING;
            boss.gotHit();
        }

    }
}
