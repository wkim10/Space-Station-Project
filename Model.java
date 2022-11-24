/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Model.java: Class that draws all the objects on the screen.
 */

import java.util.*;
import java.awt.*;

public class Model {
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
    private Canvas canvas;
    private Color canvasColor;
    private Vehicle current;
    private int xOffset;
    private int yOffset;
    private int points;
    private javax.swing.Timer timer;
    private long startTime;
    private EastPanel panel;

    public Model (Canvas canvas, javax.swing.Timer timer, long startTime) {
        this.canvas = canvas;
        this.timer = timer;
        this.startTime = startTime;

        this.canvasColor = new Color (0, 0, 0);

        xOffset = canvas.getWidth() / 2;
        yOffset = canvas.getHeight() / 2;

        // create all the initial vehicles
        vehicles.add (new Spaceship(700, 100, xOffset, yOffset, -5, "Spaceship 1", canvas));
        vehicles.add (new Spaceship(800, 500, xOffset, yOffset, -4, "Spaceship 2", canvas));
        vehicles.add (new Robot(50, 200, xOffset, yOffset, 3, "Robot", canvas));

        // create all the asteroids
        asteroids.add (new Asteroid(50, 300, xOffset, yOffset, 50, 80, 3, "Asteroid"));
        asteroids.add (new Asteroid(150, 150, xOffset, yOffset, 50, 20, 3, "Asteroid"));
        asteroids.add (new Asteroid(800, 400, xOffset, yOffset, 60, 40, 3, "Asteroid"));
        asteroids.add (new Asteroid(400, 200, xOffset, yOffset, 74, 57, 3, "Asteroid"));
        asteroids.add (new Asteroid(500, 300, xOffset, yOffset, 83, 89, 3, "Asteroid"));

        current = vehicles.get(0);

        this.points = 0;
    }

    // function to get xOffset
    public int getXOffset () {
        return xOffset;
    }

    // function to get yOffset
    public int getYOffset () {
        return yOffset;
    }

    // function get points
    public int getPoints () {
        return points;
    }

    // function to add a spaceship to the GUI
    public void addSpaceship (int x, int y, int speed, String labelField) {
        vehicles.add (new Spaceship (x, y, xOffset, yOffset, speed, labelField, canvas));
    }

    // function to add a robot to the GUI
    public void addRobot (int x, int y, int speed, String labelField) {
        vehicles.add (new Robot (x, y, xOffset, yOffset, speed, labelField, canvas));
    }

    // function to add asteroid randomly to the GUI
    public void addRandomAsteroid () {
        int x = 0;
        int y = (int) (Math.random() * (yOffset * 2 - 5 + 1));
        int width = (int) (Math.random() * (95 - 5 + 1)) + 5;
        int height = (int) (Math.random() * (95 - 5 + 1)) + 5;

        asteroids.add (new Asteroid (x, y, xOffset, yOffset, width, height, 3, "Asteroid"));
    }

    // function to draw all vehicles/asteroids
    public void draw (Graphics g) {
        g.setColor (canvasColor);
        g.fillRect (0, 0, 10000, 10000);

        xOffset = canvas.getWidth() / 2;
        yOffset = canvas.getHeight() / 2;

        for (Vehicle vehicle : vehicles) {
            vehicle.draw (g, vehicle == current);
        }

        for (Asteroid asteroid : asteroids) {
            asteroid.draw (g);
        }

        // add random asteroid every so often
        if ((System.currentTimeMillis() - startTime) % 20 == 0) {
            addRandomAsteroid();
        }

        // if points less than 0, it's game over
        if (points < 0) {
            timer.stop();
            g.setFont (new Font ("TimesRoman", Font.BOLD, 100));
            g.drawString ("GAME OVER!", xOffset - 335, yOffset + 10);
        }
    }

    // function to scale objects for zooming
    public void zoom (double zoomFactor) {
        for (Vehicle vehicle : vehicles) {
            vehicle.zoom (zoomFactor);
        }

        for (Asteroid asteroid : asteroids) {
            asteroid.zoom (zoomFactor);
        }
    }

    // function to animate all objects on screen
    public void tick () {
        for (Vehicle vehicle : vehicles) {
            vehicle.tick ();
        }

        for (Asteroid asteroid : asteroids) {
            asteroid.tick ();
        }
    }

    public Vehicle getCurrent () {
        return current;
    }

    public void addPanel (EastPanel panel) {
        this.panel = panel;
    }

    public void doMouse (Point p) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isInside(p)) {
                current = vehicle;
                break;
            }
        }

        canvas.repaint();
    }

    // function to check for collisions
    public void checkCollisions() {

        // check collisions between vehicles
        for (int i = vehicles.size() - 1; i >= 1; i--) {
            Rectangle r1 = vehicles.get(i).getBounds();

            for (int j = i - 1; j >= 0; j--) {
                Rectangle r2 = vehicles.get(j).getBounds();

                if (r1.intersects(r2)) {
                    vehicles.remove(i);
                    vehicles.remove(j);
                    points -= 20;
                    panel.getStatePanel().setLabel (points);
                    System.out.println (points);
                }
            }
        }

        // check collisions between asteroids and vehicles
        for (int i = vehicles.size() - 1; i >= 0; i--) {
            Rectangle r1 = vehicles.get(i).getBounds ();

            for (int j = asteroids.size() - 1; j >= 0; j--) {
                Rectangle r2 = asteroids.get(j).getBounds();

                if (r1.intersects(r2) && !(vehicles.get(i).getColor().equals(asteroids.get(j).getColor()))) {
                    vehicles.remove(i);
                    points -= 20;
                    panel.getStatePanel().setLabel (points);
                    System.out.println (points);
                } else if (r1.intersects(r2) && (vehicles.get(i).getColor().equals(asteroids.get(j).getColor()))) {
                    points += 1;
                    panel.getStatePanel().setLabel (points);
                    System.out.println (points);
                }
            }
        }
    }
}