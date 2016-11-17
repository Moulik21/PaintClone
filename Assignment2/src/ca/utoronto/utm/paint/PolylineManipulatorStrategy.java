package ca.utoronto.utm.paint;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

/**
 * Strategy for creating a polyline.
 */
public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy {

	/**
	 * Depending on which mousebutton was used, the polyline will either
	 * continue to create the shape or stop by drawing back to the origin point.
	 * 
	 * @param panel
	 *            the Panel where the polyline will be drawn
	 * @param e
	 * @param StyleFlag
	 *            true if the shape is going to be filled,false otherwise
	 * 
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		// If no shape exist, create a new one. Avoid null pointer.
		Point origin = new Point(e.getX(), e.getY());
		if (panel.getShape() == null) {
			PolyLine polyline = new PolyLine(origin);
			polyline.addPoint(origin);
			polyline.addPoint(origin);
			panel.setShape(polyline);
			panel.getModel().addCommand((DrawingCommand) panel.getShape());
		}
		PolyLine polyline = (PolyLine) panel.getShape();
		panel.getShape().setIsFilled(StyleFlag);

		// If left click, only add the point where the user has clicked
		if (SwingUtilities.isLeftMouseButton(e)) {
			polyline.addPoint(e.getX(), e.getY());
		}
		// If right click, end the shape by drawing back to the origin point
		else if (SwingUtilities.isRightMouseButton(e)) {
			int originX = polyline.getX().get(0);
			int originY = polyline.getY().get(0);
			polyline.removePoint();
			polyline.addPoint(originX, originY);
			panel.setShape(null);
			panel.repaint();
		}
	}

	/**
	 * Preview so that the user can see how their lines will be drawn before
	 * committing.
	 * 
	 * @param panel
	 * @param e
	 */
	public void move(PaintPanel panel, MouseEvent e) {
		if (panel.getShape() != null) {
			PolyLine polyline = (PolyLine) panel.getShape();
			polyline.removePoint();
			polyline.addPoint(e.getX(), e.getY());
			panel.repaint();

		}
	}

	public void drag(PaintPanel panel, MouseEvent e) {
	}

	/**
	 * Return the strategy that the class is currently is using.
	 */
	public String state() {
		return "Polyline";
	}

	// Not required for this strategy.
	public void keyPress(PaintPanel paintPanel, KeyEvent e) {
	}

	// Not needed for this strategy.
	public void release(PaintPanel panel, MouseEvent e) {
	}

}
