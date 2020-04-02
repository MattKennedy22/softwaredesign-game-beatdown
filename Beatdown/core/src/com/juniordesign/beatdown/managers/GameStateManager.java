package com.juniordesign.beatdown.managers;

import com.badlogic.gdx.Game;
import com.juniordesign.beatdown.BeatdownGame;
import com.juniordesign.beatdown.gamestates.*;
import com.juniordesign.beatdown.levels.Level;
import com.juniordesign.beatdown.levels.LevelOne;
import com.juniordesign.beatdown.levels.LevelTwo;

public class GameStateManager {

    // Current game state
    private GameState gameState;

    // Current Level
    private Level level;

    private BeatdownGame game;

    public static final int MENU = 0;
    public static final int LEVELSELECT = 1;
    public static final int SIDESCROLL = 2;
    public static final int BOSSFIGHT = 3;
    public static final int HELPMENU = 9;
    public static final int PAUSEMENU = 8;


    public GameStateManager(BeatdownGame game){
        this.game = game;
        // side scroll for test , should start at menu in final product
        setGameState(MENU); //!!!!!
    }

    public BeatdownGame getGame() {
        return game;
    }

    public Level getLevel(){
        return level;
    }

    public void setGameState(int state){
        if(gameState != null){
            gameState.dispose();
        }
        if(state == MENU) {
            gameState = new MenuState(this);
        }
        if(state == LEVELSELECT) {
            gameState = new LevelSelectState(this);
        }
        if(state == SIDESCROLL) {
            gameState = new SideScrollState(this);
        }
        if(state == BOSSFIGHT) {
            // switch to bossfight
            gameState = new BossFightState(this);
        }
        if(state == HELPMENU) {
            gameState = new HelpMenuState(this);
        }
        if(state == PAUSEMENU){
            gameState = new PauseState(this);
        }
    }

    public void setLevel(int levelNum){
        if(levelNum == 1){
            this.level = new LevelOne();
        }
        else if(levelNum == 2){
            this.level = new LevelTwo();
        }
        else if(levelNum == 3){
            //x = HellLever
            //level three
        }
    }

    public void update(float deltatime){
        gameState.update(deltatime);
    }

    public void draw() {
        gameState.draw();
    }

    public void dispose() {
        gameState.dispose();
    }
}
