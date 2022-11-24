/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Button.java: Class based off of structure of JButton, allows user to set text of button.
 */

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

abstract public class Button extends JButton implements ActionListener {

    protected Canvas canvas;
    protected String printText;

    public Button (String label, String printText, Canvas canvas) {
        setText (label);
        addActionListener (this);
        this.printText = printText;
        this.canvas = canvas;
    }

    // returns the text to be printed on the terminal
    public String getPrintText () {
        return printText;
    }

    // print message when button is pressed
    abstract public void actionPerformed (ActionEvent e);
}