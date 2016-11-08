package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public interface modeStrategy {
	String state ();
	void press(PaintPanel panel, MouseEvent e, boolean StyleFlag);
	void release(PaintPanel panel, MouseEvent e);
	void drag(PaintPanel panel, MouseEvent e);
	void draw(PaintPanel panel, Graphics2D g2d);
}

class createSquiggle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		Point origin = new Point(e.getX(), e.getY());
		ArrayList<Point> points = new ArrayList<Point>();			
		panel.setSquiggle(new Squiggle(points,origin,panel.getColour())) ;
		panel.getSquiggle().addPoint(origin);
		panel.getModel().addSquiggle(panel.getSquiggle());
		
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

	public void draw(PaintPanel panel, Graphics2D g2d) {
		ArrayList<Squiggle> squiggles = panel.getModel().getSquiggles();
		for(Squiggle s: squiggles){
			ArrayList<Point> points = s.getPoints();
			for(int i=0;i<points.size()-1; i++){
				Point p1=points.get(i);
				Point p2=points.get(i+1);
				g2d.setColor(s.getShapeColour());
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
			
		}
		
	}

	public String state() {
		return "Squiggle";
	}
}

class createCircle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag) {
		Point centre = new Point(e.getX(), e.getY());
		panel.setPoint(centre);
		panel.setCircle(new Circle(centre, 0,panel.getColour()));
		panel.getModel().addCircle(panel.getCircle());
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

	public void draw(PaintPanel panel, Graphics2D g2d) {
		for(Circle c: panel.getModel().getCircles()){
			int radius = c.getRadius();
			int x = (c.getOrigin().getX()-radius);
			int y = (c.getOrigin().getY()-radius);
			g2d.setColor(c.getShapeColour());
			if (c.getIsFilled()){
				g2d.drawOval(x, y, radius*2, radius*2);
			}
			else{
				g2d.fillOval(x, y, radius*2, radius*2);
			}
		}
	}
	
	public String state() {
		return "Circle";
	}
	
}

class createRectangle implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag) {
		Point origin = new Point(e.getX(), e.getY());
		panel.setPoint(origin);
		panel.setRectangle(new Rectangle(origin, origin, 0, 0,panel.getColour()));
		panel.getModel().addRectangle(panel.getRectangle());
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

	public void draw(PaintPanel panel, Graphics2D g2d) {
		for(Rectangle r: panel.getModel().getRectangles()){
			int width = r.getWidth();
			int height = r.getHeight();
			int x,y;
			
			//Cases for where the top left coordinates of the rectangle will start based on if the user is trying to drag to the right or left and up or down
			if (r.getOrigin().getX() < r.getEnd().getX()) {
				x = r.getOrigin().getX();
			}
			else {
				x = r.getEnd().getX();
			}
			if (r.getOrigin().getY() < r.getEnd().getY()) {
				y = r.getOrigin().getY();
			}
			else {
				y = r.getEnd().getY();
			}
			g2d.setColor(r.getShapeColour());
			if (r.getIsFilled()){
				g2d.drawRect(x, y, width, height);
			}
			else{
				g2d.fillRect(x, y, width, height);
			}
		}
		
	}
	public String state() {
		return "Rectangle";
	}
	
}

class createSquare implements modeStrategy{
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag) {
		Point origin = new Point(e.getX(), e.getY());
		panel.setSquare(new Square(origin, origin, 0,panel.getColour()));
		panel.getModel().addSquare(panel.getSquare());
		
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
	
	public void draw(PaintPanel panel, Graphics2D g2d) {
		for(Square s: panel.getModel().getSquares()){
			int side = s.getHeight();
			int x,y;
			
			//Cases for where the top left coordinates of the square will start based on if the user is trying to drag to the right or left and up or down
			if (s.getOrigin().getX() < s.getEnd().getX()) {
				x = s.getOrigin().getX();
			}
			else {
				x = s.getOrigin().getX() - s.getHeight();
			}
			if (s.getOrigin().getY() < s.getEnd().getY()) {
				y = s.getOrigin().getY();
			}
			else {
				y = s.getOrigin().getY() - s.getHeight();
			}
			g2d.setColor(s.getShapeColour());
			if (s.getIsFilled()){
				g2d.drawRect(x, y, side, side);
			}
			else{
				g2d.fillRect(x, y, side, side);
			}
		}
		
	}	
	
	public String state() {
		return "Square";
	}
}
