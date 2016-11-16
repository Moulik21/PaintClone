package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Command for clearing the canvas
 * @author Keenan
 *
 */
public class CommandClearCanvas implements DrawingCommand{
	private PaintPanel panel;
	private Rectangle coverRectangle;
	private Color previousColour;
	private static final int MAXSIDE = 9999;
	
	public CommandClearCanvas(PaintPanel panel){
		this.panel = panel;
		this.coverRectangle = new Rectangle(new Point (0,0));
		this.coverRectangle.setEnd(new Point(MAXSIDE,MAXSIDE));
		this.coverRectangle.setHeight(MAXSIDE);
		this.coverRectangle.setWidth(MAXSIDE);
		this.coverRectangle.setIsFilled(true);
		this.previousColour = panel.getColour();

		panel.getModel().addCommand(new CommandColor(this.panel,Color.WHITE));
		panel.getModel().addCommand((DrawingCommand)this.coverRectangle);
	    panel.getModel().addCommand(new CommandColor(this.panel,this.previousColour));
	}
	@Override
	public void execute(Graphics2D g2d) {
		int x = this.coverRectangle.getOrigin().getX();
		int y = this.coverRectangle.getOrigin().getY();
		int width = this.coverRectangle.getWidth();
		int height = this.coverRectangle.getHeight();
		g2d.fillRect(x, y, width, height);
		
	}

}
