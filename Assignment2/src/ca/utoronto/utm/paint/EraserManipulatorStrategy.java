package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class EraserManipulatorStrategy implements ShapeManipulatorStrategy{
	/**
	 * Create the shape and add it to the shape list on click.
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		//If no shape exist, create a new one. Avoid null pointer.
		Point origin = new Point(e.getX(),e.getY());
		Eraser eraser = new Eraser(origin);
		eraser.addPoint(origin);
		panel.setShape(eraser);
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
		Eraser eraser =(Eraser) panel.getShape();
		eraser.addPoint(p);
		panel.repaint();
	}

	//Not needed for this strategy.
	public void move(PaintPanel panel, MouseEvent e) {}
	
	/**
	 * Return the strategy that the class is currently is using.
	 */
	public String state() {
		return "Eraser";
	}
}

