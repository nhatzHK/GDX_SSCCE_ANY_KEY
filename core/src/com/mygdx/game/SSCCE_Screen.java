package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SSCCE_Screen implements Screen {

	SSCCE_ANYKEY game;
	Vector2      position;
	Texture      img;
	SpriteBatch batch;

	public SSCCE_Screen (SSCCE_ANYKEY game) {
		super();

		this.game = game;
		this.batch = game.batch;

		position = new Vector2 (0, 0);
		img = new Texture("badlogic.jpg");
	}

	@Override public void render (float delta) {

		if (Gdx.input.isKeyPressed (Input.Keys.ANY_KEY)) {
			if (Gdx.input.isKeyPressed (Input.Keys.DOWN)) {
				position.y -= 5;
			} else if (Gdx.input.isKeyPressed (Input.Keys.UP)) {
				position.y += 5;
			} else if (Gdx.input.isKeyPressed (Input.Keys.LEFT)) {
				position.x -= 5;
			} else if (Gdx.input.isKeyPressed (Input.Keys.RIGHT)) {
				position.x += 5;
			}

			if (position.x < 0) {
				position.x = 0;
			} else if (position.x >
			           Gdx.graphics.getWidth () - img.getWidth ())
			{
				position.x = Gdx.graphics.getWidth () - img.getWidth ();
			}

			if (position.y < 0) {
				position.y = 0;
			} else if (position.y >
			           Gdx.graphics.getHeight () - img.getHeight ())
			{
				position.y = Gdx.graphics.getHeight () - img.getHeight ();
			}
		}

		Gdx.gl.glClearColor (1, 0, 0, 1);
		Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);
		batch.begin ();
		batch.draw (img, position.x, position.y);
		batch.end ();
	}

	@Override public void show () {

	}

	@Override public void resize (int width, int height) {

	}

	@Override public void pause () {

	}

	@Override public void resume () {

	}

	@Override public void hide () {

	}

	@Override public void dispose () {
		img.dispose ();
	}
}

