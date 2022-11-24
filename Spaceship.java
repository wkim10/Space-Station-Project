/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Spaceship.java: Class that draws a Spaceship object.
 */

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Spaceship extends Vehicle {

    public Spaceship (int initialX, int initialY, int xOffset, int yOffset, int speed, String label, Canvas canvas) {
        super (initialX, initialY, xOffset, yOffset, speed, label, canvas);
        this.color = new Color (255, 0, 0);
    }

    // function for drawing a spaceship
    public void draw (Graphics g, boolean isCurrent) {        
        g.setColor(color);
        g.fillRoundRect(scaledX, scaledY, 100, 50, 10, 10);
        
        int[] x1 = {scaledX + 50, scaledX + 100, scaledX + 110};
        int[] y1 = {scaledY + 5, scaledY + 5, scaledY - 30};
        g.fillPolygon(x1, y1, 3);

        int[] x2 = {scaledX + 50, scaledX + 100, scaledX + 110};
        int[] y2 = {scaledY + 45, scaledY + 45, scaledY + 80};
        g.fillPolygon(x2, y2, 3);

        g.setColor(new Color (255, 255, 255));
        g.drawString(label, scaledX, scaledY);

        // put outline around spaceship if currently selected
        if (isCurrent) {
            g.setColor (new Color (0, 0, 255));
            g.drawPolygon (x1, y1, 3);
            g.drawPolygon (x2, y2, 3);
            g.drawRoundRect (scaledX, scaledY, 100, 50, 10, 10);
        }
    }

    // checks if mouse click is inside the spaceship
    public boolean isInside (Point p) {
        RoundRectangle2D loc1 = new RoundRectangle2D.Double (scaledX, scaledY, 100, 50, 10, 10);

        int[] x1 = {scaledX + 50, scaledX + 100, scaledX + 110};
        int[] y1 = {scaledY + 5, scaledY + 5, scaledY - 30};
        Polygon loc2 = new Polygon (x1, y1, 3);

        int[] x2 = {scaledX + 50, scaledX + 100, scaledX + 110};
        int[] y2 = {scaledY + 45, scaledY + 45, scaledY + 80};
        Polygon loc3 = new Polygon (x2, y2, 3);

        return loc1.contains (p) || loc2.contains (p) || loc3.contains (p);
    }

    // returns the boundaries of the spaceship for collisions
    public Rectangle getBounds () {
        return new Rectangle (initialX, initialY - 30, 110, 110);
    }

    // changes the color of the spaceship to gray
    public void colorAction () {
        color = new Color (127, 127, 127);

        canvas.repaint();
    }
}