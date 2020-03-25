package com.juniordesign.beatdown.levels;

import java.util.ArrayList;

public class LevelTwo extends Level{

    public LevelTwo(){
        super();
    }

    protected void init(){
        this.levelBoss = "Smore-Sheet.png";
        this.levelMap = "RooftopTest.tmx";
        this.levelMusic = "cityMusic.mp3";
        this.bossMusic = "SmoreMusic.mp3";
        this.levelEnemies = new ArrayList<>();
        levelEnemies.add("2notcello.png");
    }
}
