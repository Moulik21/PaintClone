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
/**
 * The secondary View+Controller that allows the user to draw
 *
 */
class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {

	// Instance variables
	private final Color DEFAULTCOLOUR = Color.black;
	private final BasicStroke DEFAULTSTROKE = new BasicStroke(1);
	private final modeStrategy DEFAULTMODE = new createSquiggle();
	private final boolean DEFAULTFILL = true;
	
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	
	private modeStrategy mode = DEFAULTMODE;
	private Color newColour = DEFAULTCOLOUR;
	private BasicStroke stroke = DEFAULTSTROKE;
	private boolean FillMode = DEFAULTFILL;
	
	private String state;
	private shapeFactory factory;
	private Shape shape;
	private Point origin_point; // <---- Find out what this value actually does

	/**
	 * Creates a new PaintPanel
	 * 
	 * @param model
	 *            a PaintModel
	 * @param view
	 *            the view+controller of the Paint application
	 */
	public PaintPanel(PaintModel model, View view) {
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300, 300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.model = model;
		this.model.addObserver(this);
		this.view=view;
		this.factory = new shapeFactory();
		
		this.model.addCommand(new CommandFill(this,DEFAULTFILL));
		this.model.addCommand(new CommandColor(this, DEFAULTCOLOUR));
		this.model.addCommand(new CommandStroke(this, DEFAULTSTROKE));
	}

	/**
	 * View aspect of PaintPanel Draws each shapes in the panel
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		super.paintComponent(g); // paint background
		Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue);
		// Origin is at the top left of the window 50 over, 75 down

		for (DrawingCommand command : this.model.getCommands()) {
			command.execute(g2d);
			
			g2d.setColor(this.newColour);
			g2d.setStroke(this.stroke);
		}
		g2d.dispose();
	}

	@Override
	/**
	 * Updates the panel by re-drawing everything on the panel. This method is
	 * called when where is a change in the model
	 */
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}

	// Controller aspect of PaintPanel
	/**
	 * Sets the current mode to be the shape that is going to be drawn next
	 * 
	 * @param current_mode
	 */
	public void setMode(String current_mode) {
		if (current_mode == "Squiggle") {
			this.mode = new createSquiggle();
		}
		else if (current_mode =="Polyline"){
			this.mode = new createPolyline();
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
	
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
	if(this.mode.state() == "Polyline" ){
		this.mode.move(this,e);
	}
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
		this.origin_point = new Point(e.getX(), e.getY());
		this.mode.press(this,e,this.FillMode, this.factory, this.origin_point);
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
	//Getters and Setters
	public void setColour(Color newColour){
		this.newColour=newColour;
	}
	public Color getColour(){
		return newColour;
	}
	public void setShape(Shape shape){
		this.shape = shape;
	}
	public Shape getShape(){
		return this.shape;
	}
	public void changeFillMode (boolean mode){
		this.FillMode = mode;
	}
	public boolean getFillMode(){
		return this.FillMode;
	}
	public PaintModel getModel(){
		return this.model;
	}
	public void setStroke(BasicStroke newStroke){
		this.stroke = newStroke;
	}
	public BasicStroke getStroke(){
		return this.stroke;
	}
}
