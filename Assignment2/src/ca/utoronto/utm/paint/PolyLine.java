package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class PolyLine extends Squiggle{
	private ArrayList<Integer> x = new ArrayList<Integer>();
	private ArrayList<Integer> y = new ArrayList<Integer>();
	public PolyLine(Point origin, Color color){
		super(origin, color);


	}
	public void addPoint(Integer x,Integer y){
		this.x.add(x);
		this.y.add(y);

		
	}
	public void removePoint(){
		if (x.size()>1){
			x.remove(x.size() - 1);
			y.remove(y.size() - 1);
		}
	}
	public ArrayList<Integer> getX(){
		return this.x;
	}
	public ArrayList<Integer> getY(){
		return this.y;
	}
	public void draw(Graphics2D g2d) {
		for(int i=0;i<x.size()-1; i++){
			g2d.setColor(this.getShapeColour());
			g2d.drawLine(x.get(i), y.get(i), x.get(i+1), y.get(i+1));
		}
		}
		
	
	

}
