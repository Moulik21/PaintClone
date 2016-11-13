package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;
/**
 * A PaintModel consists of 5 shapes. However, any type of Shape can be added to a PaintModel. 
 * The 5 shapes are Circle, Rectangle, Square, Squiggle, and Polyline.
 */
public class PaintModel extends Observable {
	/**
	 * The Commands are stored in an ArrayList of DrawingCommands
	 */
	private ArrayList<DrawingCommand> commands=new ArrayList<DrawingCommand>();
	
	/**
	 * Adds the command to the command array maintained by the model.
	 * @param s the shape that is to be added
	 */
	public void addCommand(DrawingCommand command){
		this.commands.add(command);		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * 
	 * @return the ArrayList of commands
	 */
	public ArrayList<DrawingCommand> getCommands(){
		return commands;
	}

}
