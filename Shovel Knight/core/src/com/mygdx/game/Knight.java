package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Knight {

    public Animation<Texture> runRight;
    public Animation<Texture> runLeft;
    public SpriteBatch batch;
    public Texture standingRight,standingLeft;
    public float stateTime;

    public float xPos, yPos;
    public int health;
    public int damage;
    public int mana;
    public int gold;

    public Knight(float x, float y){
        xPos = x;
        yPos = y;
        health = 10;
        damage = 5;
        mana = 30;
        gold = 0;

        standingRight = new Texture("standingRight.png");
        standingLeft = new Texture("standingLeft.png");

        Texture[] runFrames = new Texture[5];
        int index = 0;
        for (int i = 0; i < 5; i++){
            Texture frame = new Texture("RIGHT/Right"+i+".png");
            runFrames[index++] = frame;
        }
        runRight = new Animation<Texture>(0.08f,runFrames);

        runFrames = new Texture[5];
        index = 0;
        for (int i = 0; i < 5; i++){
            Texture frame = new Texture("LEFT/Left"+i+".png");
            runFrames[index++] = frame;
        }
        runLeft = new Animation<Texture>(0.08f, runFrames);

        batch = new SpriteBatch();
        stateTime = 0f;
    }

    public float getXPos() {
        return xPos;
    }

    public float getYPos() {
        return yPos;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        health = h;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int m) {
        mana = m;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int g) {
        gold = g;
    }

}