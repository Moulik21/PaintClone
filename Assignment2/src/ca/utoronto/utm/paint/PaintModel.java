package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;
/**
 * A PaintModel consists of 5 shapes. However, any type of Shape can be added to a PaintModel. 
 * The 5 shapes are Circle, Rectangle, Square, Squiggle, and Polyline.
 */
public class PaintModel extends Observable {
	/**
	 * The Shapes are stored in an ArrayList of Shapes
	 */
	private ArrayList<Shape> shapes=new ArrayList<Shape>();
	
	/**
	 * Adds the Shape to the array list of shapes in PaintModel
	 * @param s the shape that is to be added
	 */
	public void addShape(Shape s){
		this.shapes.add(s);		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * 
	 * @return the ArrayList of shapes
	 */
	public ArrayList<Shape> getShape(){
		return shapes;
	}

}
