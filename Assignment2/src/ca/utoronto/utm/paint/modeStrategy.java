package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public interface modeStrategy {
	String state ();
	void press(PaintPanel panel, MouseEvent e, boolean StyleFlag, shapeFactory factory, Point origin);
	void release(PaintPanel panel, MouseEvent e);
	void drag(PaintPanel panel, MouseEvent e);
}

class createSquiggle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag, shapeFactory factory, Point origin) {

		panel.setShape((Squiggle)factory.getShape("Squiggle", origin, panel.getColour(),panel.getStroke()));
		panel.getModel().addShape(panel.getShape());
		
	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
	}

	public void drag(PaintPanel panel, MouseEvent e) {
		Point p = new Point(e.getX(),e.getY());
		Squiggle squiggle =(Squiggle) panel.getShape();
		squiggle.addPoint(p);
	}
	
	public String state() {
		return "Squiggle";
	}
}

class createCircle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		Point centre = new Point(e.getX(), e.getY());
		panel.setShape((Circle)factory.getShape("Circle", centre, panel.getColour(),panel.getStroke()));
		panel.getModel().addShape(panel.getShape());

		if (StyleFlag){
			panel.getShape().changedIsFilled();
		}
	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
	}
	
	public void drag(PaintPanel panel, MouseEvent e) {
		int radius = (int) Math.sqrt((Math.abs(Math.pow((double)
				(panel.getShape().getOrigin().getX()-e.getX()), 2.0)))
				+Math.abs(Math.pow((double)(panel.getShape().getOrigin().getY()-e.getY()), 2.0)));
		Circle circle = (Circle)panel.getShape();
		circle.setRadius(radius);
	}

	public String state() {
		return "Circle";
	}
	
}

class createRectangle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		panel.setShape((Rectangle) factory.getShape("Rectangle", origin, panel.getColour(),panel.getStroke()));
		panel.getModel().addShape(panel.getShape());
		if (StyleFlag){
			panel.getShape().changedIsFilled();
		}

	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
	}

	public void drag(PaintPanel panel, MouseEvent e) {
		Point end = new Point(e.getX(), e.getY());
		Rectangle rectangle = (Rectangle)panel.getShape();
		rectangle.setEnd(end);
		rectangle.setWidth(Math.abs(end.getX()-panel.getShape().getOrigin().getX()));
		rectangle.setHeight(Math.abs(end.getY()-panel.getShape().getOrigin().getY()));
		
	}

	public String state() {
		return "Rectangle";
	}
	
}

class createSquare implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		panel.setShape((Square)factory.getShape("Square", origin, panel.getColour(),panel.getStroke()));
		panel.getModel().addShape(panel.getShape());
		
		
		if (StyleFlag){
			panel.getShape().changedIsFilled();
		}
	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
	}

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
	
	public String state() {
		return "Square";
	}
}

