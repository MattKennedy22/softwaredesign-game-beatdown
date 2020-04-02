package com.juniordesign.beatdown.levels;

import java.util.ArrayList;

public class LevelThree extends Level {

    public LevelThree(){
        super();
    }

    protected void init(){
        difficulty = 3;
        //this.levelBoss = "Smore-Sheet.png";
        this.levelMap = "HellMap.tmx";
        this.levelMusic = "HellMusic.mp3";
        this.bossMusic = "SmoreMusic.mp3";
        this.runSpeed = 266.795166f;//314.2f;//418.962656
        this.endOfLevel = 58500;
        this.levelEnemies = new ArrayList<>();
        levelEnemies.add("skeleboy.png");
    }
}
