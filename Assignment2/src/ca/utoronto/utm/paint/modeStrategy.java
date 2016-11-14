package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
/**
 * Strategy Class. Various strategy for different shapes.
 * @author Pineapple
 *
 */
public interface modeStrategy {
	String state ();
	void press(PaintPanel panel, MouseEvent e, boolean StyleFlag, shapeFactory factory, Point origin);
	void release(PaintPanel panel, MouseEvent e);
	void drag(PaintPanel panel, MouseEvent e);
	void move(PaintPanel panel, MouseEvent e);
}
/**
 * Strategy for Squiggle
 * @author Pineapple
 *
 */
class createSquiggle implements modeStrategy{
	/**
	 * Create the shape and add it to the shape list on click.
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag, shapeFactory factory, Point origin) {

		panel.setShape((Squiggle)factory.getShape("Squiggle", origin));
		panel.getModel().addCommand((DrawingCommand)panel.getShape());
		
	}
	/**
	 * Reset the shape variable in order to create brand new shape
	 */
	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
	}
	/**
	 * Create a preview where the user can see before committing.
	 */
	public void drag(PaintPanel panel, MouseEvent e) {
		Point p = new Point(e.getX(),e.getY());
		Squiggle squiggle =(Squiggle) panel.getShape();
		squiggle.addPoint(p);
	}
	/**
	 * Return the strategy that the class is currently is using.
	 */
	public String state() {
		return "Squiggle";
	}

	//Not needed for this strategy.
	public void move(PaintPanel panel, MouseEvent e) {}
	
}
/**
 * Strategy for Polyline
 * @author Pineapple
 *
 */
class createPolyline implements modeStrategy{
	
	/**
	 * Return the strategy that the class is currently is using.
	 */
	public String state() {
		return "Polyline";
	}
	
	/**
	 * Depending on which mousebutton was used, the polyline will either continue to create the shape or stop
	 * by drawing back to the origin point.
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag, shapeFactory factory, Point origin) {
		//If no shape exist, create a new one. Avoid null pointer.
		if(panel.getShape() == null){
			panel.setShape((PolyLine)factory.getShape("Polyline", origin));
			panel.getModel().addCommand((DrawingCommand)panel.getShape());
		}
		PolyLine polyline = (PolyLine)panel.getShape();
//		if (StyleFlag){
			panel.getShape().setIsFilled(StyleFlag);
//		}
		//If left click, only add the point where the user has clicked
		if(SwingUtilities.isLeftMouseButton(e)){
				polyline.addPoint(e.getX(),e.getY());
		}
		//If right click, end the shape by drawing back to the origin point
		else if(SwingUtilities.isRightMouseButton(e)){
			int originX = polyline.getX().get(0);
			int originY = polyline.getY().get(0);
			polyline.removePoint();
			polyline.addPoint(originX,originY);
			panel.setShape(null);
			panel.repaint();
		}
	}
	/**
	 * Preview so that the user can see how their lines will be drawn
	 * before committing.
	 */
	public void move(PaintPanel panel, MouseEvent e){
		if(panel.getShape()!=null){
			PolyLine polyline = (PolyLine)panel.getShape();
			polyline.removePoint();
			polyline.addPoint(e.getX(),e.getY());
			panel.repaint();

		}
	}
	//Not needed for this strategy.
	public void release(PaintPanel panel, MouseEvent e) {}

	public void drag(PaintPanel panel, MouseEvent e) {}
	
}
/**
 * Strategy for creating a circle.
 * @author Pineapple
 *
 */
class createCircle implements modeStrategy{
	/**
	 * Create a circle and add it to the shape list on click.
	 */
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		Point centre = new Point(e.getX(), e.getY());
		panel.setShape((Circle)factory.getShape("Circle", centre));
		panel.getModel().addCommand((DrawingCommand)panel.getShape());
		panel.getShape().setIsFilled(StyleFlag);
	}
	/**
	 * Reset the shape variable to create new shapes later.
	 */
	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
	}
	/**
	 * Create a preview for the user before they commit drawing.
	 */
	public void drag(PaintPanel panel, MouseEvent e) {
		//Math for the radius
		int radius = (int) Math.sqrt((Math.abs(Math.pow((double)
				(panel.getShape().getOrigin().getX()-e.getX()), 2.0)))
				+Math.abs(Math.pow((double)(panel.getShape().getOrigin().getY()-e.getY()), 2.0)));
		Circle circle = (Circle)panel.getShape();
		circle.setRadius(radius);
	}
	/**
	 * Return the current strategy being used.
	 */
	public String state() {
		return "Circle";
	}

	//Not used for this strategy
	public void move(PaintPanel panel, MouseEvent e) {}
	
}
/**
 * Strategy for creating rectangles.
 * @author Pineapple
 *
 */
class createRectangle implements modeStrategy{
	/**
	 * Create rectangles and add it to shape list on click.
	 */
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		panel.setShape((Rectangle) factory.getShape("Rectangle", origin));
		panel.getModel().addCommand((DrawingCommand)panel.getShape());
		panel.getShape().setIsFilled(StyleFlag);

	}
	
	/**
	 * Reset shape variable to create new shapes later.
	 */
	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
	}
	/**
	 * Create a preview of the shape before the user commits.
	 */
	public void drag(PaintPanel panel, MouseEvent e) {
		Point end = new Point(e.getX(), e.getY());
		Rectangle rectangle = (Rectangle)panel.getShape();
		rectangle.setEnd(end);
		rectangle.setWidth(Math.abs(end.getX()-panel.getShape().getOrigin().getX()));
		rectangle.setHeight(Math.abs(end.getY()-panel.getShape().getOrigin().getY()));
		
	}
	/**
	 * Returns the current strategy that is being used.
	 */
	public String state() {
		return "Rectangle";
	}

	//Not required for this strategy.
	public void move(PaintPanel panel, MouseEvent e) {}
	
}
/**
 * Strategy for creating a square.
 * @author Pineapple
 *
 */
class createSquare implements modeStrategy{
	/**
	 * Creates a square and adds it to the shape list on click.
	 */
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		panel.setShape((Square)factory.getShape("Square", origin));
		panel.getModel().addCommand((DrawingCommand)panel.getShape());
		
		
//		if (StyleFlag){
			panel.getShape().setIsFilled(StyleFlag);
//		}
	}
	/**
	 * Reset the shape variable to create new shapes later.
	 */
	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
	}
	/**
	 * Create a preview for the user before committing.
	 */
	public void drag(PaintPanel panel, MouseEvent e) {
		Point end = new Point(e.getX(), e.getY());
		Square square = (Square)panel.getShape();
		square.setEnd(end);
		
		int xDifference, yDifference; 
		//essentially width & height of the rectangle the user would have created
		xDifference = Math.abs(end.getX() - panel.getShape().getOrigin().getX());
		yDifference = Math.abs(end.getY() - panel.getShape().getOrigin().getY());

		//the square will be drawn based on the bigger of width & height
		if(xDifference<yDifference) {
			square.setSide(xDifference);
		}
		else {
			square.setSide(yDifference);
		}
	
	}
	/**
	 * Returns the current strategy that is being used.
	 */
	public String state() {
		return "Square";
	}
	
	//Not needed for this strategy
	public void move(PaintPanel panel, MouseEvent e) {}
}

