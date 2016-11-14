package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * Command for setting the fill mode
 * @author Pineapple
 *
 */
public class CommandFill implements DrawingCommand {
	private PaintPanel panel;
	private boolean Fillmode;
	public CommandFill(PaintPanel panel, Object o){
		this.panel = panel;
		this.Fillmode = (boolean) o;
	}
	@Override
	public void execute(Graphics2D g2d) {
		this.panel.changeFillMode();
		
	}

}
