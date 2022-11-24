/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * ZoomButton.java: Class based off of structure of Button, allows user to zoom in or out of the canvas.
 */

import java.awt.event.ActionEvent;

public class ZoomButton extends Button {
    private Model model;
    private double zoomFactor;

    public ZoomButton (String label, String printText, Canvas canvas, Model model, boolean zoomIn) {
        super (label, printText, canvas);
        this.model = model;
        this.zoomFactor = 1;

        if (zoomIn) {
            zoomFactor = 2;
        } else {
            zoomFactor = 0.5;
        }
    }

    // when clicked, zoom in or out by changing zoomFactor and calling model.zoom()
    public void actionPerformed (ActionEvent e) {
        System.out.println (printText);
        model.zoom (zoomFactor);
        canvas.repaint ();
    }
}
