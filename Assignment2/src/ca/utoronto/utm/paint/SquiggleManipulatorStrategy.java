package ca.utoronto.utm.paint;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Strategy for Squiggle
 * @author Pineapple
 *
 */
public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy{

	/**
	 * Create the shape and add it to the shape list on click.
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		Point origin = new Point(e.getX(),e.getY());
		Squiggle squiggle = new Squiggle(origin);
		squiggle.addPoint(origin);
		panel.setShape(squiggle);
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
		panel.repaint();
	}
	/**
	 * Return the strategy that the class is currently is using.
	 */
	public String state() {
		return "Squiggle";
	}

	//Not needed for this strategy.
	public void move(PaintPanel panel, MouseEvent e) {}
	@Override
	public void keyPress(PaintPanel paintPanel, KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
