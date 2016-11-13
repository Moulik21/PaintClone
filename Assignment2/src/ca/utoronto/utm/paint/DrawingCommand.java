package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * A simple interface for command objects to follow
 * @author Pineapple
 *
 */
public interface DrawingCommand {	
	/**
	 * When commanded, execute a set of code.
	 */
	public void execute(Graphics2D g2d);
	
}
