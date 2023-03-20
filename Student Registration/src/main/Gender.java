package main;

import javax.swing.JRadioButton;

public class Gender {
	public static String getGender (JRadioButton male, JRadioButton female) {
		if(male.isSelected())
			return male.getText();    
		else  
			return female.getText();
	}
	
//	public static void main(String[] args) {
//	}
}
