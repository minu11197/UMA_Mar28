package com.me.ultimatemathadventures;

import com.badlogic.gdx.math.Rectangle;

public abstract class AbstractGameObject implements GameObject {
	
	private float x;
	private float y;
	private float width;
	private float height;
	

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getWidth() {
		return width;
	}

	@Override
	public float getHeight() {
		return height;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public void setY(float y) {
		this.y = y;
		
	}

	@Override
	public void setWidth(float width) {
		this.width = width;
		
	}

	@Override
	public void setHeight(float height) {
		this.height = height;
		
	}

	@Override
	public void setBounds(float x, float y, float width, float height) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

}
