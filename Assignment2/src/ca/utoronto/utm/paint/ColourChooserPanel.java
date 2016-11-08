package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ColourChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private Color colour;
	
	public ColourChooserPanel(View view) {	
		this.view=view;
		
		JButton button = new JButton("Change Colour");
		this.add(button);
		button.addActionListener(this);
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
