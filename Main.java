/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Main.java: Main class that sets up the simulation framework and all the individual widgets within it.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ComponentListener, ActionListener {
	private static final int SMALL = 640;
	private Canvas canvas;

	private NorthPanel north;
	private EastPanel east;
	private SouthPanel south;
	private WestPanel west;

    public static void main (String [] args) {
	java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
		new Main ();
            }
        });
    }

    public Main () {
		// Window setup
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setSize (1500, 900);
		setLayout (new BorderLayout ());

		// Start the timer
		Timer timer = new Timer (100, this); // 100 milliseconds
		long startTime = System.currentTimeMillis(); 
		timer.start();
		
		// Put a Canvas in
		canvas = new Canvas ();

		add (canvas, BorderLayout.CENTER);

		// Show the window
		setVisible (true);

		// Put a Model in
		Model model = new Model (canvas, timer, startTime);

		// Set Model of Canvas
		canvas.setModel (model);

		// NORTH
		north = new NorthPanel (canvas, model, timer);
		add (north, BorderLayout.NORTH);

		// EAST
		east = new EastPanel (canvas, model);
		add (east, BorderLayout.EAST);
		model.addPanel (east);

		addComponentListener (this);

		// SOUTH
		south = new SouthPanel (this, canvas, model, timer);
		add (south, BorderLayout.SOUTH);

		// WEST
		west = new WestPanel (canvas);
		add (west, BorderLayout.WEST);
    }

	public void actionPerformed (ActionEvent e) {
		canvas.repaint();
	}

	public void componentResized (ComponentEvent e) {
		Dimension size = getSize();

		// SMALL = Use pop up dialogues
		if (size.width < SMALL || size.height < SMALL) {
			south.moveToPopups ();
		} else {
			south.moveToMain ();
		}
	}

	public void componentHidden (ComponentEvent e) {}
	public void componentMoved (ComponentEvent e) {}
	public void componentShown (ComponentEvent e) {}
}