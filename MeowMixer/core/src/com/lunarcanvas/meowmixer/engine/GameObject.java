package com.lunarcanvas.meowmixer.engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.lunarcanvas.meowmixer.MeowMixer;

public class GameObject {

    final MeowMixer game;

    public boolean queuedDestroy;


    public GameObject(MeowMixer game) {this.game = game;}


    public void update(float delta) {}

    public void drawSprite(SpriteBatch spriteBatch) {}

    public void drawShapeLined(ShapeRenderer shapeRenderer) {}

    public void drawShapeFilled(ShapeRenderer shapeRenderer) {}

    public void destroy() {queuedDestroy = true;}
}
