package com.mygdx.tank;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.tank.screens.main_menu;
import com.mygdx.tank.screens.mainscreen;

public class MyGame extends Game {

    MyGame mygame;
	@Override
	public void create() {
		setScreen(new mainscreen(this));
	}

	@Override
	public void resize(int width, int height) {
         super.resize(width, height);
	}

	@Override
	public void render() {
        super.render();
	}

	@Override
	public void pause() {
      super.pause();
	}

	@Override
	public void resume() {
        super.resume();
	}

	@Override
	public void dispose() {
        super.dispose();
	}

}
