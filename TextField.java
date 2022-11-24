/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * TextField.java: Class based off of structure of JTextField, allows user to set the initial text.
 */

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextField extends JTextField implements ActionListener {
    public TextField (String initialValue) {
        super (initialValue, 3);
        addActionListener (this);
    }

    // print text when text is inputted
    public void actionPerformed (ActionEvent e) {
        System.out.println ("Text: " + e.getActionCommand());
    }
}