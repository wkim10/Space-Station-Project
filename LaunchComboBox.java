/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * LaunchComboBox.java: Class based off structure of ComboBox, adds vehicle items into the ComboBox for the
 *                      user to select from.
 */

public class LaunchComboBox extends ComboBox {
    public LaunchComboBox () {
        addItem ("Spaceship");
        addItem ("Robot");
        setSelectedItem ("Spaceship");
    }
}
