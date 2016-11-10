package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * A Circle is a type of Shape. In addition to having an origin, colour and stroke, a Circle has a radius. 
 *
 */
public class Circle extends Shape {
	/**
	 * The radius of the circle
	 */
	private int radius;
	
	/**
	 * Creates a new Circle
	 * @param centre the centre of the Circle
	 * @param newColour the colour of the Circle
	 * @param newStroke the line thickness of the Circle
	 */
	public Circle(Point centre, Color newColour, BasicStroke newStroke){
		super(centre, newColour,newStroke);
	}
	
	/**
	 * 
	 * @return the radius of the circle
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * Sets the new radius of the circle
	 * @param radius the new radius to be set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	/**
	 * Draw the Circle.
	 * Circle has its own implementation of draw as it is drawn differently from other Shapes
	 * 
	 */
	public void draw(Graphics2D g2d) {
		int radius = this.getRadius();
		int x = (this.getOrigin().getX()-radius);
		int y = (this.getOrigin().getY()-radius);
		g2d.setColor(this.getShapeColour());
		g2d.setStroke(this.getShapeStroke());
		if (this.getIsFilled()){
			g2d.drawOval(x, y, radius*2, radius*2);
		}
		else{
			g2d.fillOval(x, y, radius*2, radius*2);
		}

		
	}

}
