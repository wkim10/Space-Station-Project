/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * NorthPanel.java: Class based off of structure of Panel and JPanel, used to contain elements in northern
 * portion of BorderLayout in Main program.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NorthPanel extends Panel {
    public NorthPanel (Canvas canvas, Model model, Timer timer) {
        setLayout (new FlowLayout ());

		// add color change button
		add (new ColorChangeButton ("CHANGE COLOR", "Changed Color", canvas, model));

		// add start/stop buttons to start/stop animation
		StartStopButton start = new StartStopButton("START", "Start Animation", canvas, timer);
		start.setEnabled (false);
		add (start);
		StartStopButton stop = new StartStopButton("STOP", "Stop Animation", canvas, timer);
		add (stop);

		// make it so that when start/stop is pushed, the button is disabled and the other button is enabled
		start.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.println (start.getPrintText());
				timer.start();
				start.setEnabled (false);
				stop.setEnabled (true);
			}
		});

		stop.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.out.println (stop.getPrintText());
				timer.stop();
				stop.setEnabled (false);
				start.setEnabled (true);
			}
		});
    }
}
