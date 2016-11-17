package ca.utoronto.utm.paint;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Strategy for creating a circle.
 */
public class CircleManipulatorStrategy implements ShapeManipulatorStrategy {

	/**
	 * Create a circle and add it to the shape list on click.
	 * 
	 * @param panel
	 *            the Panel where the circle will be drawn
	 * @param e
	 * @param StyleFlag
	 *            true if the shape is going to be filled,false otherwise
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		Point centre = new Point(e.getX(), e.getY());
		Circle circle = new Circle(centre);
		circle.setRadius(0);
		panel.setShape(circle);
		panel.getModel().addCommand((DrawingCommand) panel.getShape());
		panel.getShape().setIsFilled(StyleFlag);
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
		// Math for the radius
		int radius = (int) Math
				.sqrt((Math.abs(Math.pow((double) (panel.getShape().getOrigin().getX() - e.getX()), 2.0)))
						+ Math.abs(Math.pow((double) (panel.getShape().getOrigin().getY() - e.getY()), 2.0)));
		Circle circle = (Circle) panel.getShape();
		circle.setRadius(radius);
		panel.repaint();
	}

	/**
	 * @return the string name current strategy being used.
	 */
	public String state() {
		return "Circle";
	}

	// Not used for this strategy
	public void move(PaintPanel panel, MouseEvent e) {
	}

	// Not required for this strategy.
	public void keyPress(PaintPanel paintPanel, KeyEvent e) {
	}

}
