/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * ColorChangeButton.java: Class based off of structure of Button, allows user to change the color of the
 * currently-selected object.
 */

import java.awt.event.ActionEvent;

public class ColorChangeButton extends Button {
    private Model model;

    public ColorChangeButton (String label, String printText, Canvas canvas, Model model) {
        super (label, printText, canvas);
        this.model = model;
    }

    // changes color of currently-selected object
    public void actionPerformed (ActionEvent e) {
        System.out.println (printText);
        model.getCurrent().colorAction ();
    }
}