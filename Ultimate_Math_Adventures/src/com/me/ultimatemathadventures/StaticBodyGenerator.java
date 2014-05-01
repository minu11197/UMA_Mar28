package com.me.ultimatemathadventures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class StaticBodyGenerator extends AbstractGameObject implements GameObject  {
	private final Body body;
	private final Sprite texture;
	
	
	public StaticBodyGenerator(Sprite texture, World world, OrthographicCamera camera) {
		this(texture, world,camera, null);
	}
	
	
	public StaticBodyGenerator(Sprite texture, World world, OrthographicCamera camera, Rectangle bounds) {
		//rectangles is the issue here. Make sure you change Rectangle bounds to int height and int width, take in those values and then
		//create your own rectangle in this code; set the x,y, width and height with code that already exists!
		
		BodyDef groundBodyDef =new BodyDef();  
		groundBodyDef.position.set(new Vector2(0, 10));  
	groundBodyDef.type = BodyType.StaticBody;
	groundBodyDef.position.set(bounds.x, bounds.y + 15);
	Body groundBody = world.createBody(groundBodyDef);  
	PolygonShape groundBox = new PolygonShape();  
	groundBox.setAsBox(32, 16);
	groundBody.createFixture(groundBox, 0); 
	groundBox.dispose();
		
	
		
	this.body = world.createBody(groundBodyDef);
	this.texture = texture;
	this.body.setUserData(this);
	
	
	if (bounds == null) {
		this.setBounds(0, 0, 0, 0);
	} else {
		this.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	
}
	
	public void render(SpriteBatch spriteBatch) {
		this.texture.draw(spriteBatch);
	
	}
	
	@Override
	public final void setX(float x) {
		super.setX(x);
		this.texture.setX(x);
		this.body.setTransform(new Vector2(x, this.body.getPosition().y), this.body.getAngle());
	}
	
	
	@Override
	public final void setY(float y) {
		super.setY(y);
		this.texture.setY(y);
		this.body.setTransform(new Vector2(this.body.getPosition().x, y), this.body.getAngle());
	}
	
	@Override
	public final void setWidth(float Width) {
		super.setWidth(Width);
		this.texture.setSize(Width, this.texture.getHeight());
	}
	
	@Override
	public final void setHeight(float height) {
		super.setHeight(height);
		this.texture.setSize(this.texture.getWidth(),height);
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated constructor stu



	@Override
	public Body getBody() {
		
		return null;
	}


	@Override
	public float getZoom() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}