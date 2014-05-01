package com.me.ultimatemathadventures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CharacterScreen implements Screen {
	final UltimateMathAdventures game;
	Texture DarkNinja;
	Texture Jake;
	Texture Diamond;
	SpriteBatch batch;
	
	
	
	 public CharacterScreen(final UltimateMathAdventures gam) {
		 game = gam;
		 
		 DarkNinja = new Texture(Gdx.files.internal("DarkNinja.png"));
		 batch = new SpriteBatch();
		 
		 
		 
		 
	 }

		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resume() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void render(float delta) {
			// TODO Auto-generated method stub
			
			batch.begin();
			batch.draw(DarkNinja, 15 ,15);
			batch.end();
			
		}

		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
			
		}


	    //...Rest of class omitted for succinctness.

	}
	 

