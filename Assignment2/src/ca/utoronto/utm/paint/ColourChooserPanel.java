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

class ColourChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private Color colour;
	JButton colourButton = new JButton();

	public ColourChooserPanel(View view) {	
		this.view=view;
		
	 	try {
	    	BufferedImage img = ImageIO.read(getClass().getResource("painticon.jpg"));
	    	Image newimg = img.getScaledInstance( 60,60,  java.awt.Image.SCALE_SMOOTH ) ;  
	    	colourButton.setIcon(new ImageIcon(newimg));

	 	} catch (IOException ex) {
	  	}
//		colourButton.setBackground(new Color(250, 250 ,250));
		colourButton.addActionListener(this);
		colourButton.setBackground(Color.WHITE);
		colourButton.setPreferredSize(new Dimension(60, 60));
		colourButton.setBorder(null);
		
	}
	
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
		this.view.getPaintPanel().setColour(colour);
		System.out.println(e.getActionCommand());
	}

	
}
