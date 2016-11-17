package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

/**
 * Strategy Class. Various strategy for different shapes.
 * 
 * @author Pineapple
 *
 */
public interface ShapeManipulatorStrategy {
	/**
	 * @return the string name current strategy being used.
	 */
	public String state();

	/**
	 * Create the shape and add it to the shape list on click.
	 * 
	 * @param panel
	 *            the Panel where the shape will be drawn
	 * @param e
	 * @param StyleFlag
	 *            true if the shape is going to be filled,false otherwise
	 */
	void press(PaintPanel panel, MouseEvent e, boolean StyleFlag);

	/**
	 * Reset the shape variable to create new shapes later. Or other
	 * implementation depending on the nature of the shape.
	 * 
	 * @param panel
	 * @param e
	 */
	void release(PaintPanel panel, MouseEvent e);

	/**
	 * Create a preview for the user before they commit drawing. Or other
	 * implementation depending on the nature of the shape.
	 * 
	 * @param panel
	 * @param e
	 */
	void drag(PaintPanel panel, MouseEvent e);

	/**
	 * Preview so that the user can see how their lines will be drawn before
	 * committing.Or other implementation depending on the nature of the shape.
	 * 
	 * @param panel
	 * @param e
	 */
	void move(PaintPanel panel, MouseEvent e);
	
	/**
	 * Used for a typing command.
	 * @param paintPanel
	 * @param e
	 */
	void keyPress(PaintPanel paintPanel, KeyEvent e);

}// end class
