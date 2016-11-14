package ca.utoronto.utm.paint;

/**
 * Every shape has the properties of a colour, an origin(Point) , a stroke, and a filling option. 
 * This class is an abstract class which that different children(Shapes) have their own implementation
 *  of the method draw(Graphics2D g2d).
 *
 */
public class Shape {
	
	/**
	 * The starting point of the shape.
	 */
	private Point origin;
	
	/**
	 * True if the user wants the shape filled, false otherwise.	
	 */
	private boolean isFilled;

	/**
	 * 
	 * @param origin the starting point of the shape.
	 * @param colour the colour of the shape.
	 * @param newStroke the thickness of the line when drawing the shape.
	 */
	public Shape(Point origin){
		this.origin = origin;
		this.isFilled = false;
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
	 * @return True if the shape is filled, false otherwise.
	 */
	public boolean getIsFilled(){
		return isFilled;
	}
	
	public void setIsFilled(boolean mode){
		this.isFilled = mode;
	}
	
}
