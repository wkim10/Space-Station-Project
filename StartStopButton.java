/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * StartStopButton.java: Class based off of structure of Button, allows user to start and stop animation.
 */

import java.awt.event.ActionEvent;
import javax.swing.*;

public class StartStopButton extends Button {
    private Timer timer;

    public StartStopButton (String label, String printText, Canvas canvas, Timer timer) {
        super (label, printText, canvas);
        this.timer = timer;
    }

    public void actionPerformed (ActionEvent e) {
        System.out.println (printText);
    }
}
