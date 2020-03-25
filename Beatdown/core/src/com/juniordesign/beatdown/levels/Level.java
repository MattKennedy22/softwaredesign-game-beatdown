package com.juniordesign.beatdown.levels;


import java.util.ArrayList;

public abstract class Level {
    protected String levelBoss;
    protected String levelMap;
    protected String levelMusic;
    protected ArrayList<String> levelEnemies;

    public Level(){
        this.init();
    }

    abstract protected void init();

    public String getLevelBoss(){
        return levelBoss;
    }

    public String getLevelMap(){
        return levelMap;
    }

    public String getLevelMusic(){
        return levelMusic;
    }

    public ArrayList<String> getLevelEnemies() {return levelEnemies;}
}
