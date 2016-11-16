package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Observable;
/**
 * Command for switching color
 * @author Pineapple
 *
 */
public class CommandColor extends Observable implements DrawingCommand{
	private PaintPanel panel;
	private Color color;
	
	public CommandColor(PaintPanel panel, Object o){
		this.panel = panel;
		this.color = (Color)o;
	}
	@Override
	public void execute(Graphics2D g2d) {
		this.panel.setColour(this.color);
		
		//update the current colour indicator
		this.setChanged();
		this.notifyObservers();
		
	}

}
