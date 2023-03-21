package main;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Utilities {
	public static void clearTextFields(
			JTextField id, JTextField first, JTextField middle, JTextField last, 
			JComboBox year, JComboBox month, JComboBox day,
			JRadioButton male, 
			JTextField email, JTextField contact) {
		id.setText("");
		first.setText("");
		middle.setText("");
		last.setText("");
		year.setSelectedItem("---"); 
		month.setSelectedItem("---"); 
		day.getSelectedItem();
		male.doClick(); 
		email.setText("");
		contact.setText("");
	}
}
