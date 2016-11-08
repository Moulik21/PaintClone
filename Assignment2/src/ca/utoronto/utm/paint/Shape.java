package ca.utoronto.utm.paint;

public class Shape {
	private Point origin;
	
	public Shape(){
		this.origin = new Point(0,0);
	}
	
	public Shape(Point origin){
		this.origin = origin;
	}
	
	public Point getOrigin(){
		return this.origin;
	}
	
	public void setOrigin(Point new_origin){
		this.origin = new_origin;
	}
}
