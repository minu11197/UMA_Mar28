package com.me.ultimatemathadventures;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class GameStatics extends AbstractGameObject implements GameObject {
	private final Body body;
	private final Fixture fixture;
	
	private final Sprite texture;
	
	public GameStatics(Sprite texture, World world, BodyType bodytype, FixtureDef fixture) {
		this(texture, world, fixture, bodytype , null);
	}
	
	public GameStatics(Sprite texture, World world, FixtureDef fixture, BodyType bodytype, Rectangle bounds) {
		BodyDef body = new BodyDef();
		body.type = BodyType.StaticBody;
		body.position.set(bounds.x, bounds.y);
		this.body = world.createBody(body);
		this.texture = texture;
		
		this.body.setUserData(this);
		
		this.fixture = this.body.createFixture(fixture);
		
			this.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
		
	}
	
	public void render(SpriteBatch spriteBatch) {
		this.texture.draw(spriteBatch);
	}
	
	@Override
	public final void setX(float x) {
		super.setX(x);
		this.texture.setX(x);
	}
	
	
	@Override
	public final void setY(float y) {
		super.setY(y);
		this.texture.setY(y);
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

	@Override
	public float getZoom() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Body getBody() {
		// TODO Auto-generated method stub
		return null;
	}
}
