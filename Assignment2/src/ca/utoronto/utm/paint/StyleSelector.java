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

public class StyleSelector extends JPanel implements ActionListener {
	private boolean isOutlineMode;
	private JButton button;
	
	public StyleSelector(){
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
	
	public boolean getFlag(){
		return this.isOutlineMode;
	}
	
	public JButton getButton() {
		return button;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.isOutlineMode){
		 	try {
		    	BufferedImage img = ImageIO.read(getClass().getResource("filled.png"));
		    	Image newimg = img.getScaledInstance( 60,60,  java.awt.Image.SCALE_SMOOTH ) ;  
		    	button.setIcon(new ImageIcon(newimg));

		 	} catch (IOException ex) {
		  	}
			this.isOutlineMode = false;
		}
		else{
		 	try {
		    	BufferedImage img = ImageIO.read(getClass().getResource("notfilled.png"));
		    	Image newimg = img.getScaledInstance( 60,60,  java.awt.Image.SCALE_SMOOTH ) ;  
		    	button.setIcon(new ImageIcon(newimg));

		 	} catch (IOException ex) {
		  	}
			this.isOutlineMode = true;
		}
		
	}
	
	
}
