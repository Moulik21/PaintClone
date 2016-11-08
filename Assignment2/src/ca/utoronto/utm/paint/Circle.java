package ca.utoronto.utm.paint;

public class Circle extends Shape {
	private int radius;
	
	public Circle(){
		super();
		this.radius = 0;
	}
	
	public Circle(Point centre, int radius){
		super(centre);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
