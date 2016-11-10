package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public interface modeStrategy {
	String state ();
	void press(PaintPanel panel, MouseEvent e, boolean StyleFlag, shapeFactory factory, Point origin);
	void release(PaintPanel panel, MouseEvent e);
	void drag(PaintPanel panel, MouseEvent e);
	void move(PaintPanel panel, MouseEvent e);
}

class createSquiggle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag, shapeFactory factory, Point origin) {

		panel.setSquiggle((Squiggle)factory.getShape("Squiggle", origin, panel.getColour()));
		panel.getModel().addShape(panel.getSquiggle());
		
	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getSquiggle() !=null){
			panel.setSquiggle(null);
		}
	}

	public void drag(PaintPanel panel, MouseEvent e) {
		Point p = new Point(e.getX(),e.getY());
		panel.getSquiggle().addPoint(p);
	}
	
	public String state() {
		return "Squiggle";
	}

	@Override
	public void move(PaintPanel panel, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class createPolyline implements modeStrategy{
	
	
	public String state() {
		// TODO Auto-generated method stub
		return "Polyline";
	}
//----------------------------------------------------------------------------------------------------------------
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag, shapeFactory factory, Point origin) {

		if(panel.getPolyline() == null){
			panel.setPolyline((PolyLine)factory.getShape("Polyline", origin, panel.getColour()));
			panel.getModel().addShape(panel.getPolyline());
	
		}
		if (StyleFlag){
			panel.getPolyline().changedIsFilled();
		}
		if(SwingUtilities.isLeftMouseButton(e)){
				panel.getPolyline().addPoint(e.getX(),e.getY());
		}
		else if(SwingUtilities.isRightMouseButton(e)){
			int originX = panel.getPolyline().getX().get(0);
			int originY = panel.getPolyline().getY().get(0);
			panel.getPolyline().removePoint();
			panel.getPolyline().addPoint(originX,originY);
			panel.setPolyline(null);
			panel.repaint();
		}
	}
	public void move(PaintPanel panel, MouseEvent e){
		if(panel.getPolyline()!=null){
			panel.getPolyline().removePoint();
			panel.getPolyline().addPoint(e.getX(),e.getY());
			panel.repaint();

		}
	}
	public void release(PaintPanel panel, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void drag(PaintPanel panel, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
//------------------------------------------------------------------------------------------------------------------
class createCircle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		Point centre = new Point(e.getX(), e.getY());
		panel.setCircle((Circle)factory.getShape("Circle", centre, panel.getColour()));
		panel.getModel().addShape(panel.getCircle());

		if (StyleFlag){
			panel.getCircle().changedIsFilled();
		}
	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getCircle() !=null){
			panel.setCircle(null);
		}
	}
	
	public void drag(PaintPanel panel, MouseEvent e) {
		int radius = (int) Math.sqrt((Math.abs(Math.pow((double)
				(panel.getCircle().getOrigin().getX()-e.getX()), 2.0)))
				+Math.abs(Math.pow((double)(panel.getCircle().getOrigin().getY()-e.getY()), 2.0)));
		panel.getCircle().setRadius(radius);
	}

	public String state() {
		return "Circle";
	}

	@Override
	public void move(PaintPanel panel, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class createRectangle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		panel.setRectangle((Rectangle) factory.getShape("Rectangle", origin, panel.getColour()));
		panel.getModel().addShape(panel.getRectangle());
		if (StyleFlag){
			panel.getRectangle().changedIsFilled();
		}

	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getRectangle() !=null){
			panel.setRectangle(null);
		}
	}

	public void drag(PaintPanel panel, MouseEvent e) {
		Point end = new Point(e.getX(), e.getY());
		panel.getRectangle().setEnd(end);
		panel.getRectangle().setWidth(Math.abs(end.getX()-panel.getRectangle().getOrigin().getX()));
		panel.getRectangle().setHeight(Math.abs(end.getY()-panel.getRectangle().getOrigin().getY()));
		
	}

	public String state() {
		return "Rectangle";
	}

	@Override
	public void move(PaintPanel panel, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class createSquare implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag, shapeFactory factory, Point origin) {
		panel.setSquare((Square)factory.getShape("Square", origin, panel.getColour()));
		panel.getModel().addShape(panel.getSquare());
		
		
		if (StyleFlag){
			panel.getSquare().changedIsFilled();
		}
	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getSquare() !=null){
			panel.setSquare(null);
		}
	}

	public void drag(PaintPanel panel, MouseEvent e) {
		Point end = new Point(e.getX(), e.getY());
		panel.getSquare().setEnd(end);
		
		int xDifference, yDifference; 
		//essentially width & height of the rectangle the user would have created
		xDifference = Math.abs(end.getX() - panel.getSquare().getOrigin().getX());
		yDifference = Math.abs(end.getY() - panel.getSquare().getOrigin().getY());

		//the square will be drawn based on the bigger of width & height
		if(xDifference<yDifference) {
			panel.getSquare().setSide(xDifference);
		}
		else {
			panel.getSquare().setSide(yDifference);
		}
	
	}
	
	public String state() {
		return "Square";
	}

	@Override
	public void move(PaintPanel panel, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

