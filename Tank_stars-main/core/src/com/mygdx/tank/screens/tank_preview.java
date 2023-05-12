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
public class tank_preview implements Screen {
    private MyGame main_menu;
    private OrthographicCamera gamecam1;
    private StretchViewport gameport1;
    private Texture background;
    private Texture side_menu;
    private Texture left_button;
    private Texture right_button;
    private Texture back_button;
    private Texture player1_tank_selection;
    private Sprite Splash;
    private SpriteBatch batch;
    public tank_preview(MyGame main_menu){
        this.main_menu= main_menu;
        background=new Texture(Gdx.files.internal("ABRAM_TANK.png"));
        side_menu=new Texture (Gdx.files.internal("p1tank1.png"));
        right_button=new Texture(Gdx.files.internal("right_arrow.png"));
        back_button=new Texture (Gdx.files.internal("back_logo.png"));
        player1_tank_selection=new Texture (Gdx.files.internal("p1scroll1.png"));
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
        batch.draw(right_button,765,240,30,40);
        batch.draw(back_button,0,415,80,40);
        if (Gdx.input.justTouched()){
            float x= (float) (Gdx.graphics.getWidth()/640.0);
            float y= (float) (Gdx.graphics.getHeight()/480.0);
            if(Gdx.input.getX()>605*x & Gdx.input.getX()<635*x & Gdx.input.getY()>200*y & Gdx.input.getY()<240*y){
                main_menu.setScreen(new tank_preview2(this.main_menu));
            }
            if(Gdx.input.getX()>0 & Gdx.input.getX()<80*x & Gdx.input.getY()>25*y & Gdx.input.getY()<65*y){
                main_menu.setScreen(new main_menu(this.main_menu));
            }
            if(Gdx.input.getX()>455*x & Gdx.input.getX()<580*x & Gdx.input.getY()>275*y & Gdx.input.getY()<355*y){
                main_menu.setScreen(new gameplay(this.main_menu));
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
