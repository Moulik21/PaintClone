package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class PolyLine extends Squiggle{
	private ArrayList<Integer> x = new ArrayList<Integer>();
	private ArrayList<Integer> y = new ArrayList<Integer>();
	private int n;
	private String fill;
	public PolyLine(Point origin, Color color){
		super(origin, color);
		this.fill="no";
		this.n=0;
//		this.first_click = false;
	}
	public void addPoint(Integer x,Integer y){
		this.x.add(x);
		this.y.add(y);
		n++;
		
	}
	public void removePoint(){
		if (x.size()>1){
			x.remove(x.size() - 1);
			y.remove(y.size() - 1);
			n--;
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
	
//	public boolean getFirstClick(){
//		return this.first_click;
//	}

}
