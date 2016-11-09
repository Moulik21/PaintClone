package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	
	public ShapeChooserPanel(View view) {	
		this.view=view;
		
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		ButtonGroup shapeButtonGroup = new ButtonGroup();
		for (String label : buttonLabels) {
			JToggleButton button = new JToggleButton(label);
			button.setBackground(new Color(250, 250 ,250));
			this.add(button);
			shapeButtonGroup.add(button);
			button.addActionListener(this);
			if (label.equals("Squiggle")) { //program starts with squiggle as selected
				button.setSelected(true);
			}
		}
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setMode(e.getActionCommand());
		System.out.println(e.getActionCommand());
	}

	
}
