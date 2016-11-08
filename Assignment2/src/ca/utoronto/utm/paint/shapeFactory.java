package ca.utoronto.utm.paint;

/*
 * THE CLASS IS CURRENTLY NOT BEING USED!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class shapeFactory {
	
	public Shape getShape(String shapeType){
		if (shapeType == null){
			return null;
		}
		if (shapeType == "Squiggle"){
			return new Squiggle();
		}
		if (shapeType == "Circle"){
			return new Circle();
		}
		else if (shapeType =="Rectangle"){
			return new Rectangle();
		}
		else if (shapeType =="Square"){
			return new Square();
		}
		return null;
	}
}
