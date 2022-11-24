/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Canvas.java: Class based off of structure of JPanel, draws on the main window of the GUI.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas extends JPanel implements MouseListener {
    private Model model;

    Canvas () {
        addMouseListener (this);
    }

    public void setModel (Model model) {
        this.model = model;
    }

    // draws temporary shapes representing asteroids and spaceships
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        model.draw(g);
        model.tick();
        model.checkCollisions();
    }

    // MouseListener callbacks
    public void mousePressed (MouseEvent event) {
        model.doMouse (event.getPoint());
    }

    public void mouseClicked (MouseEvent event) {}
    public void mouseReleased (MouseEvent event) {}
    public void mouseEntered (MouseEvent event) {}
    public void mouseExited (MouseEvent event) {}
}