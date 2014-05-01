package com.me.ultimatemathadventures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen {
	
	  
	final UltimateMathAdventures game;
	private OrthographicCamera camera;
	private SpriteBatch batch;
    Texture character; 
    //Texture testimage;

    World world;
    GameChar darkNinja;
    Box2DDebugRenderer debugRenderer; 
    Rectangle floor;
    Array<StaticBodyGenerator> floors = new Array<StaticBodyGenerator>();
    TextureRegion backgroundimagecropped;
    Texture test;
    StaticBodyGenerator s;
    Sprite nuller;
    
    private SpriteBatch spriteBatch;
    Sprite floorimage;
    
	public GameScreen(final UltimateMathAdventures gam) {
		this.game  = gam;
		
		world = new World(new Vector2(0F, -10000000000000000000000F), false);
		debugRenderer = new Box2DDebugRenderer();
		
		test = new Texture(Gdx.files.internal("FBG3.png"));
		Sprite texture = new Sprite(new Texture(Gdx.files.internal("DarkNinja.png"))); 
		Sprite testimage = new Sprite(new Texture(Gdx.files.internal("TestImage.png")));
		/*Sprite*/ floorimage = new Sprite(new Texture(Gdx.files.internal("Forestfloor.png")));
		Sprite forestwall = new Sprite(new Texture(Gdx.files.internal("Forestwall.png")));
	nuller = new Sprite(new Texture(Gdx.files.internal("nullsquare.png")));
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		
		floor = new Rectangle();
		floor.x = 0;
		floor.y = 0;
		floor.width = 32;
		floor.height = 32;

//LEVEL DESIGN		
	
		//FLOORS
		int i = 0;
		
		
		do {
			floor.y = 1500;
			floor.x = i;
			floors.add(new StaticBodyGenerator(new Sprite(floorimage), world, camera, floor));
			i = i + 32;
		} while (floor.x < 768);
		
		i = 450;
		do {
			floor.y = 2175;
			floor.x = i;
			floors.add(new StaticBodyGenerator(new Sprite(floorimage), world, camera, floor));
			i = i + 32;
		} while (floor.x < 768);
		
		i = 375;
		do {
			floor.y = 1850;
			floor.x = i;
			floors.add(new StaticBodyGenerator(new Sprite(floorimage), world, camera, floor));
			i = i + 32;
			
			
		} while (floor.x < 704);  
		
		
		
		
		floor.y = 0;

			do {
				floor.y = 0;
				floor.x = i;
				 floors.add(new StaticBodyGenerator(new Sprite(floorimage), world, camera, floor));
				 
				 floor.y = 2400;
				 floors.add(new StaticBodyGenerator(new Sprite(floorimage), world, camera, floor));
				 i = i + 32;
			} while (i < 2400);

		
//WALLS
		floor.y = 0;
		
		for (int x = 0; x < 800; x++) {
			floor.x = 0;
			floors.add(new StaticBodyGenerator(new Sprite(forestwall), world, camera, floor));
			floor.x = 2400;
			floors.add(new StaticBodyGenerator(new Sprite(forestwall), world, camera, floor));
		floor.y = floor.y + 3;
		}
		
	
		
		
		
		
		
		
	
		
		
		
		Rectangle darkNinjaDimensions = new Rectangle();    
		darkNinjaDimensions.x = 100;
		darkNinjaDimensions.y = 1700;    
		darkNinjaDimensions.width = 75;    
		darkNinjaDimensions.height = 147; 
		

		
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(38 * (2/100), 74 * (2/100));
		FixtureDef fixture = new FixtureDef();
		fixture.shape = poly;
		fixture.density = 0;
		fixture.friction = 0f;
		fixture.restitution = 0f;
		
		BodyDef darkNinjaBodyDef = new BodyDef();
		darkNinjaBodyDef.type = BodyType.DynamicBody;
		darkNinjaBodyDef.position.set(100, 1700);
		
		darkNinja = new GameChar(texture, world, darkNinjaBodyDef, fixture, darkNinjaDimensions);

	}


	@Override
	public void render(float delta) {
		
		
		camera.position.set(darkNinja.getX() + darkNinja.getWidth() / 2, darkNinja.getY() + darkNinja.getHeight() / 2, 0);
		camera.viewportWidth = Gdx.graphics.getWidth();
		camera.viewportHeight = Gdx.graphics.getHeight();
		camera.update();
		debugRenderer.render(world, camera.combined);
		world.step(1/60f, 6, 2);
		Array<Body> bodies = new Array<Body>(world.getBodyCount());
		world.getBodies(bodies);
		for (Body b : bodies) {
			Object userData = b.getUserData();
			if (!(userData instanceof GameObject)) {
				continue;
			}
			GameObject gameObject = (GameObject) userData;
			Vector2 position = b.getPosition();
			gameObject.setX(position.x);
			gameObject.setY(position.y);
		}
		batch.setProjectionMatrix(camera.combined);
		   batch.begin();
		   {
			  
			   int x = -1024;
			   int y = 0;
			 
				   batch.draw(test,x,y);
				   batch.draw(test, 0, 0);
				   batch.draw(test, 0, 2048, 1024, 2048, 0, 0, 1024, 2048, false, true);
				   batch.draw(test, 1024, 2048, 1024, 2048, 0, 0, 1024, 2048, false, true);
				   batch.draw(test, 1024, 0, 1024, 2048, 0, 0, 1024, 2048, true, false);
				   batch.draw(test, 2048, 0);
				   batch.draw(test, 0, -2048, 1024, 2048, 0, 0, 1024, 2048, false, true);
			  
			darkNinja.render(batch);
			
		
			for (StaticBodyGenerator s : floors) {
				s.render(batch);
			}			
			
		batch.end();
		   
		   int xVel = 0;
		   int yVel = 0;
		   
		   
		  
				   
		   if(Gdx.input.isKeyPressed(Keys.LEFT)) xVel -= 200;
		   if(Gdx.input.isKeyPressed(Keys.RIGHT)) xVel += 200;
		   
		   if (xVel != 0) {
			   darkNinja.setX(darkNinja.getX() + xVel * Gdx.graphics.getDeltaTime());
			   xVel = 0;
		   }
		   		   
		  	//if (checkifair == false)	   
		   if (Gdx.input.isKeyPressed(Keys.UP)) yVel = 1000;
		   if (yVel != 0) 
			   darkNinja.setY(darkNinja.getY() + yVel * Gdx.graphics.getDeltaTime());
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
		batch.dispose();
	}
}