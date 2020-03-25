package com.juniordesign.beatdown.managers.collisions;

import com.juniordesign.beatdown.entities.Enemy;

import java.util.ArrayList;


public interface CollisionManager {

    void checkCollisions(float deltatime, ArrayList<Enemy> enemies);

}
