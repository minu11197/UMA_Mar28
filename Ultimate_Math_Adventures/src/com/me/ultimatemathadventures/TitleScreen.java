package com.me.ultimatemathadventures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class TitleScreen implements Screen {
	
	
		SpriteBatch batch;
		Texture titlescreenpic;
		OrthographicCamera camera;
		Rectangle playButton;
		Rectangle instructionButton;
		Rectangle shopButton;
		TextureRegion titleimage;
		
	    final UltimateMathAdventures game;

	   

	    public TitleScreen(final UltimateMathAdventures gam) {
	            game = gam;

	            camera = new OrthographicCamera();
	            camera.setToOrtho(false, 800, 480);

	           titlescreenpic = new Texture(Gdx.files.internal("titleswag.png"));
	           titleimage = new TextureRegion(titlescreenpic, 0,0,800,480);
	           batch = new SpriteBatch();
	           
	           
	           playButton = new Rectangle();
	           playButton.width = 200;
	           playButton.height = 50;
	           playButton.x = 575;
	           playButton.y = 75;
	           
	           instructionButton = new Rectangle();
	           instructionButton.width = 250;
	           instructionButton.height = 50;
	           instructionButton.x = 750;
	           instructionButton.y = 225;
	           
	           shopButton = new Rectangle();
	           shopButton.width = 250;
	           shopButton.height = 50;
	           shopButton.x = 750;
	           shopButton.y = 375;
	           
	    }
	    
		@Override
		public void render(float delta) {
			
		             
			 camera.update();                 
			 game.batch.setProjectionMatrix(camera.combined);                  
			 batch.begin();      
			 {
				batch.draw(titleimage, 0, 0);
				 
			 }
	         batch.end();
	         if (Gdx.input.isTouched()) {                         
	        	 int x = Gdx.input.getX();
	        	 int y = Gdx.input.getY();
	        	 if (playButton.contains(x, y)) {
	        		 game.setScreen(new GameScreen(game));
	        	 }
	         }
	         
			
		}
		


		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
			
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


	    //...Rest of class omitted for succinctness.

	}

