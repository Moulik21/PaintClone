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
			this.add(button);
			shapeButtonGroup.add(button);
			button.addActionListener(this);
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
class StyleSelector extends JButton implements ActionListener {
	private boolean flag;
	public StyleSelector(){
		super("Style: Fill");
		this.addActionListener(this);
		this.flag = true;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.flag){
			this.setText("Style: Outline");
			this.flag = false;
		}
		else{
			this.setText("Style: Fill");
			this.flag = true;
		}
	}
	
}
