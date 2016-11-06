package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	private int i=0;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	private Circle circle; // the circle we are building
	private Rectangle rectangle;
	private Square square;
	private Point point;
	
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.mode="Circle"; // bad code here?
		this.model = model;
		this.model.addObserver(this);
		this.view=view;
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue); 
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.black);

		// Draw Lines
		ArrayList<Point> points = this.model.getPoints();
		for(int i=0;i<points.size()-1; i++){
			Point p1=points.get(i);
			Point p2=points.get(i+1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
		
		// Draw Circles
		ArrayList<Circle> circles = this.model.getCircles();
		for(Circle c: this.model.getCircles()){
			int radius = c.getRadius();
			int x = (c.getCentre().getX()-radius);
			int y = (c.getCentre().getY()-radius);
			g2d.drawOval(x, y, radius*2, radius*2);
		}
		
		// Draw Rectangles
		ArrayList<Rectangle> rectangles = this.model.getRectangles();
		for(Rectangle r: this.model.getRectangles()){
			int width = r.getWidth();
			int height = r.getHeight();
			int x,y;
			
			//Cases for where the top left coordinates of the rectangle will start based on if the user is trying to drag to the right or left and up or down
			if (r.getOrigin().getX() < r.getEnd().getX()) {
				x = r.getOrigin().getX();
			}
			else {
				x = r.getEnd().getX();
			}
			if (r.getOrigin().getY() < r.getEnd().getY()) {
				y = r.getOrigin().getY();
			}
			else {
				y = r.getEnd().getY();
			}
			g2d.drawRect(x, y, width, height);
		}
		
		// Draw Squares
		ArrayList<Square> square = this.model.getSquares();
		for(Square s: this.model.getSquares()){
			int side = s.getSide();
			int x,y;
			
			//Cases for where the top left coordinates of the square will start based on if the user is trying to drag to the right or left and up or down
			if (s.getOrigin().getX() < s.getEnd().getX()) {
				x = s.getOrigin().getX();
			}
			else {
				x = s.getOrigin().getX() - s.getSide();
			}
			if (s.getOrigin().getY() < s.getEnd().getY()) {
				y = s.getOrigin().getY();
			}
			else {
				y = s.getOrigin().getY() - s.getSide();
			}
			g2d.drawRect(x, y, side, side);
		}
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this
	 */
	public void setMode(String mode){
		this.mode=mode;
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.mode=="Circle"){
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.mode=="Squiggle"){
			this.model.addPoint(new Point(e.getX(), e.getY()));
		} 
		else if(this.mode=="Circle"){
				int radius = (int) Math.sqrt((Math.abs(Math.pow((double)(this.circle.getCentre().getX()-e.getX()), 2.0)))+Math.abs(Math.pow((double)(this.circle.getCentre().getY()-e.getY()), 2.0)));
				this.circle.setRadius(radius);
				this.repaint();
		}
		
		else if (this.mode=="Rectangle"){
			
			Point end = new Point(e.getX(), e.getY());
			this.rectangle.setEnd(end);
			this.rectangle.setWidth(Math.abs(end.getX()-this.rectangle.getOrigin().getX()));
			this.rectangle.setHeight(Math.abs(end.getY()-this.rectangle.getOrigin().getY()));
			this.repaint();
		}
		else if (this.mode == "Square"){
			Point end = new Point(e.getX(), e.getY());
			this.square.setEnd(end);
			
			int xDifference, yDifference; 
			//essentially width & height of the square the user wanted to create
			xDifference = Math.abs(end.getX() - this.square.getOrigin().getX());
			yDifference = Math.abs(end.getY() - this.square.getOrigin().getY());
			
			//the square will be drawn based on the smaller of width & height
			if(xDifference<yDifference) {
				this.square.setSide(xDifference);
			}
			else {
				this.square.setSide(yDifference);
			}
			this.repaint();
			
		}

	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			// Problematic notion of radius and centre!!
			Point centre = new Point(e.getX(), e.getY());
			int radius = 0;
			this.point= centre;
			this.circle=new Circle(centre, 0);
			this.model.addCircle(this.circle);
		} 
		else if(this.mode=="Rectangle"){
			Point origin = new Point(e.getX(), e.getY());
			this.point= origin;
			this.rectangle =new Rectangle(origin, origin, 0, 0);
			this.model.addRectangle(this.rectangle);
		}
		else if(this.mode=="Square"){
			Point origin = new Point(e.getX(), e.getY());
			this.square = new Square(origin, origin, 0);
			this.model.addSquare(this.square);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} 
		else if(this.mode=="Circle"){
			if(this.circle!=null){
				this.circle=null;
			}
		}
		else if(this.mode=="Rectangle"){
			if(this.rectangle!=null){
				this.rectangle=null;
			}
		}
		else if(this.mode=="Square"){
			if(this.square!=null){
				this.square=null;
			}
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}
	}
}
