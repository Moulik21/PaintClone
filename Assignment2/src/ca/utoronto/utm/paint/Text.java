package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

public class Text extends Shape implements DrawingCommand{
private String text;
/**
 *Initializes the text object
 */
	public Text(Point origin) {
		super(origin);
		this.text="";
		
	}
	/**
	 * adds a character to the string displayed
	 */
	public void addText(String text){
		this.text = this.text+text;
	}
	
	/**
	 * removes the last character from the string displayed
	 */
	public void removeText(){
	if (this.text.length()>= 1){
		this.text=this.text.substring(0,this.text.length()-1);
	}
	}

	/**
	 * draws the string on the panel.
	 */
	@Override
	public void execute(Graphics2D g2d) {
		if(this.text !=null){
		g2d.drawString(this.text,this.getOrigin().getX(),this.getOrigin().getY());
		}
	}

}
