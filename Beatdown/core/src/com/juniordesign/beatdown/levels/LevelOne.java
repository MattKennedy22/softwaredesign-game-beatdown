package com.juniordesign.beatdown.levels;

import java.util.ArrayList;

public class LevelOne extends Level {

    public LevelOne(){
        super();
    }

    protected void init(){
        difficulty = 1;
        //this.levelBoss = "FinalStageBossSheet.png";
        this.levelMap = "StageLevel.tmx"; //temp
        this.levelMusic = "L2SideScroll.mp3";
        this.bossMusic = "L2BossBattle.mp3";
        this.levelEnemies = new ArrayList<>();
        this.endOfLevel = 16000;
        this.runSpeed = 175.73799999f;
        levelEnemies.add("MusicalUndertaker.png");
        levelEnemies.add("PriestTrumpet.png");
    }
}