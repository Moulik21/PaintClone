package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

public class StraightLine extends Shape implements DrawingCommand{
	Point endPoint;
	public StraightLine(Point origin) {
		super(origin);
	}

	
	public void setEndPoint(Point point){
		this.endPoint=point;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
			g2d.drawLine(this.getOrigin().getX(),this.getOrigin().getY(),endPoint.getX(),endPoint.getY());
		
	}
		

}
