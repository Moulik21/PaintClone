package ca.utoronto.utm.paint;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Strategy for creating an Eraser.
 */
public class EraserManipulatorStrategy implements ShapeManipulatorStrategy {

	/**
	 * Create an eraser and add it to the shape list on click.
	 * 
	 * @param panel
	 *            the Panel where the eraser will be erasing.
	 * @param e
	 * @param StyleFlag
	 *            true if the shape is going to be filled,false otherwise
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		// If no shape exist, create a new one. Avoid null pointer.
		Point origin = new Point(e.getX(), e.getY());
		Eraser eraser = new Eraser(origin);
		eraser.addPoint(origin);
		panel.setShape(eraser);
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
	 * Continue erasing while dragging.
	 * 
	 * @param panel
	 * @param e
	 */
	public void drag(PaintPanel panel, MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		Eraser eraser = (Eraser) panel.getShape();
		eraser.addPoint(p);
		panel.repaint();
	}

	/**
	 * @return the string name current strategy being used.
	 */
	public String state() {
		return "Eraser";
	}

	// Not needed for this strategy.
	public void move(PaintPanel panel, MouseEvent e) {
	}

	// Not required for this strategy.
	public void keyPress(PaintPanel paintPanel, KeyEvent e) {
	}

}
