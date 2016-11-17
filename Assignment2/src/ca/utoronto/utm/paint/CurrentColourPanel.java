package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * A CurrentColourPanel is a JPanel that shows the currently selected colour.
 * This colour defaults to black and changes to whatever the user selects either
 * in the quick colour palette or in the rgb palette
 */
public class CurrentColourPanel extends JPanel implements Observer{

	private PaintPanel panel;
	private Color DEFAULTCOLOUR = Color.BLACK;
	private JLabel currentColourLabel;
	private JPanel currentColourPanel;
	private JPanel currentColourPanel2;
	
	public CurrentColourPanel(PaintPanel panel) {
		this.panel = panel;
		
		this.currentColourLabel = new JLabel("Colour:", SwingConstants.CENTER);
		this.currentColourPanel = new JPanel();
		this.currentColourPanel2 = new JPanel();
		
		this.currentColourLabel.setOpaque(true);
		this.currentColourLabel.setBackground(Color.WHITE);
		this.currentColourPanel.setBackground(DEFAULTCOLOUR);
		this.currentColourPanel2.setBackground(DEFAULTCOLOUR);
		this.currentColourLabel.setBorder(null);
		this.setLayout(new GridLayout(3,1));
	
		this.add(currentColourLabel);
		this.add(currentColourPanel);		
		this.add(currentColourPanel2);		
		
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.currentColourPanel.setBackground(this.panel.getColour());
		this.currentColourPanel2.setBackground(this.panel.getColour());
	}

	

}
