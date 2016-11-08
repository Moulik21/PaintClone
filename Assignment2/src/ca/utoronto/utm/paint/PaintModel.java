package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	private ArrayList<Squiggle> squiggles=new ArrayList<Squiggle>();
	private ArrayList<Circle> circles=new ArrayList<Circle>();
	private ArrayList<Rectangle> rectangles=new ArrayList<Rectangle>();
	private ArrayList<Square> squares=new ArrayList<Square>();
	
	public void addSquiggle(Squiggle s){
		this.squiggles.add(s);		
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Squiggle> getSquiggles(){
		return squiggles;
	}
	
	public void addCircle(Circle c){
		this.circles.add(c);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Circle> getCircles(){
		return circles;
	}
	
	public void addRectangle(Rectangle r){
		this.rectangles.add(r);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Rectangle> getRectangles(){
		return rectangles;
	}
	
	public void addSquare(Square s){
		this.squares.add(s);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Square> getSquares(){
		return squares;
	}

}
