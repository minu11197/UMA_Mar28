package com.me.ultimatemathadventures;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;

public interface GameObject {
	
	float getX();
	
	float getY();
	
	float getWidth();
	
	float getHeight();
	
	float getZoom();
	
	Rectangle getBounds();
	
	void setX(float x);
	
	void setY(float y);
	
	
	void setWidth(float width);
	
	void setHeight(float height);
	
	void setBounds(float x, float y, float width, float height);
	
	Body getBody();
	
}
