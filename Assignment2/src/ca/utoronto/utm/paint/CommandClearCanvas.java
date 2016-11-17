package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Command for clearing the canvas
 * @author Keenan
 *
 */
public class CommandClearCanvas implements DrawingCommand{
	
	private Rectangle coverRectangle;

	//the program allows the user to draw off of the panel, which can be seen after expanding the window
	//MAXSIDE is large enough to make sure that the entire canvas will be cleared on all reasonable window sizes
	private static final int MAXSIDE = 9999;
	
	/**
	 * Constructor for a clear canvas command
	 * Creates the large, white, filled rectangle to be drawn on top of the canvas
	 */
	public CommandClearCanvas(){
		
		this.coverRectangle = new Rectangle(new Point (0,0));
		this.coverRectangle.setEnd(new Point(MAXSIDE,MAXSIDE));
		this.coverRectangle.setHeight(MAXSIDE);
		this.coverRectangle.setWidth(MAXSIDE);
		this.coverRectangle.setIsFilled(true);
	}
	
	/**
	 * Draw the filled rectangle on the canvas
	 */
	@Override
	public void execute(Graphics2D g2d) {
		int x = this.coverRectangle.getOrigin().getX();
		int y = this.coverRectangle.getOrigin().getY();
		int width = this.coverRectangle.getWidth();
		int height = this.coverRectangle.getHeight();
		g2d.fillRect(x, y, width, height);
		
	}

}
