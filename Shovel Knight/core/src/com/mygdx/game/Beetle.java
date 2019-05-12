package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class Beetle {

    public Animation<Texture> walkLeft;
    public Animation<Texture> walkRight;
    public float stateTime;

    public float xPos;
    public float yPos;

    public int health;
    public int damage;

    public Beetle(float x, float y){
        xPos = x;
        yPos = y;
        health = 5;
        damage = 1;

        

        stateTime = 0f;
    }

    public float getXPos(){
        return xPos;
    }

    public float getYPos(){
        return yPos;
    }

}
