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
	
	private ArrayList<Point> squiggle = new ArrayList<Point>();

	public Squiggle( Point origin ,Color colour,BasicStroke newStroke){
		super(origin,colour,newStroke);		
	}

	public void addPoint(Point p){
		squiggle.add(p);
	}
	
	public ArrayList<Point> getPoints(){
		return squiggle;
	}

	@Override
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
