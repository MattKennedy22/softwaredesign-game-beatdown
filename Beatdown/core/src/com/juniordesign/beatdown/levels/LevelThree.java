package com.juniordesign.beatdown.levels;

import java.util.ArrayList;

public class LevelThree extends Level {

    public LevelThree(){
        super();
    }

    protected void init(){
        this.levelBoss = "Smore-Sheet.png";
        this.levelMap = "HellMap.tmx";
        this.levelMusic = "HellMusic.mp3";
        this.bossMusic = "SmoreMusic.mp3";
        this.runSpeed = 319.2f;
        this.levelEnemies = new ArrayList<>();
        levelEnemies.add("skeleboy.png");
    }
}
