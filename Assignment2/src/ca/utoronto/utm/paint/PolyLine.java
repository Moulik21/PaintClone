package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class PolyLine extends Squiggle{
	private ArrayList<Integer> x = new ArrayList<Integer>();
	private ArrayList<Integer> y = new ArrayList<Integer>();
	
	public PolyLine(Point origin){
		super(origin);


	}
	
	/**
	 * Adds the coordinates to their respective arrayList
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void addPoint(Integer x,Integer y){
		this.x.add(x);
		this.y.add(y);

		
	}
	
	/**
	 * Removes the last point from the x and y arraylist.
	 */
	public void removePoint(){
		if (x.size()>1){
			x.remove(x.size() - 1);
			y.remove(y.size() - 1);
		}
	}
	
	/**
	 * 
	 * @return Array list of x coordinates
	 */
	public ArrayList<Integer> getX(){
		return this.x;
	}
	
	/**
	 * 
	 * @return ArrayList of y coordinates
	 */
	public ArrayList<Integer> getY(){
		return this.y;
	}
	
	/**
	 * Execute the code below to draw polylines.
	 */
	@Override
	public void execute(Graphics2D g2d) {
		for(int i=0;i<x.size()-1; i++){
			g2d.drawLine(x.get(i), y.get(i), x.get(i+1), y.get(i+1));
		}
	}
		
	
	

}
