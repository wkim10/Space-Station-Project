/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Label.java: Class based off of structure of JLabel, allows user to set text of label.
 */

import javax.swing.*;

public class Label extends JLabel {
    public Label (String label) {
        setText (label);
        setHorizontalTextPosition(JLabel.CENTER);
    }
}