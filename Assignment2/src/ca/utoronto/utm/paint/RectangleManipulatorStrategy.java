package ca.utoronto.utm.paint;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
/**
 * Strategy for creating a rectangle.
 */
public class RectangleManipulatorStrategy implements ShapeManipulatorStrategy {
	/**
	 * Create rectangles and add it to shape list on click.
	 */
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag) {
		Point origin = new Point(e.getX(), e.getY());		
		Rectangle rectangle = new Rectangle(origin);
		rectangle.setEnd(origin);
		rectangle.setHeight(0);
		rectangle.setWidth(0);
		panel.setShape(rectangle);
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
		panel.repaint();
	}
	/**
	 * Returns the current strategy that is being used.
	 */
	public String state() {
		return "Rectangle";
	}

	//Not required for this strategy.
	public void move(PaintPanel panel, MouseEvent e) {}

	@Override
	public void keyPress(PaintPanel paintPanel, KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
