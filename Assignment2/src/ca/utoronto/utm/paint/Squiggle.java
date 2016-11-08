package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.awt.Color;

public class Squiggle extends Shape {
	
	private ArrayList<Point> squiggle = new ArrayList<Point>();
	
	public Squiggle() {
		super();
	}
	
	public Squiggle(ArrayList<Point> scribble, Point origin ,Color colour){
		super(origin,colour);
		squiggle = scribble;		
	}

	public void addPoint(Point p){
		squiggle.add(p);
	}
	
	public ArrayList<Point> getPoints(){
		return squiggle;
	}	

}
