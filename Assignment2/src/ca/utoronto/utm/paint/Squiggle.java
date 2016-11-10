package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * When you click on the mouse and drag, it is like drawing with a pencil. 
 * When you un-click (let go of the button), it is like lifting your pencil from the paper.
 * 
 */
public class Squiggle extends Shape {
	
	/**
	 * A Squiggle has many small lines that are connected by many points.
	 * These are points are stored in an ArrayList of Points
	 */
	private ArrayList<Point> squiggle = new ArrayList<Point>();

	
	/**
	 * Creates a new Squiggle with the given origin, colour and stroke
	 * @param origin the Starting Point of the Squiggle 
	 * @param colour the colour of the Squiggle
	 * @param newStroke the line thickness when drawing a Squiggle
	 */
	public Squiggle( Point origin ,Color colour,BasicStroke newStroke){
		super(origin,colour,newStroke);		
	}
	
	/**
	 * adds a new Point to a Squiggle
	 * @param p
	 */
	public void addPoint(Point p){
		squiggle.add(p);
	}
	
	/**
	 * 
	 * @return the ArrayList of Points of the Squiggle
	 */
	public ArrayList<Point> getPoints(){
		return squiggle;
	}

	@Override
	/**
	 * Draw a Squiggle.
	 * When you click on the mouse and drag, it is like drawing with a pencil.
	 * When you un-click (let go of the button), it is like lifting your pencil from the paper. 
	 */
	public void draw(Graphics2D g2d) {
		for(int i=0;i<squiggle.size()-1; i++){
			Point p1=squiggle.get(i);
			Point p2=squiggle.get(i+1);
			g2d.setColor(this.getShapeColour());
			g2d.setStroke(this.getShapeStroke());
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
		
	}	

}
