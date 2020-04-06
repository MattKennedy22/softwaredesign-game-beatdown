package com.juniordesign.beatdown.levels;

import java.util.ArrayList;

public class LevelTwo extends Level{

    public LevelTwo(){
        super();
    }

    protected void init(){
        this.difficulty = 2;
        this.levelMSpB = 444.57617;
        this.bossStartTime = 222;
        this.levelMap = "RooftopTest.tmx";
        this.levelMusic = "cityMusic.mp3";
        this.bossMusic = "SmoreMusic.mp3";
        this.runSpeed = 175.73799999f;
        this.endOfLevel = 16000;
        this.startPosition = 64;
        this.levelEnemies = new ArrayList<>();
        levelEnemies.add("2notcello.png");
    }
}
