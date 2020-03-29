package com.juniordesign.beatdown.levels;

import java.util.ArrayList;

public class LevelOne extends Level {

    public LevelOne(){
        super();
    }

    protected void init(){
        this.levelBoss = "Smore-Sheet.png"; //place holder
        this.levelMap = "RooftopTest.tmx"; //temp
        this.levelMusic = "L2SideScroll.mp3";
        this.bossMusic = "L2BossFight.mp3";
        this.levelEnemies = new ArrayList<>();
        levelEnemies.add("MusicalUndertaker.png");
        levelEnemies.add("PriestTrumpet.png");
    }
}
