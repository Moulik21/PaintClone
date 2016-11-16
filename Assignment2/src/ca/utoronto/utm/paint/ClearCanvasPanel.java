package ca.utoronto.utm.paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/
/**
 * A ClearCanvasPanel is a JPanel that contains only a single JButton.
 * When the button is clicked, a large white filled rectangle is drawn over the entire canvas of reasonable size (9999x9999 at most)
 * The colour that was active previous to drawing the rectangle is restored after drawing the rectangle
 * This method was taken in order for the user to be able to undo if wanted
 * 
 */
class ClearCanvasPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	JButton clearCanvasButton = new JButton();
	private Color previousColour;
	
	/**
	 * Creates a new ClearCanvasPanel
	 * @param view the view that contains the panel where the user will draw
	 */
	public ClearCanvasPanel(View view) {	
		this.view=view;
		
	 	try {
	    	BufferedImage img = ImageIO.read(getClass().getResource("/icons/clearcanvas.png"));
	    	Image newimg = img.getScaledInstance( 42, 45,  java.awt.Image.SCALE_SMOOTH ) ;  
	    	clearCanvasButton.setIcon(new ImageIcon(newimg));

	 	} catch (IOException ex) {
	  	}
	 	
	 	clearCanvasButton.addActionListener(this);
	 	clearCanvasButton.setBackground(Color.WHITE);
	 	clearCanvasButton.setPreferredSize(new Dimension(60, 60));
	 	clearCanvasButton.setBorder(null);
		
	}
	
	/**
	 * 
	 * @return the JButton that allows the user to clear the canvas
	 */
	public JButton getClearCanvasButton() {
		return this.clearCanvasButton;
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		PaintPanel panel = this.view.getPaintPanel();
		this.previousColour = panel.getColour(); //remember the current active colour
		panel.getModel().addCommand(new CommandColor(panel,Color.WHITE)); //set the colour of the rectangle that will be drawn to white
		panel.getModel().addCommand(new CommandClearCanvas()); //draw the white, filled rectangle
		panel.getModel().addCommand(new CommandColor(panel,this.previousColour)); //set the active colour back to the one that was active before the rectangle was drawn
		System.out.println(e.getActionCommand());
	}

	
}
