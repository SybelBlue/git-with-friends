package comp124graphics;

import java.awt.geom.Point2D;

public class Circle extends Ellipse {
    /**
     * Constructor to create the ellipse object and initialize its instance variables.
     * The default creates an ellipse at position x,y with a bounding rectangle of width and height.
     * The ellipse is drawn with a 1 pixel black stroke outline by default.
     *
     * @param x      position
     * @param y      position
     * @param width  of the bounding rectangle
     * @param height of the bounding rectangle
     */
    private Circle(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    private double radius;

    /**
     * Constructor to create a circle object and initialize its instance variables.
     *
     * @param x x coordinate of circle's center
     * @param y y coordinate of circle's center
     * @param radius radius of the circle
     */
    public Circle(double x, double y, double radius) {
        super(x - radius, y - radius, 2 * radius, 2 * radius);
        this.radius = radius;
    }

    public Point2D.Double centerPoint() {
        return new Point2D.Double(getX() + radius, getY() + radius);
    }
}
