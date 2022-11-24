/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * ScrollBar.java: Class based off of structure of JScrollBar, allows user to scroll, prints values onto
 * console.
 */

import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar implements AdjustmentListener {
    // private ID number so can tell scrollbars apart
    private int id;

    public ScrollBar (int id) {
        // customize properties of scrollbar
        // named static constant
        setOrientation (VERTICAL);
        setMinimum (0);
        setMaximum (100);

        // initial value
        setValue (25);

        this.id = id;

        addAdjustmentListener (this);
    }

    // when value changes when scrolling, print out current value and ID of scrollbar
    public void adjustmentValueChanged (AdjustmentEvent event) {
        System.out.println("Scrollbar " + id + ": new value = " + getValue());
    }
}
