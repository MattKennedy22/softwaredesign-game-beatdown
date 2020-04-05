package com.juniordesign.beatdown.levels;

import java.util.ArrayList;

public class LevelOne extends Level {

    public LevelOne(){
        super();
    }

    protected void init(){
        this.difficulty = 1;
        this.levelMSpB = 631.3777403*2;
        this.bossStartTime = 308;
        this.levelMap = "StageLevel.tmx";
        this.levelMusic = "L2SideScroll.mp3";
        this.bossMusic = "L2BossBattle.mp3";
        this.levelEnemies = new ArrayList<>();
        this.endOfLevel = 16000;
        this.runSpeed = 175.73799999f;
        levelEnemies.add("MusicalUndertaker.png");
        levelEnemies.add("PriestTrumpet.png");
    }
}