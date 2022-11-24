/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * EastPanel.java: Class based off of structure of Panel and JPanel, used to contain elements in eastern
 * portion of BorderLayout in Main program.
 */

import java.awt.*;

public class EastPanel extends Panel {
    private StatePanel statePanel;

    public EastPanel (Canvas canvas, Model model) {
        setLayout (new GridLayout (3, 1));

        // add panel to show points to user
        statePanel = new StatePanel (model);
        add (statePanel);

        // add buttons for zooming
        add (new ZoomButton ("ZOOM IN", "Zoomed in", canvas, model, true));
        add (new ZoomButton ("ZOOM OUT", "Zoomed out", canvas, model, false));
    }

    public StatePanel getStatePanel () {
        return statePanel;
    }
}
