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
 * A ColourChooserPanel is a JPanel that contains only a single JButton.
 * When the button is clicked, the user will be able to change the colour of the next
 * shapes from a wide range of colours with the help of JColorChooser 
 *
 */
class ColourChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private Color colour;
	JButton colourButton = new JButton();
	
	/**
	 * Creates a new ColourChoosePanel
	 * @param view the view that contains the panel where the user will draw
	 */
	public ColourChooserPanel(View view) {	
		this.view=view;
		
	 	try {
	    	BufferedImage img = ImageIO.read(getClass().getResource("/icons/painticon.jpg"));
	    	Image newimg = img.getScaledInstance( 52,52,  java.awt.Image.SCALE_SMOOTH ) ;  
	    	colourButton.setIcon(new ImageIcon(newimg));

	 	} catch (IOException ex) {
	  	}

		colourButton.addActionListener(this);
		colourButton.setBackground(Color.WHITE);
		colourButton.setPreferredSize(new Dimension(60, 60));
		colourButton.setBorder(null);
		
	}
	
	/**
	 * 
	 * @return the JButton that allows the user to change colours
	 */
	public JButton getColourButton() {
		return colourButton;
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		colour = JColorChooser.showDialog(null, "Pick a colour",  colour);
		if(colour==null) { //defaults to black
			colour=(Color.BLACK);
		}
		PaintPanel panel = this.view.getPaintPanel();
//		this.view.getPaintPanel().setColour(colour);
		panel.getModel().addCommand(new CommandColor(panel, colour));
		System.out.println(e.getActionCommand());
	}

	
}
