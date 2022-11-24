/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * ComboBox.java: Class based off structure of JComboBox, prints out which item was selected.
 */

import java.awt.event.*;
import javax.swing.*;

public class ComboBox extends JComboBox<String> implements ItemListener {
    public ComboBox () {
        addItemListener (this);
    }

    public void itemStateChanged (ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println ("Combo: " + e.getItem());
        }
    }
}