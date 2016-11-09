package ca.utoronto.utm.paint;

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
//		this.setLayout(new GridLayout(1, 1));
		this.isOutlineMode = true;
		this.button = new JButton("<html>Current Style: Outline<br>Press To Toggle to Fill Style</html>");
		this.button.addActionListener(this);
//		this.button.setPreferredSize(new Dimension(120, 50));
		this.add(button);
	}
	
	public boolean getFlag(){
		return this.isOutlineMode;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.isOutlineMode){
			this.button.setText("<html>Current Style: Fill<br>Press To Toggle to Outline Style</html>");
			this.isOutlineMode = false;
		}
		else{
			this.button.setText("<html>Current Style: Outline<br>Press To Toggle to Fill Style</html>");
			this.isOutlineMode = true;
		}
		
	}
	
	
}
