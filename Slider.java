/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * Slider.java: Class based off of structure of JSlider, allows user to slide between a series of values.
 */

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import javax.swing.JSlider;

public class Slider extends JSlider implements ChangeListener {
    private int id;

    public Slider (int id) {
        setOrientation(VERTICAL);
        setMinimum(0);
        setMaximum(100);

        setValue(25);

        // sets how the ticks on the slider look
        setMajorTickSpacing(10);
        setMinorTickSpacing(1);
        setPaintTicks(true);
        setPaintLabels(true);

        this.id = id;
    }

    // prints out values of the slider on the console
    public void stateChanged (ChangeEvent event) {
        System.out.println ("Slider " + id + ": new value = " + getValue());
    }
}