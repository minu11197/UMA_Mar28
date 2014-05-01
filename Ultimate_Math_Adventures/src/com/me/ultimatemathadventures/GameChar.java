package com.me.ultimatemathadventures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class GameChar extends AbstractGameObject implements GameObject {
	
	private final Body body;
	private final Fixture fixture;
	private final Sprite texture;
	int offsetX = 8;
	int offsetY = 6;
	float pixeltometer = 0.02f;
	public GameChar(Sprite texture, World world, BodyDef bodyDef, FixtureDef fixture) {
		this(texture, world, bodyDef, fixture, null);
	}
	
	public GameChar(Sprite texture, World world, BodyDef bodyDef, FixtureDef fixture, Rectangle bounds) {
		this.body = world.createBody(bodyDef);
		this.texture = texture;
		this.body.setUserData(this);
		this.fixture = this.body.createFixture(fixture);
		
		if (bounds == null) {
			this.setBounds(0, 0, 0, 0);
		} else {
			this.setBounds(bounds.x- 75, bounds.y - 149 , bounds.width, bounds.height);
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
	
	public Body getBody() {
		return this.body;
	}
	
	public void applyForce() {
		this.body.applyForceToCenter(1.0f, 0.0f, true);
	}

	@Override
	public float getZoom() {
		// TODO Auto-generated method stub
		return 0;
	}
	}

