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

	private modeStrategy mode;
	private Circle circle; // the circle we are building
	private Rectangle rectangle;
	private Square square;
	private Point point; //<---- Find out what this value actually does
	
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
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
			int x = (c.getOrigin().getX()-radius);
			int y = (c.getOrigin().getY()-radius);
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
			int side = s.getHeight();
			int x,y;
			
			//Cases for where the top left coordinates of the square will start based on if the user is trying to drag to the right or left and up or down
			if (s.getOrigin().getX() < s.getEnd().getX()) {
				x = s.getOrigin().getX();
			}
			else {
				x = s.getOrigin().getX() - s.getHeight();
			}
			if (s.getOrigin().getY() < s.getEnd().getY()) {
				y = s.getOrigin().getY();
			}
			else {
				y = s.getOrigin().getY() - s.getHeight();
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

	public void setMode(String current_mode){
		if (current_mode == "Squiggle"){
			mode = new createSquiggle();
		}
		else if (current_mode == "Circle"){
			mode = new createCircle();
		}
		else if (current_mode == "Rectangle"){
			mode = new createRectangle();
		}
		else if (current_mode == "Square"){
			mode= new createSquare();
		}
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		this.mode.drag(this,e);
		this.repaint();
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mousePressed(MouseEvent e) {

		this.mode.press(this,e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		this.mode.release(this, e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	/*-------------------------------------------------------------------------------*/
	//Getters and Setters for the modeStrategy
	
	public void setCircle(Circle circle){
		this.circle = circle;
	}
	public Circle getCircle(){
		return this.circle;
	}
	public void setRectangle(Rectangle rectangle){
		this.rectangle = rectangle;
	}
	public Rectangle getRectangle(){
		return this.rectangle;
	}
	public void setSquare (Square square){
		this.square = square;
	}
	public Square getSquare(){
		return this.square;
	}
	public void setPoint(Point point){
		this.point = point;
	}
	public PaintModel getModel(){
		return this.model;
	}
}
