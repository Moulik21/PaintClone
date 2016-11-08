package ca.utoronto.utm.paint;

import java.awt.Color;

public class Square extends Rectangle {
	private Point origin;
	private Point end;
	private int side;
	
	public Square(){
		super();
	}
	
	public Square(Point origin, Point end, int side, Color newColour){
		super(origin,end,side,side,newColour);
	}

	public void setSide(int side) {
		super.setHeight(side);
		super.setWidth(side);
	}

}