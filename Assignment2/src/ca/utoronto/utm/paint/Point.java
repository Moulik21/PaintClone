package ca.utoronto.utm.paint;
/**
 * A Point is a coordinate on the screen that contains a x-value and a y-value. * 
 *
 */
public class Point {
	/**
	 * The coordinate of the Point
	 */
	int x, y;
	
	/**
	 * Creates a new Point with the given coordinate
	 * @param x the x value of the coordinate
	 * @param y the y value of the coordinate
	 */
	Point(int x, int y){
		this.x=x; this.y=y;
	}
	
	/**
	 * 
	 * @return the x value of the Point
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the x value of the Point
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return the y value of the Point
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the x value of the Point
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
