package ca.utoronto.utm.paint;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Strategy for creating a line.
 */
public class StraightLineManipulatorStrategy implements ShapeManipulatorStrategy {

	/**
	 * Create a line and add it to the shape list on click.
	 * 
	 * @param panel
	 *            the Panel where the line will be drawn
	 * @param e
	 * @param StyleFlag
	 *            true if the shape is going to be filled,false otherwise
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		Point origin = new Point(e.getX(), e.getY());
		StraightLine straightLine = new StraightLine(origin);
		straightLine.setEndPoint(origin);
		panel.setShape(straightLine);
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
		StraightLine line = (StraightLine) panel.getShape();
		line.setEndPoint(p);
		panel.repaint();
	}

	/**
	 * @return the string name current strategy being used.
	 */
	public String state() {
		return "StraightLine";
	}

	// Not used for this strategy
	public void move(PaintPanel panel, MouseEvent e) {
	}

	// Not required for this strategy.
	public void keyPress(PaintPanel paintPanel, KeyEvent e) {
	}

}
