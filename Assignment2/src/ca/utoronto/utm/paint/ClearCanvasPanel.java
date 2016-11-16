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
class ClearCanvasPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	JButton clearCanvasButton = new JButton();
	
	/**
	 * Creates a new ClearCanvasPanel
	 * @param view the view that contains the panel where the user will draw
	 */
	public ClearCanvasPanel(View view) {	
		this.view=view;
		
	 	try {
	    	BufferedImage img = ImageIO.read(getClass().getResource("/icons/painticon.jpg"));
	    	Image newimg = img.getScaledInstance( 60,60,  java.awt.Image.SCALE_SMOOTH ) ;  
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
	 * @return the JButton that allows the user to change colours
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
		panel.getModel().addCommand(new CommandClearCanvas(panel));
		System.out.println(e.getActionCommand());
	}

	
}
