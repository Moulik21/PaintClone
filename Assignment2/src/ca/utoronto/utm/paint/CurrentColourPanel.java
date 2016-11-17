package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A CurrentColourPanel is a JPanel that contains only a single JButton.
 * When the button is clicked, the user will be able to change the colour of the next
 * shapes from a wide range of colours with the help of JColorChooser 
 *
 */
public class CurrentColourPanel extends JPanel implements Observer{

	private PaintPanel panel;
	private Color DEFAULTCOLOUR = Color.BLACK;
	private JLabel currentColourLabel;
	private JPanel currentColourPanel;
	
	public CurrentColourPanel(PaintPanel panel) {
		this.panel = panel;
		
		this.currentColourLabel = new JLabel("Colour:");
		this.currentColourPanel = new JPanel();
	

		this.currentColourLabel.setOpaque(true);
		this.currentColourLabel.setBackground(Color.WHITE);
		this.currentColourPanel.setBackground(DEFAULTCOLOUR);
		this.currentColourLabel.setBorder(null);
		this.setLayout(new GridLayout(2,1));
	
		this.add(currentColourLabel);
		this.add(currentColourPanel);		
		
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.currentColourPanel.setBackground(this.panel.getColour());
		
	}

	

}
