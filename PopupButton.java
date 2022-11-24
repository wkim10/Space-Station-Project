/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * PopupButton.java: Class based off of structure of Button, when clicked, causes popup window to be
 * displayed.
 */

import java.awt.event.ActionEvent;

public class PopupButton extends Button {
    private Popup popup;

    public PopupButton (String label, String printText, Canvas canvas, Popup popup) {
        super (label, printText, canvas);
        this.popup = popup;
    }

    // when button is clicked, show popup window
    public void actionPerformed (ActionEvent e) {
        System.out.println (printText);
        popup.setVisible (true);
    }
}
