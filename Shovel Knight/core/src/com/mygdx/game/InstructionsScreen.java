package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class InstructionsScreen extends ScreenAdapter {

    ShovelKnight game;
    BitmapFont font;

    public InstructionsScreen(ShovelKnight g){
        game = g;
    }

    @Override
    public void show() {
        font = new BitmapFont(Gdx.files.internal("FONTS/Font.fnt"));
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if (keyCode == Input.Keys.ESCAPE){
                    game.setScreen(new TitleScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,1);
        game.batch.begin();
        font.draw(game.batch,"Instructions",460,550);
        font.draw(game.batch,"1. Collect gems to increase your gold",45,450);
        font.draw(game.batch,"2. Walls can sometimes contain treasure! Watch out!",45,350);
        font.draw(game.batch,"3. ",45,250);
        font.draw(game.batch,"<- Press ESC to go back to the Menu",45,150);
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

    }

}