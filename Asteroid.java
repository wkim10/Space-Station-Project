/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Asteroid.java: Class that draws an Asteroid object.
 */

// ERROR: CHANGE TO SCALEDX and SCALEDY

import java.awt.*;

public class Asteroid {
    private int initialX;
    private int initialY;
    private int scaledX;
    private int scaledY;
    private int xOffset;
    private int yOffset;
    private int speed;
    private int scaledSpeed;
    private Color color;
    private String label;
    private int width;
    private int height;

    public Asteroid (int initialX, int initialY, int xOffset, int yOffset, int width, int height, int speed, String label) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.scaledSpeed = speed;
        this.label = label;
        this.color = new Color(127, 127, 127);
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

    // draws the asteroid
    public void draw (Graphics g) {
        g.setColor(color);
        g.fillOval(scaledX, scaledY, width, height);
        
        g.setColor(new Color (255, 255, 255));
        g.drawString(label, scaledX, scaledY);
    }

    // function for zooming asteroids
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

    // gets bounds of an asteroid
    public Rectangle getBounds () {
        return new Rectangle (initialX, initialY, width, height);
    }
}