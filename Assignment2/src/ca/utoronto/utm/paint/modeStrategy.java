package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public interface modeStrategy {
	void press(PaintPanel panel, MouseEvent e);
	void release(PaintPanel panel, MouseEvent e);
	void drag(PaintPanel panel, MouseEvent e);
}

class createSquiggle implements modeStrategy{

	public void press(PaintPanel panel, MouseEvent e) {
		return;
	}

	public void release(PaintPanel panel, MouseEvent e) {
		return;
	}

	public void drag(PaintPanel panel, MouseEvent e) {
		panel.getModel().addPoint(new Point(e.getX(), e.getY()));
	}
}

class createCircle implements modeStrategy{

	public void press(PaintPanel panel, MouseEvent e) {
		Point centre = new Point(e.getX(), e.getY());
		int radius = 0;
		panel.setPoint(centre);
		panel.setCircle(new Circle(centre, 0));
		panel.getModel().addCircle(panel.getCircle());
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
}

class createRectangle implements modeStrategy{

	public void press(PaintPanel panel, MouseEvent e) {
		Point origin = new Point(e.getX(), e.getY());
		panel.setPoint(origin);
		panel.setRectangle(new Rectangle(origin, origin, 0, 0));
		panel.getModel().addRectangle(panel.getRectangle());
		
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
}

class createSquare implements modeStrategy{

	public void press(PaintPanel panel, MouseEvent e) {
		Point origin = new Point(e.getX(), e.getY());
		panel.setSquare(new Square(origin, origin, 0));
		panel.getModel().addSquare(panel.getSquare());
		
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
		//essentially width & height of the square the user wanted to create
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
}