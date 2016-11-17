package ca.utoronto.utm.paint;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Strategy for Squiggle
 *
 */
public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy {

	/**
	 * Create the squiggle and add it to the shape list on click.
	 * 
	 * @param panel
	 *            the Panel where the squiggle will be drawn
	 * @param e
	 * @param StyleFlag
	 *            true if the shape is going to be filled,false otherwise
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		Point origin = new Point(e.getX(), e.getY());
		Squiggle squiggle = new Squiggle(origin);
		squiggle.addPoint(origin);
		panel.setShape(squiggle);
		panel.getModel().addCommand((DrawingCommand) panel.getShape());

	}

	/**
	 * Reset the shape variable to create new shapes later.
	 * 
	 * @param panel
	 * @param e
	 */
	public void release(PaintPanel panel, MouseEvent e) {
		if (panel.getShape() != null) {
			panel.setShape(null);
		}
	}

	/**
	 * Create a preview for the user before they commit drawing.
	 * 
	 * @param panel
	 * @param e
	 */
	public void drag(PaintPanel panel, MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		Squiggle squiggle = (Squiggle) panel.getShape();
		squiggle.addPoint(p);
		panel.repaint();
	}

	/**
	 * @return the string name current strategy being used.
	 */
	public String state() {
		return "Squiggle";
	}

	// Not needed for this strategy.
	public void move(PaintPanel panel, MouseEvent e) {
	}

	// Not needed for this strategy.
	public void keyPress(PaintPanel paintPanel, KeyEvent e) {
	}

}
