package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;

public class PolyLine extends Squiggle{
	private ArrayList<Point> polyline = new ArrayList<Point>();
	private boolean first_click;
	
	public PolyLine(Point origin, Color color){
		super(origin, color);
//		this.first_click = false;
	}
	
//	public boolean getFirstClick(){
//		return this.first_click;
//	}

}
