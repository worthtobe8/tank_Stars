package com.mygdx.tank.screens;
import com.badlogic.gdx.Gdx;
import  com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.tank.MyGame;

public class mainscreen implements Screen{
    private MyGame game;
    private Sprite splash;
    private SpriteBatch batch;
    private OrthographicCamera gamecam;
    private  StretchViewport gameport;
    private Texture backgrounds;
    BitmapFont font = new BitmapFont();
    public mainscreen(MyGame game){
        this.game=game;
        backgrounds=new Texture(Gdx.files.internal("front page tank stars.png"));
        gamecam = new OrthographicCamera();
        gameport=new StretchViewport(800,480,gamecam);
    }



    @Override
    public void show() {
        batch=new SpriteBatch();
        splash=new Sprite(backgrounds);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(gamecam.combined);
        batch.begin();

        batch.draw(backgrounds,0,0,800,480);
        font.draw(batch, "Click On Screen To Play", 310, 75);
            if (Gdx.input.isTouched()){
                game.setScreen(new main_menu(this.game));
            }
        batch.end();
    }


    @Override
    public void resize(int width, int height) {
        gameport.update(width,height,true);
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
