package main;
import java.time.LocalDate;
import java.util.Arrays;

import javax.swing.JComboBox;

public class dateOfBirth {
	
	private static final String[] months = {
			"January",
			"February",
			"March",
			"April",
			"May", 
			"June", 
			"July", 
			"August", 
			"September", 
			"October", 
			"November", 
			"December"
		};
	
	public static void setMonths(JComboBox<String> comboBox) {
		comboBox.addItem("---");
		for (String i : months) {
			comboBox.addItem(i);
		}
	}
	
	public static boolean isLeapYear(Object selectedYear) {
		return (selectedYear != "---" && Integer.parseInt((String) selectedYear) % 4 == 0) ? true : false;
	}
	
	public static void setYears(JComboBox<String> comboBox) {
		int current_year = LocalDate.now().getYear();
		
		comboBox.addItem("---");
		
		for (int i = 1970; i <= current_year; i++) {
			comboBox.addItem(i+"");
		}
	}
	
	public static void setDays(JComboBox<String> comboBox, Object selectedMonth, Object selectedYear) {
		comboBox.removeAllItems();
		if(selectedMonth == "February") {			
			if(isLeapYear(selectedYear)) {
				for (int i = 0; i < 29; i++) {
					comboBox.addItem(""+(i+1));
				}
			} else {
				for (int i = 0; i < 28; i++) {
					comboBox.addItem(""+(i+1));
				}
			}
		} else if (
				selectedMonth == "January" || 
				selectedMonth == "March" ||
				selectedMonth == "May" ||
				selectedMonth == "July" ||
				selectedMonth == "August" ||
				selectedMonth == "October" ||
				selectedMonth == "December"
		) {
			for (int i = 0; i < 31; i++) {
				comboBox.addItem(""+(i+1));
			}
		} else if (selectedMonth != "---") {
			for (int i = 0; i < 30; i++) {
				comboBox.addItem(""+(i+1));
			}
		} else {
			comboBox.addItem("---");
		}
	}
	
	public static String extractMonth(String monthNum) {
		switch (monthNum) {
			case "01":
				return "January";
			case "02":
				return "February";
			case "03":
				return "March";
			case "04":
				return "April";
			case "05":
				return "May";
			case "06":
				return "June";
			case "07":
				return "July";
			case "08":
				return "August";
			case "09":
				return "October";
			case "10":
				return "November";
			case "11":
				return "December";
			default:
				return "None";
		}
	}
	
	public static String getDOA(Object year, Object month, Object day) {
		String formatMonth = String.valueOf(Arrays.asList(months).indexOf((String)month));
		String formatDay = (String) day; 
		
		if(Integer.parseInt(formatDay) < 10)
			formatDay = String.format("%02d", Integer.parseInt(formatDay));
		
		if (Arrays.asList(months).indexOf((String)month) < 10)
			formatMonth = String.format("%02d", Integer.parseInt(formatMonth)+1);
		
		return ""+(String)year+"-"+formatMonth+"-"+formatDay;
	}
}
