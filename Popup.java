/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Popup.java: Class based off of structure of JDialog, allows user to set the size of the popup window.
 */

import java.awt.*;
import javax.swing.*;

public class Popup extends JDialog {
    public Popup (Frame owner, boolean modal, int width, int height) {
        super (owner, modal);
        setSize (width, height);
        setLayout (new FlowLayout ());
    }
}