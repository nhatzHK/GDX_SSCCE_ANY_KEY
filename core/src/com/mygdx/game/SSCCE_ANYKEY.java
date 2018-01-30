package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SSCCE_ANYKEY extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen (new SSCCE_Screen (this));
	}


	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
