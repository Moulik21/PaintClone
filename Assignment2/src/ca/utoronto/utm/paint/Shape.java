package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
	private Point origin;
	private final Color colour;
	private boolean isFilled;
	private BasicStroke stroke;
	
	public Shape(Point origin, Color colour, BasicStroke newStroke){
		this.origin = origin;
		this.colour = colour;
		this.isFilled = false;
		this.stroke = newStroke;
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
	
	public boolean getIsFilled(){
		return isFilled;
	}
	
	public BasicStroke getShapeStroke(){
		return this.stroke;
	}
	
	public void changedIsFilled(){
		this.isFilled = !this.isFilled;
	}
	
	public abstract void draw(Graphics2D g2d);
}
