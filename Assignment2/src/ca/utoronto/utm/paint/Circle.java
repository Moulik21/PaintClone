package ca.utoronto.utm.paint;

import java.awt.Color;

public class Circle extends Shape {
	private int radius;
	
	public Circle(){
		super();
		this.radius = 0;
	}
	
	public Circle(Point centre, int radius, Color newColour){
		super(centre, newColour);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
