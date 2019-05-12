package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen extends ScreenAdapter{

    ShovelKnight game;
    Knight player;

    boolean standingLeft = false,standingRight = true; //keeps track of what direction the player is facing
    boolean moving = false; //keeps track of if the player is moving
    String nextPos = "standingRight";

    TiledMap map;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

    public GameScreen(ShovelKnight g){
        game = g;
    }

    @Override
    public void show() {
        player = new Knight(100,100);
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if (keyCode == Input.Keys.ESCAPE){
                    game.setScreen(new TitleScreen(game));
                }
                return true;
            }
        });
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.update();
        map = new TmxMapLoader().load("Map Stuff/gameMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,1,0);

        player.stateTime += Gdx.graphics.getDeltaTime();

        Texture runRightFrame = player.runRight.getKeyFrame(player.stateTime, true);
        Texture runLeftFrame = player.runLeft.getKeyFrame(player.stateTime, true);

        game.batch.begin();
        game.batch.setProjectionMatrix(camera.combined);

        if (nextPos.equals("standingRight") && !Gdx.input.isKeyPressed(Input.Keys.D) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            standingRight = true;
            standingLeft = false;
        }
        if (nextPos.equals("standingLeft") && !Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            standingLeft = true;
            standingRight = false;
        }

        if (standingRight){
            game.batch.draw(player.standingRight,player.xPos,player.yPos);
        }
        if (standingLeft){
            game.batch.draw(player.standingLeft,player.xPos,player.yPos);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            standingRight = false;
            standingLeft = false;
            game.batch.draw(runRightFrame,player.getXPos(),player.getYPos());
            player.xPos += 200 * Gdx.graphics.getDeltaTime();
            moving = true;
            nextPos = "standingRight";
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            standingRight = false;
            standingLeft = false;
            game.batch.draw(runLeftFrame,player.getXPos(),player.getYPos());
            player.xPos -= 200 * Gdx.graphics.getDeltaTime();
            moving = true;
            nextPos = "standingLeft";
        }
        camera.position.set(player.xPos+500,player.yPos+200,0);
        camera.update();
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