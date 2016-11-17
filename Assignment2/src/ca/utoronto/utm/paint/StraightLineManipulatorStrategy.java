package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public class StraightLineManipulatorStrategy implements ShapeManipulatorStrategy{
	
	public void press(PaintPanel panel, MouseEvent e, boolean StyleFlag) {
		Point origin = new Point(e.getX(),e.getY());
		StraightLine straightLine = new StraightLine(origin);
		straightLine.setEndPoint(origin);
		panel.setShape(straightLine);
		panel.getModel().addCommand((DrawingCommand)panel.getShape());
	}

	public void release(PaintPanel panel, MouseEvent e) {
		if(panel.getShape() !=null){
			panel.setShape(null);
		}
		
	}

	public void drag(PaintPanel panel, MouseEvent e) {
		Point p = new Point(e.getX(),e.getY());
		StraightLine line = (StraightLine)panel.getShape();
		line.setEndPoint(p);
		panel.repaint();
	}


	public void move(PaintPanel panel, MouseEvent e) {
			
	}
	
	public String state() {
		return "StraightLine";
	}

	
}
