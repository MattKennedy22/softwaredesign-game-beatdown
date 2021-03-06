package com.juniordesign.beatdown;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.juniordesign.beatdown.managers.GameStateManager;

public class BeatdownGame extends ApplicationAdapter {

	public static final String title = "Beatdown";
	public static final int v_width = 256;
	public static final int v_height = 144;
	public static final int scale = 4;

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private OrthographicCamera hudCamera;

	private GameStateManager gsm;


	// Getters
	public SpriteBatch getBatch(){
		return this.batch;
	}
	public OrthographicCamera getCamera(){
		return this.camera;
	}
	public OrthographicCamera getHudCamera(){
		return this.hudCamera;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		//Set up cameras
		camera = new OrthographicCamera(v_width, v_height);
		camera.setToOrtho(false, v_width, v_height);
		camera.update();
		hudCamera = new OrthographicCamera(v_width,v_height);
		hudCamera.setToOrtho(false,v_width,v_height);
		hudCamera.update();


		gsm = new GameStateManager(this);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Updates the game while taking into account when the last time render was called
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gsm.dispose();
	}

}
