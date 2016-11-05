package ca.utoronto.utm.paint;

public class Square {
	private Point origin;
	private Point end;
	private int side;
	
	public Square(Point origin, Point end, int side){
		this.origin = origin;
		this.end = end;
		this.side = side;
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
	
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}