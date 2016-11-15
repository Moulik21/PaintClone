package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
/**
 * Strategy Class. Various strategy for different shapes.
 * @author Pineapple
 *
 */
public interface ShapeManipulatorStrategy {
	String state ();
	void press(PaintPanel panel, MouseEvent e, boolean StyleFlag);
	void release(PaintPanel panel, MouseEvent e);
	void drag(PaintPanel panel, MouseEvent e);
	void move(PaintPanel panel, MouseEvent e);


}//end class

