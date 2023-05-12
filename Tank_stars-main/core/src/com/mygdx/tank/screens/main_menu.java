package com.mygdx.tank.screens;
import com.badlogic.gdx.Gdx;
import  com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.tank.MyGame;

import static java.awt.image.ImageObserver.WIDTH;


public class main_menu implements Screen {
    private MyGame game;
    BitmapFont font = new BitmapFont();
    private OrthographicCamera gamecam1;
    private StretchViewport gameport1;
    private Texture background;
    private Texture side_menu;
    private Texture button;
    private Texture Settings;
    private Texture Load_game;
    private Texture trial;
    private Sprite Splash;
    private SpriteBatch batch;
    public main_menu(MyGame game){
        this.game=game;
        background=new Texture(Gdx.files.internal("new main_menu.png"));
        side_menu=new Texture (Gdx.files.internal("side_menu.png"));
        button=new Texture (Gdx.files.internal("playerbutton.png"));
        Settings=new Texture(Gdx.files.internal("Screenshot 2022-11-20 000013.png"));
        Load_game=new Texture(Gdx.files.internal("load_game.png"));
        gamecam1= new OrthographicCamera();
        gameport1 =new StretchViewport(800,480,gamecam1);
    }

    @Override
    public void show() {
        batch=new SpriteBatch();
        Splash=new Sprite(background);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(gamecam1.combined);

        batch.begin();
        this.dispose();
        batch.draw(background,0,0,480,480);
        batch.draw(side_menu,480,0,360,480);
        batch.draw(button,570,170,150,80);
        batch.draw(Settings,0,415,80,40);
        batch.draw(Load_game,570,280,150,80);
        if (Gdx.input.isTouched()){
            float x= (float) (Gdx.graphics.getWidth()/640.0);
            float y= (float) (Gdx.graphics.getHeight()/480.0);
            if(Gdx.input.getX()>455*x & Gdx.input.getX()<580*x & Gdx.input.getY()>225*y & Gdx.input.getY()<305*y){
                game.setScreen(new tank_preview(this.game));
            }
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gameport1.update(width,height,true);

    }

    @Override
    public void pause() {
         game.pause();
    }

    @Override
    public void resume() {
        game.resume();
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.dispose();
    }
}
