package com.lunarcanvas.meowmixer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lunarcanvas.meowmixer.screens.LoadingScreen;

public class MeowMixer extends Game {

	// Initialize variables/objects
	public SpriteBatch spriteBatch;

	public Camera camera;
	public Viewport viewport;


	public AssetManager assetManager;

	public Sound[] soundArray;

	public Sound soundA;
	public Sound soundB;
	public Sound soundUp;
	public Sound soundDown;
	public Sound soundLeft;
	public Sound soundRight;
	
	@Override
	public void create () {

		// Assign values/classes
		spriteBatch = new SpriteBatch();

		camera = new OrthographicCamera();
		viewport = new ExtendViewport(320, 180, camera);

		assetManager = new AssetManager();

		// Go to the loading screen
		setScreen(new LoadingScreen(this));

	}

	@Override
	public void render () {

		// Draw black clear screen
		ScreenUtils.clear(0, 0, 0, 1);

		// Always have spritebatch project from camera
		spriteBatch.setProjectionMatrix(camera.combined);

		// Render other screens
		super.render();

	}
	
	@Override
	public void dispose () {

	}

	@Override
	public void resize(int width, int height) {

		// Update the viewport's width and height
		viewport.update(width, height);
		viewport.apply();

	}

}
