package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * A colourPalette is a JPanel that contains 7 buttons which the user the can use 
 * to change colours when drawing a shape.  
 *
 */
public class colorPalette extends JPanel implements ActionListener{
	/**
	 * Each button which be used to changed to a different colour
	 */
	private JButton black, cyan, red, blue, green, yellow, magenta;
	
	/**
	 * An ArrayList of the buttons used to change colours
	 */
	private ArrayList<JButton> button_lst = new ArrayList<JButton>();
	private PaintPanel panel;
	
	/**
	 * Creates a new colorPalette
	 * @param panel A PaintPanel which is where the change of colour will take place
	 */
	public colorPalette(PaintPanel panel){
		this.panel = panel;
		
		black = new JButton();cyan = new JButton();red = new JButton(); magenta = new JButton();
		blue = new JButton();green = new JButton();yellow = new JButton();
		this.button_lst.add(black); this.button_lst.add(cyan);this.button_lst.add(red); this.button_lst.add(magenta);
		this.button_lst.add(blue);this.button_lst.add(red);this.button_lst.add(green);this.button_lst.add(yellow);
		
		magenta.setBackground(Color.magenta);
		black.setBackground(Color.black);
		cyan.setBackground(Color.cyan);
		red.setBackground(Color.red);
		blue.setBackground(Color.blue);
		green.setBackground(Color.green);
		yellow.setBackground(Color.yellow);
		
		for (JButton b: this.button_lst){
			
			this.add(b);
		}
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(25,25));
		this.setLayout(new GridLayout(15,1));
		
	}
	
	/**
	 * Adds an ActionListener to all the buttons in the ArrayList button_lst
	 */
	public void addActionListener(){
		for (JButton b: this.button_lst){
			b.addActionListener(this);
		}
	}
	
	@Override
	/**
	 * This method will be called when one of the button is clicked.
	 * The colour of the panel will be changed to the colour of the button clicked.
	 */
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		this.panel.setColour(button.getBackground());
		
	}
	
}
