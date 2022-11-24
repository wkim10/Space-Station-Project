/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Vehicle.java: Abstract class that forms the framework for a Vehicle object.
 */

import java.awt.*;

abstract class Vehicle {
    protected int initialX;
    protected int initialY;
    protected int scaledX;
    protected int scaledY;
    protected int xOffset;
    protected int yOffset;
    protected int speed;
    protected int scaledSpeed;
    protected Color color;
    protected String label;
    protected Canvas canvas;
    
    public Vehicle (int initialX, int initialY, int xOffset, int yOffset, int speed, String label, Canvas canvas) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.speed = speed;
        this.scaledSpeed = speed;
        this.label = label;
        this.canvas = canvas;
        this.scaledX = initialX;
        this.scaledY = initialY;
    }

    // set color of vehicle
    public void setColor (Color color) {
        this.color = color;
    }

    // get color of vehicle
    public Color getColor () {
        return color;
    }

    /// abstract function for drawing a vehicle
    abstract public void draw (Graphics g, boolean isCurrent);

    // function for zooming vehicles
    public void zoom (double zoomFactor) {
        scaledX = (int) (Math.round((scaledX - xOffset) * zoomFactor + xOffset));
        scaledY = (int) (Math.round((scaledY - yOffset) * zoomFactor + yOffset));

        if (scaledSpeed < 0) {
            scaledSpeed = (int) Math.floor((double) scaledSpeed * (double) zoomFactor);
        } else {
            scaledSpeed = (int) Math.ceil((double) scaledSpeed * (double) zoomFactor);
        }
    }

    // function for animating vehicle
    public void tick () {
        initialX += speed;
        scaledX += scaledSpeed;
    }

    abstract public boolean isInside (Point p);

    abstract public Rectangle getBounds ();

    abstract public void colorAction ();
}