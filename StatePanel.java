/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * StatePanel.java: Class based off of structure of Panel, used to contain counter for points to display to
 * user.
 */

import java.awt.*;

public class StatePanel extends Panel {
    private Label label;

    public StatePanel (Model model) {
        setLayout (new FlowLayout());

        label = new Label ("Points: 0");
        label.setFont (new Font ("Verdana", Font.BOLD, 18));
        add (label);
    }

    public void setLabel (int points) {
        label.setText ("Points: " + String.valueOf(points));
    }
}
