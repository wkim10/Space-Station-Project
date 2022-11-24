/* 
 * Name: Won Kim
 * Email: wkim10@tufts.edu
 * 
 * SouthPanel.java: Class based off of structure of Panel and JPanel, used to contain elements in southern
 * portion of BorderLayout in Main program.
 */

import java.awt.*;
import javax.swing.*;

public class SouthPanel extends Panel {
	private LaunchComboBox comboBox;
	private TextField xField;
	private TextField yField;
	private TextField speedField;
	private TextField labelField;

	private Label xLabel;
	private Label yLabel;
	private Label speedLabel;
	private Label label;

	private SubmitButton submit;
	private PopupButton popupButton;
	private Popup launchPopup;

    public SouthPanel (Main main, Canvas canvas, Model model, Timer timer) {
		setLayout (new FlowLayout ());
		
		// create comboBox to select vehicle type
		comboBox = new LaunchComboBox();
		add (comboBox);

		// create text fields for initial x/y, speed, and label of vehicle
		xField = new TextField ("");
		yField = new TextField ("");
		speedField = new TextField ("");
		labelField = new TextField ("");

		xLabel = new Label ("Initial X");
		add (xLabel);
		add (xField);

		yLabel = new Label ("Initial Y");
		add (yLabel);
		add (yField);

		speedLabel = new Label ("Speed");
		add (speedLabel);
		add (speedField);

		label = new Label ("Label");
		add (label);
		add (labelField);

		// add submit button to create new vehicle
		submit = new SubmitButton ("LAUNCH", "Launch!", canvas, model, comboBox, xField,
												yField, speedField, labelField);
		add (submit);

		// Set up popup
		launchPopup = new Popup (main, false, 400, 200);

		// Button for future popup use
		popupButton = new PopupButton ("LAUNCH", "Popup displayed", canvas, launchPopup);
		add (popupButton);
	}

	// function that moves widgets from main control panel to popup window
	public void moveToPopups () {
		remove (comboBox);
		remove (xLabel);
		remove (xField);
		remove (yLabel);
		remove (yField);
		remove (speedLabel);
		remove (speedField);
		remove (label);
		remove (labelField);
		remove (submit);

		launchPopup.add (comboBox);
		launchPopup.add (xLabel);
		launchPopup.add (xField);
		launchPopup.add (yLabel);
		launchPopup.add (yField);
		launchPopup.add (speedLabel);
		launchPopup.add (speedField);
		launchPopup.add (label);
		launchPopup.add (labelField);
		launchPopup.add (submit);

		add (popupButton);
	}

	// function that moves widgets from popup window to main control panel
	public void moveToMain () {
		add (comboBox);
		add (xLabel);
		add (xField);
		add (yLabel);
		add (yField);
		add (speedLabel);
		add (speedField);
		add (label);
		add (labelField);
		add (submit);

		launchPopup.remove (comboBox);
		launchPopup.remove (xLabel);
		launchPopup.remove (xField);
		launchPopup.remove (yLabel);
		launchPopup.remove (yField);
		launchPopup.remove (speedLabel);
		launchPopup.remove (speedField);
		launchPopup.remove (label);
		launchPopup.remove (labelField);
		launchPopup.remove (submit);

		remove (popupButton);
	}
}