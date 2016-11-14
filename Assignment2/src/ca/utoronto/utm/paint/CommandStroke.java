package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

/**
 * Command for changing to different stroke
 * @author Pineapple
 *
 */
public class CommandStroke implements DrawingCommand{
	
	private PaintPanel panel;
	private BasicStroke stroke;
	
	public CommandStroke(PaintPanel panel, Object o){
		this.panel = panel;
		this.stroke = (BasicStroke)o;
	}
	@Override
	public void execute(Graphics2D g2d) {
		this.panel.setStroke(this.stroke);
		
	}

}
