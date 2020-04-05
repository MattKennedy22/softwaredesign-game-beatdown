package com.juniordesign.beatdown.levels;


import java.util.ArrayList;

public abstract class Level {

    protected String levelMap;
    protected String levelMusic;
    protected String bossMusic;
    protected float runSpeed;
    protected int endOfLevel;
    protected ArrayList<String> levelEnemies;

    protected int difficulty;
    protected double levelMSpB;
    protected double bossStartTime;


    public Level(){
        this.init();
    }

    abstract protected void init();

    public double getBossStartTime() {
        return bossStartTime;
    }

    public double getLevelMSpB(){
        return levelMSpB;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getBossMusic() {
        return bossMusic;
    }

    public String getLevelMap(){
        return levelMap;
    }

    public String getLevelMusic(){
        return levelMusic;
    }

    public float getRunSpeed() {
        return runSpeed;
    }

    public int getEndOfLevel(){
        return endOfLevel;
    }

    public ArrayList<String> getLevelEnemies() {return levelEnemies;}
}
