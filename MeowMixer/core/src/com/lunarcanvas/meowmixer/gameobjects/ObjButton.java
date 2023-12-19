package com.lunarcanvas.meowmixer.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lunarcanvas.meowmixer.MeowMixer;
import com.lunarcanvas.meowmixer.engine.GameObject;

public class ObjButton extends GameObject {

    final MeowMixer game;

    float x;
    float y;

    int spriteWidth;
    int spriteHeight;

    Texture buttonTex;
    Sprite buttonSprite;

    int currentRegionX;

    public static final int NORMALREGION = 0;
    public static final int PRESSEDREGION = 16;

    int keyCode;

    Sound sound;

    public ObjButton(MeowMixer game, float x, float y, String texturePath, int keyCode, Sound sound) {

        super(game);

        this.game = game;

        this.x = x;
        this.y = y;

        this.spriteWidth = 16;
        this.spriteHeight = 16;

        this.buttonTex = game.assetManager.get(texturePath, Texture.class);
        this.buttonSprite = new Sprite(this.buttonTex);

        this.currentRegionX = NORMALREGION;

        this.keyCode = keyCode;

        this.sound = sound;

    }


    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(keyCode)) {

            // Stop all existing audio
            for (Sound soundIndex : game.soundArray) {
                soundIndex.stop();
            }

            // Play sound
            sound.play();

        }
    }


    public void drawSprite(SpriteBatch spriteBatch) {

        // Change region
        if (Gdx.input.isKeyPressed(keyCode)) {currentRegionX = PRESSEDREGION;}
        if (!Gdx.input.isKeyPressed(keyCode)) {currentRegionX = NORMALREGION;}

        // Set sprite properties
        this.buttonSprite.setPosition(this.x, this.y);
        this.buttonSprite.setSize(spriteWidth, spriteHeight);
        this.buttonSprite.setRegion(currentRegionX, 0, spriteWidth, spriteHeight);

        // Draw the face
        this.buttonSprite.draw(spriteBatch);

    }
}