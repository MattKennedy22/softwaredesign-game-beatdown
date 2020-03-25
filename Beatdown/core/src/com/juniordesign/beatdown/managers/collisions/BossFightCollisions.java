package com.juniordesign.beatdown.managers.collisions;

import com.juniordesign.beatdown.entities.DeweyBossFight;
import com.juniordesign.beatdown.entities.Enemy;
import com.juniordesign.beatdown.entities.Projectile;
import com.juniordesign.beatdown.entities.bosses.Boss;

import java.util.ArrayList;

public class BossFightCollisions implements CollisionManager {
    Boss boss;
    DeweyBossFight player;

    public BossFightCollisions(Boss boss, DeweyBossFight player){
        this.boss = boss;
        this.player = player;
    }


    @Override
    public void checkCollisions(float deltatime, ArrayList<Enemy> enemies) {
        ArrayList<Projectile> projectiles = boss.getProjectiles();
        for(Projectile projectile : projectiles){
            if(projectile.getSprite().getBoundingRectangle().overlaps(player.getNormalHitbox())){
                player.gotHit();
            }
        }
    }
}
