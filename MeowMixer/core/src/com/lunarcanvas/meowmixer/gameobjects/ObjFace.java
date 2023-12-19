package com.lunarcanvas.meowmixer.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lunarcanvas.meowmixer.MeowMixer;
import com.lunarcanvas.meowmixer.engine.GameObject;

public class ObjFace extends GameObject {

    final MeowMixer game;

    float x;
    float y;

    int spriteWidth;
    int spriteHeight;

    Texture faceTex;
    Sprite faceSprite;

    int currentRegionX;

    public static final int NORMALREGION = 0;
    public static final int BUTTONREGION = 64;
    public static final int DPADREGION = 128;

    public ObjFace(MeowMixer game, float x, float y) {

        super(game);

        this.game = game;

        this.x = x;
        this.y = y;

        this.spriteWidth = 64;
        this.spriteHeight = 64;

        this.faceTex = game.assetManager.get("Textures/face.png", Texture.class);
        this.faceSprite = new Sprite(this.faceTex);

        this.currentRegionX = NORMALREGION;

    }


    public void drawSprite(SpriteBatch spriteBatch) {

        // Change region
        if (Gdx.input.isKeyPressed(Input.Keys.UP) ||
            Gdx.input.isKeyPressed(Input.Keys.DOWN) ||
            Gdx.input.isKeyPressed(Input.Keys.RIGHT) ||
            Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            currentRegionX = DPADREGION;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.Q) ||
                Gdx.input.isKeyPressed(Input.Keys.S)) {
            currentRegionX = BUTTONREGION;
        }
        else {
            currentRegionX = NORMALREGION;
        }

        // Set sprite properties
        this.faceSprite.setPosition(this.x, this.y);
        this.faceSprite.setSize(spriteWidth, spriteHeight);
        this.faceSprite.setRegion(currentRegionX, 0, spriteWidth, spriteHeight);

        // Draw the face
        this.faceSprite.draw(spriteBatch);

    }
}
