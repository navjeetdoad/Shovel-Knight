package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class TitleScreen extends ScreenAdapter {

    ShovelKnight game;
    Texture logo;
    BitmapFont font;

    public TitleScreen(ShovelKnight g){
        game = g;
    }

    @Override
    public void show() {
        logo = new Texture("logo.png");
        font = new BitmapFont(Gdx.files.internal("FONTS/FONT.fnt"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,1);

        if (Gdx.input.isTouched()){
            if (Gdx.input.getX() >= 73 && Gdx.input.getX() <= 263 && Gdx.input.getY() >= 554 && Gdx.input.getY() <= 580){
                game.setScreen(new ControlsScreen(game));
            }
            if (Gdx.input.getX() >= 564 && Gdx.input.getX() <= 660 && Gdx.input.getY() >= 427 && Gdx.input.getY() <= 455){
                game.setScreen(new GameScreen(game));
            }
            if (Gdx.input.getX() >= 900 && Gdx.input.getX() <= 1180 && Gdx.input.getY() >= 554 && Gdx.input.getY() <= 580){
                game.setScreen(new InstructionsScreen(game));
            }
//            System.out.println(Gdx.input.getX() + "," + Gdx.input.getY());
        }
        game.batch.begin();
        game.batch.draw(logo,144,265,960,359);
        font.draw(game.batch,"Controls",75,75);
        font.draw(game.batch,"By: Navjeet Doad",440,75);
        font.draw(game.batch,"Instructions",900,75);
        font.draw(game.batch,"Play",580,200);
        game.batch.end();
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
        game.batch.dispose();
    }
}