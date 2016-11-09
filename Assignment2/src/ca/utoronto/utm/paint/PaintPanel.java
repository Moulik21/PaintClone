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

	private final Color DEFAULTCOLOUR = Color.black; 
	private final modeStrategy DEFAULTMODE = new createSquiggle();
	
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	
	private String state;
	private modeStrategy mode = DEFAULTMODE;
	private Color newColour = DEFAULTCOLOUR;
	
	private Circle circle; // the circle we are building
	private Rectangle rectangle;
	private Square square;
	private Squiggle squiggle;
	private Point point; //<---- Find out what this value actually does
	
	
	private modeStrategy drawLine, drawCircle, drawRectangle, drawSquare;
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.model = model;
		this.model.addObserver(this);
		this.view=view;
		
		this.drawLine = new createSquiggle();
		this.drawCircle = new createCircle();
		this.drawRectangle = new createRectangle();
		this.drawSquare = new createSquare();
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

		this.drawLine.draw(this, g2d);
		this.drawCircle.draw(this, g2d);
		this.drawRectangle.draw(this, g2d);
		this.drawSquare.draw(this, g2d);
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
			this.mode = new createSquiggle();
		}
		else if (current_mode == "Circle"){
			this.mode = new createCircle();
		}
		else if (current_mode == "Rectangle"){
			this.mode = new createRectangle();
		}
		else if (current_mode == "Square"){
			this.mode= new createSquare();
		}
		this.state = current_mode;
	}
	
	public void setColour(Color newColour){
		this.newColour=newColour;
	}
	
	public Color getColour(){
		return newColour;
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

		this.mode.press(this,e,this.view.getStyleSelector().getFlag());
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
	public void setSquiggle(Squiggle squiggle){
		this.squiggle = squiggle;
	}
	public Squiggle getSquiggle(){
		return this.squiggle;
	}
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
