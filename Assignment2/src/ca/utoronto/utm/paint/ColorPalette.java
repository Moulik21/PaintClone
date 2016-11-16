package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
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
public class ColorPalette extends JPanel implements ActionListener{
	/**
	 * Each button which be used to changed to a different colour
	 */
	private JButton black, white, cyan, red, blue, green, yellow, magenta;
	
	/**
	 * An ArrayList of the buttons used to change colours
	 */
	private ArrayList<JButton> button_lst = new ArrayList<JButton>();
	private ArrayList<JButton> button_2nd = new ArrayList<JButton>();
	private PaintPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private View view;
	
	/**
	 * Creates a new colorPalette
	 * @param panel A PaintPanel which is where the change of colour will take place
	 */
	public ColorPalette(PaintPanel panel, View view){
		this.panel = panel;
		this.view = view;
				
		this.setLayout(new GridLayout(2,2));
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,2));
		
		black = new JButton();cyan = new JButton();red = new JButton(); magenta = new JButton();
		blue = new JButton();green = new JButton();yellow = new JButton();white = new JButton();
		this.button_lst.add(black); this.button_lst.add(white);this.button_lst.add(red); this.button_lst.add(magenta);
		this.button_2nd.add(blue);this.button_2nd.add(cyan);this.button_2nd.add(green);this.button_2nd.add(yellow);
		
		magenta.setBackground(Color.magenta);
		white.setBackground(Color.white);
		black.setBackground(Color.black);
		cyan.setBackground(Color.cyan);
		red.setBackground(Color.red);
		blue.setBackground(Color.blue);
		green.setBackground(Color.green);
		yellow.setBackground(Color.yellow);
		
		for (JButton b: this.button_lst){
			b.setPreferredSize(new Dimension(25,25));
			panel1.add(b);
		}
		
		for (JButton b: this.button_2nd){
			b.setPreferredSize(new Dimension(25,25));
			panel2.add(b);
		}
		
		
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(25,25));
		
	}
	
	public JPanel getPanel1(){
		return this.panel1;
	}
	
	public JPanel getPanel2(){
		return this.panel2;
	}
	
	/**
	 * Adds an ActionListener to all the buttons in the ArrayList button_lst
	 */
	public void addActionListener(){
		for (JButton b: this.button_lst){
			b.addActionListener(this);
		}
		for (JButton b: this.button_2nd){
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
		CommandColor newCommandColor = new CommandColor(this.panel, button.getBackground());
		this.panel.getModel().addCommand(newCommandColor);
		newCommandColor.addObserver(this.view.getCurrentColourPanel());
		
	}
	
}
