package ca.utoronto.utm.paint;

public class Rectangle extends Shape{

	private Point origin;
	private Point end;
	private int width;
	private int height;
	
	public Rectangle(){
		super();
		this.end = new Point(0,0);
		this.width = 0;
		this.height= 0;
	}
	
	public Rectangle(Point origin, Point end, int width, int height){
		super(origin);
		this.end = end;
		this.width = width;
		this.height = height;
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

}