package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * Strategy for creating a square.
 */
public class SquareManipulatorStrategy implements ShapeManipulatorStrategy {
	/**
	 * Creates a square and adds it to the shape list on click.
	 */
	public void press(PaintPanel panel, MouseEvent e,boolean StyleFlag) {
		Point origin = new Point(e.getX(),e.getY());
		Square square = new Square(origin);
		square.setEnd(origin);
		square.setSide(0);
		panel.setShape(square);
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
		
		panel.repaint();
	
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
