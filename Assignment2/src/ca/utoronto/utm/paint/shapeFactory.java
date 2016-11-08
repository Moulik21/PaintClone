package ca.utoronto.utm.paint;

public class shapeFactory {
	
	public Shape getShape(String shapeType){
		if (shapeType == null){
			return null;
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
