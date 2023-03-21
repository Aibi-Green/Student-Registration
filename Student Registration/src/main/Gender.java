package main;

import javax.swing.JRadioButton;

public class Gender {
	public static String getGender (JRadioButton male, JRadioButton female) {
		return male.isSelected() ? male.getText() : female.getText();
	}
}
