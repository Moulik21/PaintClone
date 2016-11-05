package ca.utoronto.utm.paint;

public class Rectangle {

	private Point origin;
	private Point end;
	private int width;
	private int height;
	
	public Rectangle(Point origin, Point end, int width, int height){
		this.origin = origin;
		this.end = end;
		this.width = width;
		this.height = height;
	}

	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
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