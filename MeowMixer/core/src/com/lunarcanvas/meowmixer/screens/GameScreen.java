package com.lunarcanvas.meowmixer.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.lunarcanvas.meowmixer.MeowMixer;
import com.lunarcanvas.meowmixer.engine.GameObject;
import com.lunarcanvas.meowmixer.gameobjects.ObjButton;
import com.lunarcanvas.meowmixer.gameobjects.ObjFace;

import java.util.ArrayList;
import java.util.Iterator;

public class GameScreen implements Screen {

    // Initialize variables/objects
    final MeowMixer game;

    ArrayList<GameObject> gameObjects;

    Texture backgroundTex;


    public GameScreen(MeowMixer game) {

        // Assign values/classes
        this.game = game;

        game.soundA = game.assetManager.get("Audio/buttonA.wav", Sound.class);
        game.soundB = game.assetManager.get("Audio/buttonB.wav", Sound.class);
        game.soundUp = game.assetManager.get("Audio/buttonUp.wav", Sound.class);
        game.soundDown = game.assetManager.get("Audio/buttonDown.wav", Sound.class);
        game.soundLeft = game.assetManager.get("Audio/buttonLeft.wav", Sound.class);
        game.soundRight = game.assetManager.get("Audio/buttonRight.wav", Sound.class);

        game.soundArray = new Sound[]{game.soundA, game.soundB, game.soundUp, game.soundDown, game.soundLeft, game.soundRight};

        // Create objects and add them to lists
        gameObjects = new ArrayList<GameObject>();
        ObjFace objFace = new ObjFace(game, -32, -42);
        ObjButton objButtonA = new ObjButton(game, 42, -28, "Textures/buttonA.png", Input.Keys.Q, game.soundA);
        ObjButton objButtonB = new ObjButton(game, 23, -42, "Textures/buttonB.png", Input.Keys.S, game.soundB);
        ObjButton objButtonRight = new ObjButton(game, -35, -30, "Textures/buttonRight.png", Input.Keys.RIGHT, game.soundRight);
        ObjButton objButtonDown = new ObjButton(game, -45, -46, "Textures/buttonDown.png", Input.Keys.DOWN, game.soundDown);
        ObjButton objButtonLeft = new ObjButton(game, -60, -35, "Textures/buttonLeft.png", Input.Keys.LEFT, game.soundLeft);
        ObjButton objButtonUp = new ObjButton(game, -52, -16, "Textures/buttonUp.png", Input.Keys.UP, game.soundUp);

        gameObjects.add(objFace);
        gameObjects.add(objButtonA);
        gameObjects.add(objButtonB);
        gameObjects.add(objButtonRight);
        gameObjects.add(objButtonDown);
        gameObjects.add(objButtonLeft);
        gameObjects.add(objButtonRight);
        gameObjects.add(objButtonUp);

        backgroundTex = game.assetManager.get("Textures/background.png", Texture.class);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        // Update entities
        for (Iterator<GameObject> iter = gameObjects.iterator(); iter.hasNext();) {
            GameObject gameObject = iter.next(); // Get current game object
            gameObject.update(delta); // Update game object
            if (gameObject.queuedDestroy) {iter.remove();} // Remove gameobject from list if requested
        }


        game.spriteBatch.begin();

        // Draw background
        game.spriteBatch.draw(
                backgroundTex,
                (float)-backgroundTex.getWidth() / 2,
                (float)-backgroundTex.getHeight() / 2
        );


        // Drawing sprites
        for (GameObject gameObject : gameObjects) {gameObject.drawSprite(game.spriteBatch);}

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
