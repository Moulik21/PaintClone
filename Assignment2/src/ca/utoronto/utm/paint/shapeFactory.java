package ca.utoronto.utm.paint;

import java.awt.Color;

/*
 * THE CLASS IS CURRENTLY NOT BEING USED!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class shapeFactory {
	
	public Shape getShape(String shapeType, Point origin, Color color){
		if (shapeType == null){
			return null;
		}
		if (shapeType == "Squiggle"){
			Squiggle squiggle = new Squiggle(origin, color);
			squiggle.addPoint(origin);
			return squiggle;
		}
		else if (shapeType =="Polyline"){
			PolyLine polyline = new PolyLine(origin, color);
			polyline.addPoint(origin);
			polyline.addPoint(origin);
			return polyline;
		}
		else if (shapeType == "Circle"){
			Circle circle = new Circle(origin, color);
			circle.setRadius(0);
			return circle;
		}
		else if (shapeType =="Rectangle"){
			Rectangle rectangle =  new Rectangle(origin, color);
			rectangle.setEnd(origin);
			rectangle.setHeight(0);
			rectangle.setWidth(0);
			return rectangle;
		}
		else if (shapeType =="Square"){
			Square square = new Square(origin, color);
			square.setEnd(origin);
			square.setSide(0);
			return square;
		}
		return null;
	}
}
