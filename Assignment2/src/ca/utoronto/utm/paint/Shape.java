package ca.utoronto.utm.paint;

import java.awt.Color;

public class Shape {
	private Point origin;
	private Color colour;
	
	public Shape(){
		this.origin = new Point(0,0);
	}
	
	public Shape(Point origin){
		this.origin = origin;
	}
	
	public Point getOrigin(){
		return this.origin;
	}
	
	public void setOrigin(Point new_origin){
		this.origin = new_origin;
	}
	
	public void setShapeColour(Color colour){
		this.colour = colour;
	}
	
	public Color getShapeColour(){
		return colour;
	}
}
