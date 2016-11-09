package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StyleSelector extends JPanel implements ActionListener {
	private boolean isOutlineMode;
	private JButton button;
	
	public StyleSelector(){
		this.isOutlineMode = true;
		this.button = new JButton("<html>Current Style: Outline<br>Press To Toggle Fill Style</html>");
		button.setBackground(new Color(250, 250 ,250));
		this.button.addActionListener(this);
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
			this.button.setText("<html>Current Style: Fill<br>Press To Toggle Outline Style</html>");
			this.isOutlineMode = false;
		}
		else{
			this.button.setText("<html>Current Style: Outline<br>Press To Toggle Fill Style</html>");
			this.isOutlineMode = true;
		}
		
	}
	
	
}
