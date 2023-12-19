package com.lunarcanvas.meowmixer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.lunarcanvas.meowmixer.MeowMixer;

public class LoadingScreen implements Screen {
    final MeowMixer game;

    Texture loadingTexture;


    public LoadingScreen(MeowMixer game) {
        this.game = game;

        loadingTexture = new Texture("Textures/loading.png");

        // Queue textures
        queueToAssetManager("Textures/", Texture.class);
        queueToAssetManager("Audio/", Sound.class);

    }


    private <T> void queueToAssetManager(String path, Class<T> assetType) {
        FileHandle[] files = Gdx.files.internal(path).list();

        for (FileHandle file : files) {
            // Only load folders that have an extension
            if (file.path().contains(".")) {
                System.out.println(file);
                game.assetManager.load(file.path(), assetType);
            }
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        game.assetManager.update();

        // Update and get asset manager's progress
        System.out.println("Updated assetmanager: " + game.assetManager.update());
        System.out.println("Asset count: " + game.assetManager.getLoadedAssets());
        System.out.println("Progress: " + game.assetManager.getProgress());


        // If all the assets are loaded, go to the next screen
        if (game.assetManager.isFinished()) {
            loadingTexture.dispose();
            game.setScreen(new GameScreen(game));
        }


        // Draw loading image
        game.spriteBatch.begin();

        game.spriteBatch.draw(loadingTexture, (float)-loadingTexture.getWidth() / 2, (float)-loadingTexture.getHeight() / 2);

        game.spriteBatch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
