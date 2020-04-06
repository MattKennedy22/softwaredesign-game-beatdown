package com.juniordesign.beatdown.levels;

import java.util.ArrayList;

public class LevelThree extends Level {

    public LevelThree(){
        super();
    }

    protected void init(){
        this.difficulty = 3;
        this.levelMSpB = 300;
        this.bossStartTime = 0;
        this.levelMap = "HellMap.tmx";
        this.levelMusic = "HellMusic.mp3";
        this.bossMusic = "DevilMusic.mp3";
        this.runSpeed = 266.580166f;
        this.endOfLevel = 58500;
        this.startPosition = 70;
        this.levelEnemies = new ArrayList<>();
        levelEnemies.add("skeleboy.png");
    }
}
