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

public class colorPalette extends JPanel implements ActionListener{
	private JButton black, cyan, red, blue, green, yellow, magenta;
	private ArrayList<JButton> button_lst = new ArrayList<JButton>();
	private PaintPanel panel;
	
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
	
	public void addActionListener(){
		for (JButton b: this.button_lst){
			b.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		this.panel.setColour(button.getBackground());
		
	}
	
}
