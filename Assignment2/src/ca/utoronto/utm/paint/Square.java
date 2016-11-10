package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;

public class Square extends Rectangle {
	private Point origin;
	private Point end;
	private int side;

	public Square(Point origin, Color newColour){
		super(origin,newColour);
	}

	public void setSide(int side) {
		super.setHeight(side);
		super.setWidth(side);
	}
	
	public void draw(Graphics2D g2d){
		int side = this.getHeight();
		int x,y;
		
		//Cases for where the top left coordinates of the square will start based on if the user is trying to drag to the right or left and up or down
		if (this.getOrigin().getX() < this.getEnd().getX()) {
			x = this.getOrigin().getX();
		}
		else {
			x = this.getOrigin().getX() - this.getHeight();
		}
		if (this.getOrigin().getY() < this.getEnd().getY()) {
			y = this.getOrigin().getY();
		}
		else {
			y = this.getOrigin().getY() - this.getHeight();
		}
		g2d.setColor(this.getShapeColour());
		if (this.getIsFilled()){
			g2d.drawRect(x, y, side, side);
		}
		else{
			g2d.fillRect(x, y, side, side);
		}
	}

}