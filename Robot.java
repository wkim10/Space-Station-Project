/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Robot.java: Class that draws a Robot object.
 */

import java.awt.*;

public class Robot extends Vehicle {
    private Color color2;
    private Color color3;

    public Robot (int initialX, int initialY, int xOffset, int yOffset, int speed, String label, Canvas canvas) {
        super (initialX, initialY, xOffset, yOffset, speed, label, canvas);
        this.color = new Color (211, 211, 211);
        this.color2 = new Color (0, 255, 255);
        this.color3 = new Color (255, 255, 255);
    }

    // function for drawing a robot
    public void draw(Graphics g, boolean isCurrent) {
        g.setColor(color);
        g.fillRect(scaledX, scaledY, 50, 50);

        g.setColor(color2);
        g.fillRect(scaledX + 10, scaledY + 10, 10, 10);
        g.fillRect(scaledX + 30, scaledY + 10, 10, 10);

        g.setColor(color3);
        g.fillRect(scaledX + 5, scaledY + 30, 40, 10);
        
        g.setColor(new Color (255, 255, 255));
        g.drawString(label, scaledX, scaledY);

        // if robot is clicked, create blue outline around it
        if (isCurrent) {
            g.setColor(new Color(0, 0, 255));
            g.drawRect(scaledX, scaledY, 50, 50);
        }
    }

    // checks if location of mouse click is within the object
    public boolean isInside (Point p) {
        Rectangle loc = new Rectangle (scaledX, scaledY, 50, 50);
        return loc.contains (p);
    }

    // returns the boundaries of the robot
    public Rectangle getBounds () {
        return new Rectangle (initialX, initialY, 50, 50);
    }

    // function that changes color of the entire object to gray
    public void colorAction () {
        color = new Color (127, 127, 127);
        color2 = new Color (127, 127, 127);
        color3 = new Color (127, 127, 127);

        canvas.repaint();
    }
}