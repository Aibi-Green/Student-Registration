package main;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Invalids {
	public static boolean findUnfilledTextFields (
			JTextField id, JTextField first, JTextField last,
			JTextField contact) {
		
		if (id.getText().isEmpty()) 
			id.setBackground(new Color(255, 228, 225));
		else 
			id.setBackground(new Color(255, 255, 255));
		
		if (first.getText().isEmpty())
			first.setBackground(new Color(255, 228, 225));
		else 
			first.setBackground(new Color(255, 255, 255));
		
		if (last.getText().isEmpty()) 
			last.setBackground(new Color(255, 228, 225));
		else 
			last.setBackground(new Color(255, 255, 255));
		
		if (contact.getText().isEmpty())
			contact.setBackground(new Color(255, 228, 225));
		else 
			contact.setBackground(new Color(255, 255, 255));
		
		return (id.getText().isEmpty() || first.getText().isEmpty() ||
				last.getText().isEmpty() || contact.getText().isEmpty())
				? true : false;
	}
	
	public static boolean findUncheckedRadioButtons (
			JRadioButton male, JRadioButton female
			) {
		return male.isSelected() == false && female.isSelected() == false;
	}
	
	public static boolean findUnselectedComboBox (
			Object year, Object month, Object day
			) {
		return (String) year == "---" || (String) month == "---" || (String) year == "---";  
	}
}
