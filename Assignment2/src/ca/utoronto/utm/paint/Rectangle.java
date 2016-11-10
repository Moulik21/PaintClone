package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends Shape{

	private Point origin;
	private Point end;
	private int width;
	private int height;
	
	public Rectangle(Point origin,Color newColour, BasicStroke newStroke){
		super(origin, newColour, newStroke);
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void draw(Graphics2D g2d) {
		int width = this.getWidth();
		int height = this.getHeight();
		int x,y;
		
		//Cases for where the top left coordinates of the rectangle will start based on if the user is trying to drag to the right or left and up or down
		if (this.getOrigin().getX() < this.getEnd().getX()) {
			x = this.getOrigin().getX();
		}
		else {
			x = this.getEnd().getX();
		}
		if (this.getOrigin().getY() < this.getEnd().getY()) {
			y = this.getOrigin().getY();
		}
		else {
			y = this.getEnd().getY();
		}
		g2d.setColor(this.getShapeColour());
		g2d.setStroke(this.getShapeStroke());
		if (this.getIsFilled()){
			g2d.drawRect(x, y, width, height);
		}
		else{
			g2d.fillRect(x, y, width, height);
		}
		
	}

}