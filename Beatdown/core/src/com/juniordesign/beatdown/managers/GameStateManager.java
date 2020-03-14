package com.juniordesign.beatdown.managers;

import com.badlogic.gdx.Game;
import com.juniordesign.beatdown.BeatdownGame;
import com.juniordesign.beatdown.gamestates.BossFightState;
import com.juniordesign.beatdown.gamestates.GameState;
import com.juniordesign.beatdown.gamestates.MenuState;
import com.juniordesign.beatdown.gamestates.SideScrollState;

public class GameStateManager {

    // Current game state
    private GameState gameState;

    private BeatdownGame game;

    public static final int MENU = 0;
    public static final int LEVELSELECT = 1;
    public static final int SIDESCROLL = 2;
    public static final int BOSSFIGHT = 3;

    public GameStateManager(BeatdownGame game){
        this.game = game;
        // side scroll for test , should start at menu in final product
        setGameState(MENU);
    }

    public BeatdownGame getGame() {
        return game;
    }

    public void setGameState(int state){
        if(gameState != null){
            gameState.dispose();
        }
        if(state == MENU) {
            gameState = new MenuState(this, "null");
        }
        if(state == LEVELSELECT) {
            // switch to level select
        }
        if(state == SIDESCROLL) {
            gameState = new SideScrollState(this, "RooftopTest.tmx");
        }
        if(state == BOSSFIGHT) {
            // switch to bossfight
            gameState = new BossFightState(this, "RooftopTest.tmx");
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
