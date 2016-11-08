package ca.utoronto.utm.paint;

public class Square extends Rectangle {
	private Point origin;
	private Point end;
	private int side;
	
	public Square(){
		super();
	}
	
	public Square(Point origin, Point end, int side){
		super(origin,end,side,side);
	}

	public void setSide(int side) {
		super.setHeight(side);
		super.setWidth(side);
	}

}