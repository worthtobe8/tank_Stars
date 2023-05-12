package com.mygdx.tank.screens;
import com.badlogic.gdx.Gdx;
import  com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.tank.MyGame;
public class gameplay implements Screen {
    private MyGame gameplay;
    private OrthographicCamera gamecam1;
    private StretchViewport gameport1;
    private Texture background;
    private Texture ground;
    private Sprite Splash;
    private SpriteBatch batch;
    public gameplay(MyGame gameplay){
        this.gameplay= gameplay;
        background=new Texture(Gdx.files.internal("a439b065333621.5af0ea8ca23f5.png"));
        ground=new Texture(Gdx.files.internal("ground.png"));
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
        batch.draw(background,0,0,800,480);
        batch.draw(ground,0,0,1100,300);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gameport1.update(width,height,true);
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
