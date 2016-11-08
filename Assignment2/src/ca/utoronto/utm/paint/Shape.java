package ca.utoronto.utm.paint;

public class Shape {
	private Point origin;
	private boolean isFilled;
	
	public Shape(){
		this.origin = new Point(0,0);
		this.isFilled = false;
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
	
	public boolean getIsFilled(){
		return isFilled;
	}
	
	public void changedIsFilled(){
		this.isFilled = !this.isFilled;
	}
}
