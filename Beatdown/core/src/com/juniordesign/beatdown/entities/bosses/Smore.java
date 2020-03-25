package com.juniordesign.beatdown.entities.bosses;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.juniordesign.beatdown.entities.Projectile;

import java.util.ArrayList;

public class Smore extends Boss {

    private TextureRegion yellowIdleTexture, redIdleTexture, greenAttackTexture, yellowAttackTexture, redAttackTexture, deadTexture;
    private ArrayList<Projectile> projectiles;

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

        projectiles = new ArrayList<>();

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
            animationTime += deltatime;
            if(animationTime >= animationEnd){
                sprite.setRegion(initialTexture);
                currentState = State.IDLE;
                animationTime = 0;
            }
        }


    }
}
