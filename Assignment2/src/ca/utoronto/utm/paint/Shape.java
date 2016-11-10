package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Every shape has the properties of a colour, an origin(Point) , a stroke, and a filling option. 
 * This class is an abstract class which that different children(Shapes) have their own implementation
 *  of the method draw(Graphics2D g2d).
 *
 */
public abstract class Shape {
	
	/**
	 * The starting point of the shape.
	 */
	private Point origin;
	
	/**
	 * The outline colour of the shape if isFilled is false. 
	 * If isFilled is true, colour will be the colour of the entire shape.
	 */
	private final Color colour;
	
	/**
	 * True if the user wants the shape filled, false otherwise.	
	 */
	private boolean isFilled;
	
	/**
	 * The thickness of the line when drawing a shape.
	 */
	private BasicStroke stroke;	
	/**
	 * 
	 * @param origin the starting point of the shape.
	 * @param colour the colour of the shape.
	 * @param newStroke the thickness of the line when drawing the shape.
	 */
	public Shape(Point origin, Color colour, BasicStroke newStroke){
		this.origin = origin;
		this.colour = colour;
		this.isFilled = false;
		this.stroke = newStroke;
	}
	
	/**
	 * 
	 * @return origin of the shape.
	 */
	public Point getOrigin(){
		return this.origin;
	}
	
	/**
	 * Sets the origin to a new Point.
	 * @param new_origin a new Point to be set as the origin.
	 */
	public void setOrigin(Point new_origin){
		this.origin = new_origin;
	}
	
	/**
	 * 
	 * @return the colour of the shape.
	 */
	public Color getShapeColour(){
		return colour;
	}
	
	/**
	 * 
	 * @return the line thickness of the shape.
	 */
	public BasicStroke getShapeStroke(){
		return this.stroke;
	}
	
	/**
	 * 
	 * @return True if the shape is filled, false otherwise.
	 */
	public boolean getIsFilled(){
		return isFilled;
	}	
	
	/**
	 * Changes the shape to be filled.
	 */
	public void changedIsFilled(){
		this.isFilled = !this.isFilled;
	}
	
	/**
	 * Each class that extends Shape will have their own implementation of this method 
	 * @param g2d Graphics2D object
	 */
	public abstract void draw(Graphics2D g2d);
}
