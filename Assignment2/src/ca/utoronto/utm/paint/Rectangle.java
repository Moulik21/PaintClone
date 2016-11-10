package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A Rectangle is a type of Shape. A Rectangle has an end Point, width and height.
 * 
 */
public class Rectangle extends Shape{
	
	//Instance Variables
	private Point end;
	private int width;
	private int height;
	

	/**
	 * Creates a new Rectangle with the given origin, colour and stroke
	 * @param origin the Starting Point of the Rectangle
	 * @param newColour the colour of the Rectangle
	 * @param newStroke	the line thickness when drawing a Rectangle
	 */
	public Rectangle(Point origin,Color newColour, BasicStroke newStroke){
		super(origin, newColour, newStroke);
	}
	
	/**
	 * 
	 * @return the end Point of the Rectangle
	 */
	public Point getEnd() {
		return end;
	}
	
	/**
	 * Sets the end Point of the Rectangle
	 * @param end
	 */
	public void setEnd(Point end) {
		this.end = end;
	}
	
	/**
	 * 
	 * @return the width of the Rectangle
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the width of the Rectangle
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return the Height of the rectangle
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height of the Recatangle
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	/**
	 * Draw the Rectangle.
	 * Rectangle has its own implementation of draw as it is drawn differently from other Shapes.
	 */
	public void draw(Graphics2D g2d) {
		int width = this.getWidth();
		int height = this.getHeight();
		int x,y;
		
		//Cases for where the top left coordinates of the rectangle will start based on if the user is trying to drag to the right or left and up or down
		if (this.getOrigin().getX() < this.getEnd().getX()) {
			x = this.getOrigin().getX();
		}
		else {
			x = this.getEnd().getX();
		}
		if (this.getOrigin().getY() < this.getEnd().getY()) {
			y = this.getOrigin().getY();
		}
		else {
			y = this.getEnd().getY();
		}
		g2d.setColor(this.getShapeColour());
		g2d.setStroke(this.getShapeStroke());
		if (this.getIsFilled()){
			g2d.drawRect(x, y, width, height);
		}
		else{
			g2d.fillRect(x, y, width, height);
		}
		
	}

}