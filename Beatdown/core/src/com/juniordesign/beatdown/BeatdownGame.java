package com.juniordesign.beatdown;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.juniordesign.beatdown.entities.Dewey;
import com.juniordesign.beatdown.managers.GameStateManager;

public class BeatdownGame extends ApplicationAdapter {

	public static final String title = "Beatdown";
	public static final int v_width = 256; //256
	public static final int v_height = 144;//144
	public static final int scale = 4;

	private SpriteBatch batch;
	private OrthographicCamera camera;

	private GameStateManager gsm;

	private TiledMap tiledMap;
	private TiledMapRenderer tiledMapRenderer;


	//private Dewey player;

	// Getters
	public SpriteBatch getBatch(){
		return this.batch;
	}
	public OrthographicCamera getCamera(){
		return this.camera;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//background = new Texture("NesoFhH.png");

		camera = new OrthographicCamera(v_width, v_height);
		camera.setToOrtho(false, v_width, v_height);
		camera.update();

		gsm = new GameStateManager(this);

		//tiledMap = new TmxMapLoader().load("test1.tmx"); //GABE CHANGED THIS FROM test1.tmx
		//tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		//player = new Dewey();
		//player.setPosition(64, 32);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//batch.begin();
		//batch.draw(background,0,0);
		//batch.end();
		//tiledMapRenderer.setView(camera);
		//tiledMapRenderer.render();
		// Updates the game while taking into account when the last time render was called

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
		//batch.setProjectionMatrix(camera.combined);
		//batch.begin();
		//player.draw(batch);
		//batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gsm.dispose();
		//tiledMap.dispose();
		//player.dispose();
		//background.dispose();
	}

}
