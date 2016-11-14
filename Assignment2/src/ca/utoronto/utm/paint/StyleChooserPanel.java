package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * A StyleSelector is a JPanel that contains a JButton that allows the user to choose if
 * subsequent Shapes will be filled. If the user decides to disable the fill feature, a "X"
 * will appear on top of the Icon of the button. By default, fill is disabled.
 *
 */
public class StyleChooserPanel extends JPanel implements ActionListener {
	
	//Instance Variables
	private boolean isOutlineMode;
	private JButton button;
	private View view;
	/**
	 * Creates a StyleSelector
	 */
	public StyleChooserPanel(View view){
		this.view = view;
		this.isOutlineMode = true;
		this.button = new JButton();
	 	try {
	    	BufferedImage img = ImageIO.read(getClass().getResource("notfilled.png"));
	    	Image newimg = img.getScaledInstance( 60,60,  java.awt.Image.SCALE_SMOOTH ) ;  
	    	button.setIcon(new ImageIcon(newimg));

	 	} catch (IOException ex) {
	  	}
		this.button.addActionListener(this);
		button.setBackground(Color.WHITE);
		button.setPreferredSize(new Dimension(60, 60));
		button.setBorder(null);
		this.add(button);
	}
	/**
	 * 
	 * @return the JButton that allows the user to enable/disable to fill feature
	 */
	public JButton getButton() {
		return button;
	}
	
	@Override
	/**
	 * A "X" appears on top of the button if the fill feature is disabled, disappears otherwise.
	 */
	public void actionPerformed(ActionEvent arg0) {
		PaintPanel panel = this.view.getPaintPanel();
		if (this.isOutlineMode){
		 	try {
		    	BufferedImage img = ImageIO.read(getClass().getResource("filled.png"));
		    	Image newimg = img.getScaledInstance( 60,60,  java.awt.Image.SCALE_SMOOTH ) ;  
		    	button.setIcon(new ImageIcon(newimg));

		 	} catch (IOException ex) {
		  	}
			this.isOutlineMode = false;
		 	panel.getModel().addCommand(new CommandFill(panel, false));
		 	
		 	
		}
		else{
		 	try {
		    	BufferedImage img = ImageIO.read(getClass().getResource("notfilled.png"));
		    	Image newimg = img.getScaledInstance( 60,60,  java.awt.Image.SCALE_SMOOTH ) ;  
		    	button.setIcon(new ImageIcon(newimg));

		 	} catch (IOException ex) {
		  	}
			this.isOutlineMode = true;
		 	panel.getModel().addCommand(new CommandFill(panel, true));
		}
		
	}
	
	
}
