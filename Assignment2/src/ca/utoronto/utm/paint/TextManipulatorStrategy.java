package ca.utoronto.utm.paint;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TextManipulatorStrategy implements ShapeManipulatorStrategy{

	@Override
/**
 * return current mode 
 */
	public String state() {
		return "Text";
	}

	@Override
	/**
	 * Creates a text "shape" and adds it to the shape list on click
	 */
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		Point origin = new Point(e.getX(),e.getY());
		Text text = new Text(origin);
		panel.setShape(text);
		panel.getModel().addCommand((DrawingCommand)panel.getShape());	

		
	}



	@Override
	/**
	 * Updates the text based on what keys the user presses, only updates spaces,digits,numbers, and backspaces
	 */
	public void keyPress(PaintPanel paintPanel, KeyEvent e) {
		Text field = (Text)paintPanel.getShape();
		Character key = e.getKeyChar();
		if (Character.isLetterOrDigit(key)||e.getKeyChar()==KeyEvent.VK_SPACE){
		field.addText(Character.toString(e.getKeyChar()));
		}
		
		else if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
			field.removeText();
		}

		paintPanel.repaint();
	}
	
	//unused interface methods:
	@Override
	public void release(PaintPanel panel, MouseEvent e) {

	}
		
	

	@Override
	public void drag(PaintPanel panel, MouseEvent e) {

	}

	@Override
	public void move(PaintPanel panel, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
