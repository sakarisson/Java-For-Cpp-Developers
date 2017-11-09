package dt062g.krsa1201.assignment3;

import java.awt.Graphics;

/**
 * <h1>Circle</h1>
 * <p>The class is derived from Shape</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 08-11-2017
 */
class Circle extends Shape {

    private double PI = 3.14;

    /**
     * <h2>Circle coordinate constructor</h2>
     * <p>Calls coordinate constructor of Shape</p>
     */
    Circle(double x, double y, String color) {
        super(x, y, color);
    }
    
    /**
     * <h2>Circle Point constructor</h2>
     * <p>Calls Point constructor of Shape</p>
     */
    Circle(Point point, String color) {
        super(point, color);
    }

    /**
     * <h2>Get radius</h2>
     * <p>Function used to get the radius
     * of circle object</p>
     * @return Radius of this
     */
    public double getRadius() {
        try {
            // Get difference between x and y positions
            double xDifference = Math.abs(this._points[0].x() - this._points[1].x());       // Length from center to point on circle, along the x-axis
            double yDifference = Math.abs(this._points[0].y() - this._points[1].y());       // Length from center to point on circle, along the y-axis
            double radius = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2)); // Use Pythagoras theorem to find radius
            return radius;
        } catch (Exception e) {
            return -1;
        }
    }

    // Inherited
    public double getCircumference() {
        return 2 * this.PI * this.getRadius(); // C = 2πr
    }

    // Inherited
    public double getArea() {
        return this.PI * Math.pow(this.getRadius(), 2); // A = πr^2
    }

    /**
     * <h2>Draw override</h2>
     * <p>"Writes" circle in the sense that it prints some information about
     * the circle</p>
     */
    public void draw() {
        System.out.println("Drawing a Circle" + this.toString());
    }

    /**
     * <h2>Draw override</h2>
     * <p>Not implemented in assignment 2</p>
     * @param g Graphics
     */
    public void draw(Graphics g) {
        
    }

    // Override of toString() method
    public String toString() {
        String output = "[";
        output += "start=" + this._points[0] + "; ";
        output += "end=";
        try {
            output += this._points[1].toString();
        } catch (Exception e) { // Null reference if there is no second point
            output += "N/A";
        }
        output += "; radius=";
        output += this.getRadius() >= 0 ? this.getRadius() + "; " : "N/A; "; // Write radius if non-negative, else N/A
        output += "color=" + this._color + "]";

        return output;
    }
}