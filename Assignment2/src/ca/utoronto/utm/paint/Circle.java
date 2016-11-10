package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends Shape {
	private int radius;
	
	public Circle(Point centre, Color newColour){
		super(centre, newColour);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw(Graphics2D g2d) {
		int radius = this.getRadius();
		int x = (this.getOrigin().getX()-radius);
		int y = (this.getOrigin().getY()-radius);
		g2d.setColor(this.getShapeColour());
		if (this.getIsFilled()){
			g2d.drawOval(x, y, radius*2, radius*2);
		}
		else{
			g2d.fillOval(x, y, radius*2, radius*2);
		}

		
	}

}
