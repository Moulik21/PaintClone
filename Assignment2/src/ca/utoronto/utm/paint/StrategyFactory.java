package ca.utoronto.utm.paint;

/**
 * A modular way to create new shapes 
 *
 */
public class StrategyFactory {
	/**
	 * Create a new Shape based on what Shape is required to be made
	 * @param shapeType the type of Shape to be made
	 * @param origin the starting Point of the shape	
	 * @return the Shape required to be made, null otherwise.
	 */
	public ShapeManipulatorStrategy getStrategy(String shapeType){
		
		switch(shapeType){		
		case "Squiggle": return new SquiggleManipulatorStrategy();
		case "Circle" : return new CircleManipulatorStrategy();
		case "Rectangle" : return new RectangleManipulatorStrategy();
		case "Square" : return new SquareManipulatorStrategy();
		case "Polyline" : return new PolylineManipulatorStrategy();		
		}
		return null;
	}

	

}//end class
