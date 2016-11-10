package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
/**
 * A modular way to create new shapes 
 *
 */
public class shapeFactory {
	
	/**
	 * Create a new Shape based on what Shape is required to be made
	 * @param shapeType the type of Shape to be made
	 * @param origin the starting Point of the shape
	 * @param color the colour of the shape
	 * @param newStroke the line thickness of the shape
	 * @return the Shape required to be made, null otherwise.
	 */
	public Shape getShape(String shapeType, Point origin, Color color, BasicStroke newStroke){
		if (shapeType == null){
			return null;
		}
		if (shapeType == "Squiggle"){
			Squiggle squiggle = new Squiggle(origin, color,newStroke);
			squiggle.addPoint(origin);
			return squiggle;
		}
		else if (shapeType =="Polyline"){
			PolyLine polyline = new PolyLine(origin, color,newStroke);
			polyline.addPoint(origin);
			polyline.addPoint(origin);
			return polyline;
		}
		else if (shapeType == "Circle"){
			Circle circle = new Circle(origin, color, newStroke);
			circle.setRadius(0);
			return circle;
		}
		else if (shapeType =="Rectangle"){
			Rectangle rectangle =  new Rectangle(origin, color,newStroke);
			rectangle.setEnd(origin);
			rectangle.setHeight(0);
			rectangle.setWidth(0);
			return rectangle;
		}
		else if (shapeType =="Square"){
			Square square = new Square(origin, color,newStroke);
			square.setEnd(origin);
			square.setSide(0);
			return square;
		}
		return null;
	}
}
