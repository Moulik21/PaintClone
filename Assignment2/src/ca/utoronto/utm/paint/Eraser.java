package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * When you click on the mouse and drag, it is like drawing with a pencil. 
 * When you un-click (let go of the button), it is like lifting your pencil from the paper.
 * 
 */
public class Eraser extends Shape implements DrawingCommand{
	
	/**
	 * A Eraser has many small lines that are connected by many points.
	 * These are points are stored in an ArrayList of Points
	 */
	private ArrayList<Point> squiggle = new ArrayList<Point>();

	
	/**
	 * Creates a new Eraser with the given origin, colour and stroke
	 * @param origin the Starting Point of the Eraser
	 */
	public Eraser( Point origin){
		super(origin);		
	}
	
	/**
	 * adds a new Point to a Eraser
	 * @param p
	 */
	public void addPoint(Point p){
		squiggle.add(p);
	}
	
	/**
	 * 
	 * @return the ArrayList of Points of the Eraser
	 */
	public ArrayList<Point> getPoints(){
		return squiggle;
	}

	@Override
	/**
	 * Draw a Eraser by executing the code below.
	 * When you click on the mouse and drag, it is like drawing with a pencil.
	 * When you un-click (let go of the button), it is like lifting your pencil from the paper. 
	 */
	public void execute(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		for(int i=0;i<squiggle.size()-1; i++){
			Point p1=squiggle.get(i);
			Point p2=squiggle.get(i+1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
		
	}	

}