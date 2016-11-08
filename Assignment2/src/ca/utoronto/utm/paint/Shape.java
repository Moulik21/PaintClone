package ca.utoronto.utm.paint;

import java.awt.Color;

public class Shape {
	private Point origin;
	private final Color colour;
	
	public Shape(){
		this.origin = new Point(0,0);
		this.colour = Color.BLACK;
	}
	
	public Shape(Point origin, Color colour){
		this.origin = origin;
		this.colour = colour;
	}
	
	public Point getOrigin(){
		return this.origin;
	}
	
	public void setOrigin(Point new_origin){
		this.origin = new_origin;
	}
		
	public Color getShapeColour(){
		return colour;
	}
}
