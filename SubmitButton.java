/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * SubmitButton.java: Class based off of structure of Button, allows user to submit info inputted into the
 *                    ComboBox and TextFields, creates new vehicle and draws it according to info.
 */

import java.awt.event.ActionEvent;

public class SubmitButton extends Button {
    private Model model;
    private ComboBox comboBox;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;

    public SubmitButton (String label, String printText, Canvas canvas, Model model, ComboBox comboBox,
                    TextField textField1, TextField textField2, TextField textField3, TextField textField4) {
        super (label, printText, canvas);
        this.model = model;
        this.comboBox = comboBox;
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
        this.textField4 = textField4;
    }

    // create new vehicle with given data when button is pushed
    public void actionPerformed (ActionEvent e) {
        System.out.println (printText);

        int x = Integer.parseInt(textField1.getText());
        int y = Integer.parseInt(textField2.getText());
        int speed = Integer.parseInt(textField3.getText());
        String labelField = textField4.getText();

        if (comboBox.getSelectedItem () == "Spaceship") {
            model.addSpaceship (x, y, speed, labelField);
        } else if (comboBox.getSelectedItem () == "Robot") {
            model.addRobot (x, y, speed, labelField);
        }

        canvas.repaint();
    }
}