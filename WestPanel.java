/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * WestPanel.java: Class based off of structure of Panel and JPanel, used to contain elements in western
 * portion of BorderLayout in Main program.
 */

import java.awt.*;

public class WestPanel extends Panel {
    public WestPanel (Canvas canvas) {
		setLayout (new BorderLayout ());
		add (new Label ("Scroll"), BorderLayout.WEST);
		add (new ScrollBar (2), BorderLayout.CENTER);
    }
}
