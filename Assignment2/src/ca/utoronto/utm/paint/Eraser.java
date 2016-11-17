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
	private ArrayList<Point> eraser = new ArrayList<Point>();

	
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
		eraser.add(p);
	}
	
	/**
	 * 
	 * @return the ArrayList of Points of the Eraser
	 */
	public ArrayList<Point> getPoints(){
		return eraser;
	}

	@Override
	/**
	 * Draw a Eraser by executing the code below.
	 * When you click on the mouse and drag, it is like drawing with a pencil.
	 * When you un-click (let go of the button), it is like lifting your pencil from the paper. 
	 */
	public void execute(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		
		if (eraser.size() == 1) {
			Point p1=eraser.get(0);
			g2d.drawLine(p1.getX(), p1.getY(), p1.getX(), p1.getY());
		}
		else {
			for(int i=0;i<eraser.size()-1; i++){
				Point p1=eraser.get(i);
				Point p2=eraser.get(i+1);
				g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
		}
		
	}	

}